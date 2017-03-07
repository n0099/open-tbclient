package com.baidu.tieba.frs.f;

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
    final /* synthetic */ u cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.cdh = uVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ag.a
    public void j(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.cdh.bTf;
        com.baidu.tieba.tbadkCore.n YV = frsActivity.YV();
        if (YV != null && YV.aJp() != null) {
            com.baidu.tieba.tbadkCore.c.bft().V(YV.aJp().getName(), false);
            YV.aJp().setLike(0);
            this.cdh.iE(0);
            frsActivity2 = this.cdh.bTf;
            frsActivity2.O(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.cdh.f(false, new StringBuilder(String.valueOf(j)).toString());
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
