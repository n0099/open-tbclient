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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c eKk;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a eKm;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.eKk = cVar;
            this.eKm = this.eKk.bkm();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.eKk.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.eKm.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.eKk.getLength() + " acceptRanges: " + this.eKk.isAcceptRanges());
                    this.eKm.onConnected(this.eKk.getLength(), this.eKk.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.eKk.getFinished() + " length: " + this.eKk.getLength() + " percent: " + this.eKk.getPercent());
                    this.eKm.onProgress(this.eKk.getFinished(), this.eKk.getLength(), this.eKk.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.eKk.getSavedPath());
                    if (!this.eKk.getCalledCompleted()) {
                        this.eKk.setCalledCompleted(true);
                        this.eKm.onCompleted(this.eKk.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.eKm.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.eKm.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.eKk.getException().getCause());
                    this.eKm.a((DownloadException) this.eKk.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
