package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements TextureVideoView.b {
    final /* synthetic */ z aUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(z zVar) {
        this.aUu = zVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void vx() {
        this.aUu.stopPlay();
    }
}
