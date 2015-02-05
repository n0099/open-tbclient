package com.baidu.tieba.home;

import com.baidu.tbadk.core.view.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ad {
    final /* synthetic */ f aPO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.aPO = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        r rVar;
        r rVar2;
        if (z) {
            rVar2 = this.aPO.aPA;
            rVar2.jC();
            return;
        }
        rVar = this.aPO.aPA;
        rVar.JD();
    }
}
