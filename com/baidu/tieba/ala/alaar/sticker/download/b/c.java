package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Handler;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c fxW;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a fxY;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.fxW = cVar;
            this.fxY = this.fxW.bEu();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.fxW.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.fxY.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.fxW.getLength() + " acceptRanges: " + this.fxW.isAcceptRanges());
                    this.fxY.onConnected(this.fxW.getLength(), this.fxW.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.fxW.getFinished() + " length: " + this.fxW.getLength() + " percent: " + this.fxW.getPercent());
                    this.fxY.onProgress(this.fxW.getFinished(), this.fxW.getLength(), this.fxW.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.fxW.getSavedPath());
                    if (!this.fxW.getCalledCompleted()) {
                        this.fxW.setCalledCompleted(true);
                        this.fxY.onCompleted(this.fxW.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.fxY.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.fxY.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.fxW.getException().getCause());
                    this.fxY.a((DownloadException) this.fxW.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
