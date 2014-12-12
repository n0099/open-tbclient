package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.lib.g.e {
    final /* synthetic */ bb aDt;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aDv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, com.baidu.adp.lib.guide.d dVar) {
        this.aDt = bbVar;
        this.aDv = dVar;
    }

    @Override // com.baidu.adp.lib.g.e
    public void b(Animation animation) {
        this.aDv.dismiss();
    }
}
