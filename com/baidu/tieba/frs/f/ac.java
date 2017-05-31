package com.baidu.tieba.frs.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements ae.a {
    final /* synthetic */ u chY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar) {
        this.chY = uVar;
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void i(String str, long j) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        rVar = this.chY.bTw;
        com.baidu.tieba.tbadkCore.n aau = rVar.aau();
        if (aau != null && aau.aIz() != null) {
            com.baidu.tieba.tbadkCore.c.bgf().S(aau.aIz().getName(), false);
            aau.aIz().setLike(0);
            this.chY.jc(0);
            rVar2 = this.chY.bTw;
            rVar2.N(true);
            TbadkCoreApplication.m9getInst().delLikeForum(str);
            this.chY.d(false, new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, new StringBuilder(String.valueOf(j)).toString()));
            com.baidu.tieba.tbadkCore.t tVar = new com.baidu.tieba.tbadkCore.t();
            tVar.setLike(0);
            tVar.setFid(new StringBuilder(String.valueOf(j)).toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, tVar));
        }
    }

    @Override // com.baidu.tieba.tbadkCore.ae.a
    public void j(String str, long j) {
    }
}
