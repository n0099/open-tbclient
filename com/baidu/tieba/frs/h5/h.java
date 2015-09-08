package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dj;
import com.baidu.tieba.frs.dl;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements dh {
    private di aSc;

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dj djVar) {
        if (i > 100 && this.aSc != null && djVar != null && djVar.aYY != null && (djVar.aYY instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) djVar.aYY);
            gVar.stType = djVar.stType;
            arrayList.add(gVar);
            dl dlVar = new dl();
            dlVar.hasMore = false;
            dlVar.aZa = false;
            dlVar.aZb = false;
            dlVar.pn = djVar.pn;
            dlVar.aYY = djVar.aYY;
            this.aSc.a(i, i2, dlVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(di diVar) {
        this.aSc = diVar;
    }

    @Override // com.baidu.tieba.frs.dh
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dh
    public void Kz() {
    }
}
