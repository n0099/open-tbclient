package com.baidu.tieba.frs.f;

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
public class ao implements View.OnClickListener {
    final /* synthetic */ am bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bWd = amVar;
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
        if (id == r.h.message_layout) {
            frsActivity37 = this.bWd.bLZ;
            frsActivity37.XY();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity38 = this.bWd.bLZ;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity38.getPageContext().getPageActivity());
                frsActivity39 = this.bWd.bLZ;
                frsActivity39.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == r.h.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bWd.getPageContext().getPageActivity())));
        } else if (id == r.h.bar_info_tv) {
            frsActivity34 = this.bWd.bLZ;
            if (frsActivity34.XW() != null) {
                frsActivity35 = this.bWd.bLZ;
                if (frsActivity35.XW().aJY() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bWd.getPageContext().getPageActivity();
                    frsActivity36 = this.bWd.bLZ;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity36.XW().aJY().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                    TiebaStatic.log("c11669");
                }
            }
        } else if (id == r.h.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.gk()) {
                frsActivity33 = this.bWd.bLZ;
                frsActivity33.XZ();
                return;
            }
            frsActivity32 = this.bWd.bLZ;
            frsActivity32.showToast(r.l.neterror);
        } else if (id == r.h.post_search_ll) {
            frsActivity26 = this.bWd.bLZ;
            if (frsActivity26.XW() != null) {
                frsActivity27 = this.bWd.bLZ;
                if (frsActivity27.XW().aJY() != null) {
                    frsActivity28 = this.bWd.bLZ;
                    String name = frsActivity28.XW().aJY().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.bWd.bLZ;
                        frsActivity31 = this.bWd.bLZ;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.bWd.bLZ;
                    frsActivity29.showToast(r.l.neterror);
                }
            }
        } else if (id == r.h.frs_sidebar_good_tv) {
            frsActivity23 = this.bWd.bLZ;
            frsActivity24 = this.bWd.bLZ;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.bWd.bLZ;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bFw, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == r.h.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.gk()) {
                frsActivity22 = this.bWd.bLZ;
                frsActivity22.XS();
                return;
            }
            frsActivity21 = this.bWd.bLZ;
            frsActivity21.showToast(r.l.neterror);
        } else if (id == r.h.bar_share_tv) {
            frsActivity18 = this.bWd.bLZ;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.bWd.bLZ;
            com.baidu.tieba.tbadkCore.n XW = frsActivity19.XW();
            frsActivity20 = this.bWd.bLZ;
            com.baidu.tieba.frs.utils.j.a(pageContext, XW, frsActivity20.getForumId());
        } else if (id == r.h.forum_member) {
            frsActivity11 = this.bWd.bLZ;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.bWd.bLZ;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    TiebaStatic.log("c11670");
                    frsActivity14 = this.bWd.bLZ;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.bWd.bLZ;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.bWd.bLZ;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.bWd.bLZ;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.bWd.bLZ;
            frsActivity12.showToast(r.l.neterror);
        } else if (id == r.h.frs_group) {
            frsActivity = this.bWd.bLZ;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.bWd.bLZ;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.bWd.bLZ;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.bWd.bLZ;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.bWd.bLZ;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.bWd.bLZ;
                    if (frsActivity7.XW() != null) {
                        frsActivity9 = this.bWd.bLZ;
                        if (frsActivity9.XW().bfS() != null) {
                            frsActivity10 = this.bWd.bLZ;
                            if (frsActivity10.XW().bfS().bfF() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    TiebaStatic.log("c11671");
                    frsActivity8 = this.bWd.bLZ;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.bWd.bLZ;
            frsActivity2.showToast(r.l.neterror);
        }
    }
}
