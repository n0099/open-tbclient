package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements TextureVideoView.b {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(t tVar) {
        this.aZF = tVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void onSurfaceDestroyed() {
        this.aZF.stopPlay();
    }
}
