package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bZs = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bZs.bAC;
        if (quickVideoView != null) {
            quickVideoView2 = this.bZs.bAC;
            if (!quickVideoView2.isPlaying()) {
                this.bZs.f(true, 1);
            }
        }
    }
}
