package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float auD = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, j jVar) {
        if (fVar != null && jVar != null) {
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = jVar.getThreadList();
            if (!v.v(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next.getType() == bh.Yn) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                jVar.ds(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean jF(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, f fVar, i iVar, j jVar) {
        if (fVar != null && iVar != null && jVar != null && dVar != null && iVar.getListView() != null) {
            fVar.aoN();
            if (z) {
                dVar.a(iVar.getListView(), iVar.getListView().getHeaderViewsCount());
            }
            if (jVar != null && jVar.aPU() != null) {
                iVar.a(jVar.aPU().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.b bVar) {
        if ((bdTypeListView instanceof BdExpandListView) && bVar != null && bVar.getView() != null) {
            BdExpandListView bdExpandListView = (BdExpandListView) bdTypeListView;
            bdExpandListView.e(bVar.getView(), l.f(TbadkCoreApplication.getInst(), d.e.ds568));
            bdExpandListView.requestLayout();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return g.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void av(View view) {
        view.setVisibility(8);
    }
}
