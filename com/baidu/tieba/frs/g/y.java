package com.baidu.tieba.frs.g;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.b {
    final /* synthetic */ u cbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.cbI = uVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        com.baidu.tieba.tbadkCore.ag agVar;
        aVar.dismiss();
        frsActivity = this.cbI.bST;
        com.baidu.tieba.tbadkCore.n Zr = frsActivity.Zr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            frsActivity2 = this.cbI.bST;
            m9getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cbI.getPageContext().getPageActivity(), this.cbI.getPageContext().getString(w.l.login_to_use), true, 11036)));
        } else if (Zr != null && Zr.aJw() != null) {
            agVar = this.cbI.cbD;
            agVar.s(Zr.aJw().getName(), com.baidu.adp.lib.g.b.c(Zr.aJw().getId(), 0L));
        }
    }
}
