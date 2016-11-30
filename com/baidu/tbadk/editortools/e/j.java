package com.baidu.tbadk.editortools.e;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e awU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.awU = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.gm()) {
            aVar2 = this.awU.awQ;
            aVar2.DL();
        } else {
            this.awU.b(1, true, null);
            dVar = this.awU.awB;
            dVar.bmS();
        }
        aVar.dismiss();
    }
}
