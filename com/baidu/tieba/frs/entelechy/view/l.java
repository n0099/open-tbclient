package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.chB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.chB.bBv;
        if (quickVideoView != null) {
            quickVideoView2 = this.chB.bBv;
            if (!quickVideoView2.isPlaying()) {
                this.chB.f(true, 1);
            }
        }
    }
}
