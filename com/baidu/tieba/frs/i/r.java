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
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ p cfw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.cfw = pVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.afI()) goto L11;
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
        frsActivity = this.cfw.bWH;
        com.baidu.tieba.tbadkCore.p aaR = frsActivity.aaR();
        if (aaR != null && aaR.aLP() != null) {
            cVar3 = this.cfw.cfm;
            if (cVar3 != null) {
                cVar4 = this.cfw.cfm;
                if (view != cVar4.afA()) {
                    cVar5 = this.cfw.cfm;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cfw.getPageContext().getPageActivity(), aaR.aLP().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == t.g.btn_love || id == t.g.love) {
            frsActivity2 = this.cfw.bWH;
            if (!frsActivity2.aaS() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity3 = this.cfw.bWH;
                if (!frsActivity3.checkUpIsLogin()) {
                    ay s = new ay("c10517").s("obj_locate", 1);
                    frsActivity4 = this.cfw.bWH;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.cfw.lN();
            }
        } else if (id == t.g.btn_sign || id == t.g.sign_done || id == t.g.sign) {
            frsActivity5 = this.cfw.bWH;
            if (!frsActivity5.aaS() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity6 = this.cfw.bWH;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.cfw.afy()) {
                        this.cfw.afB();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.cfw.bWH;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.cfw.bWH;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == t.g.frs_header_games) {
            frsActivity10 = this.cfw.bWH;
            if (frsActivity10.checkUpIsLogin() && aaR != null && aaR.bhp() != null) {
                String bhp = aaR.bhp();
                int dj = com.baidu.tbadk.core.util.n.dj(bhp);
                if (dj == 2) {
                    bi.vx().a((TbPageContext) this.cfw.getPageContext(), new String[]{bhp}, true);
                } else if (dj == 1) {
                    String rb = com.baidu.tieba.tbadkCore.util.n.rb(bhp);
                    if (TextUtils.isEmpty(rb) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.cfw.getPageContext().getPageActivity(), this.cfw.getPageContext().getPageActivity().getString(t.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.cfw.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", rb, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.cfw.getPageContext().getPageActivity(), rb, "1000601")));
                } else if (dj == 3) {
                    frsActivity11 = this.cfw.bWH;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), bhp);
                }
            }
        } else if (id == t.g.btn_love_content) {
            frsActivity9 = this.cfw.bWH;
            if (!frsActivity9.aaS()) {
                i = this.cfw.mScrollState;
                if (i == 0) {
                    str = this.cfw.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cfw.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cfw.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.cfw.cfm;
                    if (cVar != null) {
                        cVar2 = this.cfw.cfm;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == t.g.frs_bawu_center && aaR != null && aaR.getUserData() != null && aaR.getUserData().isBawu()) {
            String bhx = aaR.bhx();
            if (!ba.isEmpty(bhx)) {
                com.baidu.tbadk.browser.f.u(this.cfw.getPageContext().getPageActivity(), bhx);
                if (aaR.aLP() != null) {
                    TiebaStatic.log(new ay("c10502").ab("fid", aaR.aLP().getId()).ab("uid", aaR.getUserData().getUserId()));
                }
            }
        }
    }
}
