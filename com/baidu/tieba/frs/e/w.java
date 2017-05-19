package com.baidu.tieba.frs.e;

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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u cbL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.cbL = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r0.adi()) goto L11;
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
        rVar = this.cbL.bNK;
        com.baidu.tieba.tbadkCore.n Zq = rVar.Zq();
        if (Zq != null && Zq.aHE() != null) {
            bVar3 = this.cbL.cbz;
            if (bVar3 != null) {
                bVar4 = this.cbL.cbz;
                if (view != bVar4.ada()) {
                    bVar5 = this.cbL.cbz;
                }
                rVar9 = this.cbL.bNK;
                if (rVar9 != null && Zq.aHE() != null) {
                    rVar10 = this.cbL.bNK;
                    TiebaStatic.log(new as("c12046").aa("fid", Zq.aHE().getId()).s("obj_locate", rVar10.Zt() ? 1 : 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cbL.getPageContext().getPageActivity(), Zq.aHE().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == w.h.tv_love) {
            rVar7 = this.cbL.bNK;
            if (!rVar7.Zr() && com.baidu.adp.lib.util.i.hk()) {
                gVar3 = this.cbL.mContext;
                if (!bg.aN(gVar3.getPageActivity())) {
                    as s = new as("c10517").s("obj_locate", 1);
                    rVar8 = this.cbL.bNK;
                    TiebaStatic.log(s.aa("fid", rVar8.getForumId()));
                    return;
                }
                this.cbL.ej(true);
            }
        } else if (id == w.h.tv_sign) {
            rVar4 = this.cbL.bNK;
            if (!rVar4.Zr() && com.baidu.adp.lib.util.i.hk()) {
                gVar2 = this.cbL.mContext;
                if (bg.aN(gVar2.getPageActivity())) {
                    if (!this.cbL.acY()) {
                        this.cbL.adc();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        rVar5 = this.cbL.bNK;
                        Activity pageActivity = rVar5.getPageContext().getPageActivity();
                        rVar6 = this.cbL.bNK;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(rVar6.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == w.h.frs_header_games) {
            gVar = this.cbL.mContext;
            if (bg.aN(gVar.getPageActivity()) && Zq != null && Zq.bfb() != null) {
                String bfb = Zq.bfb();
                if (com.baidu.tbadk.core.util.m.dk(bfb) == 3) {
                    rVar3 = this.cbL.bNK;
                    com.baidu.tbadk.core.util.m.a(rVar3.getPageContext(), bfb);
                    return;
                }
                bb.vB().a((TbPageContext) this.cbL.getPageContext(), new String[]{bfb}, true);
            }
        } else if (id == w.h.frs_bawu_center) {
            if (Zq != null && Zq.getUserData() != null && Zq.getUserData().isBawu()) {
                String bfj = Zq.bfj();
                if (!au.isEmpty(bfj)) {
                    com.baidu.tbadk.browser.f.S(this.cbL.getPageContext().getPageActivity(), bfj);
                    if (Zq.aHE() != null) {
                        TiebaStatic.log(new as("c10502").aa("fid", Zq.aHE().getId()).aa(SapiAccountManager.SESSION_UID, Zq.getUserData().getUserId()));
                    }
                }
            }
        } else if (id == w.h.level_container) {
            rVar2 = this.cbL.bNK;
            if (!rVar2.Zr()) {
                i = this.cbL.mScrollState;
                if (i == 0) {
                    str = this.cbL.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cbL.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cbL.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    bVar = this.cbL.cbz;
                    if (bVar != null) {
                        bVar2 = this.cbL.cbz;
                        bVar2.d(view, false);
                    }
                }
            }
        }
    }
}
