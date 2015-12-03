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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.bc;
/* loaded from: classes.dex */
class r implements bc {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bc
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.z zVar) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        String str;
        if (i == this.bgy.bgr.OD().Ng()) {
            if (this.bgy.checkUpIsLogin() && zVar != null && zVar.sQ() != null && zVar.sQ().get(0) != null && !StringUtils.isNull(zVar.sQ().get(0).getUrl())) {
                bf.vD().b(this.bgy.getPageContext(), new String[]{zVar.sQ().get(0).getUrl()});
                if (zVar.sQ().get(0).rx() == 1) {
                    TiebaStatic.eventStat(this.bgy.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (zVar.sQ().get(0).rx() == 2) {
                    TiebaStatic.eventStat(this.bgy.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.bgy.bgr.OD().Mx()) {
            FrsGoodActivity frsGoodActivity = this.bgy;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgy.getPageContext().getPageActivity());
            str = this.bgy.aZi;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str, null, 18003, true, false, false)));
        } else if (i == this.bgy.bgr.OD().Ni()) {
            TiebaStatic.eventStat(this.bgy.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.bgy.bgr.OD().Nh()) {
            if (this.bgy.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.bgy.MO();
            }
        } else if (i == this.bgy.bgr.OD().Nj() && this.bgy.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            pVar = this.bgy.aZs;
            if (pVar != null) {
                pVar2 = this.bgy.aZs;
                if (pVar2.ajy() != null) {
                    pVar3 = this.bgy.aZs;
                    ForumData ajy = pVar3.ajy();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bgy.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(ajy.getId(), 0L), ajy.getName(), ajy.getImage_url(), 0)));
                }
            }
        }
    }
}
