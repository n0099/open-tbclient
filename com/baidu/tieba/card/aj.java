package com.baidu.tieba.card;

import com.baidu.tbadk.core.view.TextureVideoView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TextureVideoView.a {
    final /* synthetic */ z aQe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(z zVar) {
        this.aQe = zVar;
    }

    @Override // com.baidu.tbadk.core.view.TextureVideoView.a
    public void vt() {
        boolean z;
        if (com.baidu.tbadk.core.view.at.vD().vH()) {
            z = this.aQe.aPU;
            if (!z) {
                this.aQe.cg(false);
            }
        }
    }
}
