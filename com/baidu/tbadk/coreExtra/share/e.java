package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d alK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.alK = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zj() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zk() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zl() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zm() {
    }
}
