package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements View.OnClickListener {
    final /* synthetic */ dm bhW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dm dmVar) {
        this.bhW = dmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u au;
        BaseActivity baseActivity;
        if (this.bhW.au(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.z) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.z) au).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(n.j.user_icon_web_view_title);
            baseActivity = this.bhW.bbA;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.av("c10134").r("obj_type", 3));
        }
    }
}
