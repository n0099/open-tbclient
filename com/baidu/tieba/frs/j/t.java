package com.baidu.tieba.frs.j;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.an;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.b {
    final /* synthetic */ p bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.bUo = pVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        an anVar;
        aVar.dismiss();
        frsActivity = this.bUo.bLx;
        com.baidu.tieba.tbadkCore.p VU = frsActivity.VU();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m10getInst = TbadkCoreApplication.m10getInst();
            frsActivity2 = this.bUo.bLx;
            m10getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bUo.getPageContext().getPageActivity(), this.bUo.getPageContext().getString(u.j.login_to_use), true, 11036)));
        } else if (VU != null && VU.aGX() != null) {
            anVar = this.bUo.bUk;
            anVar.r(VU.aGX().getName(), com.baidu.adp.lib.h.b.c(VU.aGX().getId(), 0L));
        }
    }
}
