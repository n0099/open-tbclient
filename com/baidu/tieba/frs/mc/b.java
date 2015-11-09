package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.eg;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ed {
    final /* synthetic */ a bby;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bby = aVar;
    }

    @Override // com.baidu.tieba.frs.ed
    public void a(int i, int i2, eg egVar, ArrayList<u> arrayList) {
        int i3;
        ed edVar;
        o oVar;
        o oVar2;
        ed edVar2;
        this.bby.bbs = false;
        i3 = this.bby.bbo;
        if (i != i3) {
            return;
        }
        edVar = this.bby.bbw;
        if (edVar != null) {
            this.bby.bbr = egVar;
            this.bby.b(i, i2, egVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.bby.aUe;
            oVar.af(arrayList2);
            oVar2 = this.bby.aUe;
            oVar2.awy();
            edVar2 = this.bby.bbw;
            edVar2.a(i, i2, egVar, arrayList);
        }
    }
}
