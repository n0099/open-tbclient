package com.baidu.tieba.guide;

import com.baidu.tieba.model.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements bd {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.tieba.model.bd
    public void a(String str, long j) {
        a aVar;
        int a = com.baidu.adp.lib.f.b.a(String.valueOf(j), 0);
        aVar = this.a.c;
        aVar.b(a);
        this.a.a(a, false);
    }

    @Override // com.baidu.tieba.model.bd
    public void b(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.a.a;
        newUserGuideActivity.c(com.baidu.tieba.u.error);
    }
}
