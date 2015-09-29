package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements View.OnClickListener {
    final /* synthetic */ dp aYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(dp dpVar) {
        this.aYq = dpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aA;
        if (this.aYq.aA(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.v) {
            com.baidu.tbadk.browser.g.a(this.aYq.aRT.getApplicationContext(), TbadkCoreApplication.m411getInst().getString(i.h.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.v) aA).getAuthor().getUserId(), true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c10134").r("obj_type", 3));
        }
    }
}
