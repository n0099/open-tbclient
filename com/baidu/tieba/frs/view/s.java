package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bdN;
    private final /* synthetic */ PopupWindow bdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, PopupWindow popupWindow) {
        this.bdN = qVar;
        this.bdv = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.g.j.a(this.bdv, this.bdN.mContext.getPageActivity());
        this.bdN.aVf.aTI = false;
        com.baidu.tbadk.browser.g.a(this.bdN.mContext.getPageActivity(), this.bdN.mContext.getResources().getString(i.h.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
