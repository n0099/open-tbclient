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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ m cpZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.cpZ = mVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r8 == r0.ahZ()) goto L11;
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
        rVar = this.cpZ.cbE;
        com.baidu.tieba.tbadkCore.n aek = rVar.aek();
        if (aek != null && aek.aMt() != null) {
            bVar3 = this.cpZ.cpM;
            if (bVar3 != null) {
                bVar4 = this.cpZ.cpM;
                if (view != bVar4.ahR()) {
                    bVar5 = this.cpZ.cpM;
                }
                rVar9 = this.cpZ.cbE;
                if (rVar9 != null && aek.aMt() != null) {
                    rVar10 = this.cpZ.cbE;
                    TiebaStatic.log(new au("c12046").Z("fid", aek.aMt().getId()).r("obj_locate", rVar10.aem() ? 1 : 2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.cpZ.getPageContext().getPageActivity(), aek.aMt().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        int id = view.getId();
        if (id == w.h.tv_love) {
            rVar7 = this.cpZ.cbE;
            if (!rVar7.ael() && com.baidu.adp.lib.util.i.hj()) {
                gVar3 = this.cpZ.mContext;
                if (!bl.aN(gVar3.getPageActivity())) {
                    au r = new au("c10517").r("obj_locate", 1);
                    rVar8 = this.cpZ.cbE;
                    TiebaStatic.log(r.Z("fid", rVar8.getForumId()));
                    return;
                }
                this.cpZ.eQ(true);
            }
        } else if (id == w.h.tv_sign) {
            rVar4 = this.cpZ.cbE;
            if (!rVar4.ael() && com.baidu.adp.lib.util.i.hj()) {
                gVar2 = this.cpZ.mContext;
                if (bl.aN(gVar2.getPageActivity())) {
                    if (!this.cpZ.ahP()) {
                        this.cpZ.ahT();
                    } else if (TbadkCoreApplication.m9getInst().getUseNewResign() == 1) {
                        rVar5 = this.cpZ.cbE;
                        Activity pageActivity = rVar5.getPageContext().getPageActivity();
                        rVar6 = this.cpZ.cbE;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.g.b.g(rVar6.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == w.h.frs_header_games) {
            gVar = this.cpZ.mContext;
            if (bl.aN(gVar.getPageActivity()) && aek != null && aek.bkK() != null) {
                String bkK = aek.bkK();
                if (com.baidu.tbadk.core.util.o.dB(bkK) == 3) {
                    rVar3 = this.cpZ.cbE;
                    com.baidu.tbadk.core.util.o.a(rVar3.getPageContext(), bkK);
                    return;
                }
                be.vP().a((TbPageContext) this.cpZ.getPageContext(), new String[]{bkK}, true);
            }
        } else if (id == w.h.frs_bawu_center) {
            if (aek != null && aek.getUserData() != null && aek.getUserData().isBawu()) {
                String bkS = aek.bkS();
                if (!aw.isEmpty(bkS)) {
                    com.baidu.tbadk.browser.g.T(this.cpZ.getPageContext().getPageActivity(), bkS);
                    if (aek.aMt() != null) {
                        TiebaStatic.log(new au("c10502").Z("fid", aek.aMt().getId()).Z(SapiAccountManager.SESSION_UID, aek.getUserData().getUserId()));
                    }
                }
            }
        } else if (id == w.h.level_container) {
            rVar2 = this.cpZ.cbE;
            if (!rVar2.ael()) {
                i = this.cpZ.mScrollState;
                if (i == 0) {
                    str = this.cpZ.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.cpZ.mPageType;
                        if (!str2.equals("frs_page")) {
                            str3 = this.cpZ.mPageType;
                            if (!str3.equals("book_page")) {
                                return;
                            }
                        }
                    }
                    bVar = this.cpZ.cpM;
                    if (bVar != null) {
                        bVar2 = this.cpZ.cpM;
                        bVar2.f(view, false);
                    }
                }
            }
        }
    }
}
