package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bVG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bVG.bva;
        if (quickVideoView != null) {
            quickVideoView2 = this.bVG.bva;
            if (!quickVideoView2.isPlaying()) {
                this.bVG.f(true, 1);
            }
        }
    }
}
