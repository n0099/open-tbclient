package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bwy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsHeaderView frsHeaderView) {
        this.bwy = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.bwy.bvI, this.bwy.MX.getPageActivity());
        this.bwy.blH.bkb = false;
        com.baidu.tbadk.browser.f.a(this.bwy.MX.getPageActivity(), this.bwy.MX.getResources().getString(t.j.experion_speed), String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
