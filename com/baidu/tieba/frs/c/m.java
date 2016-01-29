package com.baidu.tieba.frs.c;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fj;
import com.baidu.tieba.frs.mc.FrsGoodActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l bpS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bpS = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        FrsActivity frsActivity12;
        FrsActivity frsActivity13;
        FrsActivity frsActivity14;
        FrsActivity frsActivity15;
        FrsActivity frsActivity16;
        FrsActivity frsActivity17;
        FrsActivity frsActivity18;
        FrsActivity frsActivity19;
        FrsActivity frsActivity20;
        FrsActivity frsActivity21;
        FrsActivity frsActivity22;
        FrsActivity frsActivity23;
        FrsActivity frsActivity24;
        FrsActivity frsActivity25;
        FrsActivity frsActivity26;
        FrsActivity frsActivity27;
        FrsActivity frsActivity28;
        FrsActivity frsActivity29;
        int id = view.getId();
        if (id == t.g.message_layout) {
            frsActivity27 = this.bpS.bot;
            frsActivity27.Pm();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity28 = this.bpS.bot;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity28.getPageContext().getPageActivity());
                frsActivity29 = this.bpS.bot;
                frsActivity29.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == t.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bpS.getPageContext().getPageActivity())));
        } else if (id == t.g.bar_info_tv) {
            frsActivity24 = this.bpS.bot;
            if (frsActivity24.Pk() != null) {
                frsActivity25 = this.bpS.bot;
                if (frsActivity25.Pk().aoE() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bpS.getPageContext().getPageActivity();
                    frsActivity26 = this.bpS.bot;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity26.Pk().aoE().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == t.g.forum_manager_center) {
            frsActivity18 = this.bpS.bot;
            if (frsActivity18.Pk() != null) {
                frsActivity19 = this.bpS.bot;
                if (frsActivity19.Pk().aoE() != null) {
                    frsActivity20 = this.bpS.bot;
                    String id2 = frsActivity20.Pk().aoE().getId();
                    frsActivity21 = this.bpS.bot;
                    com.baidu.tbadk.browser.f.B(this.bpS.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity21.Pk().aoE().getName() + "&fid=" + id2);
                    frsActivity22 = this.bpS.bot;
                    if (frsActivity22.Pk().getUserData() != null) {
                        au aa = new au("c10503").aa(ImageViewerConfig.FORUM_ID, id2);
                        frsActivity23 = this.bpS.bot;
                        TiebaStatic.log(aa.aa("uid", frsActivity23.Pk().getUserData().getUserId()));
                    }
                }
            }
        } else if (id == t.g.recommend_forum_item_layout) {
            fj.a aVar = (fj.a) view.getTag();
            if (aVar != null) {
                frsActivity13 = this.bpS.bot;
                if (frsActivity13.Pk() != null) {
                    frsActivity14 = this.bpS.bot;
                    if (frsActivity14.Pk().aoE() != null) {
                        frsActivity15 = this.bpS.bot;
                        String name = frsActivity15.Pk().aoE().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity16 = this.bpS.bot;
                            frsActivity16.resetData();
                            frsActivity17 = this.bpS.bot;
                            frsActivity17.a(aVar, str);
                        } else if (this.bpS.Si().isMenuShowing()) {
                            this.bpS.Si().toggle(true);
                        }
                    }
                }
            }
        } else if (id == t.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iZ()) {
                frsActivity12 = this.bpS.bot;
                frsActivity12.Pn();
                return;
            }
            frsActivity11 = this.bpS.bot;
            frsActivity11.showToast(t.j.neterror);
        } else if (id == t.g.post_search_ll) {
            frsActivity6 = this.bpS.bot;
            if (frsActivity6.Pk() != null) {
                frsActivity7 = this.bpS.bot;
                if (frsActivity7.Pk().aoE() != null) {
                    frsActivity8 = this.bpS.bot;
                    String name2 = frsActivity8.Pk().aoE().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity9 = this.bpS.bot;
                        frsActivity10 = this.bpS.bot;
                        frsActivity9.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity10.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == t.g.frs_sidebar_good_tv) {
            frsActivity3 = this.bpS.bot;
            frsActivity4 = this.bpS.bot;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity4.getPageContext().getPageActivity());
            frsActivity5 = this.bpS.bot;
            frsActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity5.bfv, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == t.g.frs_sidebar_add_to_desktop) {
            frsActivity2 = this.bpS.bot;
            frsActivity2.Pe();
        } else if (id == t.g.bar_share_tv) {
            frsActivity = this.bpS.bot;
            frsActivity.Pq();
        }
    }
}
