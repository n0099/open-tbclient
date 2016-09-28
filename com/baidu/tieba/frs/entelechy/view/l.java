package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bXh = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.bXh.aZG;
        if (quickVideoView != null) {
            quickVideoView2 = this.bXh.aZG;
            if (!quickVideoView2.isPlaying()) {
                this.bXh.e(true, 1);
            }
        }
    }
}
