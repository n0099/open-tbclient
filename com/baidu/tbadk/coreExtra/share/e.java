package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d adk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.adk = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wF() {
        n.showToast(TbadkCoreApplication.m411getInst().getContext(), y.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wG() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wH() {
        n.showToast(TbadkCoreApplication.m411getInst().getContext(), y.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wI() {
    }
}
