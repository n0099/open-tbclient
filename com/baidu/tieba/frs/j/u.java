package com.baidu.tieba.frs.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.al;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements al.a {
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(n nVar) {
        this.ckg = nVar;
    }

    @Override // com.baidu.tieba.tbadkCore.al.a
    public void j(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.ckg.bZY;
        com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
        if (acr != null && acr.aOk() != null) {
            com.baidu.tieba.tbadkCore.d.bkd().R(acr.aOk().getName(), false);
            acr.aOk().setLike(0);
            this.ckg.iL(0);
            frsActivity2 = this.ckg.bZY;
            frsActivity2.K(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.ckg.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.y yVar = new com.baidu.tieba.tbadkCore.y();
            yVar.setLike(0);
            yVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.al.a
    public void k(String str, long j) {
    }
}
