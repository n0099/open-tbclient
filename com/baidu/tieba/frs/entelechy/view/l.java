package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bGf = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bGf.bci;
        if (quickVideoView != null) {
            quickVideoView2 = this.bGf.bci;
            if (!quickVideoView2.isPlaying()) {
                this.bGf.e(true, 1);
            }
        }
    }
}
