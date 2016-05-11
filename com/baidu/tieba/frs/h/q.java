package com.baidu.tieba.frs.h;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.b {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(m mVar) {
        this.buB = mVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ak akVar;
        aVar.dismiss();
        frsActivity = this.buB.bpj;
        com.baidu.tieba.tbadkCore.o PZ = frsActivity.PZ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
            frsActivity2 = this.buB.bpj;
            m11getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.buB.getPageContext().getPageActivity(), this.buB.getPageContext().getString(t.j.login_to_use), true, 11036)));
        } else if (PZ != null && PZ.avA() != null) {
            akVar = this.buB.buw;
            akVar.n(PZ.avA().getName(), com.baidu.adp.lib.h.b.c(PZ.avA().getId(), 0L));
        }
    }
}
