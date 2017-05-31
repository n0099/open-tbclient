package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ c bXE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bXE = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        r rVar;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bXE.ciI;
        tbPageContext = this.bXE.aas;
        com.baidu.adp.lib.g.j.a(popupWindow, tbPageContext.getPageActivity());
        rVar = this.bXE.bVm;
        rVar.bTN = false;
        tbPageContext2 = this.bXE.aas;
        String string = tbPageContext2.getResources().getString(w.l.experion_speed);
        tbPageContext3 = this.bXE.aas;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
