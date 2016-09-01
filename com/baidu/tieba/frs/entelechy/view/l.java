package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bXm = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.bXm.aZl;
        if (textureVideoView != null) {
            textureVideoView2 = this.bXm.aZl;
            if (!textureVideoView2.isPlaying()) {
                this.bXm.d(true, 1);
            }
        }
    }
}
