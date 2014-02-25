package com.baidu.tieba.guide;

import com.baidu.tieba.data.af;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.adp.a.g {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        if (obj != null && (obj instanceof af)) {
            int a = com.baidu.adp.lib.f.b.a(((af) obj).a(), 0);
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
