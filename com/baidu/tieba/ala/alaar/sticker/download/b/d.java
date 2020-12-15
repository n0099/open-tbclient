package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.download.a.e;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
/* loaded from: classes4.dex */
public abstract class d implements com.baidu.tieba.ala.alaar.sticker.download.a.e {
    private final a gkt;
    private final i gku;
    private final e.a gkv;
    private volatile int mCommend = 0;
    private volatile int mStatus;
    private String mTag;

    protected abstract void a(i iVar);

    protected abstract void b(i iVar);

    protected abstract Map<String, String> c(i iVar);

    protected abstract RandomAccessFile getFile(File file, String str, long j) throws IOException;

    protected abstract int getResponseCode();

    protected abstract String getTag();

    public d(a aVar, i iVar, e.a aVar2) {
        this.gkt = aVar;
        this.gku = iVar;
        this.gkv = aVar2;
        this.mTag = getTag();
        if (TextUtils.isEmpty(this.mTag)) {
            this.mTag = getClass().getSimpleName();
        }
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e
    public void cancel() {
        this.mCommend = 107;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e
    public void pause() {
        this.mCommend = 106;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e
    public boolean isDownloading() {
        return this.mStatus == 104;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.e
    public boolean isComplete() {
        return this.mStatus == 105;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        a(this.gku);
        try {
            this.mStatus = 104;
            executeDownload();
            synchronized (this.gkv) {
                this.mStatus = 105;
                this.gkv.onDownloadCompleted(createFileSavedPath());
            }
        } catch (DownloadException e) {
            e(e);
        }
    }

    private void e(DownloadException downloadException) {
        if (downloadException.getErrorCode() == 108) {
            synchronized (this.gkv) {
                this.mStatus = 108;
                this.gkv.c(downloadException);
            }
        } else if (downloadException.getErrorCode() == 106) {
            synchronized (this.gkv) {
                this.mStatus = 106;
                this.gkv.onDownloadPaused();
            }
        } else if (downloadException.getErrorCode() == 107) {
            synchronized (this.gkv) {
                this.mStatus = 107;
                this.gkv.onDownloadCanceled();
            }
        } else {
            throw new IllegalArgumentException("Unknown state");
        }
    }

    private void executeDownload() throws DownloadException {
        HttpURLConnection httpURLConnection;
        try {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.gku.getUri()).openConnection();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (ProtocolException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                httpURLConnection.setConnectTimeout(4000);
                httpURLConnection.setReadTimeout(4000);
                httpURLConnection.setRequestMethod("GET");
                setHttpHeader(c(this.gku), httpURLConnection);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == getResponseCode()) {
                    transferData(httpURLConnection);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
                throw new DownloadException(108, "UnSupported response code:" + responseCode);
            } catch (ProtocolException e3) {
                e = e3;
                throw new DownloadException(108, "Protocol error", e);
            } catch (IOException e4) {
                e = e4;
                throw new DownloadException(108, "IO error", e);
            } catch (Throwable th2) {
                httpURLConnection2 = httpURLConnection;
                th = th2;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException e5) {
            throw new DownloadException(108, "Bad url.", e5);
        }
    }

    private void setHttpHeader(Map<String, String> map, URLConnection uRLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                uRLConnection.setRequestProperty(str, map.get(str));
            }
        }
    }

    private void transferData(HttpURLConnection httpURLConnection) throws DownloadException {
        InputStream inputStream;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
            } catch (IOException e) {
                throw new DownloadException(108, "http get inputStream error", e);
            }
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            long start = this.gku.getStart() + this.gku.getFinished();
            try {
                File dir = this.gkt.getDir();
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                RandomAccessFile file = getFile(dir, this.gkt.getName(), start);
                transferData(inputStream, file);
                try {
                    close(inputStream);
                    close(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                throw new DownloadException(108, "File occur IOException ", e3);
            } catch (Exception e4) {
                throw new DownloadException(108, "Occur Exception ", e4);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                close(inputStream);
                close(null);
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    private void transferData(InputStream inputStream, RandomAccessFile randomAccessFile) throws DownloadException {
        byte[] bArr = new byte[8192];
        while (true) {
            checkPausedOrCanceled();
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    randomAccessFile.write(bArr, 0, read);
                    this.gku.setFinished(this.gku.getFinished() + read);
                    synchronized (this.gkv) {
                        this.gkt.setFinished(this.gkt.getFinished() + read);
                        this.gkv.onDownloadProgress(this.gkt.getFinished(), this.gkt.getLength());
                    }
                } else {
                    return;
                }
            } catch (IOException e) {
                b(this.gku);
                throw new DownloadException(108, e);
            }
        }
    }

    private void checkPausedOrCanceled() throws DownloadException {
        if (this.mCommend == 107) {
            throw new DownloadException(107, "Download canceled!");
        }
        if (this.mCommend == 106) {
            b(this.gku);
            throw new DownloadException(106, "Download paused!");
        }
    }

    private final void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            synchronized (d.class) {
                closeable.close();
            }
        }
    }

    private final String createFileSavedPath() {
        return this.gkt.getDir().getAbsolutePath() + File.separator + this.gkt.getName();
    }
}
