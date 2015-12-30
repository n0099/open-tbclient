package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bg bfe;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar, com.baidu.adp.lib.guide.d dVar) {
        this.bfe = bgVar;
        this.bfg = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bfg.dismiss();
    }
}
