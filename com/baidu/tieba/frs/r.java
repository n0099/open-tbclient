package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.j.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        cx cxVar;
        com.baidu.tieba.frs.j.aa aaVar;
        cx cxVar2;
        bq bqVar4;
        a aVar;
        com.baidu.tieba.frs.j.y yVar;
        a aVar2;
        bq bqVar5;
        bq bqVar6;
        bqVar = this.bEL.bDK;
        if (view != bqVar.Wz()) {
            bqVar2 = this.bEL.bDK;
            if (view == bqVar2.Wx()) {
                bqVar3 = this.bEL.bDK;
                cxVar = this.bEL.bDN;
                bqVar3.a(cxVar);
                aaVar = this.bEL.bDZ;
                cxVar2 = this.bEL.bDN;
                aaVar.a(cxVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bEL.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                bqVar4 = this.bEL.bDK;
                bqVar4.WH();
                FrsActivityStatic.bEX = false;
                aVar = this.bEL.bEl;
                if (aVar != null) {
                    aVar2 = this.bEL.bEl;
                    aVar2.aas();
                }
                yVar = this.bEL.bEa;
                yVar.YB();
            }
        } else {
            this.bEL.closeActivity();
        }
        view.getId();
        if (view.getId() == u.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.fH()) {
            TiebaStatic.log("c10853");
            bqVar5 = this.bEL.bDK;
            if (bqVar5.WK()) {
                bqVar6 = this.bEL.bDK;
                bqVar6.WL();
                return;
            }
            String activityUrl = this.bEL.bDM.aGX().getYuleData().rL().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.v(this.bEL.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
