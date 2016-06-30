package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bb bDS;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, com.baidu.adp.lib.guide.d dVar) {
        this.bDS = bbVar;
        this.bDU = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bDU.dismiss();
    }
}
