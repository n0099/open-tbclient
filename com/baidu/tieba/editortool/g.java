package com.baidu.tieba.editortool;

import android.app.Activity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.bubble.s {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.bubble.s
    public void a(int i) {
        this.a.a.b(i);
        TbWebViewActivity.startActivityForResult((Activity) this.a.d, TbadkApplication.m252getInst().getString(com.baidu.tieba.y.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.e.a) + "mo/q/tbeantshow?_client_version=" + TbConfig.getVersion(), true, false, true, true, null, 23004);
    }

    @Override // com.baidu.tieba.bubble.s
    public void a() {
    }
}
