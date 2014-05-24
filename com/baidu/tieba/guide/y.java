package com.baidu.tieba.guide;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.base.e {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.a = xVar;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        if (obj == null) {
            newUserGuideActivity3 = this.a.a;
            newUserGuideActivity3.c(com.baidu.tieba.y.neterror);
        } else if (obj instanceof com.baidu.tieba.data.z) {
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
