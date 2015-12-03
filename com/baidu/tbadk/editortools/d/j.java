package com.baidu.tbadk.editortools.d;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ e asR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.asR = eVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iP()) {
            aVar2 = this.asR.asN;
            aVar2.Cv();
        } else {
            this.asR.a(1, true, (String) null);
            dVar = this.asR.asy;
            dVar.aDR();
        }
        aVar.dismiss();
    }
}
