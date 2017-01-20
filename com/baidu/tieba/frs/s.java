package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0056a {
    final /* synthetic */ r bGM;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str) {
        this.bGM = rVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0056a
    public void QY() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bGM.bGL;
        com.baidu.tbadk.browser.f.u(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c10502");
        frsActivity2 = this.bGM.bGL;
        com.baidu.tbadk.core.util.ar ab = arVar.ab("fid", frsActivity2.bFG.aJY().getId());
        frsActivity3 = this.bGM.bGL;
        TiebaStatic.log(ab.ab(SapiAccountManager.SESSION_UID, frsActivity3.bFG.getUserData().getUserId()));
    }
}
