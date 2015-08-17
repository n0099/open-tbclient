package com.baidu.tieba.frs.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.ai;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ai.a {
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bbz = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bbz.bat;
        com.baidu.tieba.tbadkCore.n Lu = frsActivity.Lu();
        if (Lu != null && Lu.acG() != null) {
            com.baidu.tieba.tbadkCore.c.aoQ().E(Lu.acG().getName(), false);
            Lu.acG().setLike(0);
            this.bbz.fH(0);
            frsActivity2 = this.bbz.bat;
            frsActivity2.aVj.d(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.bbz.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            w wVar = new w();
            wVar.setLike(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ai.a
    public void h(String str, long j) {
    }
}
