package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class n implements View.OnClickListener {
    final /* synthetic */ FrsHeaderView bdZ;
    private final /* synthetic */ PopupWindow bea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsHeaderView frsHeaderView, PopupWindow popupWindow) {
        this.bdZ = frsHeaderView;
        this.bea = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.g.j.a(this.bea, this.bdZ.mContext.getPageActivity());
        this.bdZ.aVn.aTQ = false;
        com.baidu.tbadk.browser.g.a(this.bdZ.mContext.getPageActivity(), this.bdZ.mContext.getResources().getString(i.h.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
