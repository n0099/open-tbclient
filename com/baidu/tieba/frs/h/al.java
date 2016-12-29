package com.baidu.tieba.frs.h;

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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ ak bPz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.bPz = akVar;
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
        if (id == r.g.message_layout) {
            frsActivity37 = this.bPz.bFI;
            frsActivity37.WH();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity38 = this.bPz.bFI;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity38.getPageContext().getPageActivity());
                frsActivity39 = this.bPz.bFI;
                frsActivity39.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == r.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bPz.getPageContext().getPageActivity())));
        } else if (id == r.g.bar_info_tv) {
            frsActivity34 = this.bPz.bFI;
            if (frsActivity34.WF() != null) {
                frsActivity35 = this.bPz.bFI;
                if (frsActivity35.WF().aIk() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bPz.getPageContext().getPageActivity();
                    frsActivity36 = this.bPz.bFI;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity36.WF().aIk().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                    TiebaStatic.log("c11669");
                }
            }
        } else if (id == r.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity33 = this.bPz.bFI;
                frsActivity33.WI();
                return;
            }
            frsActivity32 = this.bPz.bFI;
            frsActivity32.showToast(r.j.neterror);
        } else if (id == r.g.post_search_ll) {
            frsActivity26 = this.bPz.bFI;
            if (frsActivity26.WF() != null) {
                frsActivity27 = this.bPz.bFI;
                if (frsActivity27.WF().aIk() != null) {
                    frsActivity28 = this.bPz.bFI;
                    String name = frsActivity28.WF().aIk().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.bPz.bFI;
                        frsActivity31 = this.bPz.bFI;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.bPz.bFI;
                    frsActivity29.showToast(r.j.neterror);
                }
            }
        } else if (id == r.g.frs_sidebar_good_tv) {
            frsActivity23 = this.bPz.bFI;
            frsActivity24 = this.bPz.bFI;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.bPz.bFI;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bxY, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == r.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity22 = this.bPz.bFI;
                frsActivity22.WB();
                return;
            }
            frsActivity21 = this.bPz.bFI;
            frsActivity21.showToast(r.j.neterror);
        } else if (id == r.g.bar_share_tv) {
            frsActivity18 = this.bPz.bFI;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.bPz.bFI;
            com.baidu.tieba.tbadkCore.o WF = frsActivity19.WF();
            frsActivity20 = this.bPz.bFI;
            com.baidu.tieba.frs.utils.j.a(pageContext, WF, frsActivity20.getForumId());
        } else if (id == r.g.forum_member) {
            frsActivity11 = this.bPz.bFI;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.bPz.bFI;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    TiebaStatic.log("c11670");
                    frsActivity14 = this.bPz.bFI;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.bPz.bFI;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.bPz.bFI;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.bPz.bFI;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.bPz.bFI;
            frsActivity12.showToast(r.j.neterror);
        } else if (id == r.g.frs_group) {
            frsActivity = this.bPz.bFI;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.bPz.bFI;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.bPz.bFI;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.bPz.bFI;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.bPz.bFI;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.bPz.bFI;
                    if (frsActivity7.WF() != null) {
                        frsActivity9 = this.bPz.bFI;
                        if (frsActivity9.WF().bee() != null) {
                            frsActivity10 = this.bPz.bFI;
                            if (frsActivity10.WF().bee().bdS() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    TiebaStatic.log("c11671");
                    frsActivity8 = this.bPz.bFI;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.bPz.bFI;
            frsActivity2.showToast(r.j.neterror);
        }
    }
}
