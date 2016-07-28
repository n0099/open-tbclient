package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bd extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bb bFc;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb bbVar, com.baidu.adp.lib.guide.d dVar) {
        this.bFc = bbVar;
        this.bFe = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bFe.dismiss();
    }
}
