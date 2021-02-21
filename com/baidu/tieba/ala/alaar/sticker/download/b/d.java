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
/* loaded from: classes11.dex */
public abstract class d implements com.baidu.tieba.ala.alaar.sticker.download.a.e {
    private final a gtj;
    private final i gtk;
    private final e.a gtl;
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
        this.gtj = aVar;
        this.gtk = iVar;
        this.gtl = aVar2;
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
        a(this.gtk);
        try {
            this.mStatus = 104;
            executeDownload();
            synchronized (this.gtl) {
                this.mStatus = 105;
                this.gtl.onDownloadCompleted(createFileSavedPath());
            }
        } catch (DownloadException e) {
            e(e);
        }
    }

    private void e(DownloadException downloadException) {
        if (downloadException.getErrorCode() == 108) {
            synchronized (this.gtl) {
                this.mStatus = 108;
                this.gtl.c(downloadException);
            }
        } else if (downloadException.getErrorCode() == 106) {
            synchronized (this.gtl) {
                this.mStatus = 106;
                this.gtl.onDownloadPaused();
            }
        } else if (downloadException.getErrorCode() == 107) {
            synchronized (this.gtl) {
                this.mStatus = 107;
                this.gtl.onDownloadCanceled();
            }
        } else {
            throw new IllegalArgumentException("Unknown state");
        }
    }

    private void executeDownload() throws DownloadException {
        IOException e;
        ProtocolException e2;
        Throwable th;
        HttpURLConnection httpURLConnection;
        try {
            HttpURLConnection httpURLConnection2 = null;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.gtk.getUri()).openConnection();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (ProtocolException e3) {
                e2 = e3;
            } catch (IOException e4) {
                e = e4;
            }
            try {
                httpURLConnection.setConnectTimeout(4000);
                httpURLConnection.setReadTimeout(4000);
                httpURLConnection.setRequestMethod("GET");
                setHttpHeader(c(this.gtk), httpURLConnection);
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
            } catch (ProtocolException e5) {
                e2 = e5;
                throw new DownloadException(108, "Protocol error", e2);
            } catch (IOException e6) {
                e = e6;
                throw new DownloadException(108, "IO error", e);
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (MalformedURLException e7) {
            throw new DownloadException(108, "Bad url.", e7);
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
        RandomAccessFile randomAccessFile;
        InputStream inputStream;
        try {
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    long start = this.gtk.getStart() + this.gtk.getFinished();
                    try {
                        File dir = this.gtj.getDir();
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        randomAccessFile = getFile(dir, this.gtj.getName(), start);
                        try {
                            transferData(inputStream, randomAccessFile);
                            try {
                                close(inputStream);
                                close(randomAccessFile);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                close(inputStream);
                                close(randomAccessFile);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        throw new DownloadException(108, "File occur IOException ", e3);
                    } catch (Exception e4) {
                        throw new DownloadException(108, "Occur Exception ", e4);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                }
            } catch (IOException e5) {
                throw new DownloadException(108, "http get inputStream error", e5);
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            inputStream = null;
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
                    this.gtk.setFinished(this.gtk.getFinished() + read);
                    synchronized (this.gtl) {
                        this.gtj.setFinished(this.gtj.getFinished() + read);
                        this.gtl.onDownloadProgress(this.gtj.getFinished(), this.gtj.getLength());
                    }
                } else {
                    return;
                }
            } catch (IOException e) {
                b(this.gtk);
                throw new DownloadException(108, e);
            }
        }
    }

    private void checkPausedOrCanceled() throws DownloadException {
        if (this.mCommend == 107) {
            throw new DownloadException(107, "Download canceled!");
        }
        if (this.mCommend == 106) {
            b(this.gtk);
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
        return this.gtj.getDir().getAbsolutePath() + File.separator + this.gtj.getName();
    }
}
