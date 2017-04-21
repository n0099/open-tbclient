package com.baidu.tieba.frs.f;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class d extends com.baidu.adp.lib.g.d {
    final /* synthetic */ b ccc;
    private final /* synthetic */ com.baidu.adp.lib.guide.d cce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, com.baidu.adp.lib.guide.d dVar) {
        this.ccc = bVar;
        this.cce = dVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        this.cce.dismiss();
    }
}
