package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ t brL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.brL = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.brL.bqF, this.brL.MR.getPageActivity());
        this.brL.bgW.bfr = false;
        com.baidu.tbadk.browser.f.a(this.brL.MR.getPageActivity(), this.brL.MR.getResources().getString(t.j.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
