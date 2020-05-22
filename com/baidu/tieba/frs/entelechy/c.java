package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.vc.h;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class c implements com.baidu.tieba.frs.entelechy.b.b {
    private float ega = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, FrsViewData frsViewData) {
        if (hVar != null && frsViewData != null) {
            ArrayList<o> threadList = frsViewData.getThreadList();
            if (!v.isEmpty(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<o> it = threadList.iterator();
                while (it.hasNext()) {
                    o next = it.next();
                    if (next.getType() == bk.dED) {
                        arrayList.add(next);
                    }
                }
                frsViewData.setTopThreadList(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean ur(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(h hVar, n nVar, FrsViewData frsViewData) {
        if (hVar != null && nVar != null && frsViewData != null) {
            hVar.cbQ();
            if (frsViewData != null && frsViewData.getForum() != null) {
                nVar.a(frsViewData.getForum().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void bX(View view) {
        view.setVisibility(8);
    }
}
