package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements bd {
    final /* synthetic */ FrsActivity aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aUK = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v80, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bd
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.w wVar) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.frs.mc.a aVar;
        bsVar = this.aUK.aTU;
        if (i != bsVar.LV().Ls()) {
            bsVar2 = this.aUK.aTU;
            if (i != bsVar2.LV().KI()) {
                bsVar3 = this.aUK.aTU;
                if (i != bsVar3.LV().Lu()) {
                    bsVar4 = this.aUK.aTU;
                    if (i != bsVar4.LV().Lt()) {
                        bsVar5 = this.aUK.aTU;
                        if (i != bsVar5.LV().Lv()) {
                            bsVar6 = this.aUK.aTU;
                            if (i != bsVar6.LV().Lw()) {
                                bsVar8 = this.aUK.aTU;
                                if (i != bsVar8.LV().Lx()) {
                                    bsVar9 = this.aUK.aTU;
                                    if (i == bsVar9.LV().Ly()) {
                                        this.aUK.aTL = wVar;
                                        this.aUK.La();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10179").ae(ImageViewerConfig.FORUM_ID, this.aUK.getForumId()));
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.aUK.KZ();
                            bsVar7 = this.aUK.aTU;
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(i == bsVar7.LV().Lw() ? "c10177" : "c10244").ae(ImageViewerConfig.FORUM_ID, this.aUK.getForumId()));
                            return;
                        } else if (this.aUK.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar = this.aUK.aTW;
                            if (oVar != null) {
                                oVar2 = this.aUK.aTW;
                                if (oVar2.aeJ() != null) {
                                    oVar3 = this.aUK.aTW;
                                    ForumData aeJ = oVar3.aeJ();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aUK.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aeJ.getId(), 0L), aeJ.getName(), aeJ.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.aUK.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.aUK.KY();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.aUK.checkUpIsLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.aUK.getPageContext().getPageActivity())));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10077");
            aVar = this.aUK.aUi;
            aqVar.r("obj_source", aVar.Nc());
            TiebaStatic.log(aqVar);
            this.aUK.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUK.getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aUK.aTM, null, 18003, true, false, false)));
        } else if (this.aUK.checkUpIsLogin() && wVar != null && wVar.sl() != null && wVar.sl().get(0) != null && !StringUtils.isNull(wVar.sl().get(0).getUrl())) {
            com.baidu.tbadk.core.util.az.uT().b(this.aUK.getPageContext(), new String[]{wVar.sl().get(0).getUrl()});
            if (wVar.sl().get(0).ri() == 1) {
                TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (wVar.sl().get(0).ri() == 2) {
                TiebaStatic.eventStat(this.aUK.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
