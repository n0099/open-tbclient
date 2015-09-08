package com.baidu.tbadk.editortools.c;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d atO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.atO = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        d.a aVar2;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (!com.baidu.adp.lib.util.i.iL()) {
            aVar2 = this.atO.atK;
            aVar2.BS();
        } else {
            this.atO.a(1, true, null);
            dVar = this.atO.atx;
            dVar.auY();
        }
        aVar.dismiss();
    }
}
