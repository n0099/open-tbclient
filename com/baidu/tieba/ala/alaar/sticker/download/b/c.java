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
        private final com.baidu.tieba.ala.alaar.sticker.download.a.c eWX;
        private final com.baidu.tieba.ala.alaar.sticker.download.a.a eWZ;

        public a(com.baidu.tieba.ala.alaar.sticker.download.a.c cVar) {
            this.eWX = cVar;
            this.eWZ = this.eWX.bpG();
        }

        @Override // java.lang.Runnable
        public void run() {
            switch (this.eWX.getStatus()) {
                case 102:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTING");
                    this.eWZ.onConnecting();
                    return;
                case 103:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CONNECTED length: " + this.eWX.getLength() + " acceptRanges: " + this.eWX.isAcceptRanges());
                    this.eWZ.onConnected(this.eWX.getLength(), this.eWX.isAcceptRanges());
                    return;
                case 104:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PROGRESS finished: " + this.eWX.getFinished() + " length: " + this.eWX.getLength() + " percent: " + this.eWX.getPercent());
                    this.eWZ.onProgress(this.eWX.getFinished(), this.eWX.getLength(), this.eWX.getPercent());
                    return;
                case 105:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_COMPLETED Path:" + this.eWX.getSavedPath());
                    if (!this.eWX.getCalledCompleted()) {
                        this.eWX.setCalledCompleted(true);
                        this.eWZ.onCompleted(this.eWX.getSavedPath());
                        return;
                    }
                    return;
                case 106:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_PAUSED");
                    this.eWZ.onDownloadPaused();
                    return;
                case 107:
                    com.baidu.tieba.ala.alaar.sticker.b.a.d("DownloadStatusDelivery", "STATUS_CANCELED");
                    this.eWZ.onDownloadCanceled();
                    return;
                case 108:
                    com.baidu.tieba.ala.alaar.sticker.b.a.e("DownloadStatusDelivery", "STATUS_FAILED error: " + this.eWX.getException().getCause());
                    this.eWZ.a((DownloadException) this.eWX.getException());
                    return;
                default:
                    return;
            }
        }
    }
}
