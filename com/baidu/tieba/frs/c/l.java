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
    final /* synthetic */ k aND;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.aND = kVar;
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
            frsActivity17 = this.aND.aNb;
            frsActivity17.Jy();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity18 = this.aND.aNb;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity18.getPageContext().getPageActivity());
                frsActivity19 = this.aND.aNb;
                frsActivity19.sendMessage(new CustomMessage(2002001, chatMessageActivityConfig));
            }
        } else if (id == v.mention_layout) {
            frsActivity15 = this.aND.aNb;
            frsActivity15.Jx();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.aND.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.aND.getPageContext().getPageActivity());
                frsActivity16 = this.aND.aNb;
                frsActivity16.sendMessage(new CustomMessage(2002001, singleMentionActivityConfig));
            }
        } else if (id == v.history_layout) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbHistoryActivityConfig(this.aND.getPageContext().getPageActivity())));
        } else if (id == v.bar_info_layout) {
            frsActivity12 = this.aND.aNb;
            if (frsActivity12.Ju() != null) {
                frsActivity13 = this.aND.aNb;
                if (frsActivity13.Ju().YO() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.aND.getPageContext().getPageActivity();
                    frsActivity14 = this.aND.aNb;
                    messageManager.sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(pageActivity, frsActivity14.Ju().YO().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == v.forum_manager_center) {
            frsActivity8 = this.aND.aNb;
            if (frsActivity8.Ju() != null) {
                frsActivity9 = this.aND.aNb;
                if (frsActivity9.Ju().YO() != null) {
                    frsActivity10 = this.aND.aNb;
                    String id2 = frsActivity10.Ju().YO().getId();
                    frsActivity11 = this.aND.aNb;
                    com.baidu.tbadk.browser.f.x(this.aND.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity11.Ju().YO().getName() + "&fid=" + id2);
                }
            }
        } else if (id == v.recommend_forum_item_layout) {
            cl clVar = (cl) view.getTag();
            if (clVar != null) {
                frsActivity3 = this.aND.aNb;
                if (frsActivity3.Ju() != null) {
                    frsActivity4 = this.aND.aNb;
                    if (frsActivity4.Ju().YO() != null) {
                        frsActivity5 = this.aND.aNb;
                        String name = frsActivity5.Ju().YO().getName();
                        String str = clVar.name;
                        if (!str.equals(name)) {
                            frsActivity6 = this.aND.aNb;
                            frsActivity6.resetData();
                            frsActivity7 = this.aND.aNb;
                            frsActivity7.a(clVar, str);
                        } else if (this.aND.getSlidingMenu().isMenuShowing()) {
                            this.aND.getSlidingMenu().toggle(true);
                        }
                    }
                }
            }
        } else if (id == v.unfollow_layout) {
            if (com.baidu.adp.lib.util.k.iH()) {
                frsActivity2 = this.aND.aNb;
                frsActivity2.JA();
                return;
            }
            frsActivity = this.aND.aNb;
            frsActivity.showToast(y.neterror);
        }
    }
}
