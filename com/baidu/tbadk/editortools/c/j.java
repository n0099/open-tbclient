package com.baidu.tbadk.editortools.c;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ d ase;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.ase = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.ase.a(0, true, null);
        aVar.dismiss();
    }
}
