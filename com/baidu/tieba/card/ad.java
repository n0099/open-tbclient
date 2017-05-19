package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ u bvn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(u uVar) {
        this.bvn = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bvn.buW;
        if (quickVideoView != null) {
            quickVideoView2 = this.bvn.buW;
            if (!quickVideoView2.isPlaying()) {
                this.bvn.f(true, 1);
            }
        }
    }
}
