package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.de;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements db {
    final /* synthetic */ n bbG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bbG = nVar;
    }

    @Override // com.baidu.tieba.frs.db
    public void a(dc dcVar) {
    }

    @Override // com.baidu.tieba.frs.db
    public void a(int i, int i2, de deVar) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        SparseArray sparseArray;
        int Y;
        blVar = this.bbG.aUw;
        if (blVar.getListView() != null) {
            blVar2 = this.bbG.aUw;
            if (blVar2.getListView().getChildAt(0) != null) {
                n.a aVar = new n.a();
                blVar3 = this.bbG.aUw;
                aVar.bbI = blVar3.getListView().getFirstVisiblePosition();
                blVar4 = this.bbG.aUw;
                aVar.top = blVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bbG.aZL;
                Y = this.bbG.Y(i, i2);
                sparseArray.put(Y, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.db
    public void init() {
    }

    @Override // com.baidu.tieba.frs.db
    public void KL() {
    }
}
