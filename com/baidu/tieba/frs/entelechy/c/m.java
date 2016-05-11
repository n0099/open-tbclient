package com.baidu.tieba.frs.entelechy.c;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TextureVideoView.a {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.bpG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.a
    public void vt() {
        boolean z;
        if (com.baidu.tbadk.core.view.at.vD().vH()) {
            z = this.bpG.aPU;
            if (!z) {
                this.bpG.cg(false);
            }
        }
    }
}
