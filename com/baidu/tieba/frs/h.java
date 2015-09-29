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
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v80, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bd
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.v vVar) {
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
        bsVar = this.aUz.aTJ;
        if (i != bsVar.LZ().Lw()) {
            bsVar2 = this.aUz.aTJ;
            if (i != bsVar2.LZ().KM()) {
                bsVar3 = this.aUz.aTJ;
                if (i != bsVar3.LZ().Ly()) {
                    bsVar4 = this.aUz.aTJ;
                    if (i != bsVar4.LZ().Lx()) {
                        bsVar5 = this.aUz.aTJ;
                        if (i != bsVar5.LZ().Lz()) {
                            bsVar6 = this.aUz.aTJ;
                            if (i != bsVar6.LZ().LA()) {
                                bsVar8 = this.aUz.aTJ;
                                if (i != bsVar8.LZ().LB()) {
                                    bsVar9 = this.aUz.aTJ;
                                    if (i == bsVar9.LZ().LC()) {
                                        this.aUz.aTA = vVar;
                                        this.aUz.Le();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10179").ae(ImageViewerConfig.FORUM_ID, this.aUz.getForumId()));
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.aUz.Ld();
                            bsVar7 = this.aUz.aTJ;
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap(i == bsVar7.LZ().LA() ? "c10177" : "c10244").ae(ImageViewerConfig.FORUM_ID, this.aUz.getForumId()));
                            return;
                        } else if (this.aUz.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar = this.aUz.aTL;
                            if (oVar != null) {
                                oVar2 = this.aUz.aTL;
                                if (oVar2.aeN() != null) {
                                    oVar3 = this.aUz.aTL;
                                    ForumData aeN = oVar3.aeN();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aUz.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(aeN.getId(), 0L), aeN.getName(), aeN.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.aUz.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.aUz.Lc();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.aUz.checkUpIsLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.aUz.getPageContext().getPageActivity())));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.ap apVar = new com.baidu.tbadk.core.util.ap("c10077");
            aVar = this.aUz.aTX;
            apVar.r("obj_source", aVar.Ng());
            TiebaStatic.log(apVar);
            this.aUz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUz.getPageContext().getPageActivity()).createFromThreadCfg(vVar, this.aUz.aTB, null, 18003, true, false, false)));
        } else if (this.aUz.checkUpIsLogin() && vVar != null && vVar.so() != null && vVar.so().get(0) != null && !StringUtils.isNull(vVar.so().get(0).getUrl())) {
            com.baidu.tbadk.core.util.ay.uV().b(this.aUz.getPageContext(), new String[]{vVar.so().get(0).getUrl()});
            if (vVar.so().get(0).rl() == 1) {
                TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (vVar.so().get(0).rl() == 2) {
                TiebaStatic.eventStat(this.aUz.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
