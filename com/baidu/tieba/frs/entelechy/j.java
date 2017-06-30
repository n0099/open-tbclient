package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.f.m;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.frs.entelechy.b.b {
    private float atI = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(m mVar, n nVar) {
        if (mVar != null && nVar != null) {
            ArrayList<v> threadList = nVar.getThreadList();
            if (!z.t(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<v> it = threadList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next.getType() == bm.Xn) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                nVar.cU(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean iF(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, m mVar, av avVar, n nVar) {
        if (mVar != null && avVar != null && nVar != null && dVar != null && avVar.getListView() != null) {
            mVar.ahJ();
            if (z) {
                dVar.a(avVar.getListView(), avVar.getListView().getHeaderViewsCount());
            }
            if (nVar != null && nVar.aMt() != null) {
                avVar.a(nVar.aMt().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.b bVar) {
        if ((bdTypeListView instanceof BdExpandListView) && bVar != null && bVar.getView() != null) {
            ((BdExpandListView) bdTypeListView).e(bVar.getView(), k.g(TbadkCoreApplication.m9getInst(), w.f.ds568));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return com.baidu.tieba.frs.e.n.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void af(View view) {
        view.setVisibility(8);
    }
}
