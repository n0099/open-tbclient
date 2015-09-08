package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.lib.g.d {
    final /* synthetic */ aw aWm;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aWo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar, com.baidu.adp.lib.guide.d dVar) {
        this.aWm = awVar;
        this.aWo = dVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        this.aWo.dismiss();
    }
}
