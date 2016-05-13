package com.baidu.tieba.godSquare;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class c implements NoNetworkView.a {
    final /* synthetic */ GodSquareActivity bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GodSquareActivity godSquareActivity) {
        this.bKe = godSquareActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aF(boolean z) {
        com.baidu.tieba.godSquare.model.b bVar;
        d dVar;
        if (z) {
            bVar = this.bKe.bKb;
            if (!y.s(bVar.bdt)) {
                dVar = this.bKe.bKa;
                dVar.jy();
                return;
            }
            this.bKe.XW();
        }
    }
}
