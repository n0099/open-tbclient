package com.baidu.tieba.frs.f;

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
    final /* synthetic */ u chY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(u uVar) {
        this.chY = uVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        com.baidu.tieba.tbadkCore.ae aeVar;
        aVar.dismiss();
        rVar = this.chY.bTw;
        com.baidu.tieba.tbadkCore.n aau = rVar.aau();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            rVar2 = this.chY.bTw;
            m9getInst.login(rVar2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.chY.getPageContext().getPageActivity(), this.chY.getPageContext().getString(w.l.login_to_use), true, 11036)));
        } else if (aau != null && aau.aIz() != null) {
            aeVar = this.chY.chR;
            aeVar.r(aau.aIz().getName(), com.baidu.adp.lib.g.b.c(aau.aIz().getId(), 0L));
        }
    }
}
