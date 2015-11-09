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
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsActivity frsActivity) {
        this.aUS = frsActivity;
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
        bsVar = this.aUS.aUc;
        if (i != bsVar.Ml().LI()) {
            bsVar2 = this.aUS.aUc;
            if (i != bsVar2.Ml().KY()) {
                bsVar3 = this.aUS.aUc;
                if (i != bsVar3.Ml().LK()) {
                    bsVar4 = this.aUS.aUc;
                    if (i != bsVar4.Ml().LJ()) {
                        bsVar5 = this.aUS.aUc;
                        if (i != bsVar5.Ml().LL()) {
                            bsVar6 = this.aUS.aUc;
                            if (i != bsVar6.Ml().LM()) {
                                bsVar8 = this.aUS.aUc;
                                if (i != bsVar8.Ml().LN()) {
                                    bsVar9 = this.aUS.aUc;
                                    if (i == bsVar9.Ml().LO()) {
                                        this.aUS.aTT = wVar;
                                        this.aUS.Lq();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10179").ae(ImageViewerConfig.FORUM_ID, this.aUS.getForumId()));
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.aUS.Lp();
                            bsVar7 = this.aUS.aUc;
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq(i == bsVar7.Ml().LM() ? "c10177" : "c10244").ae(ImageViewerConfig.FORUM_ID, this.aUS.getForumId()));
                            return;
                        } else if (this.aUS.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar = this.aUS.aUe;
                            if (oVar != null) {
                                oVar2 = this.aUS.aUe;
                                if (oVar2.afg() != null) {
                                    oVar3 = this.aUS.aUe;
                                    ForumData afg = oVar3.afg();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.aUS.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(afg.getId(), 0L), afg.getName(), afg.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.aUS.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.aUS.Lo();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.aUS.checkUpIsLogin()) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPrivilegeActivityConfig(this.aUS.getPageContext().getPageActivity())));
                    return;
                }
                return;
            }
            com.baidu.tbadk.core.util.aq aqVar = new com.baidu.tbadk.core.util.aq("c10077");
            aVar = this.aUS.aUq;
            aqVar.r("obj_source", aVar.Nv());
            TiebaStatic.log(aqVar);
            this.aUS.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.aUS.getPageContext().getPageActivity()).createFromThreadCfg(wVar, this.aUS.aTU, null, 18003, true, false, false)));
        } else if (this.aUS.checkUpIsLogin() && wVar != null && wVar.so() != null && wVar.so().get(0) != null && !StringUtils.isNull(wVar.so().get(0).getUrl())) {
            com.baidu.tbadk.core.util.az.uX().b(this.aUS.getPageContext(), new String[]{wVar.so().get(0).getUrl()});
            if (wVar.so().get(0).rj() == 1) {
                TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "lottery", "click", 1, "page", "frs");
            } else if (wVar.so().get(0).rj() == 2) {
                TiebaStatic.eventStat(this.aUS.getPageContext().getPageActivity(), "show_picture", "click", 1, "page", "frs");
            }
        }
    }
}
