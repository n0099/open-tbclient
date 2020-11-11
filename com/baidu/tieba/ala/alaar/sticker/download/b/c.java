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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c gcw;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a gcy;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.gcw = cVar;
            this.gcy = this.gcw.bNu();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.gcw.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.gcy.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.gcw.getLength() + " acceptRanges: " + this.gcw.isAcceptRanges());
                    this.gcy.onConnected(this.gcw.getLength(), this.gcw.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.gcw.getFinished() + " length: " + this.gcw.getLength() + " percent: " + this.gcw.getPercent());
                    this.gcy.onProgress(this.gcw.getFinished(), this.gcw.getLength(), this.gcw.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.gcw.getSavedPath());
                    if (!this.gcw.getCalledCompleted()) {
                        this.gcw.setCalledCompleted(true);
                        this.gcy.onCompleted(this.gcw.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.gcy.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.gcy.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.gcw.getException().getCause());
                    this.gcy.a((DownloadException) this.gcw.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
