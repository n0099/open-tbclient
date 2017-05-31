package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ c aAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.aAT = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.hk()) {
            aVar2 = this.aAT.aAP;
            aVar2.Dd();
        } else {
            this.aAT.b(1, true, null);
            locationModel = this.aAT.aAA;
            locationModel.QK();
        }
        aVar.dismiss();
    }
}
