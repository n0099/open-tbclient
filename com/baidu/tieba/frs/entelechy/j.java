package com.baidu.tieba.frs.entelechy;

import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.f.u;
import com.baidu.tieba.tbadkCore.FrsRequestData;
import com.baidu.tieba.tbadkCore.n;
import com.baidu.tieba.view.BdExpandListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.frs.entelechy.b.b {
    private float asF = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(u uVar, n nVar) {
        if (uVar != null && nVar != null) {
            ArrayList<v> threadList = nVar.getThreadList();
            if (!x.r(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<v> it = threadList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next.getType() == bl.Xn) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                nVar.cF(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean it(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, u uVar, au auVar, n nVar) {
        if (uVar != null && auVar != null && nVar != null && dVar != null && auVar.getListView() != null) {
            uVar.adV();
            if (z) {
                dVar.a(auVar.getListView(), auVar.getListView().getHeaderViewsCount());
            }
            if (nVar != null && nVar.aIz() != null) {
                auVar.a(nVar.aIz().getFrsBannerData());
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
    public void ae(View view) {
        view.setVisibility(8);
    }
}
