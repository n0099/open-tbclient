package com.baidu.tieba.guide;

import com.baidu.tieba.tbadkCore.av;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements av {
    final /* synthetic */ t aNR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.aNR = tVar;
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void f(String str, long j) {
        a aVar;
        int i = com.baidu.adp.lib.g.c.toInt(String.valueOf(j), 0);
        aVar = this.aNR.aNP;
        aVar.fm(i);
        this.aNR.n(i, false);
    }

    @Override // com.baidu.tieba.tbadkCore.av
    public void g(String str, long j) {
        NewUserGuideActivity newUserGuideActivity;
        newUserGuideActivity = this.aNR.aNO;
        newUserGuideActivity.showToast(z.error);
    }
}
