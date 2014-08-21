package com.baidu.tieba.guide;

import com.baidu.tieba.model.bg;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements bg {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.tieba.model.bg
    public void a(String str, long j) {
        a aVar;
        int a = com.baidu.adp.lib.e.c.a(String.valueOf(j), 0);
        aVar = this.a.c;
        aVar.b(a);
        this.a.a(a, false);
    }

    @Override // com.baidu.tieba.model.bg
    public void b(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.a.a;
        newUserGuideActivity.c(x.error);
    }
}
