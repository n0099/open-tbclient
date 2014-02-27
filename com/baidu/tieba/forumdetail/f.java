package com.baidu.tieba.forumdetail;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements View.OnClickListener {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ com.baidu.tieba.f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ItemFootNavView itemFootNavView, com.baidu.tieba.f fVar) {
        this.a = itemFootNavView;
        this.b = fVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.b(this.b);
    }
}
