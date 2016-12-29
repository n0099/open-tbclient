package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d ank;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ank = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Ap() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Aq() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Ar() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void As() {
    }
}
