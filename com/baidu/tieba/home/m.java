package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
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
            com.baidu.adp.lib.g.g.a((Context) baseFragmentActivity, str);
        }
        baseFragmentActivity2 = this.a.a;
        com.baidu.tieba.ao.a(baseFragmentActivity2, "signall_enter_click");
    }
}
