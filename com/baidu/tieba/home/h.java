package com.baidu.tieba.home;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.i {
    final /* synthetic */ f aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aPP = fVar;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        com.baidu.tieba.model.d dVar;
        Boolean bool;
        if (obj != null) {
            dVar = this.aPP.aPD;
            bool = this.aPP.aPH;
            dVar.du(bool.booleanValue());
        }
    }
}
