package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsActivity bhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bhl = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cn cnVar;
        cn cnVar2;
        cn cnVar3;
        cn cnVar4;
        ed edVar;
        com.baidu.tieba.frs.h.y yVar;
        ed edVar2;
        cn cnVar5;
        com.baidu.tieba.frs.h.w wVar;
        cn cnVar6;
        com.baidu.tieba.tbadkCore.o oVar;
        cn cnVar7;
        cn cnVar8;
        cn cnVar9;
        cn cnVar10;
        cnVar = this.bhl.bgo;
        if (view != cnVar.QI()) {
            cnVar2 = this.bhl.bgo;
            if (view != cnVar2.QK()) {
                cnVar3 = this.bhl.bgo;
                if (view == cnVar3.QJ()) {
                    cnVar4 = this.bhl.bgo;
                    edVar = this.bhl.bgr;
                    cnVar4.a(edVar);
                    yVar = this.bhl.bgF;
                    edVar2 = this.bhl.bgr;
                    yVar.a(edVar2);
                    TiebaStatic.log("c10529");
                    TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                    cnVar5 = this.bhl.bgo;
                    cnVar5.QU();
                    FrsActivityStatic.bhF = false;
                    wVar = this.bhl.bgG;
                    wVar.SG();
                }
            } else {
                this.bhl.closeActivity();
            }
        } else {
            TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_post_thread", "frsclick", 1, new Object[0]);
            b.sR().putBoolean(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + "frs_write_has_click", true);
            cnVar10 = this.bhl.bgo;
            cnVar10.QF();
            this.bhl.PP();
        }
        if (view.getId() == t.g.refresh_layout) {
            TiebaStatic.eventStat(this.bhl.getPageContext().getPageActivity(), "frs_refresh", "frsclick", 1, new Object[0]);
            cnVar8 = this.bhl.bgo;
            if (!cnVar8.Qa()) {
                cnVar9 = this.bhl.bgo;
                cnVar9.jy();
            } else {
                return;
            }
        }
        if (view.getId() == t.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.fH()) {
            TiebaStatic.log("c10853");
            cnVar6 = this.bhl.bgo;
            if (cnVar6.QX()) {
                cnVar7 = this.bhl.bgo;
                cnVar7.QY();
                return;
            }
            oVar = this.bhl.bgq;
            String activityUrl = oVar.avD().getYuleData().rP().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.u(this.bhl.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
