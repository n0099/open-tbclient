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
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bbY = aVar;
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
        frsActivity = this.bbY.baR;
        com.baidu.tieba.tbadkCore.o Lh = frsActivity.Lh();
        if (Lh != null && Lh.aeN() != null) {
            if (this.bbY.Nn() != null && (view == this.bbY.Nn().NF() || view == this.bbY.Nn().NU())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbY.getPageContext().getPageActivity(), Lh.aeN().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bbY.No() != null && (view == this.bbY.No().NF() || view == this.bbY.No().NU())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbY.getPageContext().getPageActivity(), Lh.aeN().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Nn = this.bbY.Nn();
        com.baidu.tieba.frs.view.q No = this.bbY.No();
        if ((Nn != null && Nn.E(view)) || (No != null && No.E(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.bbY.baR;
                frsActivity8.Lc();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity9 = this.bbY.baR;
                m411getInst.login(frsActivity9.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbY.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == i.f.btn_love) {
            frsActivity6 = this.bbY.baR;
            if (!frsActivity6.Li() && com.baidu.adp.lib.util.i.iM()) {
                frsActivity7 = this.bbY.baR;
                if (frsActivity7.checkUpIsLogin()) {
                    this.bbY.oN();
                }
            }
        } else if (id == i.f.btn_sign) {
            frsActivity4 = this.bbY.baR;
            if (!frsActivity4.Li() && com.baidu.adp.lib.util.i.iM()) {
                frsActivity5 = this.bbY.baR;
                if (frsActivity5.checkUpIsLogin() && !this.bbY.ND()) {
                    this.bbY.NG();
                }
            }
        } else if (id == i.f.frs_header_games) {
            frsActivity3 = this.bbY.baR;
            if (frsActivity3.checkUpIsLogin() && Lh != null && Lh.avF() != null) {
                String avF = Lh.avF();
                int da = com.baidu.tbadk.core.util.o.da(avF);
                if (da == 2) {
                    az.uW().a((TbPageContext) this.bbY.getPageContext(), new String[]{avF}, true);
                } else if (da == 1) {
                    String lI = com.baidu.tieba.tbadkCore.util.n.lI(avF);
                    if (TextUtils.isEmpty(lI) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bbY.getPageContext().getPageActivity(), this.bbY.getPageContext().getPageActivity().getString(i.h.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bbY.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", lI, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bbY.getPageContext().getPageActivity(), lI, "1000601")));
                } else if (da == 3) {
                    com.baidu.tbadk.core.util.o.a(this.bbY.getPageContext(), avF);
                }
            }
        } else if (id == i.f.btn_love_content) {
            frsActivity2 = this.bbY.baR;
            if (!frsActivity2.Li()) {
                i = this.bbY.mScrollState;
                if (i == 0) {
                    str = this.bbY.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bbY.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bbY.C(view);
                            return;
                        }
                        return;
                    }
                    this.bbY.B(view);
                }
            }
        }
    }
}
