package com.baidu.tieba.forumdetail;

import com.baidu.tieba.model.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements bd {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ com.baidu.tbadk.a b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, com.baidu.tbadk.a aVar, boolean z) {
        this.a = itemFootNavView;
        this.b = aVar;
        this.c = z;
    }

    @Override // com.baidu.tieba.model.bd
    public final void a(String str, long j) {
        this.b.showToast(this.b.getString(com.baidu.tieba.a.k.unlike_success));
        this.a.a(false);
        ItemFootNavView.b(this.a, this.c);
    }

    @Override // com.baidu.tieba.model.bd
    public final void a() {
        this.b.showToast(this.b.getString(com.baidu.tieba.a.k.unlike_failure));
    }
}
