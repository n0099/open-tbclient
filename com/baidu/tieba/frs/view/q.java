package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bwi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsHeaderView frsHeaderView) {
        this.bwi = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.bwi.bvw, this.bwi.Do.getPageActivity());
        this.bwi.bjB.bgb = false;
        com.baidu.tbadk.browser.f.a(this.bwi.Do.getPageActivity(), this.bwi.Do.getResources().getString(t.j.experion_speed), String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
