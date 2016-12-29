package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ t bcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(t tVar) {
        this.bcw = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bcw.bci;
        if (quickVideoView != null) {
            quickVideoView2 = this.bcw.bci;
            if (!quickVideoView2.isPlaying()) {
                this.bcw.e(true, 1);
            }
        }
    }
}
