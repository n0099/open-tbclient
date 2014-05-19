package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bd {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ BaseActivity b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, BaseActivity baseActivity, boolean z) {
        this.a = itemFootNavView;
        this.b = baseActivity;
        this.c = z;
    }

    @Override // com.baidu.tieba.model.bd
    public void a(String str, long j) {
        this.b.showToast(this.b.getString(u.unlike_success));
        this.a.b(false);
        this.a.a(this.c);
    }

    @Override // com.baidu.tieba.model.bd
    public void b(String str, long j) {
        this.b.showToast(this.b.getString(u.unlike_failure));
    }
}
