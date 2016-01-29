package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bi bhC;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bhE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, com.baidu.adp.lib.guide.d dVar) {
        this.bhC = biVar;
        this.bhE = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bhE.dismiss();
    }
}
