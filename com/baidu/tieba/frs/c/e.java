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
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.u;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.buP = aVar;
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
        frsActivity = this.buP.bts;
        com.baidu.tieba.tbadkCore.o QZ = frsActivity.QZ();
        if (QZ != null && QZ.avu() != null) {
            if (this.buP.Tv() != null && (view == this.buP.Tv().TN() || view == this.buP.Tv().Ud())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.buP.getPageContext().getPageActivity(), QZ.avu().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.buP.Tw() != null && (view == this.buP.Tw().TN() || view == this.buP.Tw().Ud())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.buP.getPageContext().getPageActivity(), QZ.avu().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Tv = this.buP.Tv();
        u Tw = this.buP.Tw();
        if ((Tv != null && Tv.ac(view)) || (Tw != null && Tw.ac(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity12 = this.buP.bts;
                frsActivity12.QU();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity13 = this.buP.bts;
                m411getInst.login(frsActivity13.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.buP.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == t.g.btn_love) {
            frsActivity9 = this.buP.bts;
            if (!frsActivity9.Ra() && com.baidu.adp.lib.util.i.jf()) {
                frsActivity10 = this.buP.bts;
                if (!frsActivity10.checkUpIsLogin()) {
                    aw r = new aw("c10517").r("obj_locate", 1);
                    frsActivity11 = this.buP.bts;
                    TiebaStatic.log(r.ac("fid", frsActivity11.getForumId()));
                    return;
                }
                this.buP.oG();
            }
        } else if (id == t.g.btn_sign || id == t.g.sign_done) {
            frsActivity2 = this.buP.bts;
            if (!frsActivity2.Ra() && com.baidu.adp.lib.util.i.jf()) {
                frsActivity3 = this.buP.bts;
                if (frsActivity3.checkUpIsLogin()) {
                    if (!this.buP.TL()) {
                        this.buP.TO();
                    } else if (TbadkCoreApplication.m411getInst().getUseNewResign() == 1) {
                        frsActivity4 = this.buP.bts;
                        Activity pageActivity = frsActivity4.getPageContext().getPageActivity();
                        frsActivity5 = this.buP.bts;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity5.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == t.g.frs_header_games) {
            frsActivity7 = this.buP.bts;
            if (frsActivity7.checkUpIsLogin() && QZ != null && QZ.aRO() != null) {
                String aRO = QZ.aRO();
                int dl = com.baidu.tbadk.core.util.n.dl(aRO);
                if (dl == 2) {
                    bg.wM().a((TbPageContext) this.buP.getPageContext(), new String[]{aRO}, true);
                } else if (dl == 1) {
                    String oc = com.baidu.tieba.tbadkCore.util.n.oc(aRO);
                    if (TextUtils.isEmpty(oc) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.buP.getPageContext().getPageActivity(), this.buP.getPageContext().getPageActivity().getString(t.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.buP.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", oc, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.buP.getPageContext().getPageActivity(), oc, "1000601")));
                } else if (dl == 3) {
                    frsActivity8 = this.buP.bts;
                    com.baidu.tbadk.core.util.n.a(frsActivity8.getPageContext(), aRO);
                }
            }
        } else if (id == t.g.btn_love_content) {
            frsActivity6 = this.buP.bts;
            if (!frsActivity6.Ra()) {
                i = this.buP.mScrollState;
                if (i == 0) {
                    str = this.buP.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.buP.mPageType;
                        if (str2.equals("frs_page")) {
                            this.buP.aa(view);
                            return;
                        }
                        return;
                    }
                    this.buP.Z(view);
                }
            }
        } else if (id == t.g.frs_bawu_center && QZ != null && QZ.getUserData() != null && QZ.getUserData().isBawu()) {
            String aRW = QZ.aRW();
            if (!ay.isEmpty(aRW)) {
                com.baidu.tbadk.browser.f.s(this.buP.getPageContext().getPageActivity(), aRW);
                if (QZ.avu() != null) {
                    TiebaStatic.log(new aw("c10502").ac("fid", QZ.avu().getId()).ac("uid", QZ.getUserData().getUserId()));
                }
            }
        }
    }
}
