package com.baidu.tbadk.editortools.d;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e avN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.avN = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.jf()) {
            aVar2 = this.avN.avJ;
            aVar2.Ek();
        } else {
            this.avN.a(1, true, (String) null);
            dVar = this.avN.avu;
            dVar.aUl();
        }
        aVar.dismiss();
    }
}
