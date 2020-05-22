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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c eWM;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a eWO;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.eWM = cVar;
            this.eWO = this.eWM.bpE();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.eWM.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.eWO.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.eWM.getLength() + " acceptRanges: " + this.eWM.isAcceptRanges());
                    this.eWO.onConnected(this.eWM.getLength(), this.eWM.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.eWM.getFinished() + " length: " + this.eWM.getLength() + " percent: " + this.eWM.getPercent());
                    this.eWO.onProgress(this.eWM.getFinished(), this.eWM.getLength(), this.eWM.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.eWM.getSavedPath());
                    if (!this.eWM.getCalledCompleted()) {
                        this.eWM.setCalledCompleted(true);
                        this.eWO.onCompleted(this.eWM.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.eWO.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.eWO.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.eWM.getException().getCause());
                    this.eWO.a((DownloadException) this.eWM.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
