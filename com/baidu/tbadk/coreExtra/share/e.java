package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d anH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.anH = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AC() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AD() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AE() {
        k.showToast(TbadkCoreApplication.m9getInst().getContext(), r.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void AF() {
    }
}
