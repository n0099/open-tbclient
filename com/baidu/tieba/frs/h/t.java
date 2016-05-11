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
public class t implements ak.a {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(m mVar) {
        this.buB = mVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ak.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.buB.bpj;
        com.baidu.tieba.tbadkCore.o PZ = frsActivity.PZ();
        if (PZ != null && PZ.avA() != null) {
            com.baidu.tieba.tbadkCore.c.aRW().L(PZ.avA().getName(), false);
            PZ.avA().setLike(0);
            this.buB.gS(0);
            frsActivity2 = this.buB.bpj;
            frsActivity2.bhj.d(true);
            TbadkCoreApplication.m11getInst().delLikeForum(str);
            this.buB.g(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.y yVar = new com.baidu.tieba.tbadkCore.y();
            yVar.setLike(0);
            yVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ak.a
    public void h(String str, long j) {
    }
}
