package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.aj;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements aj.a {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.buP = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.buP.bts;
        com.baidu.tieba.tbadkCore.o QZ = frsActivity.QZ();
        if (QZ != null && QZ.avu() != null) {
            com.baidu.tieba.tbadkCore.c.aRC().J(QZ.avu().getName(), false);
            QZ.avu().setLike(0);
            this.buP.hm(0);
            frsActivity2 = this.buP.bts;
            frsActivity2.bli.d(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.buP.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            x xVar = new x();
            xVar.setLike(0);
            xVar.nQ(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void h(String str, long j) {
    }
}
