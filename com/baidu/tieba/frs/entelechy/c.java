package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.vc.h;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.b {
    private float drF = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, FrsViewData frsViewData) {
        if (hVar != null && frsViewData != null) {
            ArrayList<m> threadList = frsViewData.getThreadList();
            if (!v.isEmpty(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<m> it = threadList.iterator();
                while (it.hasNext()) {
                    m next = it.next();
                    if (next.getType() == bj.cRw) {
                        arrayList.add(next);
                    }
                }
                frsViewData.setTopThreadList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean to(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, com.baidu.tieba.frs.m mVar, FrsViewData frsViewData) {
        if (hVar != null && mVar != null && frsViewData != null) {
            hVar.uo();
            if (frsViewData != null && frsViewData.getForum() != null) {
                mVar.a(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bP(View view) {
        view.setVisibility(8);
    }
}
