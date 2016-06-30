package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class u implements ba {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ba
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.az azVar) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        bq bqVar4;
        bq bqVar5;
        bq bqVar6;
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.tbadkCore.p pVar5;
        com.baidu.tieba.tbadkCore.p pVar6;
        com.baidu.tieba.tbadkCore.p pVar7;
        com.baidu.tieba.tbadkCore.p pVar8;
        bq bqVar7;
        bq bqVar8;
        com.baidu.tieba.tbadkCore.p pVar9;
        com.baidu.tieba.tbadkCore.p pVar10;
        com.baidu.tieba.tbadkCore.p pVar11;
        bqVar = this.bDB.bCD;
        if (i != bqVar.Ww().XU()) {
            bqVar2 = this.bDB.bCD;
            if (i != bqVar2.Ww().XV()) {
                bqVar3 = this.bDB.bCD;
                if (i != bqVar3.Ww().XX()) {
                    bqVar4 = this.bDB.bCD;
                    if (i == bqVar4.Ww().WS()) {
                        this.bDB.bCt = azVar;
                        this.bDB.Vz();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ay("c10179").ab("fid", this.bDB.getForumId()));
                        return;
                    }
                    bqVar5 = this.bDB.bCD;
                    if (i != bqVar5.Ww().XY()) {
                        bqVar6 = this.bDB.bCD;
                        if (i == bqVar6.Ww().XW()) {
                            pVar = this.bDB.bCF;
                            if (pVar != null) {
                                pVar2 = this.bDB.bCF;
                                if (pVar2.getUserData() != null) {
                                    pVar3 = this.bDB.bCF;
                                    if (pVar3.getUserData().isBawu()) {
                                        pVar4 = this.bDB.bCF;
                                        String baF = pVar4.baF();
                                        if (!com.baidu.tbadk.core.util.ba.isEmpty(baF)) {
                                            com.baidu.tbadk.browser.f.u(this.bDB.getPageContext().getPageActivity(), baF);
                                            pVar5 = this.bDB.bCF;
                                            if (pVar5.aDN() != null) {
                                                com.baidu.tbadk.core.util.ay ayVar = new com.baidu.tbadk.core.util.ay("c10502");
                                                pVar6 = this.bDB.bCF;
                                                com.baidu.tbadk.core.util.ay ab = ayVar.ab("fid", pVar6.aDN().getId());
                                                pVar7 = this.bDB.bCF;
                                                TiebaStatic.log(ab.ab("uid", pVar7.getUserData().getUserId()));
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c10417");
                    pVar8 = this.bDB.bCF;
                    pVar8.bbf();
                    bqVar7 = this.bDB.bCD;
                    bqVar7.Wo();
                    b.sO().putLong("frs_storecard_closetime", System.currentTimeMillis());
                    return;
                }
                this.bDB.Vy();
                bqVar8 = this.bDB.bCD;
                TiebaStatic.log(new com.baidu.tbadk.core.util.ay(i == bqVar8.Ww().XX() ? "c10177" : "c10244").ab("fid", this.bDB.getForumId()));
            } else if (this.bDB.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                pVar9 = this.bDB.bCF;
                if (pVar9 != null) {
                    pVar10 = this.bDB.bCF;
                    if (pVar10.aDN() != null) {
                        pVar11 = this.bDB.bCF;
                        ForumData aDN = pVar11.aDN();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bDB.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aDN.getId(), 0L), aDN.getName(), aDN.getImage_url(), 0)));
                    }
                }
            }
        } else if (this.bDB.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            this.bDB.Vx();
        }
    }
}
