package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.frs.vc.h;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.b {
    private float eoL = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, FrsViewData frsViewData) {
        if (hVar != null && frsViewData != null) {
            ArrayList<q> threadList = frsViewData.getThreadList();
            if (!w.isEmpty(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<q> it = threadList.iterator();
                while (it.hasNext()) {
                    q next = it.next();
                    if (next.getType() == bu.dLl) {
                        arrayList.add(next);
                    }
                }
                frsViewData.setTopThreadList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean uY(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, p pVar, FrsViewData frsViewData) {
        if (hVar != null && pVar != null && frsViewData != null) {
            hVar.cfq();
            if (frsViewData != null && frsViewData.getForum() != null) {
                pVar.a(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bY(View view) {
        view.setVisibility(8);
    }
}
