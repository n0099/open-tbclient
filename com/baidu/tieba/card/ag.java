package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(z zVar) {
        this.aUu = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.aUu.aUd;
        if (textureVideoView != null) {
            textureVideoView2 = this.aUu.aUd;
            if (!textureVideoView2.isPlaying()) {
                this.aUu.e(true, 1);
            }
        }
    }
}
