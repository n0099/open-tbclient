package com.baidu.tieba.frs;

import com.baidu.tbadk.core.data.b;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements a.b {
    private final /* synthetic */ int Tf;
    private final /* synthetic */ b aSL;
    final /* synthetic */ FrsActivity bEL;
    private final /* synthetic */ boolean bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity, b bVar, boolean z, int i) {
        this.bEL = frsActivity;
        this.aSL = bVar;
        this.bEU = z;
        this.Tf = i;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(a aVar) {
        if (this.aSL.ol()) {
            this.bEL.a(this.aSL, this.bEU ? "area_download" : "btn_download");
            this.bEL.d(this.aSL, this.Tf);
            aVar.dismiss();
        }
    }
}
