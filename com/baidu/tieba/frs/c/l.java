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
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k bbX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bbX = kVar;
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
        int id = view.getId();
        if (id == i.f.message_layout) {
            frsActivity32 = this.bbX.baN;
            frsActivity32.Lo();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity33 = this.bbX.baN;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity33.getPageContext().getPageActivity());
                frsActivity34 = this.bbX.baN;
                frsActivity34.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == i.f.mention_layout) {
            frsActivity30 = this.bbX.baN;
            frsActivity30.Ln();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.bbX.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.bbX.getPageContext().getPageActivity());
                frsActivity31 = this.bbX.baN;
                frsActivity31.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleMentionActivityConfig));
            }
        } else if (id == i.f.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bbX.getPageContext().getPageActivity())));
        } else if (id == i.f.bar_info_tv) {
            frsActivity27 = this.bbX.baN;
            if (frsActivity27.Ll() != null) {
                frsActivity28 = this.bbX.baN;
                if (frsActivity28.Ll().acP() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bbX.getPageContext().getPageActivity();
                    frsActivity29 = this.bbX.baN;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity29.Ll().acP().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == i.f.forum_manager_center) {
            frsActivity23 = this.bbX.baN;
            if (frsActivity23.Ll() != null) {
                frsActivity24 = this.bbX.baN;
                if (frsActivity24.Ll().acP() != null) {
                    frsActivity25 = this.bbX.baN;
                    String id2 = frsActivity25.Ll().acP().getId();
                    frsActivity26 = this.bbX.baN;
                    com.baidu.tbadk.browser.g.B(this.bbX.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity26.Ll().acP().getName() + "&fid=" + id2);
                }
            }
        } else if (id == i.f.recommend_forum_item_layout) {
            dm.a aVar = (dm.a) view.getTag();
            if (aVar != null) {
                frsActivity18 = this.bbX.baN;
                if (frsActivity18.Ll() != null) {
                    frsActivity19 = this.bbX.baN;
                    if (frsActivity19.Ll().acP() != null) {
                        frsActivity20 = this.bbX.baN;
                        String name = frsActivity20.Ll().acP().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity21 = this.bbX.baN;
                            frsActivity21.resetData();
                            frsActivity22 = this.bbX.baN;
                            frsActivity22.a(aVar, str);
                        } else if (this.bbX.NO().isMenuShowing()) {
                            this.bbX.NO().toggle(true);
                        }
                    }
                }
            }
        } else if (id == i.f.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iL()) {
                frsActivity17 = this.bbX.baN;
                frsActivity17.Lp();
                return;
            }
            frsActivity16 = this.bbX.baN;
            frsActivity16.showToast(i.h.neterror);
        } else if (id == i.f.post_search_ll) {
            frsActivity11 = this.bbX.baN;
            if (frsActivity11.Ll() != null) {
                frsActivity12 = this.bbX.baN;
                if (frsActivity12.Ll().acP() != null) {
                    frsActivity13 = this.bbX.baN;
                    String name2 = frsActivity13.Ll().acP().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity14 = this.bbX.baN;
                        frsActivity15 = this.bbX.baN;
                        frsActivity14.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity15.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == i.f.frs_sidebar_good_tv) {
            frsActivity8 = this.bbX.baN;
            frsActivity9 = this.bbX.baN;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity9.getPageContext().getPageActivity());
            frsActivity10 = this.bbX.baN;
            frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity10.aUF, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == i.f.frs_sidebar_add_to_desktop) {
            frsActivity7 = this.bbX.baN;
            frsActivity7.Lf();
        } else if (id == i.f.bar_live_tv) {
            frsActivity = this.bbX.baN;
            if (frsActivity.Ll() != null) {
                frsActivity2 = this.bbX.baN;
                if (frsActivity2.Ll().acP() != null) {
                    frsActivity3 = this.bbX.baN;
                    if (frsActivity3.Ll().getUserData() != null) {
                        MessageManager messageManager2 = MessageManager.getInstance();
                        frsActivity4 = this.bbX.baN;
                        Activity pageActivity2 = frsActivity4.getPageContext().getPageActivity();
                        frsActivity5 = this.bbX.baN;
                        String id3 = frsActivity5.Ll().acP().getId();
                        frsActivity6 = this.bbX.baN;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsLiveListActivityConfig(pageActivity2, id3, frsActivity6.Ll().getUserData().getIsManager())));
                    }
                }
            }
        }
    }
}
