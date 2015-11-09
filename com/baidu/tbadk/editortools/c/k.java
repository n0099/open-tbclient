package com.baidu.tbadk.editortools.c;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ e aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.aqO = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        this.aqO.a(0, true, null);
        aVar.dismiss();
    }
}
