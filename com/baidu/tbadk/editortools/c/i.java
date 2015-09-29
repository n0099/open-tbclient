package com.baidu.tbadk.editortools.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d asl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.asl = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iM()) {
            aVar2 = this.asl.ash;
            aVar2.BF();
        } else {
            this.asl.a(1, true, null);
            dVar = this.asl.arU;
            dVar.axk();
        }
        aVar.dismiss();
    }
}
