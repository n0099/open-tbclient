package com.baidu.tieba.ala.alaar.sticker.download.a;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public interface b {
    void b(DownloadException downloadException);

    void c(DownloadException downloadException);

    void onConnectCanceled();

    void onConnected(long j, long j2, boolean z);

    void onConnecting();

    void onDownloadCanceled();

    void onDownloadCompleted(String str);

    void onDownloadPaused();

    void onDownloadProgress(long j, long j2, int i);

    void onStarted();
}
