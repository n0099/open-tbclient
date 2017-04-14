package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ c aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.aBg = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.hj()) {
            aVar2 = this.aBg.aBc;
            aVar2.Ef();
        } else {
            this.aBg.b(1, true, null);
            locationModel = this.aBg.aAO;
            locationModel.Qd();
        }
        aVar.dismiss();
    }
}
