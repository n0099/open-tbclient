package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.e {
    final /* synthetic */ u aqO;
    private final /* synthetic */ a.e aqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, a.e eVar) {
        this.aqO = uVar;
        this.aqQ = eVar;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        if (this.aqQ != null) {
            this.aqQ.a(aVar, z, z2);
        }
        this.aqO.Bl();
    }
}
