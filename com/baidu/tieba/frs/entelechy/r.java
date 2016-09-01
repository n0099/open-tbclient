package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ j bVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.bVn = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bVn.cgq;
        tbPageContext = this.bVn.Gd;
        com.baidu.adp.lib.h.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bVn.bRp;
        frsActivity.bPb = false;
        tbPageContext2 = this.bVn.Gd;
        String string = tbPageContext2.getResources().getString(t.j.experion_speed);
        tbPageContext3 = this.bVn.Gd;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
