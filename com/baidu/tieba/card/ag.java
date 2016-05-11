package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar) {
        this.aQe = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.aQe.aPL;
        if (textureVideoView != null) {
            textureVideoView2 = this.aQe.aPL;
            if (!textureVideoView2.isPlaying()) {
                this.aQe.e(true, 1);
            }
        }
    }
}
