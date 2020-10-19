package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.download.a.g;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import com.baidubce.http.Headers;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/* loaded from: classes4.dex */
public class f implements com.baidu.tieba.ala.alaar.sticker.download.a.g {
    private final g.a fNF;
    private volatile long mStartTime;
    private volatile int mStatus;
    private final String mUri;

    public f(String str, g.a aVar) {
        this.mUri = str;
        this.fNF = aVar;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g
    public void pause() {
        this.mStatus = 106;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g
    public void cancel() {
        this.mStatus = 107;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g
    public boolean isPaused() {
        return this.mStatus == 106;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.g
    public boolean isCanceled() {
        return this.mStatus == 107;
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.mStatus = 102;
        this.fNF.onConnecting();
        try {
            executeConnection();
        } catch (DownloadException e) {
            e(e);
        }
    }

    private void executeConnection() throws DownloadException {
        HttpURLConnection httpURLConnection;
        this.mStartTime = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.mUri).openConnection();
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
                httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=0-");
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    parseResponse(httpURLConnection, false);
                } else if (responseCode == 206) {
                    parseResponse(httpURLConnection, true);
                } else {
                    throw new DownloadException(108, "UnSupported response code:" + responseCode);
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
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

    private void parseResponse(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        long contentLength;
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (TextUtils.isEmpty(headerField) || headerField.equals("0") || headerField.equals("-1")) {
            contentLength = httpURLConnection.getContentLength();
        } else {
            contentLength = Long.parseLong(headerField);
        }
        if (contentLength <= 0) {
            String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
            if (TextUtils.isEmpty(headerField2) || headerField2.equals("0") || headerField2.equals("-1")) {
                contentLength = httpURLConnection.getContentLength();
            } else {
                contentLength = Long.parseLong(headerField2);
            }
            if (contentLength <= 0) {
                throw new DownloadException(108, "length <= 0");
            }
        }
        checkCanceledOrPaused();
        this.mStatus = 103;
        this.fNF.onConnected(System.currentTimeMillis() - this.mStartTime, contentLength, z);
    }

    private void checkCanceledOrPaused() throws DownloadException {
        if (isCanceled()) {
            throw new DownloadException(107, "Connection Canceled!");
        }
        if (isPaused()) {
            throw new DownloadException(106, "Connection Paused!");
        }
    }

    private void e(DownloadException downloadException) {
        if (downloadException.getErrorCode() == 108) {
            synchronized (this.fNF) {
                this.mStatus = 108;
                this.fNF.b(downloadException);
            }
        } else if (downloadException.getErrorCode() == 106) {
            synchronized (this.fNF) {
                this.mStatus = 106;
                this.fNF.onConnectPaused();
            }
        } else if (downloadException.getErrorCode() == 107) {
            synchronized (this.fNF) {
                this.mStatus = 107;
                this.fNF.onConnectCanceled();
            }
        } else {
            throw new IllegalArgumentException("Unknown state");
        }
    }
}
