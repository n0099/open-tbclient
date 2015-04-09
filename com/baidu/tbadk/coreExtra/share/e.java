package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d ads;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.ads = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wL() {
        n.showToast(TbadkCoreApplication.m411getInst().getContext(), y.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wM() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wN() {
        n.showToast(TbadkCoreApplication.m411getInst().getContext(), y.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void wO() {
    }
}
