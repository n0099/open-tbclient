package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ o aRB;
    private final /* synthetic */ PopupWindow aRx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PopupWindow popupWindow) {
        this.aRB = oVar;
        this.aRx = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRx.dismiss();
        this.aRB.aMl.aLa = false;
        com.baidu.tbadk.browser.f.a(this.aRB.LH.getPageActivity(), this.aRB.LH.getResources().getString(com.baidu.tieba.t.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
