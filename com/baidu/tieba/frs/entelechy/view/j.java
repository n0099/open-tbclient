package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bLV = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.bLV.aUd;
        if (textureVideoView != null) {
            textureVideoView2 = this.bLV.aUd;
            if (!textureVideoView2.isPlaying()) {
                this.bLV.e(true, 1);
            }
        }
    }
}
