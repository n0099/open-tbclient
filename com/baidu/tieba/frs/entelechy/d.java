package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.f.f;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float bjs = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, l lVar) {
        if (fVar != null && lVar != null) {
            ArrayList<i> threadList = lVar.getThreadList();
            if (!v.G(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<i> it = threadList.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (next.getType() == be.aNb) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                lVar.dI(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean ng(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar, l lVar) {
        if (fVar != null && kVar != null && lVar != null) {
            fVar.axX();
            if (lVar != null && lVar.aYy() != null) {
                kVar.a(lVar.aYy().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return com.baidu.tieba.frs.e.f.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bL(View view) {
        view.setVisibility(8);
    }
}
