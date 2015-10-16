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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.frs.bd;
/* loaded from: classes.dex */
class r implements bd {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bd
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        String str;
        if (i == this.aZM.aZG.MN().Lw()) {
            if (this.aZM.checkUpIsLogin() && wVar != null && wVar.so() != null && wVar.so().get(0) != null && !StringUtils.isNull(wVar.so().get(0).getUrl())) {
                az.uW().b(this.aZM.getPageContext(), new String[]{wVar.so().get(0).getUrl()});
                if (wVar.so().get(0).rl() == 1) {
                    TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (wVar.so().get(0).rl() == 2) {
                    TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.aZM.aZG.MN().KM()) {
            FrsGoodActivity frsGoodActivity = this.aZM;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZM.getPageContext().getPageActivity());
            str = this.aZM.aTM;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
        } else if (i == this.aZM.aZG.MN().Ly()) {
            TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.aZM.aZG.MN().Lx()) {
            if (this.aZM.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.aZM.Lc();
            }
        } else if (i == this.aZM.aZG.MN().Lz() && this.aZM.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.aZM.aTW;
            if (oVar != null) {
                oVar2 = this.aZM.aTW;
                if (oVar2.aeN() != null) {
                    oVar3 = this.aZM.aTW;
                    ForumData aeN = oVar3.aeN();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aZM.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aeN.getId(), 0L), aeN.getName(), aeN.getImage_url(), 0)));
                }
            }
        }
    }
}
