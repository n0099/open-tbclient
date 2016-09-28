package com.baidu.tieba.frs.i;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.cft = pVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        am amVar;
        aVar.dismiss();
        frsActivity = this.cft.bWH;
        com.baidu.tieba.tbadkCore.p abe = frsActivity.abe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            frsActivity2 = this.cft.bWH;
            m9getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cft.getPageContext().getPageActivity(), this.cft.getPageContext().getString(r.j.login_to_use), true, 11036)));
        } else if (abe != null && abe.aMr() != null) {
            amVar = this.cft.cfp;
            amVar.t(abe.aMr().getName(), com.baidu.adp.lib.h.b.c(abe.aMr().getId(), 0L));
        }
    }
}
