package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dy implements View.OnClickListener {
    final /* synthetic */ dx bqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dy(dx dxVar) {
        this.bqd = dxVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aF;
        BaseActivity baseActivity;
        if (this.bqd.aF(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.as) {
            String str = String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.as) aF).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title);
            baseActivity = this.bqd.bix;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.aw("c10134").r("obj_type", 3));
        }
    }
}
