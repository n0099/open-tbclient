package com.baidu.tieba.im.chat;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ak f1507a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.f1507a = akVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1507a.d.b(view, 4, this.f1507a.f, 0L);
        return true;
    }
}
