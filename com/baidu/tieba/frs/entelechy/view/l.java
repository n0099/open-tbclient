package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bMu = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bMu.blV;
        if (quickVideoView != null) {
            quickVideoView2 = this.bMu.blV;
            if (!quickVideoView2.isPlaying()) {
                this.bMu.e(true, 1);
            }
        }
    }
}
