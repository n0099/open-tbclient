package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d amT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.amT = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Be() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Bf() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Bg() {
        k.showToast(TbadkCoreApplication.m411getInst().getContext(), t.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Bh() {
    }
}
