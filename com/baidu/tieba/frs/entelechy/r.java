package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ j bRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.bRF = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bRF.ceG;
        tbPageContext = this.bRF.aaI;
        com.baidu.adp.lib.g.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bRF.bOq;
        frsActivity.bMA = false;
        tbPageContext2 = this.bRF.aaI;
        String string = tbPageContext2.getResources().getString(w.l.experion_speed);
        tbPageContext3 = this.bRF.aaI;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
