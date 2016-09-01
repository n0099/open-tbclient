package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.bm;
import com.baidu.tieba.t;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.frs.entelechy.b.b {
    private float anT = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(com.baidu.tieba.frs.i.p pVar, com.baidu.tieba.tbadkCore.p pVar2) {
        if (pVar != null && pVar2 != null) {
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = pVar2.getThreadList();
            if (!y.t(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next.getType() == bg.Tj) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                pVar2.de(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean ib(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, com.baidu.tieba.frs.i.p pVar, bm bmVar, com.baidu.tieba.tbadkCore.p pVar2) {
        if (pVar != null && bmVar != null && pVar2 != null && dVar != null && bmVar.getListView() != null) {
            pVar.afq();
            if (z) {
                dVar.b(bmVar.getListView(), bmVar.getListView().getHeaderViewsCount());
            }
            bmVar.a(pVar2.aLP(), pVar2.getUserData(), 1);
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
            ((BdExpandListView) bdTypeListView).e(cVar.getView(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), t.e.ds568));
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
}
