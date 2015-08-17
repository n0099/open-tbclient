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
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bbz = aVar;
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
        frsActivity = this.bbz.bat;
        com.baidu.tieba.tbadkCore.n Lu = frsActivity.Lu();
        if (Lu != null && Lu.acG() != null) {
            if (this.bbz.Nm() != null && (view == this.bbz.Nm().NE() || view == this.bbz.Nm().NT())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbz.getPageContext().getPageActivity(), Lu.acG().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bbz.Nn() != null && (view == this.bbz.Nn().NE() || view == this.bbz.Nn().NT())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbz.getPageContext().getPageActivity(), Lu.acG().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Nm = this.bbz.Nm();
        com.baidu.tieba.frs.view.p Nn = this.bbz.Nn();
        if ((Nm != null && Nm.E(view)) || (Nn != null && Nn.E(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.bbz.bat;
                frsActivity8.Lr();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity9 = this.bbz.bat;
                m411getInst.login(frsActivity9.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbz.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == i.f.btn_love) {
            frsActivity6 = this.bbz.bat;
            if (!frsActivity6.Lv() && com.baidu.adp.lib.util.i.iO()) {
                frsActivity7 = this.bbz.bat;
                if (frsActivity7.checkUpIsLogin()) {
                    this.bbz.oP();
                }
            }
        } else if (id == i.f.btn_sign) {
            frsActivity4 = this.bbz.bat;
            if (!frsActivity4.Lv() && com.baidu.adp.lib.util.i.iO()) {
                frsActivity5 = this.bbz.bat;
                if (frsActivity5.checkUpIsLogin() && !this.bbz.NC()) {
                    this.bbz.NF();
                }
            }
        } else if (id == i.f.frs_header_games) {
            frsActivity3 = this.bbz.bat;
            if (frsActivity3.checkUpIsLogin() && Lu != null && Lu.apb() != null) {
                String apb = Lu.apb();
                int cQ = com.baidu.tbadk.core.util.o.cQ(apb);
                if (cQ == 2) {
                    ax.uR().a((TbPageContext) this.bbz.getPageContext(), new String[]{apb}, true);
                } else if (cQ == 1) {
                    String kC = com.baidu.tieba.tbadkCore.util.l.kC(apb);
                    if (TextUtils.isEmpty(kC) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bbz.getPageContext().getPageActivity(), this.bbz.getPageContext().getPageActivity().getString(i.C0057i.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bbz.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", kC, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bbz.getPageContext().getPageActivity(), kC, "1000601")));
                } else if (cQ == 3) {
                    com.baidu.tbadk.core.util.o.a(this.bbz.getPageContext(), apb);
                }
            }
        } else if (id == i.f.btn_love_content) {
            frsActivity2 = this.bbz.bat;
            if (!frsActivity2.Lv()) {
                i = this.bbz.mScrollState;
                if (i == 0) {
                    str = this.bbz.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bbz.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bbz.C(view);
                            return;
                        }
                        return;
                    }
                    this.bbz.B(view);
                }
            }
        }
    }
}
