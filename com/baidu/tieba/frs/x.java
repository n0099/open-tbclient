package com.baidu.tieba.frs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class x implements a.InterfaceC0053a {
    final /* synthetic */ w bQt;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str) {
        this.bQt = wVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0053a
    public void Np() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bQt.bQp;
        com.baidu.tbadk.browser.f.u(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10502");
        frsActivity2 = this.bQt.bQp;
        com.baidu.tbadk.core.util.ay ab = ayVar.ab("fid", frsActivity2.bPq.aLP().getId());
        frsActivity3 = this.bQt.bQp;
        TiebaStatic.log(ab.ab("uid", frsActivity3.bPq.getUserData().getUserId()));
    }
}
