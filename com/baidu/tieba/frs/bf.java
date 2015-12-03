package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends com.baidu.adp.lib.h.d {
    final /* synthetic */ bd bbf;
    private final /* synthetic */ com.baidu.adp.lib.guide.d bbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bd bdVar, com.baidu.adp.lib.guide.d dVar) {
        this.bbf = bdVar;
        this.bbh = dVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        this.bbh.dismiss();
    }
}
