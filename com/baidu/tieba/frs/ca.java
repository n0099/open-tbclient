package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bz aXQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar) {
        this.aXQ = bzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.widget.ListView.u aA;
        BaseActivity baseActivity;
        if (this.aXQ.aA(((Integer) view.getTag()).intValue()) instanceof com.baidu.tbadk.core.data.v) {
            String str = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((com.baidu.tbadk.core.data.v) aA).getAuthor().getUserId();
            String string = TbadkCoreApplication.m411getInst().getString(i.C0057i.user_icon_web_view_title);
            baseActivity = this.aXQ.aSJ;
            com.baidu.tbadk.browser.f.a(baseActivity.getApplicationContext(), string, str, true, true, false);
            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c10134").r("obj_type", 3));
        }
    }
}
