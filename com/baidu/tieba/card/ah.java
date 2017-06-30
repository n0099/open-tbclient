package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Runnable {
    final /* synthetic */ y bBU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(y yVar) {
        this.bBU = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bBU.bBv;
        if (quickVideoView != null) {
            quickVideoView2 = this.bBU.bBv;
            if (!quickVideoView2.isPlaying()) {
                this.bBU.f(true, 1);
            }
        }
    }
}
