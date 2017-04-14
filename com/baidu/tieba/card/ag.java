package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ x bsX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar) {
        this.bsX = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bsX.bsH;
        if (quickVideoView != null) {
            quickVideoView2 = this.bsX.bsH;
            if (!quickVideoView2.isPlaying()) {
                this.bsX.e(true, 1);
            }
        }
    }
}
