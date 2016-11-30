package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements z.b {
    final /* synthetic */ a cKG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.cKG = aVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        n nVar;
        nVar = this.cKG.cKz;
        nVar.update();
    }
}
