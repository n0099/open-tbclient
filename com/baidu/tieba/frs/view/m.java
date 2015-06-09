package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView aRw;
    private final /* synthetic */ PopupWindow aRx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.aRw = frsHeaderView;
        this.aRx = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aRx.dismiss();
        this.aRw.aMl.aLa = false;
        com.baidu.tbadk.browser.f.a(this.aRw.LH.getPageActivity(), this.aRw.LH.getResources().getString(com.baidu.tieba.t.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
