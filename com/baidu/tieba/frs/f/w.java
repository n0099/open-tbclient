package com.baidu.tieba.frs.f;

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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bVP = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r12 == r1.ady()) goto L11;
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
        frsActivity = this.bVP.bLZ;
        com.baidu.tieba.tbadkCore.n XW = frsActivity.XW();
        if (XW != null && XW.aJY() != null) {
            cVar3 = this.bVP.bVE;
            if (cVar3 != null) {
                cVar4 = this.bVP.bVE;
                if (view != cVar4.adf()) {
                    cVar5 = this.bVP.bVE;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bVP.getPageContext().getPageActivity(), XW.aJY().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == r.h.btn_love || id == r.h.love) {
            frsActivity2 = this.bVP.bLZ;
            if (!frsActivity2.XX() && com.baidu.adp.lib.util.i.gk()) {
                frsActivity3 = this.bVP.bLZ;
                if (!frsActivity3.checkUpIsLogin()) {
                    com.baidu.tbadk.core.util.ar s = new com.baidu.tbadk.core.util.ar("c10517").s("obj_locate", 1);
                    frsActivity4 = this.bVP.bLZ;
                    TiebaStatic.log(s.ab("fid", frsActivity4.getForumId()));
                    return;
                }
                this.bVP.el(true);
            }
        } else if (id == r.h.btn_sign || id == r.h.sign_done || id == r.h.sign) {
            frsActivity5 = this.bVP.bLZ;
            if (!frsActivity5.XX() && com.baidu.adp.lib.util.i.gk()) {
                frsActivity6 = this.bVP.bLZ;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.bVP.add()) {
                        this.bVP.adg();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.bVP.bLZ;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.bVP.bLZ;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == r.h.frs_header_games) {
            frsActivity10 = this.bVP.bLZ;
            if (frsActivity10.checkUpIsLogin() && XW != null && XW.bfW() != null) {
                String bfW = XW.bfW();
                int dm = com.baidu.tbadk.core.util.m.dm(bfW);
                if (dm == 2) {
                    ba.vt().a((TbPageContext) this.bVP.getPageContext(), new String[]{bfW}, true);
                } else if (dm == 1) {
                    String qL = com.baidu.tieba.tbadkCore.util.m.qL(bfW);
                    if (TextUtils.isEmpty(qL) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bVP.getPageContext().getPageActivity(), this.bVP.getPageContext().getPageActivity().getString(r.l.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bVP.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", qL, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bVP.getPageContext().getPageActivity(), qL, "1000601")));
                } else if (dm == 3) {
                    frsActivity11 = this.bVP.bLZ;
                    com.baidu.tbadk.core.util.m.a(frsActivity11.getPageContext(), bfW);
                }
            }
        } else if (id == r.h.btn_love_content) {
            frsActivity9 = this.bVP.bLZ;
            if (!frsActivity9.XX()) {
                i = this.bVP.mScrollState;
                if (i == 0) {
                    str = this.bVP.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bVP.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.bVP.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    cVar = this.bVP.bVE;
                    if (cVar != null) {
                        cVar2 = this.bVP.bVE;
                        cVar2.c(view, false);
                    }
                }
            }
        } else if (id == r.h.frs_bawu_center && XW != null && XW.getUserData() != null && XW.getUserData().isBawu()) {
            String bgf = XW.bgf();
            if (!at.isEmpty(bgf)) {
                com.baidu.tbadk.browser.f.u(this.bVP.getPageContext().getPageActivity(), bgf);
                if (XW.aJY() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10502").ab("fid", XW.aJY().getId()).ab(SapiAccountManager.SESSION_UID, XW.getUserData().getUserId()));
                }
            }
        }
    }
}
