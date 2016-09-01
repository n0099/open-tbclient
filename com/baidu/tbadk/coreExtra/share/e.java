package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d ang;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ang = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void As() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), t.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void At() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Au() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), t.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Av() {
    }
}
