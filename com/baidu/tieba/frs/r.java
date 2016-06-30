package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bq bqVar;
        bq bqVar2;
        bq bqVar3;
        cx cxVar;
        com.baidu.tieba.frs.i.aa aaVar;
        cx cxVar2;
        bq bqVar4;
        com.baidu.tieba.frs.i.y yVar;
        bq bqVar5;
        com.baidu.tieba.tbadkCore.p pVar;
        bq bqVar6;
        bqVar = this.bDB.bCD;
        if (view != bqVar.Wi()) {
            bqVar2 = this.bDB.bCD;
            if (view == bqVar2.Wg()) {
                bqVar3 = this.bDB.bCD;
                cxVar = this.bDB.bCG;
                bqVar3.a(cxVar);
                aaVar = this.bDB.bCS;
                cxVar2 = this.bDB.bCG;
                aaVar.a(cxVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bDB.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                bqVar4 = this.bDB.bCD;
                bqVar4.Wq();
                FrsActivityStatic.bDN = false;
                yVar = this.bDB.bCT;
                yVar.Yh();
            }
        } else {
            this.bDB.closeActivity();
        }
        view.getId();
        if (view.getId() == u.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.fI()) {
            TiebaStatic.log("c10853");
            bqVar5 = this.bDB.bCD;
            if (bqVar5.Wt()) {
                bqVar6 = this.bDB.bCD;
                bqVar6.Wu();
                return;
            }
            pVar = this.bDB.bCF;
            String activityUrl = pVar.aDN().getYuleData().rM().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.v(this.bDB.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
