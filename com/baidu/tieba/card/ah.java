package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ y bBb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(y yVar) {
        this.bBb = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bBb.bAC;
        if (quickVideoView != null) {
            quickVideoView2 = this.bBb.bAC;
            if (!quickVideoView2.isPlaying()) {
                this.bBb.f(true, 1);
            }
        }
    }
}
