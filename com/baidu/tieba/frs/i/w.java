package com.baidu.tieba.frs.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements an.a {
    final /* synthetic */ p bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.bSo = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.an.a
    public void h(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bSo.bJR;
        com.baidu.tieba.tbadkCore.p VC = frsActivity.VC();
        if (VC != null && VC.aDN() != null) {
            com.baidu.tieba.tbadkCore.d.bah().N(VC.aDN().getName(), false);
            VC.aDN().setLike(0);
            this.bSo.hX(0);
            frsActivity2 = this.bSo.bJR;
            frsActivity2.bDy.d(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.bSo.g(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.z zVar = new com.baidu.tieba.tbadkCore.z();
            zVar.setLike(0);
            zVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, zVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.an.a
    public void i(String str, long j) {
    }
}
