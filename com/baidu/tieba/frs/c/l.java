package com.baidu.tieba.frs.c;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ck;
import com.baidu.tieba.q;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k aQg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aQg = kVar;
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
        int id = view.getId();
        if (id == q.message_layout) {
            frsActivity22 = this.aQg.aPE;
            frsActivity22.KI();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity23 = this.aQg.aPE;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity23.getPageContext().getPageActivity());
                frsActivity24 = this.aQg.aPE;
                frsActivity24.sendMessage(new CustomMessage(2002001, chatMessageActivityConfig));
            }
        } else if (id == q.mention_layout) {
            frsActivity20 = this.aQg.aPE;
            frsActivity20.KH();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aQg.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.aQg.getPageContext().getPageActivity());
                frsActivity21 = this.aQg.aPE;
                frsActivity21.sendMessage(new CustomMessage(2002001, singleMentionActivityConfig));
            }
        } else if (id == q.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aQg.getPageContext().getPageActivity())));
        } else if (id == q.bar_info_layout) {
            frsActivity17 = this.aQg.aPE;
            if (frsActivity17.KE() != null) {
                frsActivity18 = this.aQg.aPE;
                if (frsActivity18.KE().aar() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.aQg.getPageContext().getPageActivity();
                    frsActivity19 = this.aQg.aPE;
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, frsActivity19.KE().aar().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == q.forum_manager_center) {
            frsActivity13 = this.aQg.aPE;
            if (frsActivity13.KE() != null) {
                frsActivity14 = this.aQg.aPE;
                if (frsActivity14.KE().aar() != null) {
                    frsActivity15 = this.aQg.aPE;
                    String id2 = frsActivity15.KE().aar().getId();
                    frsActivity16 = this.aQg.aPE;
                    com.baidu.tbadk.browser.f.x(this.aQg.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity16.KE().aar().getName() + "&fid=" + id2);
                }
            }
        } else if (id == q.recommend_forum_item_layout) {
            ck ckVar = (ck) view.getTag();
            if (ckVar != null) {
                frsActivity8 = this.aQg.aPE;
                if (frsActivity8.KE() != null) {
                    frsActivity9 = this.aQg.aPE;
                    if (frsActivity9.KE().aar() != null) {
                        frsActivity10 = this.aQg.aPE;
                        String name = frsActivity10.KE().aar().getName();
                        String str = ckVar.name;
                        if (!str.equals(name)) {
                            frsActivity11 = this.aQg.aPE;
                            frsActivity11.resetData();
                            frsActivity12 = this.aQg.aPE;
                            frsActivity12.a(ckVar, str);
                        } else if (this.aQg.getSlidingMenu().isMenuShowing()) {
                            this.aQg.getSlidingMenu().toggle(true);
                        }
                    }
                }
            }
        } else if (id == q.unfollow_layout) {
            if (com.baidu.adp.lib.util.k.iX()) {
                frsActivity7 = this.aQg.aPE;
                frsActivity7.KK();
                return;
            }
            frsActivity6 = this.aQg.aPE;
            frsActivity6.showToast(t.neterror);
        } else if (id == q.post_search_ll) {
            frsActivity = this.aQg.aPE;
            if (frsActivity.KE() != null) {
                frsActivity2 = this.aQg.aPE;
                if (frsActivity2.KE().aar() != null) {
                    frsActivity3 = this.aQg.aPE;
                    String name2 = frsActivity3.KE().aar().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity4 = this.aQg.aPE;
                        frsActivity5 = this.aQg.aPE;
                        frsActivity4.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(frsActivity5.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        }
    }
}
