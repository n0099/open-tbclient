package com.baidu.tieba.frs.utils;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.g.d {
    final /* synthetic */ b cbk;
    private final /* synthetic */ com.baidu.adp.lib.guide.d cbm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.adp.lib.guide.d dVar) {
        this.cbk = bVar;
        this.cbm = dVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        this.cbm.dismiss();
    }
}
