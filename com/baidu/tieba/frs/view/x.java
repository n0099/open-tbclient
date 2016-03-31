package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ u bwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.bwT = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.bwT.bvI, this.bwT.MX.getPageActivity());
        this.bwT.blH.bkb = false;
        com.baidu.tbadk.browser.f.a(this.bwT.MX.getPageActivity(), this.bwT.MX.getResources().getString(t.j.experion_speed), String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
