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
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bd
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.w wVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        String str;
        if (i == this.baf.aZZ.Nb().LI()) {
            if (this.baf.checkUpIsLogin() && wVar != null && wVar.so() != null && wVar.so().get(0) != null && !StringUtils.isNull(wVar.so().get(0).getUrl())) {
                az.uX().b(this.baf.getPageContext(), new String[]{wVar.so().get(0).getUrl()});
                if (wVar.so().get(0).rj() == 1) {
                    TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (wVar.so().get(0).rj() == 2) {
                    TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.baf.aZZ.Nb().KY()) {
            FrsGoodActivity frsGoodActivity = this.baf;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.baf.getPageContext().getPageActivity());
            str = this.baf.aTU;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(wVar, str, null, 18003, true, false, false)));
        } else if (i == this.baf.aZZ.Nb().LK()) {
            TiebaStatic.eventStat(this.baf.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.baf.aZZ.Nb().LJ()) {
            if (this.baf.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.baf.Lo();
            }
        } else if (i == this.baf.aZZ.Nb().LL() && this.baf.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.baf.aUe;
            if (oVar != null) {
                oVar2 = this.baf.aUe;
                if (oVar2.afg() != null) {
                    oVar3 = this.baf.aUe;
                    ForumData afg = oVar3.afg();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.baf.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(afg.getId(), 0L), afg.getName(), afg.getImage_url(), 0)));
                }
            }
        }
    }
}
