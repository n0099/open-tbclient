package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.vc.h;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.b {
    private float eFy = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, FrsViewData frsViewData) {
        if (hVar != null && frsViewData != null) {
            ArrayList<q> threadList = frsViewData.getThreadList();
            if (!y.isEmpty(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<q> it = threadList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next.getType() == bw.eaR) {
                        arrayList.add(next);
                    }
                }
                frsViewData.setTopThreadList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean xI(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, com.baidu.tieba.frs.q qVar, FrsViewData frsViewData) {
        if (hVar != null && qVar != null && frsViewData != null) {
            hVar.ctu();
            if (frsViewData != null && frsViewData.getForum() != null) {
                qVar.a(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void cg(View view) {
        view.setVisibility(8);
    }
}
