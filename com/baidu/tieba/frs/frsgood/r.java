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
import com.baidu.tieba.frs.au;
/* loaded from: classes.dex */
class r implements au {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.frs.frsgood.FrsGoodActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.au
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.v vVar) {
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        String str;
        if (i == this.aZp.aZj.MO().LH()) {
            if (this.aZp.checkUpIsLogin() && vVar != null && vVar.ss() != null && vVar.ss().get(0) != null && !StringUtils.isNull(vVar.ss().get(0).getUrl())) {
                ax.uR().b(this.aZp.getPageContext(), new String[]{vVar.ss().get(0).getUrl()});
                if (vVar.ss().get(0).rr() == 1) {
                    TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
                } else if (vVar.ss().get(0).rr() == 2) {
                    TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
                }
            }
        } else if (i == this.aZp.aZj.MO().Ld()) {
            FrsGoodActivity frsGoodActivity = this.aZp;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.aZp.getPageContext().getPageActivity());
            str = this.aZp.aUq;
            frsGoodActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(vVar, str, null, 18003, true, false, false)));
        } else if (i == this.aZp.aZj.MO().LJ()) {
            TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
        } else if (i == this.aZp.aZj.MO().LI()) {
            if (this.aZp.checkUpIsLogin()) {
                TiebaStatic.log("forum_fortune_click");
                this.aZp.Lr();
            }
        } else if (i == this.aZp.aZj.MO().LK() && this.aZp.checkUpIsLogin()) {
            TiebaStatic.log("my_service_ck");
            nVar = this.aZp.aUy;
            if (nVar != null) {
                nVar2 = this.aZp.aUy;
                if (nVar2.acG() != null) {
                    nVar3 = this.aZp.aUy;
                    ForumData acG = nVar3.acG();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aZp.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(acG.getId(), 0L), acG.getName(), acG.getImage_url(), 0)));
                }
            }
        }
    }
}
