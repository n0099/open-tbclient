package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(t tVar) {
        this.aZF = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.aZF.aZl;
        if (textureVideoView != null) {
            textureVideoView2 = this.aZF.aZl;
            if (!textureVideoView2.isPlaying()) {
                this.aZF.d(true, 1);
            }
        }
    }
}
