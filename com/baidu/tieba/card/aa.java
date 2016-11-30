package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.bde = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bde.bcQ;
        if (quickVideoView != null) {
            quickVideoView2 = this.bde.bcQ;
            if (!quickVideoView2.isPlaying()) {
                this.bde.e(true, 1);
            }
        }
    }
}
