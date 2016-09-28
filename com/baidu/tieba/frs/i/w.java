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
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar) {
        this.cft = pVar;
    }

    @Override // com.baidu.tieba.tbadkCore.am.a
    public void i(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.cft.bWH;
        com.baidu.tieba.tbadkCore.p abe = frsActivity.abe();
        if (abe != null && abe.aMr() != null) {
            com.baidu.tieba.tbadkCore.d.bhH().R(abe.aMr().getName(), false);
            abe.aMr().setLike(0);
            this.cft.iF(0);
            frsActivity2 = this.cft.bWH;
            frsActivity2.bQf.g(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.cft.f(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.y yVar = new com.baidu.tieba.tbadkCore.y();
            yVar.setLike(0);
            yVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.am.a
    public void j(String str, long j) {
    }
}
