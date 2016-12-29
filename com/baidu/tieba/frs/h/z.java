package com.baidu.tieba.frs.h;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ak;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements ak.a {
    final /* synthetic */ s bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(s sVar) {
        this.bPp = sVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ak.a
    public void j(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bPp.bFI;
        com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
        if (WF != null && WF.aIk() != null) {
            com.baidu.tieba.tbadkCore.c.bdT().U(WF.aIk().getName(), false);
            WF.aIk().setLike(0);
            this.bPp.hV(0);
            frsActivity2 = this.bPp.bFI;
            frsActivity2.K(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.bPp.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.x xVar = new com.baidu.tieba.tbadkCore.x();
            xVar.setLike(0);
            xVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ak.a
    public void k(String str, long j) {
    }
}
