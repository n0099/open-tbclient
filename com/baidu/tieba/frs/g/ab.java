package com.baidu.tieba.frs.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements ag.a {
    final /* synthetic */ u cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.cdZ = uVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ag.a
    public void j(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.cdZ.bVk;
        com.baidu.tieba.tbadkCore.n aas = frsActivity.aas();
        if (aas != null && aas.aKx() != null) {
            com.baidu.tieba.tbadkCore.c.bhj().V(aas.aKx().getName(), false);
            aas.aKx().setLike(0);
            this.cdZ.iL(0);
            frsActivity2 = this.cdZ.bVk;
            frsActivity2.N(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.cdZ.e(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.v vVar = new com.baidu.tieba.tbadkCore.v();
            vVar.setLike(0);
            vVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ag.a
    public void k(String str, long j) {
    }
}
