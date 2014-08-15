package com.baidu.tieba.forumdetail;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.model.bg;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bg {
    final /* synthetic */ ItemFootNavView a;
    private final /* synthetic */ BaseActivity b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ItemFootNavView itemFootNavView, BaseActivity baseActivity, boolean z) {
        this.a = itemFootNavView;
        this.b = baseActivity;
        this.c = z;
    }

    @Override // com.baidu.tieba.model.bg
    public void a(String str, long j) {
        this.b.showToast(this.b.getString(x.unlike_success));
        this.a.b(false);
        this.a.a(this.c);
    }

    @Override // com.baidu.tieba.model.bg
    public void b(String str, long j) {
        this.b.showToast(this.b.getString(x.unlike_failure));
    }
}
