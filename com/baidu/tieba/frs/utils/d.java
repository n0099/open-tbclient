package com.baidu.tieba.frs.utils;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.h.d {
    final /* synthetic */ b bNK;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bNM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.adp.lib.guide.d dVar) {
        this.bNK = bVar;
        this.bNM = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bNM.dismiss();
    }
}
