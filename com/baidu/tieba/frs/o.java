package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class o implements a.InterfaceC0056a {
    final /* synthetic */ n bTb;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, String str) {
        this.bTb = nVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0056a
    public void OT() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bTb.bTa;
        com.baidu.tbadk.browser.f.u(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10502");
        frsActivity2 = this.bTb.bTa;
        com.baidu.tbadk.core.util.av ab = avVar.ab("fid", frsActivity2.bRX.aOk().getId());
        frsActivity3 = this.bTb.bTa;
        TiebaStatic.log(ab.ab("uid", frsActivity3.bRX.getUserData().getUserId()));
    }
}
