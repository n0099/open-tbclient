package com.baidu.tieba.frs.b;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bji = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        aj ajVar;
        aVar.dismiss();
        frsActivity = this.bji.bhN;
        com.baidu.tieba.tbadkCore.p MT = frsActivity.MT();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.bji.bhN;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bji.getPageContext().getPageActivity(), this.bji.getPageContext().getString(n.i.login_to_use), true, 11036)));
        } else if (MT != null && MT.ajy() != null) {
            ajVar = this.bji.bja;
            ajVar.m(MT.ajy().getName(), com.baidu.adp.lib.h.b.c(MT.ajy().getId(), 0L));
        }
    }
}
