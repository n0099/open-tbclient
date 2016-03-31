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
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.fs;
import com.baidu.tieba.frs.mc.FrsGoodActivityConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l buT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.buT = lVar;
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
        int id = view.getId();
        if (id == t.g.message_layout) {
            frsActivity27 = this.buT.bts;
            frsActivity27.Rb();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity28 = this.buT.bts;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity28.getPageContext().getPageActivity());
                frsActivity29 = this.buT.bts;
                frsActivity29.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == t.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.buT.getPageContext().getPageActivity())));
        } else if (id == t.g.bar_info_tv) {
            frsActivity24 = this.buT.bts;
            if (frsActivity24.QZ() != null) {
                frsActivity25 = this.buT.bts;
                if (frsActivity25.QZ().avu() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.buT.getPageContext().getPageActivity();
                    frsActivity26 = this.buT.bts;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity26.QZ().avu().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == t.g.forum_manager_center) {
            frsActivity18 = this.buT.bts;
            if (frsActivity18.QZ() != null) {
                frsActivity19 = this.buT.bts;
                if (frsActivity19.QZ().avu() != null) {
                    frsActivity20 = this.buT.bts;
                    String id2 = frsActivity20.QZ().avu().getId();
                    frsActivity21 = this.buT.bts;
                    com.baidu.tbadk.browser.f.s(this.buT.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity21.QZ().avu().getName() + "&fid=" + id2);
                    frsActivity22 = this.buT.bts;
                    if (frsActivity22.QZ().getUserData() != null) {
                        aw ac = new aw("c10503").ac("fid", id2);
                        frsActivity23 = this.buT.bts;
                        TiebaStatic.log(ac.ac("uid", frsActivity23.QZ().getUserData().getUserId()));
                    }
                }
            }
        } else if (id == t.g.recommend_forum_item_layout) {
            fs.a aVar = (fs.a) view.getTag();
            if (aVar != null) {
                frsActivity13 = this.buT.bts;
                if (frsActivity13.QZ() != null) {
                    frsActivity14 = this.buT.bts;
                    if (frsActivity14.QZ().avu() != null) {
                        frsActivity15 = this.buT.bts;
                        String name = frsActivity15.QZ().avu().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity16 = this.buT.bts;
                            frsActivity16.resetData();
                            frsActivity17 = this.buT.bts;
                            frsActivity17.a(aVar, str);
                        } else if (this.buT.TX().isMenuShowing()) {
                            this.buT.TX().toggle(true);
                        }
                    }
                }
            }
        } else if (id == t.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.jf()) {
                frsActivity12 = this.buT.bts;
                frsActivity12.Rc();
                return;
            }
            frsActivity11 = this.buT.bts;
            frsActivity11.showToast(t.j.neterror);
        } else if (id == t.g.post_search_ll) {
            frsActivity6 = this.buT.bts;
            if (frsActivity6.QZ() != null) {
                frsActivity7 = this.buT.bts;
                if (frsActivity7.QZ().avu() != null) {
                    frsActivity8 = this.buT.bts;
                    String name2 = frsActivity8.QZ().avu().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity9 = this.buT.bts;
                        frsActivity10 = this.buT.bts;
                        frsActivity9.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity10.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == t.g.frs_sidebar_good_tv) {
            frsActivity3 = this.buT.bts;
            frsActivity4 = this.buT.bts;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity4.getPageContext().getPageActivity());
            frsActivity5 = this.buT.bts;
            frsActivity3.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity5.bkf, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == t.g.frs_sidebar_add_to_desktop) {
            frsActivity2 = this.buT.bts;
            frsActivity2.QT();
        } else if (id == t.g.bar_share_tv) {
            frsActivity = this.buT.bts;
            frsActivity.Rf();
        }
    }
}
