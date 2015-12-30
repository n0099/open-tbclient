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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ez;
import com.baidu.tieba.frs.mc.FrsGoodActivityConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l bnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bnd = lVar;
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
        if (id == n.g.message_layout) {
            frsActivity33 = this.bnd.blE;
            frsActivity33.Np();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity34 = this.bnd.blE;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity34.getPageContext().getPageActivity());
                frsActivity35 = this.bnd.blE;
                frsActivity35.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == n.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bnd.getPageContext().getPageActivity())));
        } else if (id == n.g.bar_info_tv) {
            frsActivity30 = this.bnd.blE;
            if (frsActivity30.Nn() != null) {
                frsActivity31 = this.bnd.blE;
                if (frsActivity31.Nn().akG() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bnd.getPageContext().getPageActivity();
                    frsActivity32 = this.bnd.blE;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity32.Nn().akG().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == n.g.forum_manager_center) {
            frsActivity24 = this.bnd.blE;
            if (frsActivity24.Nn() != null) {
                frsActivity25 = this.bnd.blE;
                if (frsActivity25.Nn().akG() != null) {
                    frsActivity26 = this.bnd.blE;
                    String id2 = frsActivity26.Nn().akG().getId();
                    frsActivity27 = this.bnd.blE;
                    com.baidu.tbadk.browser.f.B(this.bnd.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity27.Nn().akG().getName() + "&fid=" + id2);
                    frsActivity28 = this.bnd.blE;
                    if (frsActivity28.Nn().getUserData() != null) {
                        av aa = new av("c10503").aa(ImageViewerConfig.FORUM_ID, id2);
                        frsActivity29 = this.bnd.blE;
                        TiebaStatic.log(aa.aa("uid", frsActivity29.Nn().getUserData().getUserId()));
                    }
                }
            }
        } else if (id == n.g.recommend_forum_item_layout) {
            ez.a aVar = (ez.a) view.getTag();
            if (aVar != null) {
                frsActivity19 = this.bnd.blE;
                if (frsActivity19.Nn() != null) {
                    frsActivity20 = this.bnd.blE;
                    if (frsActivity20.Nn().akG() != null) {
                        frsActivity21 = this.bnd.blE;
                        String name = frsActivity21.Nn().akG().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity22 = this.bnd.blE;
                            frsActivity22.resetData();
                            frsActivity23 = this.bnd.blE;
                            frsActivity23.a(aVar, str);
                        } else if (this.bnd.Qe().isMenuShowing()) {
                            this.bnd.Qe().toggle(true);
                        }
                    }
                }
            }
        } else if (id == n.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iQ()) {
                frsActivity18 = this.bnd.blE;
                frsActivity18.Nq();
                return;
            }
            frsActivity17 = this.bnd.blE;
            frsActivity17.showToast(n.j.neterror);
        } else if (id == n.g.post_search_ll) {
            frsActivity12 = this.bnd.blE;
            if (frsActivity12.Nn() != null) {
                frsActivity13 = this.bnd.blE;
                if (frsActivity13.Nn().akG() != null) {
                    frsActivity14 = this.bnd.blE;
                    String name2 = frsActivity14.Nn().akG().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity15 = this.bnd.blE;
                        frsActivity16 = this.bnd.blE;
                        frsActivity15.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity16.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == n.g.frs_sidebar_good_tv) {
            frsActivity9 = this.bnd.blE;
            frsActivity10 = this.bnd.blE;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity10.getPageContext().getPageActivity());
            frsActivity11 = this.bnd.blE;
            frsActivity9.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity11.bde, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == n.g.frs_sidebar_add_to_desktop) {
            frsActivity8 = this.bnd.blE;
            frsActivity8.Nh();
        } else if (id == n.g.bar_live_tv) {
            frsActivity2 = this.bnd.blE;
            if (frsActivity2.Nn() != null) {
                frsActivity3 = this.bnd.blE;
                if (frsActivity3.Nn().akG() != null) {
                    frsActivity4 = this.bnd.blE;
                    if (frsActivity4.Nn().getUserData() != null) {
                        MessageManager messageManager2 = MessageManager.getInstance();
                        frsActivity5 = this.bnd.blE;
                        Activity pageActivity2 = frsActivity5.getPageContext().getPageActivity();
                        frsActivity6 = this.bnd.blE;
                        String id3 = frsActivity6.Nn().akG().getId();
                        frsActivity7 = this.bnd.blE;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsLiveListActivityConfig(pageActivity2, id3, frsActivity7.Nn().getUserData().getIsManager())));
                    }
                }
            }
        } else if (id == n.g.bar_share_tv) {
            frsActivity = this.bnd.blE;
            frsActivity.showShareDialog();
        }
    }
}
