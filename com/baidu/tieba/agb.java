package com.baidu.tieba;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes5.dex */
public interface agb {
    void a(DownloadException downloadException);

    void b(DownloadException downloadException);

    void onConnectCanceled();

    void onConnected(long j, long j2, boolean z);

    void onConnecting();

    void onDownloadCanceled();

    void onDownloadCompleted(String str);

    void onDownloadPaused();

    void onDownloadProgress(long j, long j2, int i);

    void onStarted();
}
