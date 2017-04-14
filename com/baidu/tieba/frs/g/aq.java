package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements View.OnClickListener {
    final /* synthetic */ ao cbZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.cbZ = aoVar;
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
        int id = view.getId();
        if (id == w.h.message_layout) {
            frsActivity31 = this.cbZ.bST;
            frsActivity31.Zt();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity32 = this.cbZ.bST;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity32.getPageContext().getPageActivity());
                frsActivity33 = this.cbZ.bST;
                frsActivity33.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == w.h.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.cbZ.getPageContext().getPageActivity())));
        } else if (id == w.h.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.hj()) {
                frsActivity30 = this.cbZ.bST;
                frsActivity30.Zu();
                return;
            }
            frsActivity29 = this.cbZ.bST;
            frsActivity29.showToast(w.l.neterror);
        } else if (id == w.h.post_search_ll) {
            frsActivity23 = this.cbZ.bST;
            if (frsActivity23.Zr() != null) {
                frsActivity24 = this.cbZ.bST;
                if (frsActivity24.Zr().aJw() != null) {
                    frsActivity25 = this.cbZ.bST;
                    String name = frsActivity25.Zr().aJw().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity27 = this.cbZ.bST;
                        frsActivity28 = this.cbZ.bST;
                        frsActivity27.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity28.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity26 = this.cbZ.bST;
                    frsActivity26.showToast(w.l.neterror);
                }
            }
        } else if (id == w.h.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.hj()) {
                frsActivity22 = this.cbZ.bST;
                frsActivity22.Zn();
                return;
            }
            frsActivity21 = this.cbZ.bST;
            frsActivity21.showToast(w.l.neterror);
        } else if (id == w.h.bar_share_tv) {
            frsActivity18 = this.cbZ.bST;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.cbZ.bST;
            com.baidu.tieba.tbadkCore.n Zr = frsActivity19.Zr();
            frsActivity20 = this.cbZ.bST;
            com.baidu.tieba.frs.f.j.a(pageContext, Zr, frsActivity20.getForumId());
        } else if (id == w.h.forum_member) {
            frsActivity11 = this.cbZ.bST;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.cbZ.bST;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    TiebaStatic.log("c11670");
                    frsActivity14 = this.cbZ.bST;
                    Activity pageActivity = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.cbZ.bST;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.cbZ.bST;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.cbZ.bST;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.cbZ.bST;
            frsActivity12.showToast(w.l.neterror);
        } else if (id == w.h.frs_group) {
            frsActivity = this.cbZ.bST;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.cbZ.bST;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.cbZ.bST;
                    Activity pageActivity2 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.cbZ.bST;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.cbZ.bST;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity2, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.cbZ.bST;
                    if (frsActivity7.Zr() != null) {
                        frsActivity9 = this.cbZ.bST;
                        if (frsActivity9.Zr().bgt() != null) {
                            frsActivity10 = this.cbZ.bST;
                            if (frsActivity10.Zr().bgt().bgg() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    TiebaStatic.log("c11671");
                    frsActivity8 = this.cbZ.bST;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.cbZ.bST;
            frsActivity2.showToast(w.l.neterror);
        }
    }
}
