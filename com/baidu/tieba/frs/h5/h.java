package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ex;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements eu {
    private ev baG;

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ex exVar) {
        if (i > 100 && this.baG != null && exVar != null && exVar.bji != null && (exVar.bji instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) exVar.bji);
            gVar.stType = exVar.stType;
            arrayList.add(gVar);
            ey eyVar = new ey();
            eyVar.hasMore = false;
            eyVar.bjj = false;
            eyVar.bjk = false;
            eyVar.pn = exVar.pn;
            eyVar.bji = exVar.bji;
            this.baG.a(i, i2, eyVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(ev evVar) {
        this.baG = evVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void init() {
    }

    @Override // com.baidu.tieba.frs.eu
    public void My() {
    }
}
