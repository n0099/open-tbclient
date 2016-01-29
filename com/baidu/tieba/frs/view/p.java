package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView brq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsHeaderView frsHeaderView) {
        this.brq = frsHeaderView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.brq.bqF, this.brq.MR.getPageActivity());
        this.brq.bgW.bfr = false;
        com.baidu.tbadk.browser.f.a(this.brq.MR.getPageActivity(), this.brq.MR.getResources().getString(t.j.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
