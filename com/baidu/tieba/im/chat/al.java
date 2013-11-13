package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1505a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar) {
        this.f1505a = akVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1505a.d.b(view, 5, this.f1505a.f, 0L);
        return true;
    }
}
