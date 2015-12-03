package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ew;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements et {
    private eu aWF;

    @Override // com.baidu.tieba.frs.et
    public void a(int i, int i2, ew ewVar) {
        if (i > 100 && this.aWF != null && ewVar != null && ewVar.bfp != null && (ewVar.bfp instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) ewVar.bfp);
            gVar.stType = ewVar.stType;
            arrayList.add(gVar);
            ey eyVar = new ey();
            eyVar.hasMore = false;
            eyVar.bfr = false;
            eyVar.bfs = false;
            eyVar.pn = ewVar.pn;
            eyVar.bfp = ewVar.bfp;
            this.aWF.a(i, i2, eyVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.et
    public void a(eu euVar) {
        this.aWF = euVar;
    }

    @Override // com.baidu.tieba.frs.et
    public void init() {
    }

    @Override // com.baidu.tieba.frs.et
    public void Mf() {
    }
}
