package com.baidu.tieba.frs.i;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ p cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.cfw = pVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        am amVar;
        aVar.dismiss();
        frsActivity = this.cfw.bWH;
        com.baidu.tieba.tbadkCore.p aaR = frsActivity.aaR();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            frsActivity2 = this.cfw.bWH;
            m9getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cfw.getPageContext().getPageActivity(), this.cfw.getPageContext().getString(t.j.login_to_use), true, 11036)));
        } else if (aaR != null && aaR.aLP() != null) {
            amVar = this.cfw.cfs;
            amVar.s(aaR.aLP().getName(), com.baidu.adp.lib.h.b.c(aaR.aLP().getId(), 0L));
        }
    }
}
