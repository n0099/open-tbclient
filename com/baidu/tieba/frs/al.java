package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    private final /* synthetic */ int Sx;
    private final /* synthetic */ b aRR;
    final /* synthetic */ FrsActivity bDB;
    private final /* synthetic */ boolean bDK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, b bVar, boolean z, int i) {
        this.bDB = frsActivity;
        this.aRR = bVar;
        this.bDK = z;
        this.Sx = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        if (this.aRR.ow()) {
            this.bDB.a(this.aRR, this.bDK ? "area_download" : "btn_download");
            this.bDB.d(this.aRR, this.Sx);
            aVar.dismiss();
        }
    }
}
