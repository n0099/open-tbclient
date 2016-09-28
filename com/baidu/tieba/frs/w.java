package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.c.a;
/* loaded from: classes.dex */
class w implements ba {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ba
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.bi biVar) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bm bmVar5;
        bm bmVar6;
        bm bmVar7;
        bm bmVar8;
        String str;
        bmVar = this.bQi.bPi;
        if (i != bmVar.abW().adn()) {
            bmVar2 = this.bQi.bPi;
            if (i != bmVar2.abW().ado()) {
                bmVar3 = this.bQi.bPi;
                if (i != bmVar3.abW().adq()) {
                    bmVar4 = this.bQi.bPi;
                    if (i == bmVar4.abW().acu()) {
                        this.bQi.bOY = biVar;
                        this.bQi.aba();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ax("c10179").ab("fid", this.bQi.getForumId()));
                        return;
                    }
                    bmVar5 = this.bQi.bPi;
                    if (i != bmVar5.abW().adr()) {
                        bmVar6 = this.bQi.bPi;
                        if (i == bmVar6.abW().adp() && this.bQi.bPk != null && this.bQi.bPk.getUserData() != null && this.bQi.bPk.getUserData().isBawu()) {
                            String big = this.bQi.bPk.big();
                            if (!com.baidu.tbadk.core.util.az.isEmpty(big) && this.bQi.bPk.aMr() != null) {
                                a.a(this.bQi.getPageContext(), this.bQi.bPk.aMr().getId(), this.bQi.bPk.aMr().getName(), new x(this, big));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    TiebaStatic.log("c10417");
                    this.bQi.bPk.biJ();
                    bmVar7 = this.bQi.bPi;
                    bmVar7.abO();
                    b.uh().putLong("frs_storecard_closetime", System.currentTimeMillis());
                    return;
                }
                this.bQi.aaZ();
                bmVar8 = this.bQi.bPi;
                if (i == bmVar8.abW().adq()) {
                    str = "c10177";
                } else {
                    str = "c10244";
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.ax(str).ab("fid", this.bQi.getForumId()));
            } else if (this.bQi.checkUpIsLogin()) {
                TiebaStatic.log("my_service_ck");
                if (this.bQi.bPk != null && this.bQi.bPk.aMr() != null) {
                    ForumData aMr = this.bQi.bPk.aMr();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bQi.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aMr.getId(), 0L), aMr.getName(), aMr.getImage_url(), 0)));
                }
            }
        } else if (this.bQi.checkUpIsLogin()) {
            TiebaStatic.log("forum_fortune_click");
            this.bQi.aaX();
        }
    }
}
