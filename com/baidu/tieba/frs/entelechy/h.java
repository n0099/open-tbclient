package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ c cfN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.cfN = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        r rVar;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.cfN.cqI;
        tbPageContext = this.cfN.aat;
        com.baidu.adp.lib.g.j.a(popupWindow, tbPageContext.getPageActivity());
        rVar = this.cfN.cdv;
        rVar.cbW = false;
        tbPageContext2 = this.cfN.aat;
        String string = tbPageContext2.getResources().getString(w.l.experion_speed);
        tbPageContext3 = this.cfN.aat;
        com.baidu.tbadk.browser.g.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
