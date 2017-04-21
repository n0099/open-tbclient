package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ x bvq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar) {
        this.bvq = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bvq.bva;
        if (quickVideoView != null) {
            quickVideoView2 = this.bvq.bva;
            if (!quickVideoView2.isPlaying()) {
                this.bvq.f(true, 1);
            }
        }
    }
}
