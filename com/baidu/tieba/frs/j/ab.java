package com.baidu.tieba.frs.j;

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
    final /* synthetic */ aa bUu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.bUu = aaVar;
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
            frsActivity44 = this.bUu.bLx;
            frsActivity44.VW();
            TiebaStatic.log("c10528");
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                frsActivity45 = this.bUu.bLx;
                ChatMessageActivityConfig chatMessageActivityConfig = new ChatMessageActivityConfig(frsActivity45.getPageContext().getPageActivity());
                frsActivity46 = this.bUu.bLx;
                frsActivity46.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, chatMessageActivityConfig));
            }
        } else if (id == u.g.history_tv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PbHistoryActivityConfig(this.bUu.getPageContext().getPageActivity())));
        } else if (id == u.g.bar_info_tv) {
            frsActivity41 = this.bUu.bLx;
            if (frsActivity41.VU() != null) {
                frsActivity42 = this.bUu.bLx;
                if (frsActivity42.VU().aGX() != null) {
                    MessageManager messageManager = MessageManager.getInstance();
                    Activity pageActivity = this.bUu.getPageContext().getPageActivity();
                    frsActivity43 = this.bUu.bLx;
                    messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(pageActivity, frsActivity43.VU().aGX().getId(), ForumDetailActivityConfig.FromType.FRS_SIDE)));
                }
            }
        } else if (id == u.g.forum_manager_center) {
            frsActivity34 = this.bUu.bLx;
            if (frsActivity34.VU() != null) {
                frsActivity36 = this.bUu.bLx;
                if (frsActivity36.VU().aGX() != null) {
                    frsActivity37 = this.bUu.bLx;
                    String id2 = frsActivity37.VU().aGX().getId();
                    frsActivity38 = this.bUu.bLx;
                    com.baidu.tbadk.browser.f.u(this.bUu.getPageContext().getPageActivity(), "http://tieba.baidu.com/mo/q/bawuindex?fn=" + frsActivity38.VU().aGX().getName() + "&fid=" + id2);
                    frsActivity39 = this.bUu.bLx;
                    if (frsActivity39.VU().getUserData() != null) {
                        ay ab = new ay("c10503").ab("fid", id2);
                        frsActivity40 = this.bUu.bLx;
                        TiebaStatic.log(ab.ab("uid", frsActivity40.VU().getUserData().getUserId()));
                        return;
                    }
                    return;
                }
            }
            frsActivity35 = this.bUu.bLx;
            frsActivity35.showToast(u.j.neterror);
        } else if (id == u.g.unfollow_layout) {
            if (com.baidu.adp.lib.util.i.fq()) {
                frsActivity33 = this.bUu.bLx;
                frsActivity33.VX();
                return;
            }
            frsActivity32 = this.bUu.bLx;
            frsActivity32.showToast(u.j.neterror);
        } else if (id == u.g.post_search_ll) {
            frsActivity26 = this.bUu.bLx;
            if (frsActivity26.VU() != null) {
                frsActivity27 = this.bUu.bLx;
                if (frsActivity27.VU().aGX() != null) {
                    frsActivity28 = this.bUu.bLx;
                    String name = frsActivity28.VU().aGX().getName();
                    if (!StringUtils.isNull(name)) {
                        frsActivity30 = this.bUu.bLx;
                        frsActivity31 = this.bUu.bLx;
                        frsActivity30.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PostSearchActivityConfig(frsActivity31.getPageContext().getPageActivity(), name)));
                        return;
                    }
                    frsActivity29 = this.bUu.bLx;
                    frsActivity29.showToast(u.j.neterror);
                }
            }
        } else if (id == u.g.frs_sidebar_good_tv) {
            frsActivity23 = this.bUu.bLx;
            frsActivity24 = this.bUu.bLx;
            FrsGoodActivityConfig frsGoodActivityConfig = new FrsGoodActivityConfig(frsActivity24.getPageContext().getPageActivity());
            frsActivity25 = this.bUu.bLx;
            frsActivity23.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, frsGoodActivityConfig.createNormalCfg(frsActivity25.bDB, FrsActivityConfig.FRS_FROM_LIKE)));
        } else if (id == u.g.frs_sidebar_add_to_desktop) {
            if (com.baidu.adp.lib.util.i.fq()) {
                frsActivity22 = this.bUu.bLx;
                frsActivity22.VN();
                return;
            }
            frsActivity21 = this.bUu.bLx;
            frsActivity21.showToast(u.j.neterror);
        } else if (id == u.g.bar_share_tv) {
            frsActivity18 = this.bUu.bLx;
            TbPageContext pageContext = frsActivity18.getPageContext();
            frsActivity19 = this.bUu.bLx;
            com.baidu.tieba.tbadkCore.p VU = frsActivity19.VU();
            frsActivity20 = this.bUu.bLx;
            cp.a(pageContext, VU, frsActivity20.getForumId());
        } else if (id == u.g.forum_member) {
            frsActivity11 = this.bUu.bLx;
            if (!StringUtils.isNull(frsActivity11.getForumId())) {
                frsActivity13 = this.bUu.bLx;
                if (!StringUtils.isNull(frsActivity13.getForumName())) {
                    frsActivity14 = this.bUu.bLx;
                    Activity pageActivity2 = frsActivity14.getPageContext().getPageActivity();
                    frsActivity15 = this.bUu.bLx;
                    String forumId = frsActivity15.getForumId();
                    frsActivity16 = this.bUu.bLx;
                    ForumMemberActivityConfig forumMemberActivityConfig = new ForumMemberActivityConfig(pageActivity2, forumId, frsActivity16.getForumName());
                    frsActivity17 = this.bUu.bLx;
                    frsActivity17.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, forumMemberActivityConfig));
                    return;
                }
            }
            frsActivity12 = this.bUu.bLx;
            frsActivity12.showToast(u.j.neterror);
        } else if (id == u.g.frs_group) {
            frsActivity = this.bUu.bLx;
            if (frsActivity.getForumId() != null) {
                frsActivity3 = this.bUu.bLx;
                if (frsActivity3.getForumName() != null) {
                    frsActivity4 = this.bUu.bLx;
                    Activity pageActivity3 = frsActivity4.getPageContext().getPageActivity();
                    frsActivity5 = this.bUu.bLx;
                    String forumId2 = frsActivity5.getForumId();
                    frsActivity6 = this.bUu.bLx;
                    FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(pageActivity3, forumId2, frsActivity6.getForumName());
                    frsActivity7 = this.bUu.bLx;
                    if (frsActivity7.VU() != null) {
                        frsActivity9 = this.bUu.bLx;
                        if (frsActivity9.VU().bdH() != null) {
                            frsActivity10 = this.bUu.bLx;
                            if (frsActivity10.VU().bdH().bdu() != 1) {
                                frsGroupActivityConfig.showRecommend();
                            }
                        }
                    }
                    frsActivity8 = this.bUu.bLx;
                    frsActivity8.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, frsGroupActivityConfig));
                    return;
                }
            }
            frsActivity2 = this.bUu.bLx;
            frsActivity2.showToast(u.j.neterror);
        }
    }
}
