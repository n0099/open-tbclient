package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ z aTy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar) {
        this.aTy = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.aTy.aTh;
        if (textureVideoView != null) {
            textureVideoView2 = this.aTy.aTh;
            if (!textureVideoView2.isPlaying()) {
                this.aTy.d(true, 1);
            }
        }
    }
}
