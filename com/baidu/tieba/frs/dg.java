package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class dg implements View.OnClickListener {
    final /* synthetic */ df bkM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(df dfVar) {
        this.bkM = dfVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.v at;
        BaseActivity baseActivity;
        if (this.bkM.at(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.ax) {
            String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.ax) at).getAuthor().getUserId();
            String string = TbadkCoreApplication.m11getInst().getString(t.j.user_icon_web_view_title);
            baseActivity = this.bkM.bek;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").s("obj_type", 3));
        }
    }
}
