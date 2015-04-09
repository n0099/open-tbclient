package com.baidu.tieba.frs.c;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k aNU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aNU = kVar;
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
        int id = view.getId();
        if (id == v.message_layout) {
            frsActivity17 = this.aNU.aNs;
            frsActivity17.JE();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity18 = this.aNU.aNs;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity18.getPageContext().getPageActivity());
                frsActivity19 = this.aNU.aNs;
                frsActivity19.sendMessage(new CustomMessage(2002001, chatMessageActivityConfig));
            }
        } else if (id == v.mention_layout) {
            frsActivity15 = this.aNU.aNs;
            frsActivity15.JD();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aNU.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.aNU.getPageContext().getPageActivity());
                frsActivity16 = this.aNU.aNs;
                frsActivity16.sendMessage(new CustomMessage(2002001, singleMentionActivityConfig));
            }
        } else if (id == v.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aNU.getPageContext().getPageActivity())));
        } else if (id == v.bar_info_layout) {
            frsActivity12 = this.aNU.aNs;
            if (frsActivity12.JA() != null) {
                frsActivity13 = this.aNU.aNs;
                if (frsActivity13.JA().Za() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.aNU.getPageContext().getPageActivity();
                    frsActivity14 = this.aNU.aNs;
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, frsActivity14.JA().Za().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == v.forum_manager_center) {
            frsActivity8 = this.aNU.aNs;
            if (frsActivity8.JA() != null) {
                frsActivity9 = this.aNU.aNs;
                if (frsActivity9.JA().Za() != null) {
                    frsActivity10 = this.aNU.aNs;
                    String id2 = frsActivity10.JA().Za().getId();
                    frsActivity11 = this.aNU.aNs;
                    com.baidu.tbadk.browser.f.x(this.aNU.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity11.JA().Za().getName() + "&fid=" + id2);
                }
            }
        } else if (id == v.recommend_forum_item_layout) {
            cl clVar = (cl) view.getTag();
            if (clVar != null) {
                frsActivity3 = this.aNU.aNs;
                if (frsActivity3.JA() != null) {
                    frsActivity4 = this.aNU.aNs;
                    if (frsActivity4.JA().Za() != null) {
                        frsActivity5 = this.aNU.aNs;
                        String name = frsActivity5.JA().Za().getName();
                        String str = clVar.name;
                        if (!str.equals(name)) {
                            frsActivity6 = this.aNU.aNs;
                            frsActivity6.resetData();
                            frsActivity7 = this.aNU.aNs;
                            frsActivity7.a(clVar, str);
                        } else if (this.aNU.getSlidingMenu().isMenuShowing()) {
                            this.aNU.getSlidingMenu().toggle(true);
                        }
                    }
                }
            }
        } else if (id == v.unfollow_layout) {
            if (com.baidu.adp.lib.util.k.iH()) {
                frsActivity2 = this.aNU.aNs;
                frsActivity2.JG();
                return;
            }
            frsActivity = this.aNU.aNs;
            frsActivity.showToast(y.neterror);
        }
    }
}
