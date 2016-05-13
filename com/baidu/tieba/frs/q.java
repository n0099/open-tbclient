package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class q implements bi {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v100, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bi
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.ax axVar) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        cn cnVar5;
        cn cnVar6;
        cn cnVar7;
        cn cnVar8;
        cn cnVar9;
        cn cnVar10;
        com.baidu.tieba.tbadkCore.o oVar;
        cn cnVar11;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        cnVar = this.bhl.bgo;
        if (i != cnVar.Ra().Rt()) {
            cnVar2 = this.bhl.bgo;
            if (i != cnVar2.Ra().Pz()) {
                cnVar3 = this.bhl.bgo;
                if (i != cnVar3.Ra().Ru()) {
                    cnVar4 = this.bhl.bgo;
                    if (i != cnVar4.Ra().Rv()) {
                        cnVar5 = this.bhl.bgo;
                        if (i != cnVar5.Ra().Rw()) {
                            cnVar6 = this.bhl.bgo;
                            if (i != cnVar6.Ra().Sx()) {
                                cnVar8 = this.bhl.bgo;
                                if (i != cnVar8.Ra().Sy()) {
                                    cnVar9 = this.bhl.bgo;
                                    if (i == cnVar9.Ra().Ry()) {
                                        this.bhl.bge = axVar;
                                        this.bhl.PW();
                                        TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10179").ac("fid", this.bhl.getForumId()));
                                        return;
                                    }
                                    cnVar10 = this.bhl.bgo;
                                    if (i == cnVar10.Ra().Sz()) {
                                        TiebaStatic.log("c10417");
                                        oVar = this.bhl.bgq;
                                        oVar.aST();
                                        cnVar11 = this.bhl.bgo;
                                        cnVar11.QS();
                                        b.sR().putLong("frs_storecard_closetime", System.currentTimeMillis());
                                        return;
                                    }
                                    return;
                                }
                            }
                            this.bhl.PV();
                            cnVar7 = this.bhl.bgo;
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(i == cnVar7.Ra().Sx() ? "c10177" : "c10244").ac("fid", this.bhl.getForumId()));
                            return;
                        } else if (this.bhl.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar2 = this.bhl.bgq;
                            if (oVar2 != null) {
                                oVar3 = this.bhl.bgq;
                                if (oVar3.avD() != null) {
                                    oVar4 = this.bhl.bgq;
                                    ForumData avD = oVar4.avD();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bhl.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(avD.getId(), 0L), avD.getName(), avD.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.bhl.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.bhl.PU();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.bhl.checkUpIsLogin()) {
                    String str = null;
                    ArrayList<IconData> tShowInfoNew = axVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        str = axVar.getAuthor().getTShowInfoNew().get(0).getUrl();
                    }
                    if (str != null && str.startsWith("membercenter:")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.bhl.getActivity())));
                        return;
                    } else {
                        com.baidu.tbadk.browser.f.u(this.bhl.getActivity(), str);
                        return;
                    }
                }
                return;
            }
            if (this.bhl.bgC.Tt() == 2) {
                com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10077");
                awVar.s("obj_source", this.bhl.bgC.Tt());
                awVar.ac("tid", axVar.getId());
                awVar.ac("fid", this.bhl.getForumId());
                TiebaStatic.log(awVar);
            }
            this.bhl.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bhl.getPageContext().getPageActivity()).createFromThreadCfg(axVar, this.bhl.bgf, null, 18003, true, false, false)));
        } else if (this.bhl.checkUpIsLogin() && axVar != null && axVar.qV() != null && axVar.qV().get(0) != null && !StringUtils.isNull(axVar.qV().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bg.ut().c(this.bhl.getPageContext(), new String[]{axVar.qV().get(0).getUrl()});
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (axVar.qV().get(0).or() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("lottery").ac("fid", this.bhl.forumId).ac("tid", axVar.getTid()).ac("uid", currentAccount));
            }
        }
    }
}
