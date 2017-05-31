package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class ad implements a.InterfaceC0058a {
    final /* synthetic */ ac bVe;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, String str) {
        this.bVe = acVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0058a
    public void SX() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.bVe.bVb;
        com.baidu.tbadk.browser.f.S(rVar.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10502");
        rVar2 = this.bVe.bVb;
        com.baidu.tbadk.core.util.as Z = asVar.Z("fid", rVar2.bTF.aIz().getId());
        rVar3 = this.bVe.bVb;
        TiebaStatic.log(Z.Z(SapiAccountManager.SESSION_UID, rVar3.bTF.getUserData().getUserId()));
    }
}
