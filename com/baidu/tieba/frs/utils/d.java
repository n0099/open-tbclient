package com.baidu.tieba.frs.utils;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.h.d {
    final /* synthetic */ b ciD;
    private final /* synthetic */ com.baidu.adp.lib.guide.d ciF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.adp.lib.guide.d dVar) {
        this.ciD = bVar;
        this.ciF = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.ciF.dismiss();
    }
}
