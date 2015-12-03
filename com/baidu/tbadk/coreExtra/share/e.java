package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d akE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.akE = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zx() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.i.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zy() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zz() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), n.i.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zA() {
    }
}
