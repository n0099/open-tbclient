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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c fmB;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a fmD;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.fmB = cVar;
            this.fmD = this.fmB.bvz();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.fmB.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.fmD.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.fmB.getLength() + " acceptRanges: " + this.fmB.isAcceptRanges());
                    this.fmD.onConnected(this.fmB.getLength(), this.fmB.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.fmB.getFinished() + " length: " + this.fmB.getLength() + " percent: " + this.fmB.getPercent());
                    this.fmD.onProgress(this.fmB.getFinished(), this.fmB.getLength(), this.fmB.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.fmB.getSavedPath());
                    if (!this.fmB.getCalledCompleted()) {
                        this.fmB.setCalledCompleted(true);
                        this.fmD.onCompleted(this.fmB.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.fmD.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.fmD.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.fmB.getException().getCause());
                    this.fmD.a((DownloadException) this.fmB.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
