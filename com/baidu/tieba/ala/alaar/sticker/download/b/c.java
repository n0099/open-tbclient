package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Handler;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c eKp;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a eKr;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.eKp = cVar;
            this.eKr = this.eKp.bkk();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.eKp.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.eKr.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.eKp.getLength() + " acceptRanges: " + this.eKp.isAcceptRanges());
                    this.eKr.onConnected(this.eKp.getLength(), this.eKp.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.eKp.getFinished() + " length: " + this.eKp.getLength() + " percent: " + this.eKp.getPercent());
                    this.eKr.onProgress(this.eKp.getFinished(), this.eKp.getLength(), this.eKp.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.eKp.getSavedPath());
                    if (!this.eKp.getCalledCompleted()) {
                        this.eKp.setCalledCompleted(true);
                        this.eKr.onCompleted(this.eKp.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.eKr.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.eKr.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.eKp.getException().getCause());
                    this.eKr.a((DownloadException) this.eKp.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
