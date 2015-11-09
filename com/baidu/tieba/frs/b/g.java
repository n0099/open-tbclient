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
public class g implements a.b {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bcD = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ai aiVar;
        aVar.dismiss();
        frsActivity = this.bcD.bbk;
        com.baidu.tieba.tbadkCore.o Lt = frsActivity.Lt();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.bcD.bbk;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bcD.getPageContext().getPageActivity(), this.bcD.getPageContext().getString(i.h.login_to_use), true, 11036)));
        } else if (Lt != null && Lt.afg() != null) {
            aiVar = this.bcD.bcv;
            aiVar.k(Lt.afg().getName(), com.baidu.adp.lib.g.b.c(Lt.afg().getId(), 0L));
        }
    }
}
