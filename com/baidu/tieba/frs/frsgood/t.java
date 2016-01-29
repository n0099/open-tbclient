package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.bh;
/* loaded from: classes.dex */
class t implements bh {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bh
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.ah ahVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        String str;
        if (i == this.bnm.bng.QY().Pz()) {
            if (this.bnm.checkUpIsLogin() && ahVar != null && ahVar.tt() != null && ahVar.tt().get(0) != null && !StringUtils.isNull(ahVar.tt().get(0).getUrl())) {
                be.wt().c(this.bnm.getPageContext(), new String[]{ahVar.tt().get(0).getUrl()});
                if (ahVar.tt().get(0).rD() == 1) {
                    TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (ahVar.tt().get(0).rD() == 2) {
                    TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.bnm.bng.QY().OL()) {
            FrsGoodActivity frsGoodActivity = this.bnm;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bnm.getPageContext().getPageActivity());
            str = this.bnm.bfv;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str, null, 18003, true, false, false)));
        } else if (i == this.bnm.bng.QY().PB()) {
            TiebaStatic.eventStat(this.bnm.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.bnm.bng.QY().PA()) {
            if (this.bnm.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.bnm.Pf();
            }
        } else if (i == this.bnm.bng.QY().PC() && this.bnm.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.bnm.bfF;
            if (oVar != null) {
                oVar2 = this.bnm.bfF;
                if (oVar2.aoE() != null) {
                    oVar3 = this.bnm.bfF;
                    ForumData aoE = oVar3.aoE();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bnm.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aoE.getId(), 0L), aoE.getName(), aoE.getImage_url(), 0)));
                }
            }
        }
    }
}
