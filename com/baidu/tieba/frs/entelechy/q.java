package com.baidu.tieba.frs.entelechy;

import android.view.View;
import android.widget.PopupWindow;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ j bRu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(j jVar) {
        this.bRu = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PopupWindow popupWindow;
        TbPageContext tbPageContext;
        FrsActivity frsActivity;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        popupWindow = this.bRu.cdg;
        tbPageContext = this.bRu.aaX;
        com.baidu.adp.lib.g.j.a(popupWindow, tbPageContext.getPageActivity());
        frsActivity = this.bRu.bOf;
        frsActivity.bMq = false;
        tbPageContext2 = this.bRu.aaX;
        String string = tbPageContext2.getResources().getString(w.l.experion_speed);
        tbPageContext3 = this.bRu.aaX;
        com.baidu.tbadk.browser.f.a(tbPageContext3.getPageActivity(), string, String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
    }
}
