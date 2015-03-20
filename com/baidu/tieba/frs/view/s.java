package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    private final /* synthetic */ PopupWindow aOV;
    final /* synthetic */ o aOZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PopupWindow popupWindow) {
        this.aOZ = oVar;
        this.aOV = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aOV.dismiss();
        com.baidu.tbadk.browser.f.a(this.aOZ.LN.getPageActivity(), this.aOZ.LN.getResources().getString(y.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
