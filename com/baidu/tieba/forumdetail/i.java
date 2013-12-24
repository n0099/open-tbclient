package com.baidu.tieba.forumdetail;

import com.baidu.tieba.model.cj;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements cj {
    final /* synthetic */ com.baidu.tieba.j a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ItemFootNavView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, com.baidu.tieba.j jVar, boolean z) {
        this.c = itemFootNavView;
        this.a = jVar;
        this.b = z;
    }

    @Override // com.baidu.tieba.model.cj
    public void a(String str, long j) {
        this.a.showToast(this.a.getString(R.string.unlike_success));
        this.c.b(false);
        this.c.a(this.b);
    }

    @Override // com.baidu.tieba.model.cj
    public void b(String str, long j) {
        this.a.showToast(this.a.getString(R.string.unlike_failure));
    }
}
