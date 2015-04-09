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
import com.baidu.tbadk.core.util.q;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.view.FrsHeaderView;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aNQ = aVar;
    }

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
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aNQ.getPageContext().getPageActivity());
        frsActivity = this.aNQ.aNs;
        w JA = frsActivity.JA();
        if (JA != null && JA.Za() != null) {
            if (this.aNQ.KV() != null && (view == this.aNQ.KV().Lo() || view == this.aNQ.KV().Lw())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aNQ.getPageContext().getPageActivity(), JA.Za().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.aNQ.KW() != null && (view == this.aNQ.KW().Lo() || view == this.aNQ.KW().Lw())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aNQ.getPageContext().getPageActivity(), JA.Za().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView KV = this.aNQ.KV();
        com.baidu.tieba.frs.view.o KW = this.aNQ.KW();
        if ((KV != null && KV.w(view)) || (KW != null && KW.w(view))) {
            com.baidu.tbadk.core.k.A(this.aNQ.getPageContext().getPageActivity(), "forum_fortune_click");
            if (!TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.aNQ.aNs;
                frsActivity8.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aNQ.getPageContext().getPageActivity(), (String) null, true, 18004)));
            } else {
                frsActivity7 = this.aNQ.aNs;
                frsActivity7.Jx();
            }
        }
        int id = view.getId();
        if (id == v.btn_love) {
            frsActivity6 = this.aNQ.aNs;
            if (!frsActivity6.JB() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aNQ.op();
            }
        } else if (id == v.btn_sign) {
            frsActivity5 = this.aNQ.aNs;
            if (!frsActivity5.JB() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL && !this.aNQ.Lm()) {
                this.aNQ.Lp();
            }
        } else if (id == v.frs_header_groups) {
            if (JA != null && JA.Za() != null && !com.baidu.adp.lib.util.m.isEmpty(JA.Za().getId()) && JA.akJ() != null) {
                TiebaStatic.eventStat(this.aNQ.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(this.aNQ.getPageContext().getPageActivity(), JA.Za().getId(), JA.akJ().akC() != 1);
                frsActivity4 = this.aNQ.aNs;
                frsActivity4.sendMessage(new CustomMessage(2002001, frsGroupActivityConfig));
            }
        } else if (id == v.frs_header_games) {
            if (JA != null && JA.akN() != null) {
                String akN = JA.akN();
                int cz = q.cz(akN);
                if (cz == 2) {
                    com.baidu.tbadk.browser.f.b(this.aNQ.getPageContext().getPageActivity(), null, akN, true);
                } else if (cz == 1) {
                    String iP = com.baidu.tieba.tbadkCore.util.k.iP(akN);
                    if (!TextUtils.isEmpty(iP)) {
                        TiebaStatic.eventStat(this.aNQ.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", iP, "ref_id", "1000601", "ref_type", "603");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aNQ.getPageContext().getPageActivity(), iP, "1000601")));
                    }
                }
            }
        } else if (id == v.btn_love_content) {
            frsActivity2 = this.aNQ.aNs;
            if (!frsActivity2.JB()) {
                frsActivity3 = this.aNQ.aNs;
                if (!frsActivity3.JC()) {
                    str = this.aNQ.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.aNQ.mPageType;
                        if (str2.equals("frs_page")) {
                            this.aNQ.v(view);
                            return;
                        }
                        return;
                    }
                    this.aNQ.u(view);
                }
            }
        }
    }
}
