package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements av {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v77, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.av
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.x xVar) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        bi biVar5;
        bi biVar6;
        bi biVar7;
        bi biVar8;
        bi biVar9;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.frs.b.a aVar;
        biVar = this.aVz.aUL;
        if (i != biVar.Ma().Ly()) {
            biVar2 = this.aVz.aUL;
            if (i != biVar2.Ma().KR()) {
                biVar3 = this.aVz.aUL;
                if (i != biVar3.Ma().LA()) {
                    biVar4 = this.aVz.aUL;
                    if (i != biVar4.Ma().Lz()) {
                        biVar5 = this.aVz.aUL;
                        if (i != biVar5.Ma().LB()) {
                            biVar6 = this.aVz.aUL;
                            if (i != biVar6.Ma().LC()) {
                                biVar8 = this.aVz.aUL;
                                if (i != biVar8.Ma().LD()) {
                                    biVar9 = this.aVz.aUL;
                                    if (i == biVar9.Ma().LE()) {
                                        this.aVz.aUE = xVar;
                                        this.aVz.Li();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10179").af(ImageViewerConfig.FORUM_ID, this.aVz.getForumId()));
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.aVz.Lh();
                            biVar7 = this.aVz.aUL;
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao(i == biVar7.Ma().LC() ? "c10177" : "c10244").af(ImageViewerConfig.FORUM_ID, this.aVz.getForumId()));
                            return;
                        } else if (this.aVz.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar = this.aVz.aUN;
                            if (oVar != null) {
                                oVar2 = this.aVz.aUN;
                                if (oVar2.acP() != null) {
                                    oVar3 = this.aVz.aUN;
                                    ForumData acP = oVar3.acP();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aVz.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(acP.getId(), 0L), acP.getName(), acP.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.aVz.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.aVz.Lg();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                return;
            }
            com.baidu.tbadk.core.util.ao aoVar = new com.baidu.tbadk.core.util.ao("c10077");
            aVar = this.aVz.aUZ;
            aoVar.r("obj_source", aVar.Nh());
            TiebaStatic.log(aoVar);
            this.aVz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aVz.getPageContext().getPageActivity()).createFromThreadCfg(xVar, this.aVz.aUF, null, 18003, true, false, false)));
        } else if (this.aVz.checkUpIsLogin() && xVar != null && xVar.st() != null && xVar.st().get(0) != null && !StringUtils.isNull(xVar.st().get(0).getUrl())) {
            com.baidu.tbadk.core.util.ax.uX().b(this.aVz.getPageContext(), new String[]{xVar.st().get(0).getUrl()});
            if (xVar.st().get(0).rq() == 1) {
                TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (xVar.st().get(0).rq() == 2) {
                TiebaStatic.eventStat(this.aVz.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
