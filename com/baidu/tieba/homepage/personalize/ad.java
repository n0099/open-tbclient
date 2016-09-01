package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements t.b {
    final /* synthetic */ z cFs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.cFs = zVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        b bVar;
        bVar = this.cFs.cFn;
        bVar.update();
    }
}
