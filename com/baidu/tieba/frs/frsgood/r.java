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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.av;
/* loaded from: classes.dex */
class r implements av {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.av
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.x xVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        String str;
        if (i == this.aZI.aZC.MO().Ly()) {
            if (this.aZI.checkUpIsLogin() && xVar != null && xVar.st() != null && xVar.st().get(0) != null && !StringUtils.isNull(xVar.st().get(0).getUrl())) {
                ax.uX().b(this.aZI.getPageContext(), new String[]{xVar.st().get(0).getUrl()});
                if (xVar.st().get(0).rq() == 1) {
                    TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (xVar.st().get(0).rq() == 2) {
                    TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.aZI.aZC.MO().KR()) {
            FrsGoodActivity frsGoodActivity = this.aZI;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZI.getPageContext().getPageActivity());
            str = this.aZI.aUF;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(xVar, str, null, 18003, true, false, false)));
        } else if (i == this.aZI.aZC.MO().LA()) {
            TiebaStatic.eventStat(this.aZI.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.aZI.aZC.MO().Lz()) {
            if (this.aZI.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.aZI.Lg();
            }
        } else if (i == this.aZI.aZC.MO().LB() && this.aZI.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.aZI.aUN;
            if (oVar != null) {
                oVar2 = this.aZI.aUN;
                if (oVar2.acP() != null) {
                    oVar3 = this.aZI.aUN;
                    ForumData acP = oVar3.acP();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aZI.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(acP.getId(), 0L), acP.getName(), acP.getImage_url(), 0)));
                }
            }
        }
    }
}
