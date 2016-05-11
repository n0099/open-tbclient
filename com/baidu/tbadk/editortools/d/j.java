package com.baidu.tbadk.editortools.d;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e arM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.arM = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.fq()) {
            aVar2 = this.arM.arI;
            aVar2.Cd();
        } else {
            this.arM.a(1, true, (String) null);
            dVar = this.arM.art;
            dVar.aUG();
        }
        aVar.dismiss();
    }
}
