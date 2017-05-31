package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements b.e {
    final /* synthetic */ u avS;
    private final /* synthetic */ b.e avU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, b.e eVar) {
        this.avS = uVar;
        this.avU = eVar;
    }

    @Override // com.baidu.tbadk.widget.b.e
    public void a(com.baidu.tbadk.widget.b bVar, boolean z, boolean z2) {
        if (this.avU != null) {
            this.avU.a(bVar, z, z2);
        }
        this.avS.AV();
    }
}
