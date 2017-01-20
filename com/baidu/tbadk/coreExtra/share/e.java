package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d amq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.amq = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Ak() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.l.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Al() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Am() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.l.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void An() {
    }
}
