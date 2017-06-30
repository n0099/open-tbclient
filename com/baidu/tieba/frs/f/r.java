package com.baidu.tieba.frs.f;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ m cpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(m mVar) {
        this.cpZ = mVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        ae aeVar;
        aVar.dismiss();
        rVar = this.cpZ.cbE;
        com.baidu.tieba.tbadkCore.n aek = rVar.aek();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
            rVar2 = this.cpZ.cbE;
            m9getInst.login(rVar2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.cpZ.getPageContext().getPageActivity(), this.cpZ.getPageContext().getString(w.l.login_to_use), true, 11036)));
        } else if (aek != null && aek.aMt() != null) {
            aeVar = this.cpZ.cpS;
            aeVar.r(aek.aMt().getName(), com.baidu.adp.lib.g.b.c(aek.aMt().getId(), 0L));
        }
    }
}
