package com.baidu.tieba.frs.b;

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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bbN = aVar;
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
        frsActivity = this.bbN.baG;
        com.baidu.tieba.tbadkCore.o Lh = frsActivity.Lh();
        if (Lh != null && Lh.aeN() != null) {
            if (this.bbN.Nn() != null && (view == this.bbN.Nn().NF() || view == this.bbN.Nn().NU())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbN.getPageContext().getPageActivity(), Lh.aeN().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bbN.No() != null && (view == this.bbN.No().NF() || view == this.bbN.No().NU())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbN.getPageContext().getPageActivity(), Lh.aeN().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Nn = this.bbN.Nn();
        com.baidu.tieba.frs.view.q No = this.bbN.No();
        if ((Nn != null && Nn.E(view)) || (No != null && No.E(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.bbN.baG;
                frsActivity8.Lc();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity9 = this.bbN.baG;
                m411getInst.login(frsActivity9.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbN.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == i.f.btn_love) {
            frsActivity6 = this.bbN.baG;
            if (!frsActivity6.Li() && com.baidu.adp.lib.util.i.iM()) {
                frsActivity7 = this.bbN.baG;
                if (frsActivity7.checkUpIsLogin()) {
                    this.bbN.oN();
                }
            }
        } else if (id == i.f.btn_sign) {
            frsActivity4 = this.bbN.baG;
            if (!frsActivity4.Li() && com.baidu.adp.lib.util.i.iM()) {
                frsActivity5 = this.bbN.baG;
                if (frsActivity5.checkUpIsLogin() && !this.bbN.ND()) {
                    this.bbN.NG();
                }
            }
        } else if (id == i.f.frs_header_games) {
            frsActivity3 = this.bbN.baG;
            if (frsActivity3.checkUpIsLogin() && Lh != null && Lh.avz() != null) {
                String avz = Lh.avz();
                int cZ = com.baidu.tbadk.core.util.o.cZ(avz);
                if (cZ == 2) {
                    ay.uV().a((TbPageContext) this.bbN.getPageContext(), new String[]{avz}, true);
                } else if (cZ == 1) {
                    String lF = com.baidu.tieba.tbadkCore.util.n.lF(avz);
                    if (TextUtils.isEmpty(lF) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bbN.getPageContext().getPageActivity(), this.bbN.getPageContext().getPageActivity().getString(i.h.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bbN.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", lF, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bbN.getPageContext().getPageActivity(), lF, "1000601")));
                } else if (cZ == 3) {
                    com.baidu.tbadk.core.util.o.a(this.bbN.getPageContext(), avz);
                }
            }
        } else if (id == i.f.btn_love_content) {
            frsActivity2 = this.bbN.baG;
            if (!frsActivity2.Li()) {
                i = this.bbN.mScrollState;
                if (i == 0) {
                    str = this.bbN.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bbN.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bbN.C(view);
                            return;
                        }
                        return;
                    }
                    this.bbN.B(view);
                }
            }
        }
    }
}
