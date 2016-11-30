package com.baidu.tieba.frs.j;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar) {
        this.ckg = nVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        al alVar;
        aVar.dismiss();
        frsActivity = this.ckg.bZY;
        com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            frsActivity2 = this.ckg.bZY;
            m9getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.ckg.getPageContext().getPageActivity(), this.ckg.getPageContext().getString(r.j.login_to_use), true, 11036)));
        } else if (acr != null && acr.aOk() != null) {
            alVar = this.ckg.cka;
            alVar.u(acr.aOk().getName(), com.baidu.adp.lib.h.b.c(acr.aOk().getId(), 0L));
        }
    }
}
