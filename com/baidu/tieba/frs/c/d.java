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
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aQd = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ax axVar;
        aVar.dismiss();
        frsActivity = this.aQd.aPF;
        w KF = frsActivity.KF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.aQd.aPF;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.aQd.getPageContext().getPageActivity(), this.aQd.getPageContext().getString(t.login_to_use), true, 11036)));
        } else if (KF != null && KF.aas() != null) {
            axVar = this.aQd.aQb;
            axVar.k(KF.aas().getName(), Long.valueOf(KF.aas().getId()).longValue());
        }
    }
}
