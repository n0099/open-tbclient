package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class k implements View.OnClickListener {
    final /* synthetic */ d bIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.bIu = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bIu.bTh;
        tbPageContext = this.bIu.Dp;
        com.baidu.adp.lib.h.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bIu.bET;
        frsActivity.bCq = false;
        tbPageContext2 = this.bIu.Dp;
        String string = tbPageContext2.getResources().getString(u.j.experion_speed);
        tbPageContext3 = this.bIu.Dp;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
