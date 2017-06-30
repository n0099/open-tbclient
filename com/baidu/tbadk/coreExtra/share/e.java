package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d asQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.asQ = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void Az() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AA() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AB() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), w.l.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AC() {
    }
}
