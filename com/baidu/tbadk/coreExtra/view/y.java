package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements b.e {
    final /* synthetic */ u awi;
    private final /* synthetic */ b.e awk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar, b.e eVar) {
        this.awi = uVar;
        this.awk = eVar;
    }

    @Override // com.baidu.tbadk.widget.b.e
    public void a(com.baidu.tbadk.widget.b bVar, boolean z, boolean z2) {
        if (this.awk != null) {
            this.awk.a(bVar, z, z2);
        }
        this.awi.Bc();
    }
}
