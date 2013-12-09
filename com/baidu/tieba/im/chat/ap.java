package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ an f1547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar) {
        this.f1547a = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1547a.c.a(view, 4, this.f1547a.f, 0L);
    }
}
