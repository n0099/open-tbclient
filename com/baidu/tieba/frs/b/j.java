package com.baidu.tieba.frs.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements aj.a {
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bmZ = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bmZ.blE;
        com.baidu.tieba.tbadkCore.p Nn = frsActivity.Nn();
        if (Nn != null && Nn.akG() != null) {
            com.baidu.tieba.tbadkCore.d.aDI().I(Nn.akG().getName(), false);
            Nn.akG().setLike(0);
            this.bmZ.gw(0);
            frsActivity2 = this.bmZ.blE;
            frsActivity2.beb.d(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.bmZ.e(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            y yVar = new y();
            yVar.setLike(0);
            yVar.mo(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void h(String str, long j) {
    }
}
