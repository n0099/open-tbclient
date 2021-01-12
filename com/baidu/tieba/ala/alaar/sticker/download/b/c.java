package com.baidu.tieba.ala.alaar.sticker.download.b;

import android.os.Handler;
import com.baidu.tieba.ala.alaar.sticker.download.exception.DownloadException;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
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

    /* loaded from: classes10.dex */
    private static class a implements Runnable {
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c gqi;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a gqk;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.gqi = cVar;
            this.gqk = this.gqi.bPh();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.gqi.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.gqk.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.gqi.getLength() + " acceptRanges: " + this.gqi.isAcceptRanges());
                    this.gqk.onConnected(this.gqi.getLength(), this.gqi.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.gqi.getFinished() + " length: " + this.gqi.getLength() + " percent: " + this.gqi.getPercent());
                    this.gqk.onProgress(this.gqi.getFinished(), this.gqi.getLength(), this.gqi.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.gqi.getSavedPath());
                    if (!this.gqi.getCalledCompleted()) {
                        this.gqi.setCalledCompleted(true);
                        this.gqk.onCompleted(this.gqi.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.gqk.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.gqk.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.gqi.getException().getCause());
                    this.gqk.a((DownloadException) this.gqi.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
