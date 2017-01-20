package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements ah.a {
    final /* synthetic */ u bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.bVP = uVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ah.a
    public void j(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bVP.bLZ;
        com.baidu.tieba.tbadkCore.n XW = frsActivity.XW();
        if (XW != null && XW.aJY() != null) {
            com.baidu.tieba.tbadkCore.c.bfG().U(XW.aJY().getName(), false);
            XW.aJY().setLike(0);
            this.bVP.iI(0);
            frsActivity2 = this.bVP.bLZ;
            frsActivity2.O(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.bVP.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.v vVar = new com.baidu.tieba.tbadkCore.v();
            vVar.setLike(0);
            vVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ah.a
    public void k(String str, long j) {
    }
}
