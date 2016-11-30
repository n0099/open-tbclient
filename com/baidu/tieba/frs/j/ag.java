package com.baidu.tieba.frs.j;

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
public class ag implements View.OnClickListener {
    final /* synthetic */ af ckq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.ckq = afVar;
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
            frsActivity37 = this.ckq.bZY;
            frsActivity37.act();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity38 = this.ckq.bZY;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity38.getPageContext().getPageActivity());
                frsActivity39 = this.ckq.bZY;
                frsActivity39.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == r.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.ckq.getPageContext().getPageActivity())));
        } else if (id == r.g.bar_info_tv) {
            frsActivity34 = this.ckq.bZY;
            if (frsActivity34.acr() != null) {
                frsActivity35 = this.ckq.bZY;
                if (frsActivity35.acr().aOk() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.ckq.getPageContext().getPageActivity();
                    frsActivity36 = this.ckq.bZY;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity36.acr().aOk().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                    TiebaStatic.log("c11669");
                }
            }
        } else if (id == r.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity33 = this.ckq.bZY;
                frsActivity33.acu();
                return;
            }
            frsActivity32 = this.ckq.bZY;
            frsActivity32.showToast(r.j.neterror);
        } else if (id == r.g.post_search_ll) {
            frsActivity26 = this.ckq.bZY;
            if (frsActivity26.acr() != null) {
                frsActivity27 = this.ckq.bZY;
                if (frsActivity27.acr().aOk() != null) {
                    frsActivity28 = this.ckq.bZY;
                    String name = frsActivity28.acr().aOk().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.ckq.bZY;
                        frsActivity31 = this.ckq.bZY;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.ckq.bZY;
                    frsActivity29.showToast(r.j.neterror);
                }
            }
        } else if (id == r.g.frs_sidebar_good_tv) {
            frsActivity23 = this.ckq.bZY;
            frsActivity24 = this.ckq.bZY;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.ckq.bZY;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bRN, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == r.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity22 = this.ckq.bZY;
                frsActivity22.acn();
                return;
            }
            frsActivity21 = this.ckq.bZY;
            frsActivity21.showToast(r.j.neterror);
        } else if (id == r.g.bar_share_tv) {
            frsActivity18 = this.ckq.bZY;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.ckq.bZY;
            com.baidu.tieba.tbadkCore.p acr = frsActivity19.acr();
            frsActivity20 = this.ckq.bZY;
            com.baidu.tieba.frs.utils.j.a(pageContext, acr, frsActivity20.getForumId());
        } else if (id == r.g.forum_member) {
            frsActivity11 = this.ckq.bZY;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.ckq.bZY;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    TiebaStatic.log("c11670");
                    frsActivity14 = this.ckq.bZY;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.ckq.bZY;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.ckq.bZY;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.ckq.bZY;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.ckq.bZY;
            frsActivity12.showToast(r.j.neterror);
        } else if (id == r.g.frs_group) {
            frsActivity = this.ckq.bZY;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.ckq.bZY;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.ckq.bZY;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.ckq.bZY;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.ckq.bZY;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.ckq.bZY;
                    if (frsActivity7.acr() != null) {
                        frsActivity9 = this.ckq.bZY;
                        if (frsActivity9.acr().bko() != null) {
                            frsActivity10 = this.ckq.bZY;
                            if (frsActivity10.acr().bko().bkc() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    TiebaStatic.log("c11671");
                    frsActivity8 = this.ckq.bZY;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.ckq.bZY;
            frsActivity2.showToast(r.j.neterror);
        }
    }
}
