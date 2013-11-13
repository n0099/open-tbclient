package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1506a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.f1506a = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1506a.c.a(view, 4, this.f1506a.f, 0L);
    }
}
