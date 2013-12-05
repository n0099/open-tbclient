package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1497a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f1497a = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        BaseFragmentActivity baseFragmentActivity;
        String str;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        z = this.f1497a.s;
        if (z) {
            baseFragmentActivity3 = this.f1497a.f1496a;
            SignAllForumActivity.a(baseFragmentActivity3);
        } else {
            baseFragmentActivity = this.f1497a.f1496a;
            str = this.f1497a.t;
            com.baidu.adp.lib.h.g.a((Context) baseFragmentActivity, str);
        }
        baseFragmentActivity2 = this.f1497a.f1496a;
        com.baidu.tieba.ap.a(baseFragmentActivity2, "signall_enter_click");
    }
}
