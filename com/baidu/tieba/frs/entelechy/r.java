package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ j bEc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.bEc = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bEc.bQE;
        tbPageContext = this.bEc.Gf;
        com.baidu.adp.lib.h.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bEc.bzH;
        frsActivity.bxU = false;
        tbPageContext2 = this.bEc.Gf;
        String string = tbPageContext2.getResources().getString(r.j.experion_speed);
        tbPageContext3 = this.bEc.Gf;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
