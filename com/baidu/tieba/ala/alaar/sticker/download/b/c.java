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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c gcd;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a gcf;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.gcd = cVar;
            this.gcf = this.gcd.bMN();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.gcd.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.gcf.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.gcd.getLength() + " acceptRanges: " + this.gcd.isAcceptRanges());
                    this.gcf.onConnected(this.gcd.getLength(), this.gcd.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.gcd.getFinished() + " length: " + this.gcd.getLength() + " percent: " + this.gcd.getPercent());
                    this.gcf.onProgress(this.gcd.getFinished(), this.gcd.getLength(), this.gcd.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.gcd.getSavedPath());
                    if (!this.gcd.getCalledCompleted()) {
                        this.gcd.setCalledCompleted(true);
                        this.gcf.onCompleted(this.gcd.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.gcf.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.gcf.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.gcd.getException().getCause());
                    this.gcf.a((DownloadException) this.gcd.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
