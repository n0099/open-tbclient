package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d MV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.MV = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void pG() {
        m.showToast(TbadkApplication.m251getInst(), y.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void pH() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void pI() {
        m.showToast(TbadkApplication.m251getInst(), y.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void pJ() {
    }
}
