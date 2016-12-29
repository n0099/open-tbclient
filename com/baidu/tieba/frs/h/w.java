package com.baidu.tieba.frs.h;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.b {
    final /* synthetic */ s bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.bPp = sVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tieba.tbadkCore.ak akVar;
        aVar.dismiss();
        frsActivity = this.bPp.bFI;
        com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            frsActivity2 = this.bPp.bFI;
            m9getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bPp.getPageContext().getPageActivity(), this.bPp.getPageContext().getString(r.j.login_to_use), true, 11036)));
        } else if (WF != null && WF.aIk() != null) {
            akVar = this.bPp.bPj;
            akVar.t(WF.aIk().getName(), com.baidu.adp.lib.h.b.c(WF.aIk().getId(), 0L));
        }
    }
}
