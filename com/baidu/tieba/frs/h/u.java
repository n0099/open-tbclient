package com.baidu.tieba.frs.h;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ s bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar) {
        this.bPp = sVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.acp()) goto L11;
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
        frsActivity = this.bPp.bFI;
        com.baidu.tieba.tbadkCore.o WF = frsActivity.WF();
        if (WF != null && WF.aIk() != null) {
            cVar3 = this.bPp.bPd;
            if (cVar3 != null) {
                cVar4 = this.bPp.bPd;
                if (view != cVar4.abY()) {
                    cVar5 = this.bPp.bPd;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bPp.getPageContext().getPageActivity(), WF.aIk().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == r.g.btn_love || id == r.g.love) {
            frsActivity2 = this.bPp.bFI;
            if (!frsActivity2.WG() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity3 = this.bPp.bFI;
                if (!frsActivity3.checkUpIsLogin()) {
                    at s = new at("c10517").s("obj_locate", 1);
                    frsActivity4 = this.bPp.bFI;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.bPp.eg(true);
            }
        } else if (id == r.g.btn_sign || id == r.g.sign_done || id == r.g.sign) {
            frsActivity5 = this.bPp.bFI;
            if (!frsActivity5.WG() && com.baidu.adp.lib.util.i.gm()) {
                frsActivity6 = this.bPp.bFI;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.bPp.abW()) {
                        this.bPp.abZ();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.bPp.bFI;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.bPp.bFI;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == r.g.frs_header_games) {
            frsActivity10 = this.bPp.bFI;
            if (frsActivity10.checkUpIsLogin() && WF != null && WF.bei() != null) {
                String bei = WF.bei();
                int m11do = com.baidu.tbadk.core.util.n.m11do(bei);
                if (m11do == 2) {
                    bc.vz().a((TbPageContext) this.bPp.getPageContext(), new String[]{bei}, true);
                } else if (m11do == 1) {
                    String qr = com.baidu.tieba.tbadkCore.util.m.qr(bei);
                    if (TextUtils.isEmpty(qr) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bPp.getPageContext().getPageActivity(), this.bPp.getPageContext().getPageActivity().getString(r.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bPp.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", qr, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bPp.getPageContext().getPageActivity(), qr, "1000601")));
                } else if (m11do == 3) {
                    frsActivity11 = this.bPp.bFI;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), bei);
                }
            }
        } else if (id == r.g.btn_love_content) {
            frsActivity9 = this.bPp.bFI;
            if (!frsActivity9.WG()) {
                i = this.bPp.mScrollState;
                if (i == 0) {
                    str = this.bPp.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bPp.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.bPp.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.bPp.bPd;
                    if (cVar != null) {
                        cVar2 = this.bPp.bPd;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == r.g.frs_bawu_center && WF != null && WF.getUserData() != null && WF.getUserData().isBawu()) {
            String ber = WF.ber();
            if (!av.isEmpty(ber)) {
                com.baidu.tbadk.browser.f.u(this.bPp.getPageContext().getPageActivity(), ber);
                if (WF.aIk() != null) {
                    TiebaStatic.log(new at("c10502").ab("fid", WF.aIk().getId()).ab(SapiAccountManager.SESSION_UID, WF.getUserData().getUserId()));
                }
            }
        }
    }
}
