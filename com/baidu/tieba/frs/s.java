package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0054a {
    final /* synthetic */ r bNK;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str) {
        this.bNK = rVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0054a
    public void So() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bNK.bNJ;
        com.baidu.tbadk.browser.f.S(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10502");
        frsActivity2 = this.bNK.bNJ;
        com.baidu.tbadk.core.util.as aa = asVar.aa("fid", frsActivity2.bME.aJw().getId());
        frsActivity3 = this.bNK.bNJ;
        TiebaStatic.log(aa.aa(SapiAccountManager.SESSION_UID, frsActivity3.bME.getUserData().getUserId()));
    }
}
