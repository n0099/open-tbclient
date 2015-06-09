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
    final /* synthetic */ k aQh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aQh = kVar;
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
            frsActivity22 = this.aQh.aPF;
            frsActivity22.KJ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity23 = this.aQh.aPF;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity23.getPageContext().getPageActivity());
                frsActivity24 = this.aQh.aPF;
                frsActivity24.sendMessage(new CustomMessage(2002001, chatMessageActivityConfig));
            }
        } else if (id == q.mention_layout) {
            frsActivity20 = this.aQh.aPF;
            frsActivity20.KI();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aQh.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.aQh.getPageContext().getPageActivity());
                frsActivity21 = this.aQh.aPF;
                frsActivity21.sendMessage(new CustomMessage(2002001, singleMentionActivityConfig));
            }
        } else if (id == q.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aQh.getPageContext().getPageActivity())));
        } else if (id == q.bar_info_layout) {
            frsActivity17 = this.aQh.aPF;
            if (frsActivity17.KF() != null) {
                frsActivity18 = this.aQh.aPF;
                if (frsActivity18.KF().aas() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.aQh.getPageContext().getPageActivity();
                    frsActivity19 = this.aQh.aPF;
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, frsActivity19.KF().aas().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == q.forum_manager_center) {
            frsActivity13 = this.aQh.aPF;
            if (frsActivity13.KF() != null) {
                frsActivity14 = this.aQh.aPF;
                if (frsActivity14.KF().aas() != null) {
                    frsActivity15 = this.aQh.aPF;
                    String id2 = frsActivity15.KF().aas().getId();
                    frsActivity16 = this.aQh.aPF;
                    com.baidu.tbadk.browser.f.x(this.aQh.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity16.KF().aas().getName() + "&fid=" + id2);
                }
            }
        } else if (id == q.recommend_forum_item_layout) {
            ck ckVar = (ck) view.getTag();
            if (ckVar != null) {
                frsActivity8 = this.aQh.aPF;
                if (frsActivity8.KF() != null) {
                    frsActivity9 = this.aQh.aPF;
                    if (frsActivity9.KF().aas() != null) {
                        frsActivity10 = this.aQh.aPF;
                        String name = frsActivity10.KF().aas().getName();
                        String str = ckVar.name;
                        if (!str.equals(name)) {
                            frsActivity11 = this.aQh.aPF;
                            frsActivity11.resetData();
                            frsActivity12 = this.aQh.aPF;
                            frsActivity12.a(ckVar, str);
                        } else if (this.aQh.getSlidingMenu().isMenuShowing()) {
                            this.aQh.getSlidingMenu().toggle(true);
                        }
                    }
                }
            }
        } else if (id == q.unfollow_layout) {
            if (com.baidu.adp.lib.util.k.iX()) {
                frsActivity7 = this.aQh.aPF;
                frsActivity7.KL();
                return;
            }
            frsActivity6 = this.aQh.aPF;
            frsActivity6.showToast(t.neterror);
        } else if (id == q.post_search_ll) {
            frsActivity = this.aQh.aPF;
            if (frsActivity.KF() != null) {
                frsActivity2 = this.aQh.aPF;
                if (frsActivity2.KF().aas() != null) {
                    frsActivity3 = this.aQh.aPF;
                    String name2 = frsActivity3.KF().aas().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity4 = this.aQh.aPF;
                        frsActivity5 = this.aQh.aPF;
                        frsActivity4.sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(frsActivity5.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        }
    }
}
