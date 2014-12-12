package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d SI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.SI = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void tc() {
        l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void td() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void te() {
        l.showToast(TbadkCoreApplication.m255getInst().getContext(), z.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void tf() {
    }
}
