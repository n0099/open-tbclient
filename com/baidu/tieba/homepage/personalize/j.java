package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ae.c {
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.cuC = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.c
    public void aN(boolean z) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        oVar = this.cuC.cuu;
        if (oVar != null) {
            oVar2 = this.cuC.cuu;
            if (oVar2.Kq() != null) {
                oVar4 = this.cuC.cuu;
                oVar4.Kq().ajv();
            }
            oVar3 = this.cuC.cuu;
            oVar3.eM(false);
        }
    }
}
