package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fr;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements fp {
    final /* synthetic */ a btJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.btJ = aVar;
    }

    @Override // com.baidu.tieba.frs.fp
    public void a(int i, int i2, fr frVar, ArrayList<u> arrayList) {
        int i3;
        fp fpVar;
        o oVar;
        o oVar2;
        fp fpVar2;
        this.btJ.btA = false;
        i3 = this.btJ.btw;
        if (i != i3) {
            return;
        }
        fpVar = this.btJ.btG;
        if (fpVar != null) {
            this.btJ.btz = frVar;
            this.btJ.b(i, i2, frVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.btJ.bkq;
            oVar.ao(arrayList2);
            oVar2 = this.btJ.bkq;
            oVar2.aSl();
            fpVar2 = this.btJ.btG;
            fpVar2.a(i, i2, frVar, arrayList);
        }
    }
}
