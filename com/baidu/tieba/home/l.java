package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        String str;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        z = this.a.s;
        if (z) {
            baseFragmentActivity3 = this.a.a;
            SignAllForumActivity.a(baseFragmentActivity3);
        } else {
            baseFragmentActivity = this.a.a;
            str = this.a.t;
            com.baidu.adp.lib.h.g.a((Context) baseFragmentActivity, str);
        }
        baseFragmentActivity2 = this.a.a;
        com.baidu.tieba.ao.a(baseFragmentActivity2, "signall_enter_click");
    }
}
