package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Handler;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes11.dex */
public class c implements com.baidu.tieba.ala.alaar.sticker.download.a.d {
    private Executor mDownloadStatusPoster;

    public c(final Handler handler) {
        this.mDownloadStatusPoster = new Executor() { // from class: com.baidu.tieba.ala.alaar.sticker.download.b.c.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.download.a.d
    public void a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
        this.mDownloadStatusPoster.execute(new a(cVar));
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c gtg;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a gti;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.gtg = cVar;
            this.gti = this.gtg.bPS();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.gtg.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.gti.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.gtg.getLength() + " acceptRanges: " + this.gtg.isAcceptRanges());
                    this.gti.onConnected(this.gtg.getLength(), this.gtg.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.gtg.getFinished() + " length: " + this.gtg.getLength() + " percent: " + this.gtg.getPercent());
                    this.gti.onProgress(this.gtg.getFinished(), this.gtg.getLength(), this.gtg.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.gtg.getSavedPath());
                    if (!this.gtg.getCalledCompleted()) {
                        this.gtg.setCalledCompleted(true);
                        this.gti.onCompleted(this.gtg.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.gti.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.gti.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.gtg.getException().getCause());
                    this.gti.a((DownloadException) this.gtg.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
