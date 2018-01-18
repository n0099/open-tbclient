package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.f.f;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float bjC = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, l lVar) {
        if (fVar != null && lVar != null) {
            ArrayList<i> threadList = lVar.getThreadList();
            if (!v.E(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<i> it = threadList.iterator();
                while (it.hasNext()) {
                    i next = it.next();
                    if (next.getType() == bd.aMX) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                lVar.dr(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean nj(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar, l lVar) {
        if (fVar != null && kVar != null && lVar != null) {
            fVar.aza();
            if (lVar != null && lVar.aYE() != null) {
                kVar.a(lVar.aYE().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return com.baidu.tieba.frs.e.f.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bN(View view) {
        view.setVisibility(8);
    }
}
