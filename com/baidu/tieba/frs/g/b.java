package com.baidu.tieba.frs.g;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a btu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.btu = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v at;
        BaseActivity baseActivity;
        if (this.btu.at(((Integer) view.getTag()).intValue()) instanceof ax) {
            String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((ax) at).getAuthor().getUserId();
            String string = TbadkCoreApplication.m11getInst().getString(t.j.user_icon_web_view_title);
            baseActivity = this.btu.bek;
            f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new aw("c10134").s("obj_type", 3));
        }
    }
}
