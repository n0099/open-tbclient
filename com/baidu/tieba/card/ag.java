package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ x btf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(x xVar) {
        this.btf = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.btf.bsP;
        if (quickVideoView != null) {
            quickVideoView2 = this.btf.bsP;
            if (!quickVideoView2.isPlaying()) {
                this.btf.e(true, 1);
            }
        }
    }
}
