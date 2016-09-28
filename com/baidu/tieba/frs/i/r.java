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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cft = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.afW()) goto L11;
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
        String str3;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        com.baidu.tieba.frs.view.c cVar3;
        com.baidu.tieba.frs.view.c cVar4;
        com.baidu.tieba.frs.view.c cVar5;
        frsActivity = this.cft.bWH;
        com.baidu.tieba.tbadkCore.p abe = frsActivity.abe();
        if (abe != null && abe.aMr() != null) {
            cVar3 = this.cft.cfj;
            if (cVar3 != null) {
                cVar4 = this.cft.cfj;
                if (view != cVar4.afO()) {
                    cVar5 = this.cft.cfj;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cft.getPageContext().getPageActivity(), abe.aMr().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == r.g.btn_love || id == r.g.love) {
            frsActivity2 = this.cft.bWH;
            if (!frsActivity2.abf() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity3 = this.cft.bWH;
                if (!frsActivity3.checkUpIsLogin()) {
                    ax s = new ax("c10517").s("obj_locate", 1);
                    frsActivity4 = this.cft.bWH;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.cft.lN();
            }
        } else if (id == r.g.btn_sign || id == r.g.sign_done || id == r.g.sign) {
            frsActivity5 = this.cft.bWH;
            if (!frsActivity5.abf() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity6 = this.cft.bWH;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.cft.afM()) {
                        this.cft.afP();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.cft.bWH;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.cft.bWH;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == r.g.frs_header_games) {
            frsActivity10 = this.cft.bWH;
            if (frsActivity10.checkUpIsLogin() && abe != null && abe.bhX() != null) {
                String bhX = abe.bhX();
                int dl = com.baidu.tbadk.core.util.n.dl(bhX);
                if (dl == 2) {
                    bh.vL().a((TbPageContext) this.cft.getPageContext(), new String[]{bhX}, true);
                } else if (dl == 1) {
                    String rq = com.baidu.tieba.tbadkCore.util.n.rq(bhX);
                    if (TextUtils.isEmpty(rq) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.cft.getPageContext().getPageActivity(), this.cft.getPageContext().getPageActivity().getString(r.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.cft.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", rq, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.cft.getPageContext().getPageActivity(), rq, "1000601")));
                } else if (dl == 3) {
                    frsActivity11 = this.cft.bWH;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), bhX);
                }
            }
        } else if (id == r.g.btn_love_content) {
            frsActivity9 = this.cft.bWH;
            if (!frsActivity9.abf()) {
                i = this.cft.mScrollState;
                if (i == 0) {
                    str = this.cft.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cft.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cft.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.cft.cfj;
                    if (cVar != null) {
                        cVar2 = this.cft.cfj;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == r.g.frs_bawu_center && abe != null && abe.getUserData() != null && abe.getUserData().isBawu()) {
            String big = abe.big();
            if (!az.isEmpty(big)) {
                com.baidu.tbadk.browser.f.u(this.cft.getPageContext().getPageActivity(), big);
                if (abe.aMr() != null) {
                    TiebaStatic.log(new ax("c10502").ab("fid", abe.aMr().getId()).ab("uid", abe.getUserData().getUserId()));
                }
            }
        }
    }
}
