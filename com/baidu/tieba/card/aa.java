package com.baidu.tieba.card;

import com.baidu.tieba.play.QuickVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ r aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(r rVar) {
        this.aZW = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        QuickVideoView quickVideoView;
        QuickVideoView quickVideoView2;
        quickVideoView = this.aZW.aZG;
        if (quickVideoView != null) {
            quickVideoView2 = this.aZW.aZG;
            if (!quickVideoView2.isPlaying()) {
                this.aZW.e(true, 1);
            }
        }
    }
}
