package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.i.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bQp = frsActivity;
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
        bmVar = this.bQp.bPo;
        if (view != bmVar.abv()) {
            bmVar2 = this.bQp.bPo;
            if (view == bmVar2.abt()) {
                bmVar3 = this.bQp.bPo;
                ctVar = this.bQp.bPr;
                bmVar3.a(ctVar);
                aaVar = this.bQp.bPD;
                ctVar2 = this.bQp.bPr;
                aaVar.a(ctVar2);
                TiebaStatic.log("c10529");
                TiebaStatic.eventStat(this.bQp.getPageContext().getPageActivity(), "frs_more", "frsclick", 1, new Object[0]);
                bmVar4 = this.bQp.bPo;
                bmVar4.abD();
                FrsActivityStatic.bQB = false;
                aVar = this.bQp.bPP;
                if (aVar != null) {
                    aVar2 = this.bQp.bPP;
                    aVar2.afd();
                }
                yVar = this.bQp.bPE;
                yVar.adn();
            }
        } else {
            this.bQp.closeActivity();
        }
        view.getId();
        if (view.getId() == t.g.game_activity_egg_layout && com.baidu.adp.lib.util.k.gD()) {
            TiebaStatic.log("c10853");
            bmVar5 = this.bQp.bPo;
            if (bmVar5.abG()) {
                bmVar6 = this.bQp.bPo;
                bmVar6.abH();
                return;
            }
            String activityUrl = this.bQp.bPq.aLP().getYuleData().sQ().getActivityUrl();
            if (!StringUtils.isNull(activityUrl)) {
                com.baidu.tbadk.browser.f.v(this.bQp.getPageContext().getPageActivity(), activityUrl);
            }
        }
    }
}
