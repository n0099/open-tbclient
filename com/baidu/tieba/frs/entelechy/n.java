package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.bq;
import com.baidu.tieba.u;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.frs.entelechy.b.b {
    private float akN = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(com.baidu.tieba.frs.j.p pVar, com.baidu.tieba.tbadkCore.p pVar2) {
        if (pVar != null && pVar2 != null) {
            ArrayList<v> threadList = pVar2.getThreadList();
            if (!y.t(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<v> it = threadList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next.getType() == be.QA) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                pVar2.da(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean hy(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, com.baidu.tieba.frs.j.p pVar, bq bqVar, com.baidu.tieba.tbadkCore.p pVar2) {
        if (pVar != null && bqVar != null && pVar2 != null && dVar != null && bqVar.getListView() != null) {
            pVar.aaF();
            if (z) {
                dVar.b(bqVar.getListView(), bqVar.getListView().getHeaderViewsCount());
            }
            bqVar.a(pVar2.aGX(), pVar2.getUserData(), 1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, BannerView bannerView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(bannerView);
            bdTypeListView.f(bannerView, bdTypeListView.getHeaderViewsCount() - 1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void b(BdTypeListView bdTypeListView, BannerView bannerView) {
        if (bdTypeListView != null) {
            bdTypeListView.removeHeaderView(bannerView);
            bdTypeListView.f(bannerView, bdTypeListView.getHeaderViewsCount() - 1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar) {
        if ((bdTypeListView instanceof BdExpandListView) && cVar != null && cVar.getView() != null) {
            ((BdExpandListView) bdTypeListView).e(cVar.getView(), com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m10getInst(), u.e.ds568));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, com.baidu.tieba.tbadkCore.m mVar) {
        if (i == 4) {
            return 2;
        }
        switch (i) {
            case 2:
                if (mVar != null) {
                    mVar.setSortType(0);
                    mVar.setIsGood(0);
                    break;
                }
                break;
            case 3:
                if (mVar != null) {
                    mVar.setSortType(1);
                    mVar.setIsGood(0);
                    break;
                }
                break;
            case 5:
                if (mVar != null) {
                    mVar.setSortType(0);
                    mVar.setIsGood(1);
                    break;
                }
                break;
            case 6:
                if (mVar != null) {
                    mVar.setSortType(2);
                    mVar.setIsGood(0);
                    break;
                }
                break;
            case 7:
                if (mVar != null) {
                    mVar.setSortType(3);
                    mVar.setIsGood(0);
                    break;
                }
                break;
        }
        return 1;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void ad(View view) {
        view.setVisibility(8);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public View a(Context context, BdTypeListView bdTypeListView) {
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public BannerView at(Context context) {
        if (context == null) {
            return null;
        }
        int A = (int) (com.baidu.adp.lib.util.k.A(context) * this.akN);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(u.e.ds20);
        a aVar = new a(context);
        aVar.setLayoutParams(new AbsListView.LayoutParams(-1, A + dimensionPixelSize));
        return aVar;
    }
}
