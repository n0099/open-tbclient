package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bh extends com.baidu.adp.lib.g.e {
    final /* synthetic */ bf aBH;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aBJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bf bfVar, com.baidu.adp.lib.guide.d dVar) {
        this.aBH = bfVar;
        this.aBJ = dVar;
    }

    @Override // com.baidu.adp.lib.g.e
    public void b(Animation animation) {
        this.aBJ.dismiss();
    }
}
