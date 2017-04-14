package com.baidu.tieba.frs.g;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u cbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.cbI = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r1.aet()) goto L11;
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
        frsActivity = this.cbI.bST;
        com.baidu.tieba.tbadkCore.n Zr = frsActivity.Zr();
        if (Zr != null && Zr.aJw() != null) {
            cVar3 = this.cbI.cbx;
            if (cVar3 != null) {
                cVar4 = this.cbI.cbx;
                if (view != cVar4.aea()) {
                    cVar5 = this.cbI.cbx;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cbI.getPageContext().getPageActivity(), Zr.aJw().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == w.h.btn_love || id == w.h.love) {
            frsActivity2 = this.cbI.bST;
            if (!frsActivity2.Zs() && com.baidu.adp.lib.util.i.hj()) {
                frsActivity3 = this.cbI.bST;
                if (!frsActivity3.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 1);
                    frsActivity4 = this.cbI.bST;
                    TiebaStatic.log(s.aa("fid", frsActivity4.getForumId()));
                    return;
                }
                this.cbI.el(true);
            }
        } else if (id == w.h.btn_sign || id == w.h.sign_done || id == w.h.sign) {
            frsActivity5 = this.cbI.bST;
            if (!frsActivity5.Zs() && com.baidu.adp.lib.util.i.hj()) {
                frsActivity6 = this.cbI.bST;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.cbI.adY()) {
                        this.cbI.aeb();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.cbI.bST;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.cbI.bST;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == w.h.frs_header_games) {
            frsActivity10 = this.cbI.bST;
            if (frsActivity10.checkUpIsLogin() && Zr != null && Zr.bgx() != null) {
                String bgx = Zr.bgx();
                if (com.baidu.tbadk.core.util.m.dm(bgx) == 3) {
                    frsActivity11 = this.cbI.bST;
                    com.baidu.tbadk.core.util.m.a(frsActivity11.getPageContext(), bgx);
                    return;
                }
                bb.wn().a((TbPageContext) this.cbI.getPageContext(), new String[]{bgx}, true);
            }
        } else if (id == w.h.btn_love_content) {
            frsActivity9 = this.cbI.bST;
            if (!frsActivity9.Zs()) {
                i = this.cbI.mScrollState;
                if (i == 0) {
                    str = this.cbI.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cbI.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cbI.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.cbI.cbx;
                    if (cVar != null) {
                        cVar2 = this.cbI.cbx;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == w.h.frs_bawu_center && Zr != null && Zr.getUserData() != null && Zr.getUserData().isBawu()) {
            String bgF = Zr.bgF();
            if (!com.baidu.tbadk.core.util.au.isEmpty(bgF)) {
                com.baidu.tbadk.browser.f.S(this.cbI.getPageContext().getPageActivity(), bgF);
                if (Zr.aJw() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10502").aa("fid", Zr.aJw().getId()).aa(SapiAccountManager.SESSION_UID, Zr.getUserData().getUserId()));
                }
            }
        }
    }
}
