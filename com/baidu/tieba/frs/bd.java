package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.lib.h.d {
    private final /* synthetic */ com.baidu.adp.lib.guide.d bQB;
    final /* synthetic */ bb bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, com.baidu.adp.lib.guide.d dVar) {
        this.bQz = bbVar;
        this.bQB = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bQB.dismiss();
    }
}
