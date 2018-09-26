package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.frs.aggregation.a, com.baidu.tieba.lego.card.view.f {
    private i RQ;
    private String ahY;
    private BdTypeRecyclerView bEd;
    private b dOI;
    private d dPe;
    private com.baidu.afd.a.b dPf;
    private com.baidu.adp.widget.ListView.a dPg;
    RecyclerView.SmoothScroller dPi;
    private boolean dxD;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dxE = -1;
    private int dPh = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2) {
        this.dxD = false;
        this.mContext = tbPageContext;
        this.bEd = bdTypeRecyclerView;
        this.dxD = z;
        this.dOI = bVar;
        this.mFrom = str;
        this.ahY = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dPe = new d(this.mContext, this, this.dOI, this.dxD, this.mFrom, this.ahY, this);
        this.dPf = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.Rr, this, this.dOI, this);
        this.dPg = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.Rq);
        this.mAdapters.add(this.dPe);
        this.mAdapters.add(this.dPg);
        this.mAdapters.add(this.dPf);
        this.bEd.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            this.bEd.setDataWithPartChange(this.mDatas, size, list.size());
            if (list.size() > 0 && this.dxD && z) {
                ayz();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.kM() && !com.baidu.tieba.video.g.bCZ().bDa()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.dxE != -1 ? this.dxE : this.dPh;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kL() || com.baidu.tieba.video.g.bCZ().bDa()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dxJ != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dxJ.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dxJ.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bEd != null && this.bEd.getListAdapter() != null) {
            this.bEd.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dPe.onDestroy();
        this.dPf.onDestory();
    }

    public boolean pw() {
        return this.dPe.pw() || this.dPf.pw();
    }

    public void pu() {
        this.dPe.pu();
        this.dPf.pu();
    }

    public void pv() {
        this.dPe.pv();
        this.dPf.pv();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dPe.onConfigurationChanged(configuration);
    }

    public boolean lo(int i) {
        return this.dPe.lo(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ln(int i) {
        mA(i);
    }

    public int ayx() {
        return this.dxE;
    }

    public void ayy() {
        if (!v.z(this.mDatas)) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) hVar;
                    hVar2.setAutoPlay(false);
                    hVar2.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        ayz();
    }

    private void ayz() {
        ayy();
        this.dxE = 0;
        this.dPh = -1;
        pu();
    }

    public void mA(int i) {
        this.dxE = i;
        this.dPh = i;
        if (!v.z(this.mDatas) && this.bEd != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dxE < this.mDatas.size() - 1) {
                int mB = mB(i);
                int i2 = this.dxE + mB;
                this.dxE = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar2.setAutoPlay(true);
                    if (j.kL() || com.baidu.tieba.video.g.bCZ().bDa()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    if (this.dPi == null) {
                        this.dPi = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                            @Override // android.support.v7.widget.LinearSmoothScroller
                            public int calculateDtToFit(int i3, int i4, int i5, int i6, int i7) {
                                return (((i6 - i5) / 5) + i5) - (((i4 - i3) / 5) + i3);
                            }

                            @Override // android.support.v7.widget.LinearSmoothScroller
                            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                                return 0.2f;
                            }

                            @Override // android.support.v7.widget.LinearSmoothScroller
                            protected int getVerticalSnapPreference() {
                                return -1;
                            }
                        };
                    }
                    this.dPi.setTargetPosition(mB + this.bEd.getHeaderViewsCount() + i);
                    this.bEd.getLayoutManager().startSmoothScroll(this.dPi);
                    notifyDataSetChanged();
                }
            } else if (this.dxE == this.mDatas.size() - 1 && (this.mDatas.get(this.dxE) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dxE);
                hVar3.setAutoPlay(true);
                if (j.kL() || com.baidu.tieba.video.g.bCZ().bDa()) {
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int mB(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean mC(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return f(this.mDatas.get(i));
    }

    private boolean f(h hVar) {
        boolean z = true;
        if (hVar == null) {
            return false;
        }
        if (hVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (hVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e pq = ((com.baidu.afd.d) hVar).pq();
            if (pq == null || pq.RC) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void mD(int i) {
        if (this.dxE != i || this.RQ == null || !this.RQ.isPlaying()) {
            this.dxE = i;
            this.dPh = i;
            if (!v.z(this.mDatas) && this.bEd != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.dxE <= this.mDatas.size() - 1 && (this.mDatas.get(this.dxE) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dxE);
                    hVar2.setAutoPlay(true);
                    if (j.kL() || com.baidu.tieba.video.g.bCZ().bDa()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    notifyDataSetChanged();
                }
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        i iVar2 = this.RQ;
        this.RQ = iVar;
        if (iVar2 != null && iVar2 != this.RQ) {
            iVar2.stopPlay();
        }
    }

    public void gQ(boolean z) {
        this.dPe.gQ(z);
    }
}
