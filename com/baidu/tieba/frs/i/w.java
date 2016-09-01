package com.baidu.tieba.frs.i;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements am.a {
    final /* synthetic */ p cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.cfw = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.am.a
    public void i(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.cfw.bWH;
        com.baidu.tieba.tbadkCore.p aaR = frsActivity.aaR();
        if (aaR != null && aaR.aLP() != null) {
            com.baidu.tieba.tbadkCore.d.bgZ().R(aaR.aLP().getName(), false);
            aaR.aLP().setLike(0);
            this.cfw.iA(0);
            frsActivity2 = this.cfw.bWH;
            frsActivity2.bQm.g(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.cfw.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.y yVar = new com.baidu.tieba.tbadkCore.y();
            yVar.setLike(0);
            yVar.hi(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am.a
    public void j(String str, long j) {
    }
}
