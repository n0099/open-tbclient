package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChatMessageActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cp;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa bSu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bSu = aaVar;
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
        FrsActivity frsActivity36;
        FrsActivity frsActivity37;
        FrsActivity frsActivity38;
        FrsActivity frsActivity39;
        FrsActivity frsActivity40;
        FrsActivity frsActivity41;
        FrsActivity frsActivity42;
        FrsActivity frsActivity43;
        FrsActivity frsActivity44;
        FrsActivity frsActivity45;
        FrsActivity frsActivity46;
        int id = view.getId();
        if (id == u.g.message_layout) {
            frsActivity44 = this.bSu.bJR;
            frsActivity44.VE();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity45 = this.bSu.bJR;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity45.getPageContext().getPageActivity());
                frsActivity46 = this.bSu.bJR;
                frsActivity46.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == u.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bSu.getPageContext().getPageActivity())));
        } else if (id == u.g.bar_info_tv) {
            frsActivity41 = this.bSu.bJR;
            if (frsActivity41.VC() != null) {
                frsActivity42 = this.bSu.bJR;
                if (frsActivity42.VC().aDN() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bSu.getPageContext().getPageActivity();
                    frsActivity43 = this.bSu.bJR;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity43.VC().aDN().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == u.g.forum_manager_center) {
            frsActivity34 = this.bSu.bJR;
            if (frsActivity34.VC() != null) {
                frsActivity36 = this.bSu.bJR;
                if (frsActivity36.VC().aDN() != null) {
                    frsActivity37 = this.bSu.bJR;
                    String id2 = frsActivity37.VC().aDN().getId();
                    frsActivity38 = this.bSu.bJR;
                    com.baidu.tbadk.browser.f.u(this.bSu.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity38.VC().aDN().getName() + "&fid=" + id2);
                    frsActivity39 = this.bSu.bJR;
                    if (frsActivity39.VC().getUserData() != null) {
                        ay ab = new ay("c10503").ab("fid", id2);
                        frsActivity40 = this.bSu.bJR;
                        TiebaStatic.log(ab.ab("uid", frsActivity40.VC().getUserData().getUserId()));
                        return;
                    }
                    return;
                }
            }
            frsActivity35 = this.bSu.bJR;
            frsActivity35.showToast(u.j.neterror);
        } else if (id == u.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.fr()) {
                frsActivity33 = this.bSu.bJR;
                frsActivity33.VF();
                return;
            }
            frsActivity32 = this.bSu.bJR;
            frsActivity32.showToast(u.j.neterror);
        } else if (id == u.g.post_search_ll) {
            frsActivity26 = this.bSu.bJR;
            if (frsActivity26.VC() != null) {
                frsActivity27 = this.bSu.bJR;
                if (frsActivity27.VC().aDN() != null) {
                    frsActivity28 = this.bSu.bJR;
                    String name = frsActivity28.VC().aDN().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.bSu.bJR;
                        frsActivity31 = this.bSu.bJR;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.bSu.bJR;
                    frsActivity29.showToast(u.j.neterror);
                }
            }
        } else if (id == u.g.frs_sidebar_good_tv) {
            frsActivity23 = this.bSu.bJR;
            frsActivity24 = this.bSu.bJR;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.bSu.bJR;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bCu, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == u.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.fr()) {
                frsActivity22 = this.bSu.bJR;
                frsActivity22.Vw();
                return;
            }
            frsActivity21 = this.bSu.bJR;
            frsActivity21.showToast(u.j.neterror);
        } else if (id == u.g.bar_share_tv) {
            frsActivity18 = this.bSu.bJR;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.bSu.bJR;
            com.baidu.tieba.tbadkCore.p VC = frsActivity19.VC();
            frsActivity20 = this.bSu.bJR;
            cp.a(pageContext, VC, frsActivity20.getForumId());
        } else if (id == u.g.forum_member) {
            frsActivity11 = this.bSu.bJR;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.bSu.bJR;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    frsActivity14 = this.bSu.bJR;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.bSu.bJR;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.bSu.bJR;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.bSu.bJR;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.bSu.bJR;
            frsActivity12.showToast(u.j.neterror);
        } else if (id == u.g.frs_group) {
            frsActivity = this.bSu.bJR;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.bSu.bJR;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.bSu.bJR;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.bSu.bJR;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.bSu.bJR;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.bSu.bJR;
                    if (frsActivity7.VC() != null) {
                        frsActivity9 = this.bSu.bJR;
                        if (frsActivity9.VC().bat() != null) {
                            frsActivity10 = this.bSu.bJR;
                            if (frsActivity10.VC().bat().bag() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    frsActivity8 = this.bSu.bJR;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.bSu.bJR;
            frsActivity2.showToast(u.j.neterror);
        }
    }
}
