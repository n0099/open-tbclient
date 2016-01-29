package com.baidu.tieba.frs.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.t;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bpO = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v27, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        int i;
        String str;
        String str2;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        FrsActivity frsActivity12;
        FrsActivity frsActivity13;
        frsActivity = this.bpO.bot;
        com.baidu.tieba.tbadkCore.o Pk = frsActivity.Pk();
        if (Pk != null && Pk.aoE() != null) {
            if (this.bpO.RH() != null && (view == this.bpO.RH().RZ() || view == this.bpO.RH().So())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bpO.getPageContext().getPageActivity(), Pk.aoE().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bpO.RI() != null && (view == this.bpO.RI().RZ() || view == this.bpO.RI().So())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bpO.getPageContext().getPageActivity(), Pk.aoE().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView RH = this.bpO.RH();
        t RI = this.bpO.RI();
        if ((RH != null && RH.Y(view)) || (RI != null && RI.Y(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity12 = this.bpO.bot;
                frsActivity12.Pf();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity13 = this.bpO.bot;
                m411getInst.login(frsActivity13.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bpO.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == t.g.btn_love) {
            frsActivity9 = this.bpO.bot;
            if (!frsActivity9.Pl() && com.baidu.adp.lib.util.i.iZ()) {
                frsActivity10 = this.bpO.bot;
                if (!frsActivity10.checkUpIsLogin()) {
                    au r = new au("c10517").r("obj_locate", 1);
                    frsActivity11 = this.bpO.bot;
                    TiebaStatic.log(r.aa(ImageViewerConfig.FORUM_ID, frsActivity11.getForumId()));
                    return;
                }
                this.bpO.oN();
            }
        } else if (id == t.g.btn_sign || id == t.g.sign_done) {
            frsActivity2 = this.bpO.bot;
            if (!frsActivity2.Pl() && com.baidu.adp.lib.util.i.iZ()) {
                frsActivity3 = this.bpO.bot;
                if (frsActivity3.checkUpIsLogin()) {
                    if (!this.bpO.RX()) {
                        this.bpO.Sa();
                    } else if (TbadkCoreApplication.m411getInst().getUseNewResign() == 1) {
                        frsActivity4 = this.bpO.bot;
                        Activity pageActivity = frsActivity4.getPageContext().getPageActivity();
                        frsActivity5 = this.bpO.bot;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity5.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == t.g.frs_header_games) {
            frsActivity7 = this.bpO.bot;
            if (frsActivity7.checkUpIsLogin() && Pk != null && Pk.aKZ() != null) {
                String aKZ = Pk.aKZ();
                int di = com.baidu.tbadk.core.util.n.di(aKZ);
                if (di == 2) {
                    be.wt().a((TbPageContext) this.bpO.getPageContext(), new String[]{aKZ}, true);
                } else if (di == 1) {
                    String mQ = com.baidu.tieba.tbadkCore.util.n.mQ(aKZ);
                    if (TextUtils.isEmpty(mQ) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bpO.getPageContext().getPageActivity(), this.bpO.getPageContext().getPageActivity().getString(t.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bpO.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", mQ, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bpO.getPageContext().getPageActivity(), mQ, "1000601")));
                } else if (di == 3) {
                    frsActivity8 = this.bpO.bot;
                    com.baidu.tbadk.core.util.n.a(frsActivity8.getPageContext(), aKZ);
                }
            }
        } else if (id == t.g.btn_love_content) {
            frsActivity6 = this.bpO.bot;
            if (!frsActivity6.Pl()) {
                i = this.bpO.mScrollState;
                if (i == 0) {
                    str = this.bpO.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bpO.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bpO.W(view);
                            return;
                        }
                        return;
                    }
                    this.bpO.V(view);
                }
            }
        } else if (id == t.g.frs_bawu_center && Pk != null && Pk.getUserData() != null && Pk.getUserData().isBawu()) {
            String aLh = Pk.aLh();
            if (!aw.isEmpty(aLh)) {
                com.baidu.tbadk.browser.f.B(this.bpO.getPageContext().getPageActivity(), aLh);
                if (Pk.aoE() != null) {
                    TiebaStatic.log(new au("c10502").aa(ImageViewerConfig.FORUM_ID, Pk.aoE().getId()).aa("uid", Pk.getUserData().getUserId()));
                }
            }
        }
    }
}
