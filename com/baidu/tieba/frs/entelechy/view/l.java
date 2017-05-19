package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bTA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bTA = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bTA.buW;
        if (quickVideoView != null) {
            quickVideoView2 = this.bTA.buW;
            if (!quickVideoView2.isPlaying()) {
                this.bTA.f(true, 1);
            }
        }
    }
}
