package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ j bYo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(j jVar) {
        this.bYo = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bYo.clt;
        tbPageContext = this.bYo.Gf;
        com.baidu.adp.lib.h.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bYo.bTA;
        frsActivity.bRJ = false;
        tbPageContext2 = this.bYo.Gf;
        String string = tbPageContext2.getResources().getString(r.j.experion_speed);
        tbPageContext3 = this.bYo.Gf;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
