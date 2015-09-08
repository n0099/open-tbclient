package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d ajO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ajO = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yP() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.h.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yQ() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yR() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.h.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yS() {
    }
}
