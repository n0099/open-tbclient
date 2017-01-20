package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements a.e {
    final /* synthetic */ u aqr;
    private final /* synthetic */ a.e aqt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, a.e eVar) {
        this.aqr = uVar;
        this.aqt = eVar;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        if (this.aqt != null) {
            this.aqt.a(aVar, z, z2);
        }
        this.aqr.Ba();
    }
}
