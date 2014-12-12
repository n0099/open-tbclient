package com.baidu.tieba.home;

import com.baidu.tbadk.core.view.ad;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements ad {
    final /* synthetic */ f aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(f fVar) {
        this.aOG = fVar;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void ar(boolean z) {
        s sVar;
        s sVar2;
        if (z) {
            sVar2 = this.aOG.aOs;
            sVar2.jK();
            return;
        }
        sVar = this.aOG.aOs;
        sVar.Jm();
    }
}
