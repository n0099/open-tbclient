package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class u implements NoNetworkView.a {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aL(boolean z) {
        if (this.bzl.byr.aaO() == 1 && z && !this.bzl.byg.WG()) {
            if (this.bzl.byh == null || com.baidu.tbadk.core.util.x.t(this.bzl.byh.getThreadList())) {
                this.bzl.hideNetRefreshView(this.bzl.byg.Xv());
                this.bzl.showLoadingView(this.bzl.byg.Xv(), true);
                this.bzl.byg.dy(false);
                this.bzl.refresh();
                return;
            }
            this.bzl.byg.Xj();
        }
    }
}
