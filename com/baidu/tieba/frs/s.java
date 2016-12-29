package com.baidu.tieba.frs;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class s implements a.InterfaceC0056a {
    final /* synthetic */ r bzm;
    private final /* synthetic */ String val$url;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, String str) {
        this.bzm = rVar;
        this.val$url = str;
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0056a
    public void Of() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bzm.bzl;
        f.u(frsActivity.getPageContext().getPageActivity(), this.val$url);
        com.baidu.tbadk.core.util.at atVar = new com.baidu.tbadk.core.util.at("c10502");
        frsActivity2 = this.bzm.bzl;
        com.baidu.tbadk.core.util.at ab = atVar.ab("fid", frsActivity2.byh.aIk().getId());
        frsActivity3 = this.bzm.bzl;
        TiebaStatic.log(ab.ab(SapiAccountManager.SESSION_UID, frsActivity3.byh.getUserData().getUserId()));
    }
}
