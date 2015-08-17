package com.baidu.tieba.frs.c;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k bbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bbD = kVar;
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
        int id = view.getId();
        if (id == i.f.message_layout) {
            frsActivity26 = this.bbD.bat;
            frsActivity26.Lx();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity27 = this.bbD.bat;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity27.getPageContext().getPageActivity());
                frsActivity28 = this.bbD.bat;
                frsActivity28.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == i.f.mention_layout) {
            frsActivity24 = this.bbD.bat;
            frsActivity24.Lw();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.bbD.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.bbD.getPageContext().getPageActivity());
                frsActivity25 = this.bbD.bat;
                frsActivity25.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleMentionActivityConfig));
            }
        } else if (id == i.f.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bbD.getPageContext().getPageActivity())));
        } else if (id == i.f.bar_info_tv) {
            frsActivity21 = this.bbD.bat;
            if (frsActivity21.Lu() != null) {
                frsActivity22 = this.bbD.bat;
                if (frsActivity22.Lu().acG() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bbD.getPageContext().getPageActivity();
                    frsActivity23 = this.bbD.bat;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity23.Lu().acG().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == i.f.forum_manager_center) {
            frsActivity17 = this.bbD.bat;
            if (frsActivity17.Lu() != null) {
                frsActivity18 = this.bbD.bat;
                if (frsActivity18.Lu().acG() != null) {
                    frsActivity19 = this.bbD.bat;
                    String id2 = frsActivity19.Lu().acG().getId();
                    frsActivity20 = this.bbD.bat;
                    com.baidu.tbadk.browser.f.B(this.bbD.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity20.Lu().acG().getName() + "&fid=" + id2);
                }
            }
        } else if (id == i.f.recommend_forum_item_layout) {
            dg.a aVar = (dg.a) view.getTag();
            if (aVar != null) {
                frsActivity12 = this.bbD.bat;
                if (frsActivity12.Lu() != null) {
                    frsActivity13 = this.bbD.bat;
                    if (frsActivity13.Lu().acG() != null) {
                        frsActivity14 = this.bbD.bat;
                        String name = frsActivity14.Lu().acG().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity15 = this.bbD.bat;
                            frsActivity15.resetData();
                            frsActivity16 = this.bbD.bat;
                            frsActivity16.a(aVar, str);
                        } else if (this.bbD.NN().isMenuShowing()) {
                            this.bbD.NN().toggle(true);
                        }
                    }
                }
            }
        } else if (id == i.f.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iO()) {
                frsActivity11 = this.bbD.bat;
                frsActivity11.Ly();
                return;
            }
            frsActivity10 = this.bbD.bat;
            frsActivity10.showToast(i.C0057i.neterror);
        } else if (id == i.f.post_search_ll) {
            frsActivity5 = this.bbD.bat;
            if (frsActivity5.Lu() != null) {
                frsActivity6 = this.bbD.bat;
                if (frsActivity6.Lu().acG() != null) {
                    frsActivity7 = this.bbD.bat;
                    String name2 = frsActivity7.Lu().acG().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity8 = this.bbD.bat;
                        frsActivity9 = this.bbD.bat;
                        frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity9.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == i.f.frs_sidebar_good_tv) {
            frsActivity2 = this.bbD.bat;
            frsActivity3 = this.bbD.bat;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity3.getPageContext().getPageActivity());
            frsActivity4 = this.bbD.bat;
            frsActivity2.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity4.aUq, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == i.f.frs_sidebar_add_to_desktop) {
            frsActivity = this.bbD.bat;
            frsActivity.Lq();
        }
    }
}
