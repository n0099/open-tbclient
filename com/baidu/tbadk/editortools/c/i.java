package com.baidu.tbadk.editortools.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d asm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.asm = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iM()) {
            aVar2 = this.asm.asi;
            aVar2.BC();
        } else {
            this.asm.a(1, true, null);
            dVar = this.asm.arV;
            dVar.axq();
        }
        aVar.dismiss();
    }
}
