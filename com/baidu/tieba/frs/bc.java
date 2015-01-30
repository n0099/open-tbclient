package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class bc extends com.baidu.adp.lib.g.e {
    final /* synthetic */ ba aEu;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aEw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ba baVar, com.baidu.adp.lib.guide.d dVar) {
        this.aEu = baVar;
        this.aEw = dVar;
    }

    @Override // com.baidu.adp.lib.g.e
    public void b(Animation animation) {
        this.aEw.dismiss();
    }
}
