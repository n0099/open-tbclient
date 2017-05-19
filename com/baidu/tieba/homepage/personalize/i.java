package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ae.b {
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar) {
        this.cuC = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void aM(boolean z) {
        o oVar;
        this.cuC.cux = true;
        oVar = this.cuC.cuu;
        oVar.update();
    }
}
