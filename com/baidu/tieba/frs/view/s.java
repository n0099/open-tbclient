package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ o aRA;
    private final /* synthetic */ PopupWindow aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PopupWindow popupWindow) {
        this.aRA = oVar;
        this.aRw = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRw.dismiss();
        this.aRA.aMk.aKZ = false;
        com.baidu.tbadk.browser.f.a(this.aRA.LH.getPageActivity(), this.aRA.LH.getResources().getString(com.baidu.tieba.t.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
