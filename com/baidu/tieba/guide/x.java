package com.baidu.tieba.guide;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x extends com.baidu.adp.a.h {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        if (obj != null && (obj instanceof com.baidu.tieba.data.z)) {
            int a = com.baidu.adp.lib.f.b.a(((com.baidu.tieba.data.z) obj).a(), 0);
            aVar = this.a.c;
            aVar.a(a);
            this.a.a(a, true);
            newUserGuideActivity = this.a.a;
            newUserGuideActivity.b(true);
            newUserGuideActivity2 = this.a.a;
            newUserGuideActivity2.a(true);
        }
    }
}
