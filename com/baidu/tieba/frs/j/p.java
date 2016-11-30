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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.ckg = nVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.ahS()) goto L11;
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
        frsActivity = this.ckg.bZY;
        com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
        if (acr != null && acr.aOk() != null) {
            cVar3 = this.ckg.cjU;
            if (cVar3 != null) {
                cVar4 = this.ckg.cjU;
                if (view != cVar4.ahB()) {
                    cVar5 = this.ckg.cjU;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.ckg.getPageContext().getPageActivity(), acr.aOk().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == r.g.btn_love || id == r.g.love) {
            frsActivity2 = this.ckg.bZY;
            if (!frsActivity2.acs() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity3 = this.ckg.bZY;
                if (!frsActivity3.checkUpIsLogin()) {
                    av s = new av("c10517").s("obj_locate", 1);
                    frsActivity4 = this.ckg.bZY;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.ckg.ew(true);
            }
        } else if (id == r.g.btn_sign || id == r.g.sign_done || id == r.g.sign) {
            frsActivity5 = this.ckg.bZY;
            if (!frsActivity5.acs() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity6 = this.ckg.bZY;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.ckg.ahz()) {
                        this.ckg.ahC();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.ckg.bZY;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.ckg.bZY;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == r.g.frs_header_games) {
            frsActivity10 = this.ckg.bZY;
            if (frsActivity10.checkUpIsLogin() && acr != null && acr.bks() != null) {
                String bks = acr.bks();
                int dn = com.baidu.tbadk.core.util.n.dn(bks);
                if (dn == 2) {
                    bf.vP().a((TbPageContext) this.ckg.getPageContext(), new String[]{bks}, true);
                } else if (dn == 1) {
                    String rL = com.baidu.tieba.tbadkCore.util.m.rL(bks);
                    if (TextUtils.isEmpty(rL) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.ckg.getPageContext().getPageActivity(), this.ckg.getPageContext().getPageActivity().getString(r.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.ckg.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", rL, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.ckg.getPageContext().getPageActivity(), rL, "1000601")));
                } else if (dn == 3) {
                    frsActivity11 = this.ckg.bZY;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), bks);
                }
            }
        } else if (id == r.g.btn_love_content) {
            frsActivity9 = this.ckg.bZY;
            if (!frsActivity9.acs()) {
                i = this.ckg.mScrollState;
                if (i == 0) {
                    str = this.ckg.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.ckg.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.ckg.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.ckg.cjU;
                    if (cVar != null) {
                        cVar2 = this.ckg.cjU;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == r.g.frs_bawu_center && acr != null && acr.getUserData() != null && acr.getUserData().isBawu()) {
            String bkB = acr.bkB();
            if (!ax.isEmpty(bkB)) {
                com.baidu.tbadk.browser.f.u(this.ckg.getPageContext().getPageActivity(), bkB);
                if (acr.aOk() != null) {
                    TiebaStatic.log(new av("c10502").ab("fid", acr.aOk().getId()).ab("uid", acr.getUserData().getUserId()));
                }
            }
        }
    }
}
