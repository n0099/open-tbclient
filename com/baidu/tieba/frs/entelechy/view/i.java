package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ a bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bKn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.bKn.aTh;
        if (textureVideoView != null) {
            textureVideoView2 = this.bKn.aTh;
            if (!textureVideoView2.isPlaying()) {
                this.bKn.d(true, 1);
            }
        }
    }
}
