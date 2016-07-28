package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements TextureVideoView.b {
    final /* synthetic */ a bLV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bLV = aVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void vx() {
        this.bLV.stopPlay();
    }
}
