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
    private i Si;
    private String anG;
    private BdTypeRecyclerView bNt;
    private boolean dGT;
    private b dXR;
    private d dYn;
    private com.baidu.afd.a.b dYo;
    private com.baidu.adp.widget.ListView.a dYp;
    RecyclerView.SmoothScroller dYs;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean dYq = false;
    private int dGU = -1;
    private int dYr = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2) {
        this.dGT = false;
        this.mContext = tbPageContext;
        this.bNt = bdTypeRecyclerView;
        this.dGT = z;
        this.dXR = bVar;
        this.mFrom = str;
        this.anG = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dYn = new d(this.mContext, this, this.dXR, this.dGT, this.mFrom, this.anG, this);
        this.dYo = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.RI, this, this.dXR, this);
        this.dYp = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.RH);
        this.mAdapters.add(this.dYn);
        this.mAdapters.add(this.dYp);
        this.mAdapters.add(this.dYo);
        this.bNt.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.dYq) {
                this.dYq = false;
                this.bNt.setData(this.mDatas);
            } else {
                this.bNt.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.dGT && z) {
                aBq();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.kX() && !com.baidu.tieba.video.g.bFM().bFN()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.dGU != -1 ? this.dGU : this.dYr;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bFM().bFN()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.I(this.mDatas) && this.mDatas.get(0) != null) {
            this.dYq = true;
            ((com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0)).dHa.mcnLeadPage = gVar.dHa.mcnLeadPage;
        }
    }

    public void K(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dGZ != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dGZ.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dGZ.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bNt != null && this.bNt.getListAdapter() != null) {
            this.bNt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dYn.onDestroy();
        this.dYo.onDestory();
    }

    public boolean pC() {
        return this.dYn.pC() || this.dYo.pC();
    }

    public void pA() {
        this.dYn.pA();
        this.dYo.pA();
    }

    public void pB() {
        this.dYn.pB();
        this.dYo.pB();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dYn.onConfigurationChanged(configuration);
    }

    public boolean me(int i) {
        return this.dYn.me(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void md(int i) {
        nq(i);
    }

    public int aBo() {
        return this.dGU;
    }

    public void aBp() {
        if (!v.I(this.mDatas)) {
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
        aBq();
    }

    private void aBq() {
        aBp();
        this.dGU = 0;
        this.dYr = -1;
        pA();
    }

    public void nq(int i) {
        this.dGU = i;
        this.dYr = i;
        if (!v.I(this.mDatas) && this.bNt != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dGU < this.mDatas.size() - 1) {
                int nr = nr(i);
                int i2 = this.dGU + nr;
                this.dGU = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bFM().bFN()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    if (this.dYs == null) {
                        this.dYs = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                    this.dYs.setTargetPosition(nr + this.bNt.getHeaderViewsCount() + i);
                    this.bNt.getLayoutManager().startSmoothScroll(this.dYs);
                    notifyDataSetChanged();
                }
            } else if (this.dGU == this.mDatas.size() - 1 && (this.mDatas.get(this.dGU) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dGU);
                hVar3.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bFM().bFN()) {
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int nr(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean ns(int i) {
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
            com.baidu.afd.e pw = ((com.baidu.afd.d) hVar).pw();
            if (pw == null || pw.RW) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void nt(int i) {
        if (this.dGU != i || this.Si == null || !this.Si.isPlaying()) {
            this.dGU = i;
            this.dYr = i;
            if (!v.I(this.mDatas) && this.bNt != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.dGU <= this.mDatas.size() - 1 && (this.mDatas.get(this.dGU) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dGU);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bFM().bFN()) {
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
        i iVar2 = this.Si;
        this.Si = iVar;
        if (iVar2 != null && iVar2 != this.Si) {
            iVar2.stopPlay();
        }
    }

    public void hs(boolean z) {
        this.dYn.hs(z);
    }
}
