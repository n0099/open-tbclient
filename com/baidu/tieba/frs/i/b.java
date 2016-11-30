package com.baidu.tieba.frs.i;

import android.view.View;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cie;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cie = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        v aJ;
        BaseActivity baseActivity;
        if (this.cie.aJ(((Integer) view.getTag()).intValue()) instanceof bk) {
            String str = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon?user_id=" + ((bk) aJ).getAuthor().getUserId();
            String string = TbadkCoreApplication.m9getInst().getString(r.j.user_icon_web_view_title);
            baseActivity = this.cie.aTb;
            f.a(baseActivity.getApplicationContext(), string, str, true, true, true);
            TiebaStatic.log(new av("c10134").s("obj_type", 3));
        }
    }
}
