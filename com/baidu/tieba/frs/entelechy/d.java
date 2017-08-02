package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g.g;
import com.baidu.tieba.frs.h.f;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.i;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float auA = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, i iVar) {
        if (fVar != null && iVar != null) {
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = iVar.getThreadList();
            if (!u.v(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next.getType() == bl.XD) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                iVar.dr(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean iP(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, f fVar, com.baidu.tieba.frs.i iVar, i iVar2) {
        if (fVar != null && iVar != null && iVar2 != null && dVar != null && iVar.getListView() != null) {
            fVar.aji();
            if (z) {
                dVar.a(iVar.getListView(), iVar.getListView().getHeaderViewsCount());
            }
            if (iVar2 != null && iVar2.aOW() != null) {
                iVar.a(iVar2.aOW().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.b bVar) {
        if ((bdTypeListView instanceof BdExpandListView) && bVar != null && bVar.getView() != null) {
            BdExpandListView bdExpandListView = (BdExpandListView) bdTypeListView;
            bdExpandListView.e(bVar.getView(), k.g(TbadkCoreApplication.getInst(), d.f.ds568));
            bdExpandListView.requestLayout();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void ak(View view) {
        view.setVisibility(8);
    }
}
