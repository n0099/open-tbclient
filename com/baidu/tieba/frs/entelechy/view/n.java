package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements TextureVideoView.b {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.bXm = aVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void onSurfaceDestroyed() {
        this.bXm.stopPlay();
    }
}
