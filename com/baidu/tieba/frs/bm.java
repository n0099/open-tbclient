package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bk bmo;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bk bkVar, com.baidu.adp.lib.guide.d dVar) {
        this.bmo = bkVar;
        this.bmr = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bmr.dismiss();
    }
}
