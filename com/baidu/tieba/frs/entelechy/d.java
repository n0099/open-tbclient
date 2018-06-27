package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float aGQ = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, l lVar) {
        if (fVar != null && lVar != null) {
            ArrayList<h> threadList = lVar.getThreadList();
            if (!w.A(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<h> it = threadList.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.getType() == bc.aia) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                lVar.dz(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean kG(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar, l lVar) {
        if (fVar != null && kVar != null && lVar != null) {
            fVar.azT();
            if (lVar != null && lVar.baT() != null) {
                kVar.a(lVar.baT().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void at(View view) {
        view.setVisibility(8);
    }
}
