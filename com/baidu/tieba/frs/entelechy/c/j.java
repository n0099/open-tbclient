package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bpG = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TextureVideoView textureVideoView;
        TextureVideoView textureVideoView2;
        textureVideoView = this.bpG.aPL;
        if (textureVideoView != null) {
            textureVideoView2 = this.bpG.aPL;
            if (!textureVideoView2.isPlaying()) {
                this.bpG.e(true, 1);
            }
        }
    }
}
