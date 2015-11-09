package com.baidu.tieba.frs.view;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    private final /* synthetic */ PopupWindow bea;
    final /* synthetic */ q bes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, PopupWindow popupWindow) {
        this.bes = qVar;
        this.bea = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.g.j.a(this.bea, this.bes.mContext.getPageActivity());
        this.bes.aVn.aTQ = false;
        com.baidu.tbadk.browser.g.a(this.bes.mContext.getPageActivity(), this.bes.mContext.getResources().getString(i.h.experion_speed), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
