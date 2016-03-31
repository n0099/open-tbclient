package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class fb implements View.OnClickListener {
    final /* synthetic */ fa bqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(fa faVar) {
        this.bqT = faVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aF;
        if (this.bqT.aF(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.as) {
            com.baidu.tbadk.browser.f.a(this.bqT.bix.getApplicationContext(), TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.as) aF).getAuthor().getUserId(), true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").r("obj_type", 3));
        }
    }
}
