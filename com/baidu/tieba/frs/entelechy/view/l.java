package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bTB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bTB.bsP;
        if (quickVideoView != null) {
            quickVideoView2 = this.bTB.bsP;
            if (!quickVideoView2.isPlaying()) {
                this.bTB.e(true, 1);
            }
        }
    }
}
