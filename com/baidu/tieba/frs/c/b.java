package com.baidu.tieba.frs.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.GameDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.frs.view.o;
import com.baidu.tieba.q;
import com.baidu.tieba.tbadkCore.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aQd = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v11, resolved type: com.baidu.tieba.frs.FrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        String str;
        String str2;
        FrsActivity frsActivity4;
        FrsActivity frsActivity5;
        FrsActivity frsActivity6;
        FrsActivity frsActivity7;
        FrsActivity frsActivity8;
        FrsActivity frsActivity9;
        FrsActivity frsActivity10;
        FrsActivity frsActivity11;
        FrsActivity frsActivity12;
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aQd.getPageContext().getPageActivity());
        frsActivity = this.aQd.aPF;
        w KF = frsActivity.KF();
        if (KF != null && KF.aas() != null) {
            if (this.aQd.Mb() != null && (view == this.aQd.Mb().Mu() || view == this.aQd.Mb().MC())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aQd.getPageContext().getPageActivity(), KF.aas().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.aQd.Mc() != null && (view == this.aQd.Mc().Mu() || view == this.aQd.Mc().MC())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aQd.getPageContext().getPageActivity(), KF.aas().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Mb = this.aQd.Mb();
        o Mc = this.aQd.Mc();
        if ((Mb != null && Mb.z(view)) || (Mc != null && Mc.z(view))) {
            com.baidu.tbadk.core.k.A(this.aQd.getPageContext().getPageActivity(), "forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity11 = this.aQd.aPF;
                frsActivity11.KC();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity12 = this.aQd.aPF;
                m411getInst.login(frsActivity12.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.aQd.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == q.btn_love) {
            frsActivity9 = this.aQd.aPF;
            if (!frsActivity9.KG() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                frsActivity10 = this.aQd.aPF;
                if (frsActivity10.checkUpIsLogin()) {
                    this.aQd.oF();
                }
            }
        } else if (id == q.btn_sign) {
            frsActivity7 = this.aQd.aPF;
            if (!frsActivity7.KG() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                frsActivity8 = this.aQd.aPF;
                if (frsActivity8.checkUpIsLogin() && !this.aQd.Ms()) {
                    this.aQd.Mv();
                }
            }
        } else if (id == q.frs_header_groups) {
            frsActivity5 = this.aQd.aPF;
            if (frsActivity5.checkUpIsLogin() && KF != null && KF.aas() != null && !com.baidu.adp.lib.util.m.isEmpty(KF.aas().getId()) && KF.amv() != null) {
                TiebaStatic.eventStat(this.aQd.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(this.aQd.getPageContext().getPageActivity(), KF.aas().getId(), KF.amv().amo() != 1);
                frsActivity6 = this.aQd.aPF;
                frsActivity6.sendMessage(new CustomMessage(2002001, frsGroupActivityConfig));
            }
        } else if (id == q.frs_header_games) {
            frsActivity4 = this.aQd.aPF;
            if (frsActivity4.checkUpIsLogin() && KF != null && KF.amz() != null) {
                String amz = KF.amz();
                int cO = com.baidu.tbadk.core.util.q.cO(amz);
                if (cO == 2) {
                    com.baidu.tbadk.browser.f.b(this.aQd.getPageContext().getPageActivity(), null, amz, true);
                } else if (cO == 1) {
                    String jJ = com.baidu.tieba.tbadkCore.util.k.jJ(amz);
                    if (!TextUtils.isEmpty(jJ)) {
                        TiebaStatic.eventStat(this.aQd.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", jJ, "ref_id", "1000601", "ref_type", "603");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aQd.getPageContext().getPageActivity(), jJ, "1000601")));
                    }
                }
            }
        } else if (id == q.btn_love_content) {
            frsActivity2 = this.aQd.aPF;
            if (!frsActivity2.KG()) {
                frsActivity3 = this.aQd.aPF;
                if (!frsActivity3.KH()) {
                    str = this.aQd.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.aQd.mPageType;
                        if (str2.equals("frs_page")) {
                            this.aQd.y(view);
                            return;
                        }
                        return;
                    }
                    this.aQd.x(view);
                }
            }
        }
    }
}
