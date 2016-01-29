package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ai.a {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bpO = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bpO.bot;
        com.baidu.tieba.tbadkCore.o Pk = frsActivity.Pk();
        if (Pk != null && Pk.aoE() != null) {
            com.baidu.tieba.tbadkCore.c.aKN().I(Pk.aoE().getName(), false);
            Pk.aoE().setLike(0);
            this.bpO.gT(0);
            frsActivity2 = this.bpO.bot;
            frsActivity2.bgx.d(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.bpO.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            x xVar = new x();
            xVar.setLike(0);
            xVar.mF(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void h(String str, long j) {
    }
}
