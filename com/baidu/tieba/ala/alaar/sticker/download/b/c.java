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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c fWF;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a fWH;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.fWF = cVar;
            this.fWH = this.fWF.bKV();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.fWF.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.fWH.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.fWF.getLength() + " acceptRanges: " + this.fWF.isAcceptRanges());
                    this.fWH.onConnected(this.fWF.getLength(), this.fWF.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.fWF.getFinished() + " length: " + this.fWF.getLength() + " percent: " + this.fWF.getPercent());
                    this.fWH.onProgress(this.fWF.getFinished(), this.fWF.getLength(), this.fWF.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.fWF.getSavedPath());
                    if (!this.fWF.getCalledCompleted()) {
                        this.fWF.setCalledCompleted(true);
                        this.fWH.onCompleted(this.fWF.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.fWH.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.fWH.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.fWF.getException().getCause());
                    this.fWH.a((DownloadException) this.fWF.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
