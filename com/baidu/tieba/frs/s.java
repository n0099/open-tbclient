package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0055a {
    final /* synthetic */ r bNV;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str) {
        this.bNV = rVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0055a
    public void RQ() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bNV.bNU;
        com.baidu.tbadk.browser.f.O(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10502");
        frsActivity2 = this.bNV.bNU;
        com.baidu.tbadk.core.util.as Z = asVar.Z("fid", frsActivity2.bMO.aJp().getId());
        frsActivity3 = this.bNV.bNU;
        TiebaStatic.log(Z.Z(SapiAccountManager.SESSION_UID, frsActivity3.bMO.getUserData().getUserId()));
    }
}
