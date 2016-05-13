package com.baidu.tieba.frs.entelechy;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.t;
import com.baidu.tieba.view.BdExpandListView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.frs.entelechy.b.b {
    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(com.baidu.tieba.frs.h.m mVar, com.baidu.tieba.tbadkCore.o oVar) {
        if (mVar != null && oVar != null) {
            ArrayList<v> threadList = oVar.getThreadList();
            if (!y.s(threadList)) {
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                Iterator<v> it = threadList.iterator();
                while (it.hasNext()) {
                    v next = it.next();
                    if (next.getType() == ax.PT) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                oVar.cw(arrayList);
                BdLog.e("TopThreadCount:" + arrayList.size() + "   Cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public boolean gx(int i) {
        return false;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(boolean z, com.baidu.tieba.frs.entelechy.b.d dVar, com.baidu.tieba.frs.h.m mVar, cn cnVar, com.baidu.tieba.tbadkCore.o oVar) {
        if (mVar != null && cnVar != null && oVar != null && dVar != null && cnVar.QR() != null) {
            mVar.TM();
            cnVar.a(oVar.avD(), oVar.getUserData(), 1);
            if (z) {
                dVar.b(cnVar.QR(), cnVar.QR().getHeaderViewsCount());
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdExpandListView bdExpandListView, BannerView bannerView) {
        if (bdExpandListView != null) {
            bdExpandListView.f(bannerView, 2);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void b(BdExpandListView bdExpandListView, BannerView bannerView) {
        if (bdExpandListView != null) {
            bdExpandListView.removeHeaderView(bannerView);
            a(bdExpandListView, bannerView);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public void a(BdExpandListView bdExpandListView, com.baidu.tieba.frs.view.c cVar) {
        if (bdExpandListView != null && cVar != null && cVar.getView() != null) {
            bdExpandListView.e(cVar.getView(), com.baidu.adp.lib.util.k.c(TbadkCoreApplication.m11getInst(), t.e.ds568));
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public int a(int i, com.baidu.tieba.tbadkCore.l lVar) {
        if (i == 4) {
            return 2;
        }
        switch (i) {
            case 2:
                if (lVar != null) {
                    lVar.pb(0);
                    lVar.setIsGood(0);
                    break;
                }
                break;
            case 3:
                if (lVar != null) {
                    lVar.pb(1);
                    lVar.setIsGood(0);
                    break;
                }
                break;
            case 5:
                if (lVar != null) {
                    lVar.pb(0);
                    lVar.setIsGood(1);
                    break;
                }
                break;
            case 6:
                if (lVar != null) {
                    lVar.pb(2);
                    lVar.setIsGood(0);
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
    public View a(Context context, BdExpandListView bdExpandListView) {
        return null;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.b
    public BannerView aq(Context context) {
        if (context == null) {
            return null;
        }
        a aVar = new a(context);
        aVar.setLayoutParams(new AbsListView.LayoutParams(-1, context.getResources().getDimensionPixelSize(t.e.frs_header_banner_height) + context.getResources().getDimensionPixelSize(t.e.ds20)));
        return aVar;
    }
}
