package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.e.u;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.frs.entelechy.b.b {
    private float asV = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(u uVar, n nVar) {
        if (uVar != null && nVar != null) {
            ArrayList<v> threadList = nVar.getThreadList();
            if (!x.r(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<v> it = threadList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next.getType() == bk.Xs) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                nVar.cC(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean hV(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, u uVar, at atVar, n nVar) {
        if (uVar != null && atVar != null && nVar != null && dVar != null && atVar.getListView() != null) {
            uVar.acS();
            if (z) {
                dVar.a(atVar.getListView(), atVar.getListView().getHeaderViewsCount());
            }
            if (nVar != null && nVar.aHE() != null) {
                atVar.a(nVar.aHE().getFrsBannerData());
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
        return com.baidu.tieba.frs.d.n.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void ae(View view) {
        view.setVisibility(8);
    }
}
