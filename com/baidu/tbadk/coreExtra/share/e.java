package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ d aiQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aiQ = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yB() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.h.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yC() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yD() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), i.h.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yE() {
    }
}
