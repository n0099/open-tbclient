package com.baidu.tieba.forumdetail;

import com.baidu.tieba.model.cg;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements cg {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ItemFootNavView f1090a;
    private final /* synthetic */ com.baidu.tieba.j b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar, boolean z) {
        this.f1090a = itemFootNavView;
        this.b = jVar;
        this.c = z;
    }

    @Override // com.baidu.tieba.model.cg
    public void a(String str, long j) {
        this.b.a(this.b.getString(R.string.unlike_success));
        this.f1090a.b(false);
        this.f1090a.a(this.c);
    }

    @Override // com.baidu.tieba.model.cg
    public void b(String str, long j) {
        this.b.a(this.b.getString(R.string.unlike_failure));
    }
}
