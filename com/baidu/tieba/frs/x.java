package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class x implements a.InterfaceC0056a {
    final /* synthetic */ w bQm;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str) {
        this.bQm = wVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0056a
    public void NQ() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bQm.bQi;
        com.baidu.tbadk.browser.f.u(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.ax axVar = new com.baidu.tbadk.core.util.ax("c10502");
        frsActivity2 = this.bQm.bQi;
        com.baidu.tbadk.core.util.ax ab = axVar.ab("fid", frsActivity2.bPk.aMr().getId());
        frsActivity3 = this.bQm.bQi;
        TiebaStatic.log(ab.ab("uid", frsActivity3.bPk.getUserData().getUserId()));
    }
}
