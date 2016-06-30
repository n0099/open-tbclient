package com.baidu.tieba.frs.i;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p bSo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.bSo = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.aav()) goto L11;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        int i;
        String str;
        com.baidu.tieba.frs.view.c cVar;
        com.baidu.tieba.frs.view.c cVar2;
        String str2;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        com.baidu.tieba.frs.view.c cVar3;
        com.baidu.tieba.frs.view.c cVar4;
        com.baidu.tieba.frs.view.c cVar5;
        frsActivity = this.bSo.bJR;
        com.baidu.tieba.tbadkCore.p VC = frsActivity.VC();
        if (VC != null && VC.aDN() != null) {
            cVar3 = this.bSo.bSe;
            if (cVar3 != null) {
                cVar4 = this.bSo.bSe;
                if (view != cVar4.aan()) {
                    cVar5 = this.bSo.bSe;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bSo.getPageContext().getPageActivity(), VC.aDN().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == u.g.btn_love || id == u.g.love) {
            frsActivity2 = this.bSo.bJR;
            if (!frsActivity2.VD() && com.baidu.adp.lib.util.i.fr()) {
                frsActivity3 = this.bSo.bJR;
                if (!frsActivity3.checkUpIsLogin()) {
                    ay s = new ay("c10517").s("obj_locate", 1);
                    frsActivity4 = this.bSo.bJR;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.bSo.kW();
            }
        } else if (id == u.g.btn_sign || id == u.g.sign_done || id == u.g.sign) {
            frsActivity5 = this.bSo.bJR;
            if (!frsActivity5.VD() && com.baidu.adp.lib.util.i.fr()) {
                frsActivity6 = this.bSo.bJR;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.bSo.aal()) {
                        this.bSo.aao();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.bSo.bJR;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.bSo.bJR;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == u.g.frs_header_games) {
            frsActivity10 = this.bSo.bJR;
            if (frsActivity10.checkUpIsLogin() && VC != null && VC.bax() != null) {
                String bax = VC.bax();
                int dh = com.baidu.tbadk.core.util.n.dh(bax);
                if (dh == 2) {
                    bi.us().a((TbPageContext) this.bSo.getPageContext(), new String[]{bax}, true);
                } else if (dh == 1) {
                    String pH = com.baidu.tieba.tbadkCore.util.n.pH(bax);
                    if (TextUtils.isEmpty(pH) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bSo.getPageContext().getPageActivity(), this.bSo.getPageContext().getPageActivity().getString(u.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bSo.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", pH, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bSo.getPageContext().getPageActivity(), pH, "1000601")));
                } else if (dh == 3) {
                    frsActivity11 = this.bSo.bJR;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), bax);
                }
            }
        } else if (id == u.g.btn_love_content) {
            frsActivity9 = this.bSo.bJR;
            if (!frsActivity9.VD()) {
                i = this.bSo.mScrollState;
                if (i == 0) {
                    str = this.bSo.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bSo.mPageType;
                        if (!str2.equals("frs_page")) {
                            return;
                        }
                    }
                    cVar = this.bSo.bSe;
                    if (cVar != null) {
                        cVar2 = this.bSo.bSe;
                        cVar2.f(view, false);
                    }
                }
            }
        } else if (id == u.g.frs_bawu_center && VC != null && VC.getUserData() != null && VC.getUserData().isBawu()) {
            String baF = VC.baF();
            if (!ba.isEmpty(baF)) {
                com.baidu.tbadk.browser.f.u(this.bSo.getPageContext().getPageActivity(), baF);
                if (VC.aDN() != null) {
                    TiebaStatic.log(new ay("c10502").ab("fid", VC.aDN().getId()).ab("uid", VC.getUserData().getUserId()));
                }
            }
        }
    }
}
