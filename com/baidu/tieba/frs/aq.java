package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.lib.g.e {
    final /* synthetic */ ao aKx;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aKz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar, com.baidu.adp.lib.guide.d dVar) {
        this.aKx = aoVar;
        this.aKz = dVar;
    }

    @Override // com.baidu.adp.lib.g.e
    public void b(Animation animation) {
        this.aKz.dismiss();
    }
}
