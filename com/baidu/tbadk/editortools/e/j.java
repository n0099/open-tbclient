package com.baidu.tbadk.editortools.e;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e awr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.awr = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.gm()) {
            aVar2 = this.awr.awn;
            aVar2.Dt();
        } else {
            this.awr.b(1, true, null);
            dVar = this.awr.avY;
            dVar.bgM();
        }
        aVar.dismiss();
    }
}
