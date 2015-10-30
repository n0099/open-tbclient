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
        com.baidu.tieba.tbadkCore.o Ld = frsActivity.Ld();
        if (Ld != null && Ld.aeJ() != null) {
            if (this.bbY.Nj() != null && (view == this.bbY.Nj().NB() || view == this.bbY.Nj().NQ())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbY.getPageContext().getPageActivity(), Ld.aeJ().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bbY.Nk() != null && (view == this.bbY.Nk().NB() || view == this.bbY.Nk().NQ())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bbY.getPageContext().getPageActivity(), Ld.aeJ().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Nj = this.bbY.Nj();
        com.baidu.tieba.frs.view.q Nk = this.bbY.Nk();
        if ((Nj != null && Nj.E(view)) || (Nk != null && Nk.E(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.bbY.baR;
                frsActivity8.KY();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity9 = this.bbY.baR;
                m411getInst.login(frsActivity9.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bbY.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == i.f.btn_love) {
            frsActivity6 = this.bbY.baR;
            if (!frsActivity6.Le() && com.baidu.adp.lib.util.i.iM()) {
                frsActivity7 = this.bbY.baR;
                if (frsActivity7.checkUpIsLogin()) {
                    this.bbY.oN();
                }
            }
        } else if (id == i.f.btn_sign) {
            frsActivity4 = this.bbY.baR;
            if (!frsActivity4.Le() && com.baidu.adp.lib.util.i.iM()) {
                frsActivity5 = this.bbY.baR;
                if (frsActivity5.checkUpIsLogin() && !this.bbY.Nz()) {
                    this.bbY.NC();
                }
            }
        } else if (id == i.f.frs_header_games) {
            frsActivity3 = this.bbY.baR;
            if (frsActivity3.checkUpIsLogin() && Ld != null && Ld.avB() != null) {
                String avB = Ld.avB();
                int da = com.baidu.tbadk.core.util.o.da(avB);
                if (da == 2) {
                    az.uT().a((TbPageContext) this.bbY.getPageContext(), new String[]{avB}, true);
                } else if (da == 1) {
                    String lI = com.baidu.tieba.tbadkCore.util.n.lI(avB);
                    if (TextUtils.isEmpty(lI) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bbY.getPageContext().getPageActivity(), this.bbY.getPageContext().getPageActivity().getString(i.h.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bbY.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", lI, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bbY.getPageContext().getPageActivity(), lI, "1000601")));
                } else if (da == 3) {
                    com.baidu.tbadk.core.util.o.a(this.bbY.getPageContext(), avB);
                }
            }
        } else if (id == i.f.btn_love_content) {
            frsActivity2 = this.bbY.baR;
            if (!frsActivity2.Le()) {
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
