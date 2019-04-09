package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.vc.f;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.b {
    private float ccz = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, FrsViewData frsViewData) {
        if (fVar != null && frsViewData != null) {
            ArrayList<m> threadList = frsViewData.getThreadList();
            if (!v.T(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<m> it = threadList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if (next.getType() == bg.bAT) {
                        arrayList.add(next);
                    }
                }
                frsViewData.setTopThreadList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean qv(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar, FrsViewData frsViewData) {
        if (fVar != null && kVar != null && frsViewData != null) {
            fVar.biX();
            if (frsViewData != null && frsViewData.getForum() != null) {
                kVar.a(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bH(View view) {
        view.setVisibility(8);
    }
}
