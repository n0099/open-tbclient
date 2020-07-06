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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c fhs;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a fhu;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.fhs = cVar;
            this.fhu = this.fhs.bsq();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.fhs.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.fhu.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.fhs.getLength() + " acceptRanges: " + this.fhs.isAcceptRanges());
                    this.fhu.onConnected(this.fhs.getLength(), this.fhs.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.fhs.getFinished() + " length: " + this.fhs.getLength() + " percent: " + this.fhs.getPercent());
                    this.fhu.onProgress(this.fhs.getFinished(), this.fhs.getLength(), this.fhs.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.fhs.getSavedPath());
                    if (!this.fhs.getCalledCompleted()) {
                        this.fhs.setCalledCompleted(true);
                        this.fhu.onCompleted(this.fhs.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.fhu.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.fhu.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.fhs.getException().getCause());
                    this.fhu.a((DownloadException) this.fhs.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
