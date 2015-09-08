package com.baidu.tieba.frs.c;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bbT = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        aj ajVar;
        aVar.dismiss();
        frsActivity = this.bbT.baN;
        com.baidu.tieba.tbadkCore.o Ll = frsActivity.Ll();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            frsActivity2 = this.bbT.baN;
            m411getInst.login(frsActivity2.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbT.getPageContext().getPageActivity(), this.bbT.getPageContext().getString(i.h.login_to_use), true, 11036)));
        } else if (Ll != null && Ll.acP() != null) {
            ajVar = this.bbT.bbM;
            ajVar.k(Ll.acP().getName(), com.baidu.adp.lib.g.b.c(Ll.acP().getId(), 0L));
        }
    }
}
