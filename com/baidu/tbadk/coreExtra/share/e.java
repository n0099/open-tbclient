package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d ajm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ajm = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zd() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), u.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void ze() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zf() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), u.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void zg() {
    }
}
