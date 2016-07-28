package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bSW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bSW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v aw;
        BaseActivity baseActivity;
        if (this.bSW.aw(((Integer) view.getTag()).intValue()) instanceof be) {
            String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((be) aw).getAuthor().getUserId();
            String string = TbadkCoreApplication.m10getInst().getString(u.j.user_icon_web_view_title);
            baseActivity = this.bSW.bem;
            f.a(baseActivity.getApplicationContext(), string, str, true, true, true);
            TiebaStatic.log(new ay("c10134").s("obj_type", 3));
        }
    }
}
