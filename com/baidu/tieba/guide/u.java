package com.baidu.tieba.guide;

import com.baidu.tieba.data.ab;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.h {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        if (obj == null) {
            newUserGuideActivity3 = this.a.a;
            newUserGuideActivity3.c(x.neterror);
        } else if (obj instanceof ab) {
            int a = com.baidu.adp.lib.e.c.a(((ab) obj).a(), 0);
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
