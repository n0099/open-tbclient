package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d amO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.amO = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Av() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Aw() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Ax() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Ay() {
    }
}
