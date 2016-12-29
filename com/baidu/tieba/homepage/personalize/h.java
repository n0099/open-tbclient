package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements z.b {
    final /* synthetic */ a cqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.cqb = aVar;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aM(boolean z) {
        n nVar;
        nVar = this.cqb.cpU;
        nVar.update();
    }
}
