package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ f aMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.aMC = fVar;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        r rVar;
        r rVar2;
        if (z) {
            rVar2 = this.aMC.aMr;
            rVar2.hO();
            return;
        }
        rVar = this.aMC.aMr;
        rVar.IR();
    }
}
