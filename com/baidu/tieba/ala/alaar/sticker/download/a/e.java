package com.baidu.tieba.ala.alaar.sticker.download.a;

import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
/* loaded from: classes3.dex */
public interface e extends Runnable {

    /* loaded from: classes3.dex */
    public interface a {
        void c(DownloadException downloadException);

        void onDownloadCanceled();

        void onDownloadCompleted(String str);

        void onDownloadPaused();

        void onDownloadProgress(long j, long j2);
    }

    void cancel();

    boolean isComplete();

    boolean isDownloading();

    void pause();
}
