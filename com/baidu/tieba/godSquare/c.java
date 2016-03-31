package com.baidu.tieba.godSquare;

import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class c implements NoNetworkView.a {
    final /* synthetic */ GodSquareActivity bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(GodSquareActivity godSquareActivity) {
        this.bJY = godSquareActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        com.baidu.tieba.godSquare.model.b bVar;
        d dVar;
        if (z) {
            bVar = this.bJY.bJV;
            if (!y.q(bVar.bKm)) {
                dVar = this.bJY.bJU;
                dVar.nk();
                return;
            }
            this.bJY.XW();
        }
    }
}
