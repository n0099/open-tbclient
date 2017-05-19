package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d ase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ase = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Al() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Am() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void An() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Ao() {
    }
}
