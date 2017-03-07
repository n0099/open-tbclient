package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.e {
    final /* synthetic */ u avM;
    private final /* synthetic */ a.e avO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, a.e eVar) {
        this.avM = uVar;
        this.avO = eVar;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        if (this.avO != null) {
            this.avO.a(aVar, z, z2);
        }
        this.avM.Bt();
    }
}
