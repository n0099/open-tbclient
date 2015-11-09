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
public class e implements View.OnClickListener {
    final /* synthetic */ a bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bcD = aVar;
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
        frsActivity = this.bcD.bbk;
        com.baidu.tieba.tbadkCore.o Lt = frsActivity.Lt();
        if (Lt != null && Lt.afg() != null) {
            if (this.bcD.NF() != null && (view == this.bcD.NF().NX() || view == this.bcD.NF().Om())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bcD.getPageContext().getPageActivity(), Lt.afg().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.bcD.NG() != null && (view == this.bcD.NG().NX() || view == this.bcD.NG().Om())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(this.bcD.getPageContext().getPageActivity(), Lt.afg().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView NF = this.bcD.NF();
        com.baidu.tieba.frs.view.q NG = this.bcD.NG();
        if ((NF != null && NF.F(view)) || (NG != null && NG.F(view))) {
            TiebaStatic.log("forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.bcD.bbk;
                frsActivity8.Lo();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity9 = this.bcD.bbk;
                m411getInst.login(frsActivity9.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) this.bcD.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == i.f.btn_love) {
            frsActivity6 = this.bcD.bbk;
            if (!frsActivity6.Lu() && com.baidu.adp.lib.util.i.iN()) {
                frsActivity7 = this.bcD.bbk;
                if (frsActivity7.checkUpIsLogin()) {
                    this.bcD.oO();
                }
            }
        } else if (id == i.f.btn_sign) {
            frsActivity4 = this.bcD.bbk;
            if (!frsActivity4.Lu() && com.baidu.adp.lib.util.i.iN()) {
                frsActivity5 = this.bcD.bbk;
                if (frsActivity5.checkUpIsLogin() && !this.bcD.NV()) {
                    this.bcD.NY();
                }
            }
        } else if (id == i.f.frs_header_games) {
            frsActivity3 = this.bcD.bbk;
            if (frsActivity3.checkUpIsLogin() && Lt != null && Lt.awi() != null) {
                String awi = Lt.awi();
                int da = com.baidu.tbadk.core.util.o.da(awi);
                if (da == 2) {
                    az.uX().a((TbPageContext) this.bcD.getPageContext(), new String[]{awi}, true);
                } else if (da == 1) {
                    String lO = com.baidu.tieba.tbadkCore.util.n.lO(awi);
                    if (TextUtils.isEmpty(lO) || Build.VERSION.SDK_INT < 11) {
                        com.baidu.adp.lib.util.k.showToast(this.bcD.getPageContext().getPageActivity(), this.bcD.getPageContext().getPageActivity().getString(i.h.frs_header_games_unavailable));
                        return;
                    }
                    TiebaStatic.eventStat(this.bcD.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", lO, "ref_id", "1000601", "ref_type", "603");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GameDetailActivityConfig(this.bcD.getPageContext().getPageActivity(), lO, "1000601")));
                } else if (da == 3) {
                    com.baidu.tbadk.core.util.o.a(this.bcD.getPageContext(), awi);
                }
            }
        } else if (id == i.f.btn_love_content) {
            frsActivity2 = this.bcD.bbk;
            if (!frsActivity2.Lu()) {
                i = this.bcD.mScrollState;
                if (i == 0) {
                    str = this.bcD.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.bcD.mPageType;
                        if (str2.equals("frs_page")) {
                            this.bcD.D(view);
                            return;
                        }
                        return;
                    }
                    this.bcD.C(view);
                }
            }
        }
    }
}
