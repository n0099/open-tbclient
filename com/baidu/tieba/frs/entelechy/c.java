package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.d.j;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.vc.h;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c implements com.baidu.tieba.frs.entelechy.a.b {
    private float fwc = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.a.b
    public void a(h hVar, FrsViewData frsViewData) {
        if (hVar != null && frsViewData != null) {
            ArrayList<n> threadList = frsViewData.getThreadList();
            if (!y.isEmpty(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<n> it = threadList.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next.getType() == cb.eQl) {
                        arrayList.add(next);
                    }
                }
                frsViewData.setTopThreadList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.b
    public boolean zm(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.a.b
    public void a(h hVar, q qVar, FrsViewData frsViewData) {
        if (hVar != null && qVar != null && frsViewData != null) {
            hVar.cLj();
            if (frsViewData != null && frsViewData.getForum() != null) {
                qVar.a(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.b
    public int a(int i, FrsRequestData frsRequestData) {
        return j.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.a.b
    public void cV(View view) {
        view.setVisibility(8);
    }
}
