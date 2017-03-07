package com.baidu.tbadk.editortools.pb;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ c aAQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.aAQ = cVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        LocationModel.a aVar2;
        LocationModel locationModel;
        if (!com.baidu.adp.lib.util.i.he()) {
            aVar2 = this.aAQ.aAM;
            aVar2.DH();
        } else {
            this.aAQ.b(1, true, null);
            locationModel = this.aAQ.aAy;
            locationModel.PF();
        }
        aVar.dismiss();
    }
}
