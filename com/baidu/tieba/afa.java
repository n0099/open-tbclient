package com.baidu.tieba;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes3.dex */
public interface afa extends Runnable {

    /* loaded from: classes3.dex */
    public interface a {
        void b(DownloadException downloadException);

        void onConnectCanceled();

        void onConnectPaused();

        void onConnected(long j, long j2, boolean z);

        void onConnecting();
    }

    void cancel();

    boolean isCanceled();

    boolean isPaused();

    void pause();
}
