package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ c bRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bRN = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        r rVar;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bRN.ccu;
        tbPageContext = this.bRN.aat;
        com.baidu.adp.lib.g.j.a(popupWindow, tbPageContext.getPageActivity());
        rVar = this.bRN.bPw;
        rVar.bOa = false;
        tbPageContext2 = this.bRN.aat;
        String string = tbPageContext2.getResources().getString(w.l.experion_speed);
        tbPageContext3 = this.bRN.aat;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
