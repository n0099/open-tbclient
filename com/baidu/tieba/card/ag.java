package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar) {
        this.bml = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bml.blV;
        if (quickVideoView != null) {
            quickVideoView2 = this.bml.blV;
            if (!quickVideoView2.isPlaying()) {
                this.bml.e(true, 1);
            }
        }
    }
}
