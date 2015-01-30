package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d Tp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.Tp = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void tt() {
        l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void tu() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void tv() {
        l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void tw() {
    }
}
