package com.baidu.tieba.guide;

import com.baidu.tieba.model.bd;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements bd {
    final /* synthetic */ t aLZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aLZ = tVar;
    }

    @Override // com.baidu.tieba.model.bd
    public void d(String str, long j) {
        a aVar;
        int f = com.baidu.adp.lib.g.c.f(String.valueOf(j), 0);
        aVar = this.aLZ.aLX;
        aVar.fl(f);
        this.aLZ.n(f, false);
    }

    @Override // com.baidu.tieba.model.bd
    public void e(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.aLZ.aLW;
        newUserGuideActivity.showToast(y.error);
    }
}
