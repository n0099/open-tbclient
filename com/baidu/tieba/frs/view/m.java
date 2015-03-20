package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aOU;
    private final /* synthetic */ PopupWindow aOV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.aOU = frsHeaderView;
        this.aOV = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aOV.dismiss();
        com.baidu.tbadk.browser.f.a(this.aOU.LN.getPageActivity(), this.aOU.LN.getResources().getString(y.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
