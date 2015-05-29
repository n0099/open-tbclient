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
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aQc = aVar;
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
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aQc.getPageContext().getPageActivity());
        frsActivity = this.aQc.aPE;
        w KE = frsActivity.KE();
        if (KE != null && KE.aar() != null) {
            if (this.aQc.Ma() != null && (view == this.aQc.Ma().Mt() || view == this.aQc.Ma().MB())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aQc.getPageContext().getPageActivity(), KE.aar().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.aQc.Mb() != null && (view == this.aQc.Mb().Mt() || view == this.aQc.Mb().MB())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aQc.getPageContext().getPageActivity(), KE.aar().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView Ma = this.aQc.Ma();
        o Mb = this.aQc.Mb();
        if ((Ma != null && Ma.z(view)) || (Mb != null && Mb.z(view))) {
            com.baidu.tbadk.core.k.A(this.aQc.getPageContext().getPageActivity(), "forum_fortune_click");
            if (TbadkCoreApplication.isLogin()) {
                frsActivity11 = this.aQc.aPE;
                frsActivity11.KB();
            } else {
                TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
                frsActivity12 = this.aQc.aPE;
                m411getInst.login(frsActivity12.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.aQc.getPageContext().getPageActivity(), (String) null, true, 18004)));
            }
        }
        int id = view.getId();
        if (id == q.btn_love) {
            frsActivity9 = this.aQc.aPE;
            if (!frsActivity9.KF() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                frsActivity10 = this.aQc.aPE;
                if (frsActivity10.checkUpIsLogin()) {
                    this.aQc.oF();
                }
            }
        } else if (id == q.btn_sign) {
            frsActivity7 = this.aQc.aPE;
            if (!frsActivity7.KF() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                frsActivity8 = this.aQc.aPE;
                if (frsActivity8.checkUpIsLogin() && !this.aQc.Mr()) {
                    this.aQc.Mu();
                }
            }
        } else if (id == q.frs_header_groups) {
            frsActivity5 = this.aQc.aPE;
            if (frsActivity5.checkUpIsLogin() && KE != null && KE.aar() != null && !com.baidu.adp.lib.util.m.isEmpty(KE.aar().getId()) && KE.amu() != null) {
                TiebaStatic.eventStat(this.aQc.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(this.aQc.getPageContext().getPageActivity(), KE.aar().getId(), KE.amu().amn() != 1);
                frsActivity6 = this.aQc.aPE;
                frsActivity6.sendMessage(new CustomMessage(2002001, frsGroupActivityConfig));
            }
        } else if (id == q.frs_header_games) {
            frsActivity4 = this.aQc.aPE;
            if (frsActivity4.checkUpIsLogin() && KE != null && KE.amy() != null) {
                String amy = KE.amy();
                int cO = com.baidu.tbadk.core.util.q.cO(amy);
                if (cO == 2) {
                    com.baidu.tbadk.browser.f.b(this.aQc.getPageContext().getPageActivity(), null, amy, true);
                } else if (cO == 1) {
                    String jJ = com.baidu.tieba.tbadkCore.util.k.jJ(amy);
                    if (!TextUtils.isEmpty(jJ)) {
                        TiebaStatic.eventStat(this.aQc.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", jJ, "ref_id", "1000601", "ref_type", "603");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aQc.getPageContext().getPageActivity(), jJ, "1000601")));
                    }
                }
            }
        } else if (id == q.btn_love_content) {
            frsActivity2 = this.aQc.aPE;
            if (!frsActivity2.KF()) {
                frsActivity3 = this.aQc.aPE;
                if (!frsActivity3.KG()) {
                    str = this.aQc.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.aQc.mPageType;
                        if (str2.equals("frs_page")) {
                            this.aQc.y(view);
                            return;
                        }
                        return;
                    }
                    this.aQc.x(view);
                }
            }
        }
    }
}
