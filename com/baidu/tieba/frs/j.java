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
class j implements bf {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v100, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.frs.bf
    public void a(int i, int i2, View view, View view2, com.baidu.tbadk.core.data.z zVar) {
        com.baidu.tieba.tbadkCore.p pVar;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        com.baidu.tieba.tbadkCore.p pVar4;
        if (i != this.bed.bdm.Of().Nz()) {
            if (i != this.bed.bdm.Of().MQ()) {
                if (i != this.bed.bdm.Of().NB()) {
                    if (i != this.bed.bdm.Of().NA()) {
                        if (i != this.bed.bdm.Of().NC()) {
                            if (i != this.bed.bdm.Of().ND() && i != this.bed.bdm.Of().NE()) {
                                if (i == this.bed.bdm.Of().NF()) {
                                    this.bed.bdd = zVar;
                                    this.bed.Nk();
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10179").aa(ImageViewerConfig.FORUM_ID, this.bed.getForumId()));
                                    return;
                                } else if (i == this.bed.bdm.Of().NG()) {
                                    TiebaStatic.log("c10417");
                                    pVar = this.bed.bdo;
                                    pVar.aEt();
                                    this.bed.bdm.NZ();
                                    com.baidu.tbadk.core.sharedPref.b.tJ().putLong("frs_storecard_closetime", System.currentTimeMillis());
                                    return;
                                } else {
                                    return;
                                }
                            }
                            this.bed.Nj();
                            TiebaStatic.log(new com.baidu.tbadk.core.util.av(i == this.bed.bdm.Of().ND() ? "c10177" : "c10244").aa(ImageViewerConfig.FORUM_ID, this.bed.getForumId()));
                            return;
                        } else if (this.bed.checkUpIsLogin()) {
                            TiebaStatic.log("my_service_ck");
                            pVar2 = this.bed.bdo;
                            if (pVar2 != null) {
                                pVar3 = this.bed.bdo;
                                if (pVar3.akG() != null) {
                                    pVar4 = this.bed.bdo;
                                    ForumData akG = pVar4.akG();
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(this.bed.getPageContext().getPageActivity(), com.baidu.adp.lib.h.b.c(akG.getId(), 0L), akG.getName(), akG.getImage_url(), 0)));
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if (this.bed.checkUpIsLogin()) {
                        TiebaStatic.log("forum_fortune_click");
                        this.bed.Ni();
                        return;
                    } else {
                        return;
                    }
                }
                TiebaStatic.eventStat(this.bed.getPageContext().getPageActivity(), "consume_1", "click", 1, new Object[0]);
                if (this.bed.checkUpIsLogin()) {
                    String str = null;
                    ArrayList<IconData> tShowInfoNew = zVar.getAuthor().getTShowInfoNew();
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        str = zVar.getAuthor().getTShowInfoNew().get(0).getUrl();
                    }
                    if (str != null && str.startsWith("membercenter:")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MembercenterActivityConfig(this.bed.getActivity())));
                        return;
                    } else {
                        com.baidu.tbadk.browser.f.C(this.bed.getActivity(), str);
                        return;
                    }
                }
                return;
            }
            if (this.bed.bdz.Pt() == 2) {
                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10077");
                avVar.r("obj_source", this.bed.bdz.Pt());
                avVar.aa("tid", zVar.getId());
                avVar.aa(ImageViewerConfig.FORUM_ID, this.bed.getForumId());
                TiebaStatic.log(avVar);
            }
            this.bed.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bed.getPageContext().getPageActivity()).createFromThreadCfg(zVar, this.bed.bde, null, 18003, true, false, false)));
        } else if (this.bed.checkUpIsLogin() && zVar != null && zVar.sA() != null && zVar.sA().get(0) != null && !StringUtils.isNull(zVar.sA().get(0).getUrl())) {
            com.baidu.tbadk.core.util.bf.vn().b(this.bed.getPageContext(), new String[]{zVar.sA().get(0).getUrl()});
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (zVar.sA().get(0).rg() == 1) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("lottery").aa(ImageViewerConfig.FORUM_ID, this.bed.forumId).aa("tid", zVar.getTid()).aa("uid", currentAccount));
            } else if (zVar.sA().get(0).rg() == 2) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.av("show_picture").aa(ImageViewerConfig.FORUM_ID, this.bed.forumId).aa("tid", zVar.getTid()).aa("uid", currentAccount));
            }
        }
    }
}
