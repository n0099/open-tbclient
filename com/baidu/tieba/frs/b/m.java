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
    final /* synthetic */ l bjm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.bjm = lVar;
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
        if (id == n.f.message_layout) {
            frsActivity33 = this.bjm.bhN;
            frsActivity33.MV();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity34 = this.bjm.bhN;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity34.getPageContext().getPageActivity());
                frsActivity35 = this.bjm.bhN;
                frsActivity35.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == n.f.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bjm.getPageContext().getPageActivity())));
        } else if (id == n.f.bar_info_tv) {
            frsActivity30 = this.bjm.bhN;
            if (frsActivity30.MT() != null) {
                frsActivity31 = this.bjm.bhN;
                if (frsActivity31.MT().ajy() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bjm.getPageContext().getPageActivity();
                    frsActivity32 = this.bjm.bhN;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity32.MT().ajy().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == n.f.forum_manager_center) {
            frsActivity24 = this.bjm.bhN;
            if (frsActivity24.MT() != null) {
                frsActivity25 = this.bjm.bhN;
                if (frsActivity25.MT().ajy() != null) {
                    frsActivity26 = this.bjm.bhN;
                    String id2 = frsActivity26.MT().ajy().getId();
                    frsActivity27 = this.bjm.bhN;
                    com.baidu.tbadk.browser.f.B(this.bjm.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity27.MT().ajy().getName() + "&fid=" + id2);
                    frsActivity28 = this.bjm.bhN;
                    if (frsActivity28.MT().getUserData() != null) {
                        av ab = new av("c10503").ab(ImageViewerConfig.FORUM_ID, id2);
                        frsActivity29 = this.bjm.bhN;
                        TiebaStatic.log(ab.ab("uid", frsActivity29.MT().getUserData().getUserId()));
                    }
                }
            }
        } else if (id == n.f.recommend_forum_item_layout) {
            ez.a aVar = (ez.a) view.getTag();
            if (aVar != null) {
                frsActivity19 = this.bjm.bhN;
                if (frsActivity19.MT() != null) {
                    frsActivity20 = this.bjm.bhN;
                    if (frsActivity20.MT().ajy() != null) {
                        frsActivity21 = this.bjm.bhN;
                        String name = frsActivity21.MT().ajy().getName();
                        String str = aVar.name;
                        if (!str.equals(name)) {
                            frsActivity22 = this.bjm.bhN;
                            frsActivity22.resetData();
                            frsActivity23 = this.bjm.bhN;
                            frsActivity23.a(aVar, str);
                        } else if (this.bjm.PM().isMenuShowing()) {
                            this.bjm.PM().toggle(true);
                        }
                    }
                }
            }
        } else if (id == n.f.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.iP()) {
                frsActivity18 = this.bjm.bhN;
                frsActivity18.MW();
                return;
            }
            frsActivity17 = this.bjm.bhN;
            frsActivity17.showToast(n.i.neterror);
        } else if (id == n.f.post_search_ll) {
            frsActivity12 = this.bjm.bhN;
            if (frsActivity12.MT() != null) {
                frsActivity13 = this.bjm.bhN;
                if (frsActivity13.MT().ajy() != null) {
                    frsActivity14 = this.bjm.bhN;
                    String name2 = frsActivity14.MT().ajy().getName();
                    if (!StringUtils.isNull(name2)) {
                        frsActivity15 = this.bjm.bhN;
                        frsActivity16 = this.bjm.bhN;
                        frsActivity15.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity16.getPageContext().getPageActivity(), name2)));
                    }
                }
            }
        } else if (id == n.f.frs_sidebar_good_tv) {
            frsActivity9 = this.bjm.bhN;
            frsActivity10 = this.bjm.bhN;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity10.getPageContext().getPageActivity());
            frsActivity11 = this.bjm.bhN;
            frsActivity9.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity11.aZi, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == n.f.frs_sidebar_add_to_desktop) {
            frsActivity8 = this.bjm.bhN;
            frsActivity8.MN();
        } else if (id == n.f.bar_live_tv) {
            frsActivity2 = this.bjm.bhN;
            if (frsActivity2.MT() != null) {
                frsActivity3 = this.bjm.bhN;
                if (frsActivity3.MT().ajy() != null) {
                    frsActivity4 = this.bjm.bhN;
                    if (frsActivity4.MT().getUserData() != null) {
                        MessageManager messageManager2 = MessageManager.getInstance();
                        frsActivity5 = this.bjm.bhN;
                        Activity pageActivity2 = frsActivity5.getPageContext().getPageActivity();
                        frsActivity6 = this.bjm.bhN;
                        String id3 = frsActivity6.MT().ajy().getId();
                        frsActivity7 = this.bjm.bhN;
                        messageManager2.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsLiveListActivityConfig(pageActivity2, id3, frsActivity7.MT().getUserData().getIsManager())));
                    }
                }
            }
        } else if (id == n.f.bar_share_tv) {
            frsActivity = this.bjm.bhN;
            frsActivity.showShareDialog();
        }
    }
}
