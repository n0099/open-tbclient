package com.baidu.tieba.forumdetail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.j f1282a;
    final /* synthetic */ ItemFootNavView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar) {
        this.b = itemFootNavView;
        this.f1282a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.b(this.f1282a);
    }
}
