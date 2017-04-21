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
    final /* synthetic */ u cdZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.cdZ = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r1.afu()) goto L11;
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
        frsActivity = this.cdZ.bVk;
        com.baidu.tieba.tbadkCore.n aas = frsActivity.aas();
        if (aas != null && aas.aKx() != null) {
            cVar3 = this.cdZ.cdO;
            if (cVar3 != null) {
                cVar4 = this.cdZ.cdO;
                if (view != cVar4.afb()) {
                    cVar5 = this.cdZ.cdO;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cdZ.getPageContext().getPageActivity(), aas.aKx().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == w.h.btn_love || id == w.h.love) {
            frsActivity2 = this.cdZ.bVk;
            if (!frsActivity2.aat() && com.baidu.adp.lib.util.i.hk()) {
                frsActivity3 = this.cdZ.bVk;
                if (!frsActivity3.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.as s = new com.baidu.tbadk.core.util.as("c10517").s("obj_locate", 1);
                    frsActivity4 = this.cdZ.bVk;
                    TiebaStatic.log(s.aa("fid", frsActivity4.getForumId()));
                    return;
                }
                this.cdZ.ev(true);
            }
        } else if (id == w.h.btn_sign || id == w.h.sign_done || id == w.h.sign) {
            frsActivity5 = this.cdZ.bVk;
            if (!frsActivity5.aat() && com.baidu.adp.lib.util.i.hk()) {
                frsActivity6 = this.cdZ.bVk;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.cdZ.aeZ()) {
                        this.cdZ.afc();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.cdZ.bVk;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.cdZ.bVk;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == w.h.frs_header_games) {
            frsActivity10 = this.cdZ.bVk;
            if (frsActivity10.checkUpIsLogin() && aas != null && aas.bhz() != null) {
                String bhz = aas.bhz();
                if (com.baidu.tbadk.core.util.m.dm(bhz) == 3) {
                    frsActivity11 = this.cdZ.bVk;
                    com.baidu.tbadk.core.util.m.a(frsActivity11.getPageContext(), bhz);
                    return;
                }
                bb.wn().a((TbPageContext) this.cdZ.getPageContext(), new String[]{bhz}, true);
            }
        } else if (id == w.h.btn_love_content) {
            frsActivity9 = this.cdZ.bVk;
            if (!frsActivity9.aat()) {
                i = this.cdZ.mScrollState;
                if (i == 0) {
                    str = this.cdZ.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cdZ.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cdZ.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.cdZ.cdO;
                    if (cVar != null) {
                        cVar2 = this.cdZ.cdO;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == w.h.frs_bawu_center && aas != null && aas.getUserData() != null && aas.getUserData().isBawu()) {
            String bhH = aas.bhH();
            if (!com.baidu.tbadk.core.util.au.isEmpty(bhH)) {
                com.baidu.tbadk.browser.f.S(this.cdZ.getPageContext().getPageActivity(), bhH);
                if (aas.aKx() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10502").aa("fid", aas.aKx().getId()).aa(SapiAccountManager.SESSION_UID, aas.getUserData().getUserId()));
                }
            }
        }
    }
}
