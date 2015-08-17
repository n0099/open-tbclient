package com.baidu.tieba.frs.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bbz = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ai aiVar;
        aVar.dismiss();
        frsActivity = this.bbz.bat;
        com.baidu.tieba.tbadkCore.n Lu = frsActivity.Lu();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.bbz.bat;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbz.getPageContext().getPageActivity(), this.bbz.getPageContext().getString(i.C0057i.login_to_use), true, 11036)));
        } else if (Lu != null && Lu.acG() != null) {
            aiVar = this.bbz.bbs;
            aiVar.k(Lu.acG().getName(), com.baidu.adp.lib.g.b.c(Lu.acG().getId(), 0L));
        }
    }
}
