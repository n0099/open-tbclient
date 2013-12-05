package com.baidu.tieba.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f1085a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f1085a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1085a.b = ((g) view.getTag()).c;
        this.f1085a.notifyDataSetChanged();
    }
}
