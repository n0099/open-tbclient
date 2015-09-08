package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    private final /* synthetic */ PopupWindow bdq;
    final /* synthetic */ p bdt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, PopupWindow popupWindow) {
        this.bdt = pVar;
        this.bdq = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.g.j.a(this.bdq, this.bdt.mContext.getPageActivity());
        this.bdt.aVM.aUB = false;
        com.baidu.tbadk.browser.g.a(this.bdt.mContext.getPageActivity(), this.bdt.mContext.getResources().getString(i.h.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
