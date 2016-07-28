package com.baidu.tieba.frs.j;

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
    final /* synthetic */ p bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.bUo = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.an.a
    public void h(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bUo.bLx;
        com.baidu.tieba.tbadkCore.p VU = frsActivity.VU();
        if (VU != null && VU.aGX() != null) {
            com.baidu.tieba.tbadkCore.d.bdv().N(VU.aGX().getName(), false);
            VU.aGX().setLike(0);
            this.bUo.hY(0);
            frsActivity2 = this.bUo.bLx;
            frsActivity2.bEI.g(true);
            TbadkCoreApplication.m10getInst().delLikeForum(str);
            this.bUo.g(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.z zVar = new com.baidu.tieba.tbadkCore.z();
            zVar.setLike(0);
            zVar.gF(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, zVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.an.a
    public void i(String str, long j) {
    }
}
