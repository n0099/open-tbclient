package com.baidu.tieba.frs.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.bpO = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ai aiVar;
        aVar.dismiss();
        frsActivity = this.bpO.bot;
        com.baidu.tieba.tbadkCore.o Pk = frsActivity.Pk();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.bpO.bot;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bpO.getPageContext().getPageActivity(), this.bpO.getPageContext().getString(t.j.login_to_use), true, 11036)));
        } else if (Pk != null && Pk.aoE() != null) {
            aiVar = this.bpO.bpG;
            aiVar.m(Pk.aoE().getName(), com.baidu.adp.lib.h.b.c(Pk.aoE().getId(), 0L));
        }
    }
}
