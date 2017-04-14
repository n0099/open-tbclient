package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.frs.entelechy.b.b {
    private float asP = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(com.baidu.tieba.frs.g.u uVar, com.baidu.tieba.tbadkCore.n nVar) {
        if (uVar != null && nVar != null) {
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = nVar.getThreadList();
            if (!com.baidu.tbadk.core.util.x.q(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next.getType() == bi.XZ) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                nVar.cM(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean hZ(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, com.baidu.tieba.frs.g.u uVar, az azVar, com.baidu.tieba.tbadkCore.n nVar) {
        if (uVar != null && azVar != null && nVar != null && dVar != null && azVar.getListView() != null) {
            uVar.adQ();
            if (z) {
                dVar.a(azVar.getListView(), azVar.getListView().getHeaderViewsCount());
            }
            if (nVar != null && nVar.aJw() != null) {
                azVar.a(nVar.aJw().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar) {
        if ((bdTypeListView instanceof BdExpandListView) && cVar != null && cVar.getView() != null) {
            ((BdExpandListView) bdTypeListView).e(cVar.getView(), com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds568));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return com.baidu.tieba.frs.f.r.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void ag(View view) {
        view.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public View b(Context context, BdTypeListView bdTypeListView) {
        return null;
    }
}
