package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d ajF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ajF = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yI() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.C0057i.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yJ() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yK() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.C0057i.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yL() {
    }
}
