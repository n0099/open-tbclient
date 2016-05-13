package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class es implements View.OnClickListener {
    final /* synthetic */ er bmg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(er erVar) {
        this.bmg = erVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.v as;
        if (this.bmg.as(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.ax) {
            com.baidu.tbadk.browser.f.a(this.bmg.bek.getApplicationContext(), TbadkCoreApplication.m11getInst().getString(t.j.user_icon_web_view_title), String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.ax) as).getAuthor().getUserId(), true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").s("obj_type", 3));
        }
    }
}
