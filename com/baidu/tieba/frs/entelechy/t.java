package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.r;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.frs.entelechy.b.b {
    private float anX = 0.16875f;

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(com.baidu.tieba.frs.h.s sVar, com.baidu.tieba.tbadkCore.o oVar) {
        if (sVar != null && oVar != null) {
            ArrayList<com.baidu.adp.widget.ListView.v> threadList = oVar.getThreadList();
            if (!com.baidu.tbadk.core.util.x.t(threadList)) {
                ArrayList arrayList = new ArrayList();
                Iterator<com.baidu.adp.widget.ListView.v> it = threadList.iterator();
                while (it.hasNext()) {
                    com.baidu.adp.widget.ListView.v next = it.next();
                    if (next.getType() == bg.Tm) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                oVar.db(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean ho(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, com.baidu.tieba.frs.h.s sVar, ax axVar, com.baidu.tieba.tbadkCore.o oVar) {
        if (sVar != null && axVar != null && oVar != null && dVar != null && axVar.Xm() != null) {
            sVar.abO();
            if (z) {
                dVar.b(axVar.Xm(), axVar.Xm().getHeaderViewsCount());
            }
            axVar.a(oVar.aIk(), oVar.getUserData(), 1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(FrsActivity frsActivity, BdTypeListView bdTypeListView, BannerView bannerView) {
        if (bdTypeListView != null && frsActivity != null && !frsActivity.Wv()) {
            bdTypeListView.removeHeaderView(bannerView);
            bdTypeListView.f(bannerView, bdTypeListView.getHeaderViewsCount() - 1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void b(FrsActivity frsActivity, BdTypeListView bdTypeListView, BannerView bannerView) {
        if (bdTypeListView != null && frsActivity != null && !frsActivity.Wv()) {
            bdTypeListView.removeHeaderView(bannerView);
            bdTypeListView.f(bannerView, bdTypeListView.getHeaderViewsCount() - 1);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdTypeListView bdTypeListView, com.baidu.tieba.frs.view.c cVar) {
        if ((bdTypeListView instanceof BdExpandListView) && cVar != null && cVar.getView() != null) {
            ((BdExpandListView) bdTypeListView).e(cVar.getView(), com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds568));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, com.baidu.tieba.tbadkCore.l lVar) {
        return com.baidu.tieba.frs.utils.r.a(i, lVar);
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
