package com.baidu.tieba.frs.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.ax;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aQc = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ax axVar;
        aVar.dismiss();
        frsActivity = this.aQc.aPE;
        w KE = frsActivity.KE();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.aQc.aPE;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.aQc.getPageContext().getPageActivity(), this.aQc.getPageContext().getString(t.login_to_use), true, 11036)));
        } else if (KE != null && KE.aar() != null) {
            axVar = this.aQc.aQa;
            axVar.k(KE.aar().getName(), Long.valueOf(KE.aar().getId()).longValue());
        }
    }
}
