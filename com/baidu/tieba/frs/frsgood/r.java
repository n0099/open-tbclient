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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.bd;
/* loaded from: classes.dex */
class r implements bd {
    final /* synthetic */ FrsGoodActivity aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.aZB = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bd
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        String str;
        if (i == this.aZB.aZv.MN().Lw()) {
            if (this.aZB.checkUpIsLogin() && vVar != null && vVar.so() != null && vVar.so().get(0) != null && !StringUtils.isNull(vVar.so().get(0).getUrl())) {
                ay.uV().b(this.aZB.getPageContext(), new String[]{vVar.so().get(0).getUrl()});
                if (vVar.so().get(0).rl() == 1) {
                    TiebaStatic.eventStat(this.aZB.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (vVar.so().get(0).rl() == 2) {
                    TiebaStatic.eventStat(this.aZB.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.aZB.aZv.MN().KM()) {
            FrsGoodActivity frsGoodActivity = this.aZB;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZB.getPageContext().getPageActivity());
            str = this.aZB.aTB;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str, null, 18003, true, false, false)));
        } else if (i == this.aZB.aZv.MN().Ly()) {
            TiebaStatic.eventStat(this.aZB.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.aZB.aZv.MN().Lx()) {
            if (this.aZB.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.aZB.Lc();
            }
        } else if (i == this.aZB.aZv.MN().Lz() && this.aZB.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.aZB.aTL;
            if (oVar != null) {
                oVar2 = this.aZB.aTL;
                if (oVar2.aeN() != null) {
                    oVar3 = this.aZB.aTL;
                    ForumData aeN = oVar3.aeN();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aZB.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aeN.getId(), 0L), aeN.getName(), aeN.getImage_url(), 0)));
                }
            }
        }
    }
}
