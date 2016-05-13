package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class dq implements View.OnClickListener {
    final /* synthetic */ dp blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(dp dpVar) {
        this.blk = dpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.v as;
        BaseActivity baseActivity;
        if (this.blk.as(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.ax) {
            String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.ax) as).getAuthor().getUserId();
            String string = TbadkCoreApplication.m11getInst().getString(t.j.user_icon_web_view_title);
            baseActivity = this.blk.bek;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").s("obj_type", 3));
        }
    }
}
