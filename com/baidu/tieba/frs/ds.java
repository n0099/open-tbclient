package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements View.OnClickListener {
    final /* synthetic */ dr aYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dr drVar) {
        this.aYN = drVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aA;
        if (this.aYN.aA(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.w) {
            com.baidu.tbadk.browser.g.a(this.aYN.aSm.getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.w) aA).getAuthor().getUserId(), true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c10134").r("obj_type", 3));
        }
    }
}
