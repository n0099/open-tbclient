package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class k implements bh {
    final /* synthetic */ FrsActivity bgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.bgz = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v100, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bh
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.ah ahVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        if (i != this.bgz.bfD.Qi().Pz()) {
            if (i != this.bgz.bfD.Qi().OL()) {
                if (i != this.bgz.bfD.Qi().PB()) {
                    if (i != this.bgz.bfD.Qi().PA()) {
                        if (i != this.bgz.bfD.Qi().PC()) {
                            if (i != this.bgz.bfD.Qi().PD() && i != this.bgz.bfD.Qi().PE()) {
                                if (i == this.bgz.bfD.Qi().PF()) {
                                    this.bgz.bfu = ahVar;
                                    this.bgz.Ph();
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10179").aa(ImageViewerConfig.FORUM_ID, this.bgz.getForumId()));
                                    return;
                                } else if (i == this.bgz.bfD.Qi().PG()) {
                                    TiebaStatic.log("c10417");
                                    oVar = this.bgz.bfF;
                                    oVar.aLy();
                                    this.bgz.bfD.PZ();
                                    com.baidu.tbadk.core.sharedPref.b.uO().putLong("frs_storecard_closetime", System.currentTimeMillis());
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.bgz.Pg();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.au(i == this.bgz.bfD.Qi().PD() ? "c10177" : "c10244").aa(ImageViewerConfig.FORUM_ID, this.bgz.getForumId()));
                            return;
                        } else if (this.bgz.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar2 = this.bgz.bfF;
                            if (oVar2 != null) {
                                oVar3 = this.bgz.bfF;
                                if (oVar3.aoE() != null) {
                                    oVar4 = this.bgz.bfF;
                                    ForumData aoE = oVar4.aoE();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bgz.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(aoE.getId(), 0L), aoE.getName(), aoE.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.bgz.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.bgz.Pf();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.bgz.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.bgz.checkUpIsLogin()) {
                    String str = null;
                    ArrayList<IconData> tShowInfoNew = ahVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        str = ahVar.getAuthor().getTShowInfoNew().get(0).getUrl();
                    }
                    if (str != null && str.startsWith("membercenter:")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.bgz.getActivity())));
                        return;
                    } else {
                        com.baidu.tbadk.browser.f.C(this.bgz.getActivity(), str);
                        return;
                    }
                }
                return;
            }
            if (this.bgz.bfQ.Rx() == 2) {
                com.baidu.tbadk.core.util.au auVar = new com.baidu.tbadk.core.util.au("c10077");
                auVar.r("obj_source", this.bgz.bfQ.Rx());
                auVar.aa("tid", ahVar.getId());
                auVar.aa(ImageViewerConfig.FORUM_ID, this.bgz.getForumId());
                TiebaStatic.log(auVar);
            }
            this.bgz.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bgz.getPageContext().getPageActivity()).createFromThreadCfg(ahVar, this.bgz.bfv, null, 18003, true, false, false)));
        } else if (this.bgz.checkUpIsLogin() && ahVar != null && ahVar.tt() != null && ahVar.tt().get(0) != null && !StringUtils.isNull(ahVar.tt().get(0).getUrl())) {
            com.baidu.tbadk.core.util.be.wt().c(this.bgz.getPageContext(), new String[]{ahVar.tt().get(0).getUrl()});
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (ahVar.tt().get(0).rD() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("lottery").aa(ImageViewerConfig.FORUM_ID, this.bgz.forumId).aa("tid", ahVar.getTid()).aa("uid", currentAccount));
            } else if (ahVar.tt().get(0).rD() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.au("show_picture").aa(ImageViewerConfig.FORUM_ID, this.bgz.forumId).aa("tid", ahVar.getTid()).aa("uid", currentAccount));
            }
        }
    }
}
