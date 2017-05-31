package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements NoNetworkView.a {
    final /* synthetic */ r bVb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(r rVar) {
        this.bVb = rVar;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        if (this.bVb.bUj.acU() == 1 && z && !this.bVb.bUa.aav()) {
            if (this.bVb.bTF == null || com.baidu.tbadk.core.util.x.r(this.bVb.bTF.getThreadList())) {
                this.bVb.hideNetRefreshView(this.bVb.bUa.TK());
                this.bVb.showLoadingView(this.bVb.bUa.TK(), true);
                this.bVb.bUa.ef(false);
                this.bVb.refresh();
                return;
            }
            this.bVb.bUa.aaH();
        }
    }
}
