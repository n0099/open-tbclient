package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements View.OnClickListener {
    final /* synthetic */ dr bkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dr drVar) {
        this.bkO = drVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aG;
        BaseActivity baseActivity;
        if (this.bkO.aG(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.ah) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.ah) aG).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(t.j.user_icon_web_view_title);
            baseActivity = this.bkO.bdK;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c10134").r("obj_type", 3));
        }
    }
}
