package com.baidu.tieba.frs.f;

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
    final /* synthetic */ u cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.cdh = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r1.aey()) goto L11;
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
        frsActivity = this.cdh.bTf;
        com.baidu.tieba.tbadkCore.n YV = frsActivity.YV();
        if (YV != null && YV.aJp() != null) {
            cVar3 = this.cdh.ccW;
            if (cVar3 != null) {
                cVar4 = this.cdh.ccW;
                if (view != cVar4.aef()) {
                    cVar5 = this.cdh.ccW;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cdh.getPageContext().getPageActivity(), YV.aJp().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == w.h.btn_love || id == w.h.love) {
            frsActivity2 = this.cdh.bTf;
            if (!frsActivity2.YW() && com.baidu.adp.lib.util.i.he()) {
                frsActivity3 = this.cdh.bTf;
                if (!frsActivity3.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 1);
                    frsActivity4 = this.cdh.bTf;
                    TiebaStatic.log(s.Z("fid", frsActivity4.getForumId()));
                    return;
                }
                this.cdh.el(true);
            }
        } else if (id == w.h.btn_sign || id == w.h.sign_done || id == w.h.sign) {
            frsActivity5 = this.cdh.bTf;
            if (!frsActivity5.YW() && com.baidu.adp.lib.util.i.he()) {
                frsActivity6 = this.cdh.bTf;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.cdh.aed()) {
                        this.cdh.aeg();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.cdh.bTf;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.cdh.bTf;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == w.h.frs_header_games) {
            frsActivity10 = this.cdh.bTf;
            if (frsActivity10.checkUpIsLogin() && YV != null && YV.bfJ() != null) {
                String bfJ = YV.bfJ();
                if (com.baidu.tbadk.core.util.m.df(bfJ) == 3) {
                    frsActivity11 = this.cdh.bTf;
                    com.baidu.tbadk.core.util.m.a(frsActivity11.getPageContext(), bfJ);
                    return;
                }
                bb.vQ().a((TbPageContext) this.cdh.getPageContext(), new String[]{bfJ}, true);
            }
        } else if (id == w.h.btn_love_content) {
            frsActivity9 = this.cdh.bTf;
            if (!frsActivity9.YW()) {
                i = this.cdh.mScrollState;
                if (i == 0) {
                    str = this.cdh.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cdh.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cdh.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.cdh.ccW;
                    if (cVar != null) {
                        cVar2 = this.cdh.ccW;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == w.h.frs_bawu_center && YV != null && YV.getUserData() != null && YV.getUserData().isBawu()) {
            String bfS = YV.bfS();
            if (!com.baidu.tbadk.core.util.au.isEmpty(bfS)) {
                com.baidu.tbadk.browser.f.O(this.cdh.getPageContext().getPageActivity(), bfS);
                if (YV.aJp() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10502").Z("fid", YV.aJp().getId()).Z(SapiAccountManager.SESSION_UID, YV.getUserData().getUserId()));
                }
            }
        }
    }
}
