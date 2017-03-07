package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.cb;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cj;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements cb {
    private cc bKV;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(int i, int i2, cj cjVar) {
        if (i > 100 && this.bKV != null && cjVar != null && cjVar.bQr != null && (cjVar.bQr instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) cjVar.bQr);
            hVar.stType = cjVar.stType;
            arrayList.add(hVar);
            cm cmVar = new cm();
            cmVar.hasMore = false;
            cmVar.bQt = false;
            cmVar.bQu = false;
            cmVar.pn = cjVar.pn;
            cmVar.bQr = cjVar.bQr;
            this.bKV.a(i, i2, cmVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.cb
    public void a(cc ccVar) {
        this.bKV = ccVar;
    }

    @Override // com.baidu.tieba.frs.cb
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cb
    public void MQ() {
    }
}
