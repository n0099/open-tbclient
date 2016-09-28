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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa cfz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.cfz = aaVar;
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
            frsActivity37 = this.cfz.bWH;
            frsActivity37.abg();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity38 = this.cfz.bWH;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity38.getPageContext().getPageActivity());
                frsActivity39 = this.cfz.bWH;
                frsActivity39.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == r.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.cfz.getPageContext().getPageActivity())));
        } else if (id == r.g.bar_info_tv) {
            frsActivity34 = this.cfz.bWH;
            if (frsActivity34.abe() != null) {
                frsActivity35 = this.cfz.bWH;
                if (frsActivity35.abe().aMr() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.cfz.getPageContext().getPageActivity();
                    frsActivity36 = this.cfz.bWH;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity36.abe().aMr().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                    TiebaStatic.log("c11669");
                }
            }
        } else if (id == r.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity33 = this.cfz.bWH;
                frsActivity33.abh();
                return;
            }
            frsActivity32 = this.cfz.bWH;
            frsActivity32.showToast(r.j.neterror);
        } else if (id == r.g.post_search_ll) {
            frsActivity26 = this.cfz.bWH;
            if (frsActivity26.abe() != null) {
                frsActivity27 = this.cfz.bWH;
                if (frsActivity27.abe().aMr() != null) {
                    frsActivity28 = this.cfz.bWH;
                    String name = frsActivity28.abe().aMr().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.cfz.bWH;
                        frsActivity31 = this.cfz.bWH;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.cfz.bWH;
                    frsActivity29.showToast(r.j.neterror);
                }
            }
        } else if (id == r.g.frs_sidebar_good_tv) {
            frsActivity23 = this.cfz.bWH;
            frsActivity24 = this.cfz.bWH;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.cfz.bWH;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bOZ, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == r.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.gm()) {
                frsActivity22 = this.cfz.bWH;
                frsActivity22.aaW();
                return;
            }
            frsActivity21 = this.cfz.bWH;
            frsActivity21.showToast(r.j.neterror);
        } else if (id == r.g.bar_share_tv) {
            frsActivity18 = this.cfz.bWH;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.cfz.bWH;
            com.baidu.tieba.tbadkCore.p abe = frsActivity19.abe();
            frsActivity20 = this.cfz.bWH;
            cl.a(pageContext, abe, frsActivity20.getForumId());
        } else if (id == r.g.forum_member) {
            frsActivity11 = this.cfz.bWH;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.cfz.bWH;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    TiebaStatic.log("c11670");
                    frsActivity14 = this.cfz.bWH;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.cfz.bWH;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.cfz.bWH;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.cfz.bWH;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.cfz.bWH;
            frsActivity12.showToast(r.j.neterror);
        } else if (id == r.g.frs_group) {
            frsActivity = this.cfz.bWH;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.cfz.bWH;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.cfz.bWH;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.cfz.bWH;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.cfz.bWH;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.cfz.bWH;
                    if (frsActivity7.abe() != null) {
                        frsActivity9 = this.cfz.bWH;
                        if (frsActivity9.abe().bhT() != null) {
                            frsActivity10 = this.cfz.bWH;
                            if (frsActivity10.abe().bhT().bhG() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    TiebaStatic.log("c11671");
                    frsActivity8 = this.cfz.bWH;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.cfz.bWH;
            frsActivity2.showToast(r.j.neterror);
        }
    }
}
