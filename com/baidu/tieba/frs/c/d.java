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
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.aNz = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        ax axVar;
        aVar.dismiss();
        frsActivity = this.aNz.aNb;
        w Ju = frsActivity.Ju();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            frsActivity2 = this.aNz.aNb;
            frsActivity2.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aNz.getPageContext().getPageActivity(), this.aNz.getPageContext().getString(y.login_to_use), true, 11036)));
        } else if (Ju != null && Ju.YO() != null) {
            axVar = this.aNz.aNx;
            axVar.i(Ju.YO().getName(), Long.valueOf(Ju.YO().getId()).longValue());
        }
    }
}
