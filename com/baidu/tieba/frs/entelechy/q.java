package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ j bTL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(j jVar) {
        this.bTL = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bTL.cfx;
        tbPageContext = this.bTL.aaY;
        com.baidu.adp.lib.g.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bTL.bQw;
        frsActivity.bOH = false;
        tbPageContext2 = this.bTL.aaY;
        String string = tbPageContext2.getResources().getString(w.l.experion_speed);
        tbPageContext3 = this.bTL.aaY;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
