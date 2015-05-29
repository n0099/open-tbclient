package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d aey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aey = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void xy() {
        n.showToast(TbadkCoreApplication.m411getInst().getContext(), t.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void xz() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void xA() {
        n.showToast(TbadkCoreApplication.m411getInst().getContext(), t.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void xB() {
    }
}
