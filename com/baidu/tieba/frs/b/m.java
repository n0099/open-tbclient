package com.baidu.tieba.frs.b;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SingleMentionActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.eh;
import com.baidu.tieba.frs.mc.FrsGoodActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l bcH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bcH = lVar;
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
        int id = view.getId();
        if (id == i.f.message_layout) {
            frsActivity33 = this.bcH.bbk;
            frsActivity33.Lw();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity34 = this.bcH.bbk;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity34.getPageContext().getPageActivity());
                frsActivity35 = this.bcH.bbk;
                frsActivity35.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == i.f.mention_layout) {
            frsActivity31 = this.bcH.bbk;
            frsActivity31.Lv();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.bcH.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.bcH.getPageContext().getPageActivity());
                frsActivity32 = this.bcH.bbk;
                frsActivity32.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleMentionActivityConfig));
            }
        } else if (id == i.f.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bcH.getPageContext().getPageActivity())));
        } else if (id == i.f.bar_info_tv) {
            frsActivity28 = this.bcH.bbk;
            if (frsActivity28.Lt() != null) {
                frsActivity29 = this.bcH.bbk;
                if (frsActivity29.Lt().afg() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bcH.getPageContext().getPageActivity();
                    frsActivity30 = this.bcH.bbk;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity30.Lt().afg().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == i.f.forum_manager_center) {
            frsActivity24 = this.bcH.bbk;
            if (frsActivity24.Lt() != null) {
                frsActivity25 = this.bcH.bbk;
                if (frsActivity25.Lt().afg() != null) {
                    frsActivity26 = this.bcH.bbk;
                    String id2 = frsActivity26.Lt().afg().getId();
                    frsActivity27 = this.bcH.bbk;
                    com.baidu.tbadk.browser.g.B(this.bcH.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity27.Lt().afg().getName() + "&fid=" + id2);
                }
            }
        } else if (id == i.f.recommend_forum_item_layout) {
            eh.a aVar = (eh.a) view.getTag();
            if (aVar != null) {
                frsActivity19 = this.bcH.bbk;
                if (frsActivity19.Lt() != null) {
                    frsActivity20 = this.bcH.bbk;
                    if (frsActivity20.Lt().afg() != null) {
                        frsActivity21 = this.bcH.bbk;
                        String name = frsActivity21.Lt().afg().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity22 = this.bcH.bbk;
                            frsActivity22.resetData();
                            frsActivity23 = this.bcH.bbk;
                            frsActivity23.a(aVar, str);
                        } else if (this.bcH.Og().isMenuShowing()) {
                            this.bcH.Og().toggle(true);
                        }
                    }
                }
            }
        } else if (id == i.f.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iN()) {
                frsActivity18 = this.bcH.bbk;
                frsActivity18.Lx();
                return;
            }
            frsActivity17 = this.bcH.bbk;
            frsActivity17.showToast(i.h.neterror);
        } else if (id == i.f.post_search_ll) {
            frsActivity12 = this.bcH.bbk;
            if (frsActivity12.Lt() != null) {
                frsActivity13 = this.bcH.bbk;
                if (frsActivity13.Lt().afg() != null) {
                    frsActivity14 = this.bcH.bbk;
                    String name2 = frsActivity14.Lt().afg().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity15 = this.bcH.bbk;
                        frsActivity16 = this.bcH.bbk;
                        frsActivity15.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity16.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == i.f.frs_sidebar_good_tv) {
            frsActivity9 = this.bcH.bbk;
            frsActivity10 = this.bcH.bbk;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity10.getPageContext().getPageActivity());
            frsActivity11 = this.bcH.bbk;
            frsActivity9.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity11.aTU, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == i.f.frs_sidebar_add_to_desktop) {
            frsActivity8 = this.bcH.bbk;
            frsActivity8.Ln();
        } else if (id == i.f.bar_live_tv) {
            frsActivity2 = this.bcH.bbk;
            if (frsActivity2.Lt() != null) {
                frsActivity3 = this.bcH.bbk;
                if (frsActivity3.Lt().afg() != null) {
                    frsActivity4 = this.bcH.bbk;
                    if (frsActivity4.Lt().getUserData() != null) {
                        MessageManager messageManager2 = MessageManager.getInstance();
                        frsActivity5 = this.bcH.bbk;
                        Activity pageActivity2 = frsActivity5.getPageContext().getPageActivity();
                        frsActivity6 = this.bcH.bbk;
                        String id3 = frsActivity6.Lt().afg().getId();
                        frsActivity7 = this.bcH.bbk;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsLiveListActivityConfig(pageActivity2, id3, frsActivity7.Lt().getUserData().getIsManager())));
                    }
                }
            }
        } else if (id == i.f.bar_share_tv) {
            frsActivity = this.bcH.bbk;
            frsActivity.showShareDialog();
        }
    }
}
