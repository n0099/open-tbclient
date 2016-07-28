package com.baidu.tieba.frs.j;

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
    final /* synthetic */ p bUo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.bUo = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.aaX()) goto L11;
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
        frsActivity = this.bUo.bLx;
        com.baidu.tieba.tbadkCore.p VU = frsActivity.VU();
        if (VU != null && VU.aGX() != null) {
            cVar3 = this.bUo.bUe;
            if (cVar3 != null) {
                cVar4 = this.bUo.bUe;
                if (view != cVar4.aaP()) {
                    cVar5 = this.bUo.bUe;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bUo.getPageContext().getPageActivity(), VU.aGX().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == u.g.btn_love || id == u.g.love) {
            frsActivity2 = this.bUo.bLx;
            if (!frsActivity2.VV() && com.baidu.adp.lib.util.i.fq()) {
                frsActivity3 = this.bUo.bLx;
                if (!frsActivity3.checkUpIsLogin()) {
                    ay s = new ay("c10517").s("obj_locate", 1);
                    frsActivity4 = this.bUo.bLx;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.bUo.kS();
            }
        } else if (id == u.g.btn_sign || id == u.g.sign_done || id == u.g.sign) {
            frsActivity5 = this.bUo.bLx;
            if (!frsActivity5.VV() && com.baidu.adp.lib.util.i.fq()) {
                frsActivity6 = this.bUo.bLx;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.bUo.aaN()) {
                        this.bUo.aaQ();
                    } else if (TbadkCoreApplication.m10getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.bUo.bLx;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.bUo.bLx;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == u.g.frs_header_games) {
            frsActivity10 = this.bUo.bLx;
            if (frsActivity10.checkUpIsLogin() && VU != null && VU.bdL() != null) {
                String bdL = VU.bdL();
                int dg = com.baidu.tbadk.core.util.n.dg(bdL);
                if (dg == 2) {
                    bi.us().a((TbPageContext) this.bUo.getPageContext(), new String[]{bdL}, true);
                } else if (dg == 1) {
                    String qr = com.baidu.tieba.tbadkCore.util.n.qr(bdL);
                    if (TextUtils.isEmpty(qr) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bUo.getPageContext().getPageActivity(), this.bUo.getPageContext().getPageActivity().getString(u.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bUo.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", qr, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bUo.getPageContext().getPageActivity(), qr, "1000601")));
                } else if (dg == 3) {
                    frsActivity11 = this.bUo.bLx;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), bdL);
                }
            }
        } else if (id == u.g.btn_love_content) {
            frsActivity9 = this.bUo.bLx;
            if (!frsActivity9.VV()) {
                i = this.bUo.mScrollState;
                if (i == 0) {
                    str = this.bUo.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bUo.mPageType;
                        if (!str2.equals("frs_page")) {
                            return;
                        }
                    }
                    cVar = this.bUo.bUe;
                    if (cVar != null) {
                        cVar2 = this.bUo.bUe;
                        cVar2.d(view, false);
                    }
                }
            }
        } else if (id == u.g.frs_bawu_center && VU != null && VU.getUserData() != null && VU.getUserData().isBawu()) {
            String bdT = VU.bdT();
            if (!ba.isEmpty(bdT)) {
                com.baidu.tbadk.browser.f.u(this.bUo.getPageContext().getPageActivity(), bdT);
                if (VU.aGX() != null) {
                    TiebaStatic.log(new ay("c10502").ab("fid", VU.aGX().getId()).ab("uid", VU.getUserData().getUserId()));
                }
            }
        }
    }
}
