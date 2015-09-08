package com.baidu.tieba.frs.c;

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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bbT = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        int i;
        String str;
        String str2;
        FrsActivity frsActivity3;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        frsActivity = this.bbT.baN;
        com.baidu.tieba.tbadkCore.o Ll = frsActivity.Ll();
        if (Ll != null && Ll.acP() != null) {
            if (this.bbT.Nn() != null && (view == this.bbT.Nn().NF() || view == this.bbT.Nn().NU())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbT.getPageContext().getPageActivity(), Ll.acP().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bbT.No() != null && (view == this.bbT.No().NF() || view == this.bbT.No().NU())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbT.getPageContext().getPageActivity(), Ll.acP().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Nn = this.bbT.Nn();
        com.baidu.tieba.frs.view.p No = this.bbT.No();
        if ((Nn != null && Nn.E(view)) || (No != null && No.E(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.bbT.baN;
                frsActivity8.Lg();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity9 = this.bbT.baN;
                m411getInst.login(frsActivity9.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbT.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == i.f.btn_love) {
            frsActivity6 = this.bbT.baN;
            if (!frsActivity6.Lm() && com.baidu.adp.lib.util.i.iL()) {
                frsActivity7 = this.bbT.baN;
                if (frsActivity7.checkUpIsLogin()) {
                    this.bbT.oM();
                }
            }
        } else if (id == i.f.btn_sign) {
            frsActivity4 = this.bbT.baN;
            if (!frsActivity4.Lm() && com.baidu.adp.lib.util.i.iL()) {
                frsActivity5 = this.bbT.baN;
                if (frsActivity5.checkUpIsLogin() && !this.bbT.ND()) {
                    this.bbT.NG();
                }
            }
        } else if (id == i.f.frs_header_games) {
            frsActivity3 = this.bbT.baN;
            if (frsActivity3.checkUpIsLogin() && Ll != null && Ll.atj() != null) {
                String atj = Ll.atj();
                int cW = com.baidu.tbadk.core.util.o.cW(atj);
                if (cW == 2) {
                    ax.uX().a((TbPageContext) this.bbT.getPageContext(), new String[]{atj}, true);
                } else if (cW == 1) {
                    String lh = com.baidu.tieba.tbadkCore.util.l.lh(atj);
                    if (TextUtils.isEmpty(lh) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bbT.getPageContext().getPageActivity(), this.bbT.getPageContext().getPageActivity().getString(i.h.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bbT.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", lh, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bbT.getPageContext().getPageActivity(), lh, "1000601")));
                } else if (cW == 3) {
                    com.baidu.tbadk.core.util.o.a(this.bbT.getPageContext(), atj);
                }
            }
        } else if (id == i.f.btn_love_content) {
            frsActivity2 = this.bbT.baN;
            if (!frsActivity2.Lm()) {
                i = this.bbT.mScrollState;
                if (i == 0) {
                    str = this.bbT.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bbT.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bbT.C(view);
                            return;
                        }
                        return;
                    }
                    this.bbT.B(view);
                }
            }
        }
    }
}
