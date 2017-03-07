package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements ab.b {
    final /* synthetic */ a cyA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.cyA = aVar;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aL(boolean z) {
        n nVar;
        nVar = this.cyA.cys;
        nVar.update();
    }
}
