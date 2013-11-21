package com.baidu.tieba.forumdetail;

import com.baidu.tieba.model.ck;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ck {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.j f1285a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ItemFootNavView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar, boolean z) {
        this.c = itemFootNavView;
        this.f1285a = jVar;
        this.b = z;
    }

    @Override // com.baidu.tieba.model.ck
    public void a(String str, long j) {
        this.f1285a.showToast(this.f1285a.getString(R.string.unlike_success));
        this.c.b(false);
        this.c.a(this.b);
    }

    @Override // com.baidu.tieba.model.ck
    public void b(String str, long j) {
        this.f1285a.showToast(this.f1285a.getString(R.string.unlike_failure));
    }
}
