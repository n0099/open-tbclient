package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ c aBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.aBh = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.hk()) {
            aVar2 = this.aBh.aBd;
            aVar2.Dj();
        } else {
            this.aBh.b(1, true, null);
            locationModel = this.aBh.aAO;
            locationModel.Qy();
        }
        aVar.dismiss();
    }
}
