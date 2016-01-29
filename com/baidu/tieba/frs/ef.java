package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ef implements View.OnClickListener {
    final /* synthetic */ ee blm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(ee eeVar) {
        this.blm = eeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aG;
        BaseActivity baseActivity;
        if (this.blm.aG(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.ah) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.ah) aG).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title);
            baseActivity = this.blm.bdK;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10134").r("obj_type", 3));
        }
    }
}
