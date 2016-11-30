package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.cax = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.cax.bcQ;
        if (quickVideoView != null) {
            quickVideoView2 = this.cax.bcQ;
            if (!quickVideoView2.isPlaying()) {
                this.cax.e(true, 1);
            }
        }
    }
}
