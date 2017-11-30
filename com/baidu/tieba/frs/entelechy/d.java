package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.g.f;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.b {
    private float ave = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(f fVar, k kVar) {
        if (fVar != null && kVar != null) {
            ArrayList<com.baidu.adp.widget.ListView.f> threadList = kVar.getThreadList();
            if (!v.w(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.f> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.f next = it.next();
                    if (next.getType() == bd.YF) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                kVar.dD(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean kd(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, f fVar, i iVar, k kVar) {
        if (fVar != null && iVar != null && kVar != null && dVar != null && iVar.getListView() != null) {
            fVar.aqH();
            if (z) {
                dVar.a(iVar.getListView(), iVar.getListView().getHeaderViewsCount());
            }
            if (kVar != null && kVar.aRf() != null) {
                iVar.a(kVar.aRf().getFrsBannerData());
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
        return com.baidu.tieba.frs.f.f.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void aw(View view) {
        view.setVisibility(8);
    }
}
