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
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.bji = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bji.bhN;
        com.baidu.tieba.tbadkCore.p MT = frsActivity.MT();
        if (MT != null && MT.ajy() != null) {
            com.baidu.tieba.tbadkCore.d.aBA().J(MT.ajy().getName(), false);
            MT.ajy().setLike(0);
            this.bji.gD(0);
            frsActivity2 = this.bji.bhN;
            frsActivity2.bae.d(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.bji.e(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            y yVar = new y();
            yVar.setLike(0);
            yVar.mr(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void h(String str, long j) {
    }
}
