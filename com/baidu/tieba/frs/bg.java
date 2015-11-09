package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.lib.g.d {
    final /* synthetic */ be aVQ;
    private final /* synthetic */ com.baidu.adp.lib.guide.d aVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(be beVar, com.baidu.adp.lib.guide.d dVar) {
        this.aVQ = beVar;
        this.aVS = dVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        this.aVS.dismiss();
    }
}
