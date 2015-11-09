package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.frs.eg;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements ec {
    private ed aRr;

    @Override // com.baidu.tieba.frs.ec
    public void a(int i, int i2, ee eeVar) {
        if (i > 100 && this.aRr != null && eeVar != null && eeVar.aZk != null && (eeVar.aZk instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) eeVar.aZk);
            gVar.stType = eeVar.stType;
            arrayList.add(gVar);
            eg egVar = new eg();
            egVar.hasMore = false;
            egVar.aZm = false;
            egVar.aZn = false;
            egVar.pn = eeVar.pn;
            egVar.aZk = eeVar.aZk;
            this.aRr.a(i, i2, egVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.ec
    public void a(ed edVar) {
        this.aRr = edVar;
    }

    @Override // com.baidu.tieba.frs.ec
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ec
    public void KG() {
    }
}
