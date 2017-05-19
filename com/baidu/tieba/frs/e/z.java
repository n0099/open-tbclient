package com.baidu.tieba.frs.e;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.b {
    final /* synthetic */ u cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.cbL = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.tbadkCore.ae aeVar;
        aVar.dismiss();
        rVar = this.cbL.bNK;
        com.baidu.tieba.tbadkCore.n Zq = rVar.Zq();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            rVar2 = this.cbL.bNK;
            m9getInst.login(rVar2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cbL.getPageContext().getPageActivity(), this.cbL.getPageContext().getString(w.l.login_to_use), true, 11036)));
        } else if (Zq != null && Zq.aHE() != null) {
            aeVar = this.cbL.cbF;
            aeVar.s(Zq.aHE().getName(), com.baidu.adp.lib.g.b.c(Zq.aHE().getId(), 0L));
        }
    }
}
