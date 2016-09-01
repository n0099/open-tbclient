package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bb bQG;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bQI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, com.baidu.adp.lib.guide.d dVar) {
        this.bQG = bbVar;
        this.bQI = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bQI.dismiss();
    }
}
