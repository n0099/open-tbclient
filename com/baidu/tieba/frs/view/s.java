package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q boO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.boO = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.boO.bnN, this.boO.mContext.getPageActivity());
        this.boO.beB.bda = false;
        com.baidu.tbadk.browser.f.a(this.boO.mContext.getPageActivity(), this.boO.mContext.getResources().getString(n.j.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
