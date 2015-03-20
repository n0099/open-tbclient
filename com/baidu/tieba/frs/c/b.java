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
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aNz = aVar;
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
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.aNz.getPageContext().getPageActivity());
        frsActivity = this.aNz.aNb;
        w Ju = frsActivity.Ju();
        if (Ju != null && Ju.YO() != null) {
            if (this.aNz.KJ() != null && (view == this.aNz.KJ().Lc() || view == this.aNz.KJ().Lk())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aNz.getPageContext().getPageActivity(), Ju.YO().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            } else if (this.aNz.KK() != null && (view == this.aNz.KK().Lc() || view == this.aNz.KK().Lk())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(this.aNz.getPageContext().getPageActivity(), Ju.YO().getId(), ForumDetailActivityConfig.FromType.FRS)));
                return;
            }
        }
        FrsHeaderView KJ = this.aNz.KJ();
        com.baidu.tieba.frs.view.o KK = this.aNz.KK();
        if ((KJ != null && KJ.w(view)) || (KK != null && KK.w(view))) {
            com.baidu.tbadk.core.k.A(this.aNz.getPageContext().getPageActivity(), "forum_fortune_click");
            if (!TbadkCoreApplication.isLogin()) {
                frsActivity8 = this.aNz.aNb;
                frsActivity8.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aNz.getPageContext().getPageActivity(), (String) null, true, 18004)));
            } else {
                frsActivity7 = this.aNz.aNb;
                frsActivity7.Jr();
            }
        }
        int id = view.getId();
        if (id == v.btn_love) {
            frsActivity6 = this.aNz.aNb;
            if (!frsActivity6.Jv() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL) {
                this.aNz.op();
            }
        } else if (id == v.btn_sign) {
            frsActivity5 = this.aNz.aNb;
            if (!frsActivity5.Jv() && netStatusInfo != UtilHelper.NetworkStateInfo.UNAVAIL && !this.aNz.La()) {
                this.aNz.Ld();
            }
        } else if (id == v.frs_header_groups) {
            if (Ju != null && Ju.YO() != null && !com.baidu.adp.lib.util.m.isEmpty(Ju.YO().getId()) && Ju.aku() != null) {
                TiebaStatic.eventStat(this.aNz.getPageContext().getPageActivity(), "im_e_glist_from_frs", "click", 1, new Object[0]);
                FrsGroupActivityConfig frsGroupActivityConfig = new FrsGroupActivityConfig(this.aNz.getPageContext().getPageActivity(), Ju.YO().getId(), Ju.aku().akn() != 1);
                frsActivity4 = this.aNz.aNb;
                frsActivity4.sendMessage(new CustomMessage(2002001, frsGroupActivityConfig));
            }
        } else if (id == v.frs_header_games) {
            if (Ju != null && Ju.aky() != null) {
                String aky = Ju.aky();
                int cz = q.cz(aky);
                if (cz == 2) {
                    com.baidu.tbadk.browser.f.b(this.aNz.getPageContext().getPageActivity(), null, aky, true);
                } else if (cz == 1) {
                    String iM = com.baidu.tieba.tbadkCore.util.k.iM(aky);
                    if (!TextUtils.isEmpty(iM)) {
                        TiebaStatic.eventStat(this.aNz.getPageContext().getPageActivity(), "frs_ourgame", "click", 1, "dev_id", iM, "ref_id", "1000601", "ref_type", "603");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GameDetailActivityConfig(this.aNz.getPageContext().getPageActivity(), iM, "1000601")));
                    }
                }
            }
        } else if (id == v.btn_love_content) {
            frsActivity2 = this.aNz.aNb;
            if (!frsActivity2.Jv()) {
                frsActivity3 = this.aNz.aNb;
                if (!frsActivity3.Jw()) {
                    str = this.aNz.mPageType;
                    if (!str.equals("normal_page")) {
                        str2 = this.aNz.mPageType;
                        if (str2.equals("frs_page")) {
                            this.aNz.v(view);
                            return;
                        }
                        return;
                    }
                    this.aNz.u(view);
                }
            }
        }
    }
}
