package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ e bJY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.bJY = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bJY.bVh;
        tbPageContext = this.bJY.DQ;
        com.baidu.adp.lib.h.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bJY.bGh;
        frsActivity.bDx = false;
        tbPageContext2 = this.bJY.DQ;
        String string = tbPageContext2.getResources().getString(u.j.experion_speed);
        tbPageContext3 = this.bJY.DQ;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
