package com.baidu.tieba.frs.f;

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
    final /* synthetic */ ao cdy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.cdy = aoVar;
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
            frsActivity31 = this.cdy.bTf;
            frsActivity31.YX();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity32 = this.cdy.bTf;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity32.getPageContext().getPageActivity());
                frsActivity33 = this.cdy.bTf;
                frsActivity33.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == w.h.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.cdy.getPageContext().getPageActivity())));
        } else if (id == w.h.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.he()) {
                frsActivity30 = this.cdy.bTf;
                frsActivity30.YY();
                return;
            }
            frsActivity29 = this.cdy.bTf;
            frsActivity29.showToast(w.l.neterror);
        } else if (id == w.h.post_search_ll) {
            frsActivity23 = this.cdy.bTf;
            if (frsActivity23.YV() != null) {
                frsActivity24 = this.cdy.bTf;
                if (frsActivity24.YV().aJp() != null) {
                    frsActivity25 = this.cdy.bTf;
                    String name = frsActivity25.YV().aJp().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity27 = this.cdy.bTf;
                        frsActivity28 = this.cdy.bTf;
                        frsActivity27.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity28.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity26 = this.cdy.bTf;
                    frsActivity26.showToast(w.l.neterror);
                }
            }
        } else if (id == w.h.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.he()) {
                frsActivity22 = this.cdy.bTf;
                frsActivity22.YR();
                return;
            }
            frsActivity21 = this.cdy.bTf;
            frsActivity21.showToast(w.l.neterror);
        } else if (id == w.h.bar_share_tv) {
            frsActivity18 = this.cdy.bTf;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.cdy.bTf;
            com.baidu.tieba.tbadkCore.n YV = frsActivity19.YV();
            frsActivity20 = this.cdy.bTf;
            com.baidu.tieba.frs.utils.j.a(pageContext, YV, frsActivity20.getForumId());
        } else if (id == w.h.forum_member) {
            frsActivity11 = this.cdy.bTf;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.cdy.bTf;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    TiebaStatic.log("c11670");
                    frsActivity14 = this.cdy.bTf;
                    Activity pageActivity = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.cdy.bTf;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.cdy.bTf;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.cdy.bTf;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.cdy.bTf;
            frsActivity12.showToast(w.l.neterror);
        } else if (id == w.h.frs_group) {
            frsActivity = this.cdy.bTf;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.cdy.bTf;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.cdy.bTf;
                    Activity pageActivity2 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.cdy.bTf;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.cdy.bTf;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity2, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.cdy.bTf;
                    if (frsActivity7.YV() != null) {
                        frsActivity9 = this.cdy.bTf;
                        if (frsActivity9.YV().bfF() != null) {
                            frsActivity10 = this.cdy.bTf;
                            if (frsActivity10.YV().bfF().bfs() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    TiebaStatic.log("c11671");
                    frsActivity8 = this.cdy.bTf;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.cdy.bTf;
            frsActivity2.showToast(w.l.neterror);
        }
    }
}
