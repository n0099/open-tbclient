package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements TextureVideoView.b {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar) {
        this.bpG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.b
    public void vu() {
        this.bpG.stopPlay();
    }
}
