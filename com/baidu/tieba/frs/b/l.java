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
import com.baidu.tieba.frs.ef;
import com.baidu.tieba.frs.mc.FrsGoodActivityConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k bcc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.bcc = kVar;
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
            frsActivity33 = this.bcc.baR;
            frsActivity33.Lk();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity34 = this.bcc.baR;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity34.getPageContext().getPageActivity());
                frsActivity35 = this.bcc.baR;
                frsActivity35.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == i.f.mention_layout) {
            frsActivity31 = this.bcc.baR;
            frsActivity31.Lj();
            String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount2 != null && currentAccount2.length() > 0) {
                TiebaStatic.eventStat(this.bcc.getPageContext().getPageActivity(), "frs_message", "frsclick", 1, new Object[0]);
                SingleMentionActivityConfig singleMentionActivityConfig = new SingleMentionActivityConfig(this.bcc.getPageContext().getPageActivity());
                frsActivity32 = this.bcc.baR;
                frsActivity32.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, singleMentionActivityConfig));
            }
        } else if (id == i.f.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bcc.getPageContext().getPageActivity())));
        } else if (id == i.f.bar_info_tv) {
            frsActivity28 = this.bcc.baR;
            if (frsActivity28.Lh() != null) {
                frsActivity29 = this.bcc.baR;
                if (frsActivity29.Lh().aeN() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bcc.getPageContext().getPageActivity();
                    frsActivity30 = this.bcc.baR;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity30.Lh().aeN().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == i.f.forum_manager_center) {
            frsActivity24 = this.bcc.baR;
            if (frsActivity24.Lh() != null) {
                frsActivity25 = this.bcc.baR;
                if (frsActivity25.Lh().aeN() != null) {
                    frsActivity26 = this.bcc.baR;
                    String id2 = frsActivity26.Lh().aeN().getId();
                    frsActivity27 = this.bcc.baR;
                    com.baidu.tbadk.browser.g.B(this.bcc.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity27.Lh().aeN().getName() + "&fid=" + id2);
                }
            }
        } else if (id == i.f.recommend_forum_item_layout) {
            ef.a aVar = (ef.a) view.getTag();
            if (aVar != null) {
                frsActivity19 = this.bcc.baR;
                if (frsActivity19.Lh() != null) {
                    frsActivity20 = this.bcc.baR;
                    if (frsActivity20.Lh().aeN() != null) {
                        frsActivity21 = this.bcc.baR;
                        String name = frsActivity21.Lh().aeN().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity22 = this.bcc.baR;
                            frsActivity22.resetData();
                            frsActivity23 = this.bcc.baR;
                            frsActivity23.a(aVar, str);
                        } else if (this.bcc.NO().isMenuShowing()) {
                            this.bcc.NO().toggle(true);
                        }
                    }
                }
            }
        } else if (id == i.f.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iM()) {
                frsActivity18 = this.bcc.baR;
                frsActivity18.Ll();
                return;
            }
            frsActivity17 = this.bcc.baR;
            frsActivity17.showToast(i.h.neterror);
        } else if (id == i.f.post_search_ll) {
            frsActivity12 = this.bcc.baR;
            if (frsActivity12.Lh() != null) {
                frsActivity13 = this.bcc.baR;
                if (frsActivity13.Lh().aeN() != null) {
                    frsActivity14 = this.bcc.baR;
                    String name2 = frsActivity14.Lh().aeN().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity15 = this.bcc.baR;
                        frsActivity16 = this.bcc.baR;
                        frsActivity15.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity16.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == i.f.frs_sidebar_good_tv) {
            frsActivity9 = this.bcc.baR;
            frsActivity10 = this.bcc.baR;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity10.getPageContext().getPageActivity());
            frsActivity11 = this.bcc.baR;
            frsActivity9.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity11.aTM, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == i.f.frs_sidebar_add_to_desktop) {
            frsActivity8 = this.bcc.baR;
            frsActivity8.Lb();
        } else if (id == i.f.bar_live_tv) {
            frsActivity2 = this.bcc.baR;
            if (frsActivity2.Lh() != null) {
                frsActivity3 = this.bcc.baR;
                if (frsActivity3.Lh().aeN() != null) {
                    frsActivity4 = this.bcc.baR;
                    if (frsActivity4.Lh().getUserData() != null) {
                        MessageManager messageManager2 = MessageManager.getInstance();
                        frsActivity5 = this.bcc.baR;
                        Activity pageActivity2 = frsActivity5.getPageContext().getPageActivity();
                        frsActivity6 = this.bcc.baR;
                        String id3 = frsActivity6.Lh().aeN().getId();
                        frsActivity7 = this.bcc.baR;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsLiveListActivityConfig(pageActivity2, id3, frsActivity7.Lh().getUserData().getIsManager())));
                    }
                }
            }
        } else if (id == i.f.bar_share_tv) {
            frsActivity = this.bcc.baR;
            frsActivity.showShareDialog();
        }
    }
}
