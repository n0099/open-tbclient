package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bl extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bj bhL;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bhN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bj bjVar, com.baidu.adp.lib.guide.d dVar) {
        this.bhL = bjVar;
        this.bhN = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bhN.dismiss();
    }
}
