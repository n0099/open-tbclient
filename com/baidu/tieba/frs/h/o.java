package com.baidu.tieba.frs.h;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.buB = mVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v27, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r14 == r1.Ue()) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        FrsActivity frsActivity;
        com.baidu.tieba.frs.view.c cVar;
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
        com.baidu.tieba.frs.view.c cVar2;
        com.baidu.tieba.frs.view.c cVar3;
        String str2;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        com.baidu.tieba.frs.view.c cVar4;
        FrsActivity frsActivity12;
        FrsActivity frsActivity13;
        com.baidu.tieba.frs.view.c cVar5;
        com.baidu.tieba.frs.view.c cVar6;
        com.baidu.tieba.frs.view.c cVar7;
        frsActivity = this.buB.bpj;
        com.baidu.tieba.tbadkCore.o PZ = frsActivity.PZ();
        if (PZ != null && PZ.avA() != null) {
            cVar5 = this.buB.buq;
            if (cVar5 != null) {
                cVar6 = this.buB.buq;
                if (view != cVar6.TU()) {
                    cVar7 = this.buB.buq;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.buB.getPageContext().getPageActivity(), PZ.avA().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        cVar = this.buB.buq;
        if (cVar != null) {
            cVar4 = this.buB.buq;
            if (cVar4.ag(view)) {
                TiebaStatic.log("forum_fortune_click");
                if (TbadkCoreApplication.isLogin()) {
                    frsActivity12 = this.buB.bpj;
                    frsActivity12.PU();
                } else {
                    TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
                    frsActivity13 = this.buB.bpj;
                    m11getInst.login(frsActivity13.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.buB.getPageContext().getPageActivity(), (String) null, true, 18004)));
                }
            }
        }
        int id = view.getId();
        if (id == t.g.btn_love || id == t.g.love) {
            frsActivity2 = this.buB.bpj;
            if (!frsActivity2.Qa() && com.baidu.adp.lib.util.i.fq()) {
                frsActivity3 = this.buB.bpj;
                if (!frsActivity3.checkUpIsLogin()) {
                    aw s = new aw("c10517").s("obj_locate", 1);
                    frsActivity4 = this.buB.bpj;
                    TiebaStatic.log(s.ac("fid", frsActivity4.getForumId()));
                    return;
                }
                this.buB.kT();
            }
        } else if (id == t.g.btn_sign || id == t.g.sign_done || id == t.g.sign) {
            frsActivity5 = this.buB.bpj;
            if (!frsActivity5.Qa() && com.baidu.adp.lib.util.i.fq()) {
                frsActivity6 = this.buB.bpj;
                if (frsActivity6.checkUpIsLogin()) {
                    if (!this.buB.TS()) {
                        this.buB.TV();
                    } else if (TbadkCoreApplication.m11getInst().getUseNewResign() == 1) {
                        frsActivity7 = this.buB.bpj;
                        Activity pageActivity = frsActivity7.getPageContext().getPageActivity();
                        frsActivity8 = this.buB.bpj;
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SupplementSignActivityConfig(pageActivity, com.baidu.adp.lib.h.b.g(frsActivity8.getForumId(), 0), 24002)));
                    }
                }
            }
        } else if (id == t.g.frs_header_games) {
            frsActivity10 = this.buB.bpj;
            if (frsActivity10.checkUpIsLogin() && PZ != null && PZ.aSk() != null) {
                String aSk = PZ.aSk();
                int dj = com.baidu.tbadk.core.util.n.dj(aSk);
                if (dj == 2) {
                    bg.us().a((TbPageContext) this.buB.getPageContext(), new String[]{aSk}, true);
                } else if (dj == 1) {
                    String nZ = com.baidu.tieba.tbadkCore.util.n.nZ(aSk);
                    if (TextUtils.isEmpty(nZ) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.buB.getPageContext().getPageActivity(), this.buB.getPageContext().getPageActivity().getString(t.j.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.buB.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", nZ, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.buB.getPageContext().getPageActivity(), nZ, "1000601")));
                } else if (dj == 3) {
                    frsActivity11 = this.buB.bpj;
                    com.baidu.tbadk.core.util.n.a(frsActivity11.getPageContext(), aSk);
                }
            }
        } else if (id == t.g.btn_love_content) {
            frsActivity9 = this.buB.bpj;
            if (!frsActivity9.Qa()) {
                i = this.buB.mScrollState;
                if (i == 0) {
                    str = this.buB.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.buB.mPageType;
                        if (!str2.equals("frs_page")) {
                            return;
                        }
                    }
                    cVar2 = this.buB.buq;
                    if (cVar2 != null) {
                        cVar3 = this.buB.buq;
                        cVar3.f(view, false);
                    }
                }
            }
        } else if (id == t.g.frs_bawu_center && PZ != null && PZ.getUserData() != null && PZ.getUserData().isBawu()) {
            String aSs = PZ.aSs();
            if (!ay.isEmpty(aSs)) {
                com.baidu.tbadk.browser.f.t(this.buB.getPageContext().getPageActivity(), aSs);
                if (PZ.avA() != null) {
                    TiebaStatic.log(new aw("c10502").ac("fid", PZ.avA().getId()).ac("uid", PZ.getUserData().getUserId()));
                }
            }
        }
    }
}
