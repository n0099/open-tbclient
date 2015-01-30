package com.baidu.tieba.home;

import com.baidu.tbadk.core.view.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ad {
    final /* synthetic */ f aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.aPP = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        r rVar;
        r rVar2;
        if (z) {
            rVar2 = this.aPP.aPB;
            rVar2.jJ();
            return;
        }
        rVar = this.aPP.aPB;
        rVar.JI();
    }
}
