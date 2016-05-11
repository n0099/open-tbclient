package com.baidu.tieba.frs.h;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y buF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.buF = yVar;
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
        FrsActivity frsActivity30;
        FrsActivity frsActivity31;
        FrsActivity frsActivity32;
        FrsActivity frsActivity33;
        FrsActivity frsActivity34;
        FrsActivity frsActivity35;
        FrsActivity frsActivity36;
        FrsActivity frsActivity37;
        FrsActivity frsActivity38;
        FrsActivity frsActivity39;
        FrsActivity frsActivity40;
        FrsActivity frsActivity41;
        FrsActivity frsActivity42;
        FrsActivity frsActivity43;
        FrsActivity frsActivity44;
        int id = view.getId();
        if (id == t.g.message_layout) {
            frsActivity42 = this.buF.bpj;
            frsActivity42.Qb();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity43 = this.buF.bpj;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity43.getPageContext().getPageActivity());
                frsActivity44 = this.buF.bpj;
                frsActivity44.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == t.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.buF.getPageContext().getPageActivity())));
        } else if (id == t.g.bar_info_tv) {
            frsActivity39 = this.buF.bpj;
            if (frsActivity39.PZ() != null) {
                frsActivity40 = this.buF.bpj;
                if (frsActivity40.PZ().avA() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.buF.getPageContext().getPageActivity();
                    frsActivity41 = this.buF.bpj;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity41.PZ().avA().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == t.g.forum_manager_center) {
            frsActivity32 = this.buF.bpj;
            if (frsActivity32.PZ() != null) {
                frsActivity34 = this.buF.bpj;
                if (frsActivity34.PZ().avA() != null) {
                    frsActivity35 = this.buF.bpj;
                    String id2 = frsActivity35.PZ().avA().getId();
                    frsActivity36 = this.buF.bpj;
                    com.baidu.tbadk.browser.f.t(this.buF.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity36.PZ().avA().getName() + "&fid=" + id2);
                    frsActivity37 = this.buF.bpj;
                    if (frsActivity37.PZ().getUserData() != null) {
                        aw ac = new aw("c10503").ac("fid", id2);
                        frsActivity38 = this.buF.bpj;
                        TiebaStatic.log(ac.ac("uid", frsActivity38.PZ().getUserData().getUserId()));
                        return;
                    }
                    return;
                }
            }
            frsActivity33 = this.buF.bpj;
            frsActivity33.showToast(t.j.neterror);
        } else if (id == t.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.fq()) {
                frsActivity31 = this.buF.bpj;
                frsActivity31.Qc();
                return;
            }
            frsActivity30 = this.buF.bpj;
            frsActivity30.showToast(t.j.neterror);
        } else if (id == t.g.post_search_ll) {
            frsActivity24 = this.buF.bpj;
            if (frsActivity24.PZ() != null) {
                frsActivity25 = this.buF.bpj;
                if (frsActivity25.PZ().avA() != null) {
                    frsActivity26 = this.buF.bpj;
                    String name = frsActivity26.PZ().avA().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity28 = this.buF.bpj;
                        frsActivity29 = this.buF.bpj;
                        frsActivity28.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity29.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity27 = this.buF.bpj;
                    frsActivity27.showToast(t.j.neterror);
                }
            }
        } else if (id == t.g.frs_sidebar_good_tv) {
            frsActivity21 = this.buF.bpj;
            frsActivity22 = this.buF.bpj;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity22.getPageContext().getPageActivity());
            frsActivity23 = this.buF.bpj;
            frsActivity21.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity23.bgf, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == t.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.fq()) {
                frsActivity20 = this.buF.bpj;
                frsActivity20.PT();
                return;
            }
            frsActivity19 = this.buF.bpj;
            frsActivity19.showToast(t.j.neterror);
        } else if (id == t.g.bar_share_tv) {
            frsActivity18 = this.buF.bpj;
            frsActivity18.Qg();
        } else if (id == t.g.forum_member) {
            frsActivity11 = this.buF.bpj;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.buF.bpj;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    frsActivity14 = this.buF.bpj;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.buF.bpj;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.buF.bpj;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.buF.bpj;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.buF.bpj;
            frsActivity12.showToast(t.j.neterror);
        } else if (id == t.g.frs_group) {
            frsActivity = this.buF.bpj;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.buF.bpj;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.buF.bpj;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.buF.bpj;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.buF.bpj;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.buF.bpj;
                    if (frsActivity7.PZ() != null) {
                        frsActivity9 = this.buF.bpj;
                        if (frsActivity9.PZ().aSg() != null) {
                            frsActivity10 = this.buF.bpj;
                            if (frsActivity10.PZ().aSg().aRV() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    frsActivity8 = this.buF.bpj;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.buF.bpj;
            frsActivity2.showToast(t.j.neterror);
        }
    }
}
