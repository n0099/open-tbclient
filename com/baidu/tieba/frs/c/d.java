package com.baidu.tieba.frs.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ax;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ a aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aNQ = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ax axVar;
        aVar.dismiss();
        frsActivity = this.aNQ.aNs;
        w JA = frsActivity.JA();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            frsActivity2 = this.aNQ.aNs;
            frsActivity2.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aNQ.getPageContext().getPageActivity(), this.aNQ.getPageContext().getString(y.login_to_use), true, 11036)));
        } else if (JA != null && JA.Za() != null) {
            axVar = this.aNQ.aNO;
            axVar.i(JA.Za().getName(), Long.valueOf(JA.Za().getId()).longValue());
        }
    }
}
