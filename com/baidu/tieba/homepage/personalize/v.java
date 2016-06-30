package com.baidu.tieba.homepage.personalize;

import com.baidu.tbadk.core.view.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements t.b {
    final /* synthetic */ s crd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.crd = sVar;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        a aVar;
        aVar = this.crd.cqY;
        aVar.update();
    }
}
