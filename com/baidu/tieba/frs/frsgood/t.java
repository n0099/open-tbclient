package com.baidu.tieba.frs.frsgood;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.bj;
/* loaded from: classes.dex */
class t implements bj {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bj
    public void a(int i, int i2, View view, View view2, as asVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        String str;
        if (i == this.bsj.bsd.SM().Ro()) {
            if (this.bsj.checkUpIsLogin() && asVar != null && asVar.tw() != null && asVar.tw().get(0) != null && !StringUtils.isNull(asVar.tw().get(0).getUrl())) {
                bg.wM().c(this.bsj.getPageContext(), new String[]{asVar.tw().get(0).getUrl()});
                if (asVar.tw().get(0).qU() == 1) {
                    TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (asVar.tw().get(0).qU() == 2) {
                    TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.bsj.bsd.SM().QA()) {
            FrsGoodActivity frsGoodActivity = this.bsj;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bsj.getPageContext().getPageActivity());
            str = this.bsj.bkf;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(asVar, str, null, 18003, true, false, false)));
        } else if (i == this.bsj.bsd.SM().Rq()) {
            TiebaStatic.eventStat(this.bsj.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.bsj.bsd.SM().Rp()) {
            if (this.bsj.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.bsj.QU();
            }
        } else if (i == this.bsj.bsd.SM().Rr() && this.bsj.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            oVar = this.bsj.bkq;
            if (oVar != null) {
                oVar2 = this.bsj.bkq;
                if (oVar2.avu() != null) {
                    oVar3 = this.bsj.bkq;
                    ForumData avu = oVar3.avu();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bsj.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(avu.getId(), 0L), avu.getName(), avu.getImage_url(), 0)));
                }
            }
        }
    }
}
