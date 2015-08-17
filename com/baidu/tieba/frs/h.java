package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements au {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v51, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.au
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.v vVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        bl blVar5;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        com.baidu.tieba.frs.b.a aVar;
        blVar = this.this$0.aUw;
        if (i != blVar.Mj().LH()) {
            blVar2 = this.this$0.aUw;
            if (i != blVar2.Mj().Ld()) {
                blVar3 = this.this$0.aUw;
                if (i != blVar3.Mj().LJ()) {
                    blVar4 = this.this$0.aUw;
                    if (i != blVar4.Mj().LI()) {
                        blVar5 = this.this$0.aUw;
                        if (i == blVar5.Mj().LK() && this.this$0.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            nVar = this.this$0.aUy;
                            if (nVar != null) {
                                nVar2 = this.this$0.aUy;
                                if (nVar2.acG() != null) {
                                    nVar3 = this.this$0.aUy;
                                    ForumData acG = nVar3.acG();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.this$0.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(acG.getId(), 0L), acG.getName(), acG.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.this$0.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.this$0.Lr();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                return;
            }
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c10077");
            aVar = this.this$0.aUK;
            aoVar.r("obj_source", aVar.Ng());
            TiebaStatic.log(aoVar);
            this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.this$0.getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.this$0.aUq, null, 18003, true, false, false)));
        } else if (this.this$0.checkUpIsLogin() && vVar != null && vVar.ss() != null && vVar.ss().get(0) != null && !StringUtils.isNull(vVar.ss().get(0).getUrl())) {
            com.baidu.tbadk.core.util.ax.uR().b(this.this$0.getPageContext(), new String[]{vVar.ss().get(0).getUrl()});
            if (vVar.ss().get(0).rr() == 1) {
                TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (vVar.ss().get(0).rr() == 2) {
                TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
