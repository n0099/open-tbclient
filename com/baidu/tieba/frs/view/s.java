package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bkX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar) {
        this.bkX = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.h.j.a(this.bkX.bjW, this.bkX.mContext.getPageActivity());
        this.bkX.baC.aZe = false;
        com.baidu.tbadk.browser.f.a(this.bkX.mContext.getPageActivity(), this.bkX.mContext.getResources().getString(n.i.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
