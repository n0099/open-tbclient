package com.baidu.tieba.guide;

import com.baidu.tieba.model.bd;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements bd {
    final /* synthetic */ t aLL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aLL = tVar;
    }

    @Override // com.baidu.tieba.model.bd
    public void d(String str, long j) {
        a aVar;
        int f = com.baidu.adp.lib.g.c.f(String.valueOf(j), 0);
        aVar = this.aLL.aLJ;
        aVar.fl(f);
        this.aLL.n(f, false);
    }

    @Override // com.baidu.tieba.model.bd
    public void e(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.aLL.aLI;
        newUserGuideActivity.showToast(y.error);
    }
}
