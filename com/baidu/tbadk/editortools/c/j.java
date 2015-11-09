package com.baidu.tbadk.editortools.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.aqO = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iN()) {
            aVar2 = this.aqO.aqK;
            aVar2.Bv();
        } else {
            this.aqO.a(1, true, null);
            dVar = this.aqO.aqu;
            dVar.ayz();
        }
        aVar.dismiss();
    }
}
