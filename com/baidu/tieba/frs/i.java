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
class i implements bc {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v100, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bc
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.z zVar) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        if (i != this.bag.aZq.NM().Ng()) {
            if (i != this.bag.aZq.NM().Mx()) {
                if (i != this.bag.aZq.NM().Ni()) {
                    if (i != this.bag.aZq.NM().Nh()) {
                        if (i != this.bag.aZq.NM().Nj()) {
                            if (i != this.bag.aZq.NM().Nk() && i != this.bag.aZq.NM().Nl()) {
                                if (i == this.bag.aZq.NM().Nm()) {
                                    this.bag.aZh = zVar;
                                    this.bag.MQ();
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10179").ab(ImageViewerConfig.FORUM_ID, this.bag.getForumId()));
                                    return;
                                } else if (i == this.bag.aZq.NM().Nn()) {
                                    TiebaStatic.log("c10417");
                                    pVar = this.bag.aZs;
                                    pVar.aCl();
                                    this.bag.aZq.NG();
                                    com.baidu.tbadk.core.sharedPref.b.tZ().putLong("frs_storecard_closetime", System.currentTimeMillis());
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.bag.MP();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av(i == this.bag.aZq.NM().Nk() ? "c10177" : "c10244").ab(ImageViewerConfig.FORUM_ID, this.bag.getForumId()));
                            return;
                        } else if (this.bag.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            pVar2 = this.bag.aZs;
                            if (pVar2 != null) {
                                pVar3 = this.bag.aZs;
                                if (pVar3.ajy() != null) {
                                    pVar4 = this.bag.aZs;
                                    ForumData ajy = pVar4.ajy();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bag.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(ajy.getId(), 0L), ajy.getName(), ajy.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.bag.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.bag.MO();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.bag.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.bag.checkUpIsLogin()) {
                    String str = null;
                    ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        str = zVar.getAuthor().getTShowInfoNew().get(0).getUrl();
                    }
                    if (str != null && str.startsWith("membercenter:")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.bag.getActivity())));
                        return;
                    } else {
                        com.baidu.tbadk.browser.f.C(this.bag.getActivity(), str);
                        return;
                    }
                }
                return;
            }
            if (this.bag.aZD.Pb() == 2) {
                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10077");
                avVar.r("obj_source", this.bag.aZD.Pb());
                avVar.ab("tid", zVar.getId());
                avVar.ab(ImageViewerConfig.FORUM_ID, this.bag.getForumId());
                TiebaStatic.log(avVar);
            }
            this.bag.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bag.getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bag.aZi, null, 18003, true, false, false)));
        } else if (this.bag.checkUpIsLogin() && zVar != null && zVar.sQ() != null && zVar.sQ().get(0) != null && !StringUtils.isNull(zVar.sQ().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bf.vD().b(this.bag.getPageContext(), new String[]{zVar.sQ().get(0).getUrl()});
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (zVar.sQ().get(0).rx() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("lottery").ab(ImageViewerConfig.FORUM_ID, this.bag.forumId).ab("tid", zVar.getTid()).ab("uid", currentAccount));
            } else if (zVar.sQ().get(0).rx() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("show_picture").ab(ImageViewerConfig.FORUM_ID, this.bag.forumId).ab("tid", zVar.getTid()).ab("uid", currentAccount));
            }
        }
    }
}
