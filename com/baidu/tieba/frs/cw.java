package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements View.OnClickListener {
    final /* synthetic */ cv bdx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cv cvVar) {
        this.bdx = cvVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aB;
        BaseActivity baseActivity;
        if (this.bdx.aB(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.z) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.z) aB).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(n.i.user_icon_web_view_title);
            baseActivity = this.bdx.aXA;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10134").r("obj_type", 3));
        }
    }
}
