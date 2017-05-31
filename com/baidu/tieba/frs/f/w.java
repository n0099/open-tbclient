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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u chY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.chY = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r0.ael()) goto L11;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        com.baidu.tieba.frs.r rVar;
        com.baidu.tieba.frs.r rVar2;
        int i;
        String str;
        com.baidu.tieba.frs.view.b bVar;
        com.baidu.tieba.frs.view.b bVar2;
        String str2;
        String str3;
        com.baidu.adp.base.g gVar;
        com.baidu.tieba.frs.r rVar3;
        com.baidu.tieba.frs.r rVar4;
        com.baidu.adp.base.g gVar2;
        com.baidu.tieba.frs.r rVar5;
        com.baidu.tieba.frs.r rVar6;
        com.baidu.tieba.frs.r rVar7;
        com.baidu.adp.base.g gVar3;
        com.baidu.tieba.frs.r rVar8;
        com.baidu.tieba.frs.view.b bVar3;
        com.baidu.tieba.frs.view.b bVar4;
        com.baidu.tieba.frs.r rVar9;
        com.baidu.tieba.frs.r rVar10;
        com.baidu.tieba.frs.view.b bVar5;
        rVar = this.chY.bTw;
        com.baidu.tieba.tbadkCore.n aau = rVar.aau();
        if (aau != null && aau.aIz() != null) {
            bVar3 = this.chY.chL;
            if (bVar3 != null) {
                bVar4 = this.chY.chL;
                if (view != bVar4.aed()) {
                    bVar5 = this.chY.chL;
                }
                rVar9 = this.chY.bTw;
                if (rVar9 != null && aau.aIz() != null) {
                    rVar10 = this.chY.bTw;
                    TiebaStatic.log(new as("c12046").Z("fid", aau.aIz().getId()).r("obj_locate", rVar10.aaw() ? 1 : 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.chY.getPageContext().getPageActivity(), aau.aIz().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == w.h.tv_love) {
            rVar7 = this.chY.bTw;
            if (!rVar7.aav() && com.baidu.adp.lib.util.i.hk()) {
                gVar3 = this.chY.mContext;
                if (!bh.aN(gVar3.getPageActivity())) {
                    as r = new as("c10517").r("obj_locate", 1);
                    rVar8 = this.chY.bTw;
                    TiebaStatic.log(r.Z("fid", rVar8.getForumId()));
                    return;
                }
                this.chY.ez(true);
            }
        } else if (id == w.h.tv_sign) {
            rVar4 = this.chY.bTw;
            if (!rVar4.aav() && com.baidu.adp.lib.util.i.hk()) {
                gVar2 = this.chY.mContext;
                if (bh.aN(gVar2.getPageActivity())) {
                    if (!this.chY.aeb()) {
                        this.chY.aef();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        rVar5 = this.chY.bTw;
                        Activity pageActivity = rVar5.getPageContext().getPageActivity();
                        rVar6 = this.chY.bTw;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(rVar6.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == w.h.frs_header_games) {
            gVar = this.chY.mContext;
            if (bh.aN(gVar.getPageActivity()) && aau != null && aau.bgw() != null) {
                String bgw = aau.bgw();
                if (com.baidu.tbadk.core.util.m.dh(bgw) == 3) {
                    rVar3 = this.chY.bTw;
                    com.baidu.tbadk.core.util.m.a(rVar3.getPageContext(), bgw);
                    return;
                }
                bb.vy().a((TbPageContext) this.chY.getPageContext(), new String[]{bgw}, true);
            }
        } else if (id == w.h.frs_bawu_center) {
            if (aau != null && aau.getUserData() != null && aau.getUserData().isBawu()) {
                String bgE = aau.bgE();
                if (!au.isEmpty(bgE)) {
                    com.baidu.tbadk.browser.f.S(this.chY.getPageContext().getPageActivity(), bgE);
                    if (aau.aIz() != null) {
                        TiebaStatic.log(new as("c10502").Z("fid", aau.aIz().getId()).Z(SapiAccountManager.SESSION_UID, aau.getUserData().getUserId()));
                    }
                }
            }
        } else if (id == w.h.level_container) {
            rVar2 = this.chY.bTw;
            if (!rVar2.aav()) {
                i = this.chY.mScrollState;
                if (i == 0) {
                    str = this.chY.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.chY.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.chY.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    bVar = this.chY.chL;
                    if (bVar != null) {
                        bVar2 = this.chY.chL;
                        bVar2.f(view, false);
                    }
                }
            }
        }
    }
}
