package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class ac implements a.InterfaceC0058a {
    final /* synthetic */ ab bPo;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, String str) {
        this.bPo = abVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0058a
    public void SL() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.bPo.bPn;
        com.baidu.tbadk.browser.f.S(rVar.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.as asVar = new com.baidu.tbadk.core.util.as("c10502");
        rVar2 = this.bPo.bPn;
        com.baidu.tbadk.core.util.as aa = asVar.aa("fid", rVar2.bNT.aHE().getId());
        rVar3 = this.bPo.bPn;
        TiebaStatic.log(aa.aa(SapiAccountManager.SESSION_UID, rVar3.bNT.getUserData().getUserId()));
    }
}
