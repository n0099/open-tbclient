package com.baidu.tieba.forumdetail;

import com.baidu.tieba.model.by;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements by {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ com.baidu.tieba.f b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, com.baidu.tieba.f fVar, boolean z) {
        this.a = itemFootNavView;
        this.b = fVar;
        this.c = z;
    }

    @Override // com.baidu.tieba.model.by
    public void a(String str, long j) {
        this.b.showToast(this.b.getString(R.string.unlike_success));
        this.a.b(false);
        this.a.a(this.c);
    }

    @Override // com.baidu.tieba.model.by
    public void b(String str, long j) {
        this.b.showToast(this.b.getString(R.string.unlike_failure));
    }
}
