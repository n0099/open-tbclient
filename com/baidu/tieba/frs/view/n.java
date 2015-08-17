package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bcU;
    private final /* synthetic */ PopupWindow bcV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.bcU = frsHeaderView;
        this.bcV = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.g.j.a(this.bcV, this.bcU.LS.getPageActivity());
        this.bcU.aVx.aUn = false;
        com.baidu.tbadk.browser.f.a(this.bcU.LS.getPageActivity(), this.bcU.LS.getResources().getString(i.C0057i.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
