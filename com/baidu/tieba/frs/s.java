package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0054a {
    final /* synthetic */ r bQb;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str) {
        this.bQb = rVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0054a
    public void Tq() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bQb.bQa;
        com.baidu.tbadk.browser.f.S(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10502");
        frsActivity2 = this.bQb.bQa;
        com.baidu.tbadk.core.util.as aa = asVar.aa("fid", frsActivity2.bOV.aKx().getId());
        frsActivity3 = this.bQb.bQa;
        TiebaStatic.log(aa.aa(SapiAccountManager.SESSION_UID, frsActivity3.bOV.getUserData().getUserId()));
    }
}
