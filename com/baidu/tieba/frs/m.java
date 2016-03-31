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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import java.util.ArrayList;
/* loaded from: classes.dex */
class m implements bj {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v100, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bj
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.as asVar) {
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        com.baidu.tieba.tbadkCore.o oVar4;
        if (i != this.blk.bko.Sb().Ro()) {
            if (i != this.blk.bko.Sb().QA()) {
                if (i != this.blk.bko.Sb().Rq()) {
                    if (i != this.blk.bko.Sb().Rp()) {
                        if (i != this.blk.bko.Sb().Rr()) {
                            if (i != this.blk.bko.Sb().Rs() && i != this.blk.bko.Sb().Rt()) {
                                if (i == this.blk.bko.Sb().Ru()) {
                                    this.blk.bke = asVar;
                                    this.blk.QW();
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10179").ac("fid", this.blk.getForumId()));
                                    return;
                                } else if (i == this.blk.bko.Sb().Rv()) {
                                    TiebaStatic.log("c10417");
                                    oVar = this.blk.bkq;
                                    oVar.aSr();
                                    this.blk.bko.RS();
                                    com.baidu.tbadk.core.sharedPref.b.vk().putLong("frs_storecard_closetime", System.currentTimeMillis());
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.blk.QV();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aw(i == this.blk.bko.Sb().Rs() ? "c10177" : "c10244").ac("fid", this.blk.getForumId()));
                            return;
                        } else if (this.blk.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            oVar2 = this.blk.bkq;
                            if (oVar2 != null) {
                                oVar3 = this.blk.bkq;
                                if (oVar3.avu() != null) {
                                    oVar4 = this.blk.bkq;
                                    ForumData avu = oVar4.avu();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.blk.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(avu.getId(), 0L), avu.getName(), avu.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.blk.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.blk.QU();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.blk.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.blk.checkUpIsLogin()) {
                    String str = null;
                    ArrayList<IconData> tShowInfoNew = asVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        str = asVar.getAuthor().getTShowInfoNew().get(0).getUrl();
                    }
                    if (str != null && str.startsWith("membercenter:")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.blk.getActivity())));
                        return;
                    } else {
                        com.baidu.tbadk.browser.f.t(this.blk.getActivity(), str);
                        return;
                    }
                }
                return;
            }
            if (this.blk.bkB.Tk() == 2) {
                com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10077");
                awVar.r("obj_source", this.blk.bkB.Tk());
                awVar.ac("tid", asVar.getId());
                awVar.ac("fid", this.blk.getForumId());
                TiebaStatic.log(awVar);
            }
            this.blk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.blk.getPageContext().getPageActivity()).createFromThreadCfg(asVar, this.blk.bkf, null, 18003, true, false, false)));
        } else if (this.blk.checkUpIsLogin() && asVar != null && asVar.tw() != null && asVar.tw().get(0) != null && !StringUtils.isNull(asVar.tw().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bg.wM().c(this.blk.getPageContext(), new String[]{asVar.tw().get(0).getUrl()});
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (asVar.tw().get(0).qU() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("lottery").ac("fid", this.blk.forumId).ac("tid", asVar.getTid()).ac("uid", currentAccount));
            } else if (asVar.tw().get(0).qU() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.aw("show_picture").ac("fid", this.blk.forumId).ac("tid", asVar.getTid()).ac("uid", currentAccount));
            }
        }
    }
}
