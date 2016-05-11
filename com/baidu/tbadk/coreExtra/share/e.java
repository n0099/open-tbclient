package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d aiG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aiG = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yX() {
        k.showToast(TbadkCoreApplication.m11getInst().getContext(), t.j.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yY() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void yZ() {
        k.showToast(TbadkCoreApplication.m11getInst().getContext(), t.j.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void za() {
    }
}
