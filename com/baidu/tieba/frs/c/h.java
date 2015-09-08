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
public class h implements aj.a {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.bbT = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void g(String str, long j) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.bbT.baN;
        com.baidu.tieba.tbadkCore.o Ll = frsActivity.Ll();
        if (Ll != null && Ll.acP() != null) {
            com.baidu.tieba.tbadkCore.d.asX().G(Ll.acP().getName(), false);
            Ll.acP().setLike(0);
            this.bbT.fQ(0);
            frsActivity2 = this.bbT.baN;
            frsActivity2.aVx.d(true);
            TbadkCoreApplication.m411getInst().delLikeForum(str);
            this.bbT.e(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            x xVar = new x();
            xVar.setLike(0);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.aj.a
    public void h(String str, long j) {
    }
}
