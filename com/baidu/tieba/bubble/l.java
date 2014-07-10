package com.baidu.tieba.bubble;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class l implements View.OnClickListener {
    final /* synthetic */ k a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Activity activity) {
        this.a = kVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.adp.lib.guide.d dVar;
        com.baidu.adp.lib.guide.d dVar2;
        dVar = h.a;
        if (dVar != null) {
            dVar2 = h.a;
            dVar2.a();
        }
        TbWebViewActivity.startActivityForResult(this.b, TbadkApplication.m252getInst().getString(y.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeantshow?_client_version=" + TbConfig.getVersion(), true, false, true, true, null, 23004);
    }
}
