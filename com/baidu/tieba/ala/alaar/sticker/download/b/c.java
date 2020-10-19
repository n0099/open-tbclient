package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Handler;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    private static class a implements Runnable {
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c fNv;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a fNx;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.fNv = cVar;
            this.fNx = this.fNv.bIx();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.fNv.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.fNx.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.fNv.getLength() + " acceptRanges: " + this.fNv.isAcceptRanges());
                    this.fNx.onConnected(this.fNv.getLength(), this.fNv.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.fNv.getFinished() + " length: " + this.fNv.getLength() + " percent: " + this.fNv.getPercent());
                    this.fNx.onProgress(this.fNv.getFinished(), this.fNv.getLength(), this.fNv.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.fNv.getSavedPath());
                    if (!this.fNv.getCalledCompleted()) {
                        this.fNv.setCalledCompleted(true);
                        this.fNx.onCompleted(this.fNv.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.fNx.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.fNx.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.fNv.getException().getCause());
                    this.fNx.a((DownloadException) this.fNv.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
