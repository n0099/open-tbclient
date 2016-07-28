package com.baidu.tbadk.editortools.d;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e atr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.atr = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.fq()) {
            aVar2 = this.atr.atn;
            aVar2.Cl();
        } else {
            this.atr.b(1, true, null);
            dVar = this.atr.asY;
            dVar.bgp();
        }
        aVar.dismiss();
    }
}
