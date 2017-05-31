package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ae.c {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.cAU = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.c
    public void aL(boolean z) {
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        oVar = this.cAU.cAM;
        if (oVar != null) {
            oVar2 = this.cAU.cAM;
            if (oVar2.aaC() != null) {
                oVar4 = this.cAU.cAM;
                oVar4.aaC().akv();
            }
            oVar3 = this.cAU.cAM;
            oVar3.fc(false);
        }
    }
}
