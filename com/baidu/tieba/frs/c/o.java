package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements dh {
    final /* synthetic */ n bca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.bca = nVar;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        SparseArray sparseArray;
        int Y;
        biVar = this.bca.aUL;
        if (biVar.getListView() != null) {
            biVar2 = this.bca.aUL;
            if (biVar2.getListView().getChildAt(0) != null) {
                n.a aVar = new n.a();
                biVar3 = this.bca.aUL;
                aVar.bcc = biVar3.getListView().getFirstVisiblePosition();
                biVar4 = this.bca.aUL;
                aVar.top = biVar4.getListView().getChildAt(0).getTop();
                sparseArray = this.bca.bad;
                Y = this.bca.Y(i, i2);
                sparseArray.put(Y, aVar);
            }
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
    }
}
