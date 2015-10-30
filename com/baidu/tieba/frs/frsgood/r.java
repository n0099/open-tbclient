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
        if (i == this.aZM.aZG.MJ().Ls()) {
            if (this.aZM.checkUpIsLogin() && wVar != null && wVar.sl() != null && wVar.sl().get(0) != null && !StringUtils.isNull(wVar.sl().get(0).getUrl())) {
                az.uT().b(this.aZM.getPageContext(), new String[]{wVar.sl().get(0).getUrl()});
                if (wVar.sl().get(0).ri() == 1) {
                    TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (wVar.sl().get(0).ri() == 2) {
                    TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.aZM.aZG.MJ().KI()) {
            FrsGoodActivity frsGoodActivity = this.aZM;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZM.getPageContext().getPageActivity());
            str = this.aZM.aTM;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
        } else if (i == this.aZM.aZG.MJ().Lu()) {
            TiebaStatic.eventStat(this.aZM.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.aZM.aZG.MJ().Lt()) {
            if (this.aZM.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.aZM.KY();
            }
        } else if (i == this.aZM.aZG.MJ().Lv() && this.aZM.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.aZM.aTW;
            if (oVar != null) {
                oVar2 = this.aZM.aTW;
                if (oVar2.aeJ() != null) {
                    oVar3 = this.aZM.aTW;
                    ForumData aeJ = oVar3.aeJ();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aZM.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aeJ.getId(), 0L), aeJ.getName(), aeJ.getImage_url(), 0)));
                }
            }
        }
    }
}
