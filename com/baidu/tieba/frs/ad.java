package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0061a {
    final /* synthetic */ ac cdn;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, String str) {
        this.cdn = acVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0061a
    public void Uz() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.cdn.cdl;
        com.baidu.tbadk.browser.g.T(rVar.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10502");
        rVar2 = this.cdn.cdl;
        com.baidu.tbadk.core.util.au Z = auVar.Z("fid", rVar2.cbN.aMt().getId());
        rVar3 = this.cdn.cdl;
        TiebaStatic.log(Z.Z(SapiAccountManager.SESSION_UID, rVar3.cbN.getUserData().getUserId()));
    }
}
