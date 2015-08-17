package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.lib.g.d {
    final /* synthetic */ av aVV;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aVX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar, com.baidu.adp.lib.guide.d dVar) {
        this.aVV = avVar;
        this.aVX = dVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        this.aVX.dismiss();
    }
}
