package com.baidu.tieba.frs.b;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bji = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v22, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        int i;
        String str;
        String str2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        frsActivity = this.bji.bhN;
        com.baidu.tieba.tbadkCore.p MT = frsActivity.MT();
        if (MT != null && MT.ajy() != null) {
            if (this.bji.Pl() != null && (view == this.bji.Pl().PD() || view == this.bji.Pl().PS())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bji.getPageContext().getPageActivity(), MT.ajy().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bji.Pm() != null && (view == this.bji.Pm().PD() || view == this.bji.Pm().PS())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bji.getPageContext().getPageActivity(), MT.ajy().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Pl = this.bji.Pl();
        com.baidu.tieba.frs.view.q Pm = this.bji.Pm();
        if ((Pl != null && Pl.J(view)) || (Pm != null && Pm.J(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity10 = this.bji.bhN;
                frsActivity10.MO();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity11 = this.bji.bhN;
                m411getInst.login(frsActivity11.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bji.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == n.f.btn_love) {
            frsActivity7 = this.bji.bhN;
            if (!frsActivity7.MU() && com.baidu.adp.lib.util.i.iP()) {
                frsActivity8 = this.bji.bhN;
                if (!frsActivity8.checkUpIsLogin()) {
                    av r = new av("c10517").r("obj_locate", 1);
                    frsActivity9 = this.bji.bhN;
                    TiebaStatic.log(r.ab(ImageViewerConfig.FORUM_ID, frsActivity9.getForumId()));
                    return;
                }
                this.bji.oU();
            }
        } else if (id == n.f.btn_sign) {
            frsActivity5 = this.bji.bhN;
            if (!frsActivity5.MU() && com.baidu.adp.lib.util.i.iP()) {
                frsActivity6 = this.bji.bhN;
                if (frsActivity6.checkUpIsLogin() && !this.bji.PB()) {
                    this.bji.PE();
                }
            }
        } else if (id == n.f.frs_header_games) {
            frsActivity3 = this.bji.bhN;
            if (frsActivity3.checkUpIsLogin() && MT != null && MT.aBN() != null) {
                String aBN = MT.aBN();
                int di = com.baidu.tbadk.core.util.o.di(aBN);
                if (di == 2) {
                    bf.vD().a((TbPageContext) this.bji.getPageContext(), new String[]{aBN}, true);
                } else if (di == 1) {
                    String mC = com.baidu.tieba.tbadkCore.util.n.mC(aBN);
                    if (TextUtils.isEmpty(mC) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bji.getPageContext().getPageActivity(), this.bji.getPageContext().getPageActivity().getString(n.i.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bji.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", mC, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bji.getPageContext().getPageActivity(), mC, "1000601")));
                } else if (di == 3) {
                    frsActivity4 = this.bji.bhN;
                    com.baidu.tbadk.core.util.o.a(frsActivity4.getPageContext(), aBN);
                }
            }
        } else if (id == n.f.btn_love_content) {
            frsActivity2 = this.bji.bhN;
            if (!frsActivity2.MU()) {
                i = this.bji.mScrollState;
                if (i == 0) {
                    str = this.bji.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bji.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bji.H(view);
                            return;
                        }
                        return;
                    }
                    this.bji.G(view);
                }
            }
        } else if (id == n.f.frs_bawu_center && MT != null && MT.getUserData() != null && MT.getUserData().isBawu()) {
            String aBV = MT.aBV();
            if (!ax.isEmpty(aBV)) {
                com.baidu.tbadk.browser.f.B(this.bji.getPageContext().getPageActivity(), aBV);
                if (MT.ajy() != null) {
                    TiebaStatic.log(new av("c10502").ab(ImageViewerConfig.FORUM_ID, MT.ajy().getId()).ab("uid", MT.getUserData().getUserId()));
                }
            }
        }
    }
}
