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
import com.baidu.tieba.frs.bf;
/* loaded from: classes.dex */
class r implements bf {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bf
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.z zVar) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        String str;
        if (i == this.bkp.bkj.OV().Nz()) {
            if (this.bkp.checkUpIsLogin() && zVar != null && zVar.sA() != null && zVar.sA().get(0) != null && !StringUtils.isNull(zVar.sA().get(0).getUrl())) {
                com.baidu.tbadk.core.util.bf.vn().b(this.bkp.getPageContext(), new String[]{zVar.sA().get(0).getUrl()});
                if (zVar.sA().get(0).rg() == 1) {
                    TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (zVar.sA().get(0).rg() == 2) {
                    TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.bkp.bkj.OV().MQ()) {
            FrsGoodActivity frsGoodActivity = this.bkp;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bkp.getPageContext().getPageActivity());
            str = this.bkp.bde;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str, null, 18003, true, false, false)));
        } else if (i == this.bkp.bkj.OV().NB()) {
            TiebaStatic.eventStat(this.bkp.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.bkp.bkj.OV().NA()) {
            if (this.bkp.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.bkp.Ni();
            }
        } else if (i == this.bkp.bkj.OV().NC() && this.bkp.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            pVar = this.bkp.bdo;
            if (pVar != null) {
                pVar2 = this.bkp.bdo;
                if (pVar2.akG() != null) {
                    pVar3 = this.bkp.bdo;
                    ForumData akG = pVar3.akG();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bkp.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(akG.getId(), 0L), akG.getName(), akG.getImage_url(), 0)));
                }
            }
        }
    }
}
