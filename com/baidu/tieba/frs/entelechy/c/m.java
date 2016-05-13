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
    public void vu() {
        boolean z;
        if (com.baidu.tbadk.core.view.at.vE().vI()) {
            z = this.bpG.aPU;
            if (!z) {
                this.bpG.cg(false);
            }
        }
    }
}
