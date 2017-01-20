package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.frs.entelechy.b.b {
    private float ane = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(com.baidu.tieba.frs.f.u uVar, com.baidu.tieba.tbadkCore.n nVar) {
        if (uVar != null && nVar != null) {
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = nVar.getThreadList();
            if (!com.baidu.tbadk.core.util.w.s(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next.getType() == bh.Sw) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                nVar.dg(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean ia(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, com.baidu.tieba.frs.f.u uVar, ax axVar, com.baidu.tieba.tbadkCore.n nVar) {
        if (uVar != null && axVar != null && nVar != null && dVar != null && axVar.Iv() != null) {
            uVar.acV();
            if (z) {
                dVar.a(axVar.Iv(), axVar.Iv().getHeaderViewsCount());
            }
            if (nVar != null && nVar.aJY() != null) {
                axVar.a(nVar.aJY().getFrsBannerData());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar) {
        if ((bdTypeListView instanceof BdExpandListView) && cVar != null && cVar.getView() != null) {
            ((BdExpandListView) bdTypeListView).e(cVar.getView(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds568));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, FrsRequestData frsRequestData) {
        return com.baidu.tieba.frs.utils.r.a(i, frsRequestData);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void ai(View view) {
        view.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public View b(Context context, BdTypeListView bdTypeListView) {
        return null;
    }
}
