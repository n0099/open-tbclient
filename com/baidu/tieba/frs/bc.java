package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bc extends com.baidu.adp.lib.g.e {
    final /* synthetic */ ba aEr;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aEt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, com.baidu.adp.lib.guide.d dVar) {
        this.aEr = baVar;
        this.aEt = dVar;
    }

    @Override // com.baidu.adp.lib.g.e
    public void b(Animation animation) {
        this.aEt.dismiss();
    }
}
