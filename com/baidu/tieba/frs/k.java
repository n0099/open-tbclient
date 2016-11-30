package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.j.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        br brVar;
        com.baidu.tieba.frs.j.af afVar;
        br brVar2;
        a aVar;
        com.baidu.tieba.frs.j.w wVar;
        a aVar2;
        if (view != this.bTa.bRW.acQ()) {
            if (view == this.bTa.bRW.acO()) {
                au auVar = this.bTa.bRW;
                brVar = this.bTa.bRY;
                auVar.a(brVar);
                afVar = this.bTa.bSj;
                brVar2 = this.bTa.bRY;
                afVar.a(brVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bTa.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                this.bTa.bRW.acZ();
                FrsActivityStatic.bTg = false;
                aVar = this.bTa.bSx;
                if (aVar != null) {
                    aVar2 = this.bTa.bSx;
                    aVar2.ahb();
                }
                wVar = this.bTa.bSk;
                wVar.aeS();
            }
        } else {
            this.bTa.closeActivity();
        }
        if (view.getId() == r.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10853");
            if (this.bTa.bRW.adb()) {
                this.bTa.bRW.adc();
                return;
            }
            String activityUrl = this.bTa.bRX.aOk().getYuleData().tj().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.v(this.bTa.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
