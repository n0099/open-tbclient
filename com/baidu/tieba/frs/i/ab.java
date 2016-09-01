package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
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
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa cfC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cfC = aaVar;
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
        int id = view.getId();
        if (id == t.g.message_layout) {
            frsActivity37 = this.cfC.bWH;
            frsActivity37.aaT();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity38 = this.cfC.bWH;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity38.getPageContext().getPageActivity());
                frsActivity39 = this.cfC.bWH;
                frsActivity39.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == t.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.cfC.getPageContext().getPageActivity())));
        } else if (id == t.g.bar_info_tv) {
            frsActivity34 = this.cfC.bWH;
            if (frsActivity34.aaR() != null) {
                frsActivity35 = this.cfC.bWH;
                if (frsActivity35.aaR().aLP() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.cfC.getPageContext().getPageActivity();
                    frsActivity36 = this.cfC.bWH;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity36.aaR().aLP().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == t.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity33 = this.cfC.bWH;
                frsActivity33.aaU();
                return;
            }
            frsActivity32 = this.cfC.bWH;
            frsActivity32.showToast(t.j.neterror);
        } else if (id == t.g.post_search_ll) {
            frsActivity26 = this.cfC.bWH;
            if (frsActivity26.aaR() != null) {
                frsActivity27 = this.cfC.bWH;
                if (frsActivity27.aaR().aLP() != null) {
                    frsActivity28 = this.cfC.bWH;
                    String name = frsActivity28.aaR().aLP().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.cfC.bWH;
                        frsActivity31 = this.cfC.bWH;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.cfC.bWH;
                    frsActivity29.showToast(t.j.neterror);
                }
            }
        } else if (id == t.g.frs_sidebar_good_tv) {
            frsActivity23 = this.cfC.bWH;
            frsActivity24 = this.cfC.bWH;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.cfC.bWH;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bPf, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == t.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity22 = this.cfC.bWH;
                frsActivity22.aaI();
                return;
            }
            frsActivity21 = this.cfC.bWH;
            frsActivity21.showToast(t.j.neterror);
        } else if (id == t.g.bar_share_tv) {
            frsActivity18 = this.cfC.bWH;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.cfC.bWH;
            com.baidu.tieba.tbadkCore.p aaR = frsActivity19.aaR();
            frsActivity20 = this.cfC.bWH;
            cl.a(pageContext, aaR, frsActivity20.getForumId());
        } else if (id == t.g.forum_member) {
            frsActivity11 = this.cfC.bWH;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.cfC.bWH;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    frsActivity14 = this.cfC.bWH;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.cfC.bWH;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.cfC.bWH;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.cfC.bWH;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.cfC.bWH;
            frsActivity12.showToast(t.j.neterror);
        } else if (id == t.g.frs_group) {
            frsActivity = this.cfC.bWH;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.cfC.bWH;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.cfC.bWH;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.cfC.bWH;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.cfC.bWH;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.cfC.bWH;
                    if (frsActivity7.aaR() != null) {
                        frsActivity9 = this.cfC.bWH;
                        if (frsActivity9.aaR().bhl() != null) {
                            frsActivity10 = this.cfC.bWH;
                            if (frsActivity10.aaR().bhl().bgY() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    frsActivity8 = this.cfC.bWH;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.cfC.bWH;
            frsActivity2.showToast(t.j.neterror);
        }
    }
}
