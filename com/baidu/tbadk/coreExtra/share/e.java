package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d amC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.amC = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AB() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AC() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AD() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AE() {
    }
}
