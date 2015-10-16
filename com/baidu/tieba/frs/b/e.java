package com.baidu.tieba.frs.b;

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
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bbY = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ai aiVar;
        aVar.dismiss();
        frsActivity = this.bbY.baR;
        com.baidu.tieba.tbadkCore.o Lh = frsActivity.Lh();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.bbY.baR;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbY.getPageContext().getPageActivity(), this.bbY.getPageContext().getString(i.h.login_to_use), true, 11036)));
        } else if (Lh != null && Lh.aeN() != null) {
            aiVar = this.bbY.bbR;
            aiVar.k(Lh.aeN().getName(), com.baidu.adp.lib.g.b.c(Lh.aeN().getId(), 0L));
        }
    }
}
