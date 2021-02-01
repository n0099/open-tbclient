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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c gsS;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a gsU;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.gsS = cVar;
            this.gsU = this.gsS.bPL();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.gsS.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.gsU.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.gsS.getLength() + " acceptRanges: " + this.gsS.isAcceptRanges());
                    this.gsU.onConnected(this.gsS.getLength(), this.gsS.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.gsS.getFinished() + " length: " + this.gsS.getLength() + " percent: " + this.gsS.getPercent());
                    this.gsU.onProgress(this.gsS.getFinished(), this.gsS.getLength(), this.gsS.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.gsS.getSavedPath());
                    if (!this.gsS.getCalledCompleted()) {
                        this.gsS.setCalledCompleted(true);
                        this.gsU.onCompleted(this.gsS.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.gsU.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.gsU.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.gsS.getException().getCause());
                    this.gsU.a((DownloadException) this.gsS.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
