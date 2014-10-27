package com.baidu.tieba.guide;

import com.baidu.tieba.data.aa;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.base.h {
    final /* synthetic */ t aLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.aLL = tVar;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        a aVar;
        NewUserGuideActivity newUserGuideActivity;
        NewUserGuideActivity newUserGuideActivity2;
        NewUserGuideActivity newUserGuideActivity3;
        if (obj == null) {
            newUserGuideActivity3 = this.aLL.aLI;
            newUserGuideActivity3.showToast(y.neterror);
        } else if (obj instanceof aa) {
            int f = com.baidu.adp.lib.g.c.f(((aa) obj).getFid(), 0);
            aVar = this.aLL.aLJ;
            aVar.fk(f);
            this.aLL.n(f, true);
            newUserGuideActivity = this.aLL.aLI;
            newUserGuideActivity.cr(true);
            newUserGuideActivity2 = this.aLL.aLI;
            newUserGuideActivity2.cq(true);
        }
    }
}
