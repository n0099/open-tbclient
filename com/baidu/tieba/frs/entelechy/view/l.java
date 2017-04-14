package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bTp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bTp.bsH;
        if (quickVideoView != null) {
            quickVideoView2 = this.bTp.bsH;
            if (!quickVideoView2.isPlaying()) {
                this.bTp.e(true, 1);
            }
        }
    }
}
