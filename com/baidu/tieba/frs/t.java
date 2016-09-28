package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.i.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        ct ctVar;
        com.baidu.tieba.frs.i.aa aaVar;
        ct ctVar2;
        bm bmVar4;
        a aVar;
        com.baidu.tieba.frs.i.y yVar;
        a aVar2;
        bm bmVar5;
        bm bmVar6;
        bmVar = this.bQi.bPi;
        if (view != bmVar.abH()) {
            bmVar2 = this.bQi.bPi;
            if (view == bmVar2.abF()) {
                bmVar3 = this.bQi.bPi;
                ctVar = this.bQi.bPl;
                bmVar3.a(ctVar);
                aaVar = this.bQi.bPv;
                ctVar2 = this.bQi.bPl;
                aaVar.a(ctVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bQi.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                bmVar4 = this.bQi.bPi;
                bmVar4.abQ();
                FrsActivityStatic.bQu = false;
                aVar = this.bQi.bPI;
                if (aVar != null) {
                    aVar2 = this.bQi.bPI;
                    aVar2.afr();
                }
                yVar = this.bQi.bPw;
                yVar.adB();
            }
        } else {
            this.bQi.closeActivity();
        }
        if (view.getId() == r.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10853");
            bmVar5 = this.bQi.bPi;
            if (bmVar5.abT()) {
                bmVar6 = this.bQi.bPi;
                bmVar6.abU();
                return;
            }
            String activityUrl = this.bQi.bPk.aMr().getYuleData().tf().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.v(this.bQi.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
