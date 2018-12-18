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
    private String arh;
    private BdTypeRecyclerView bRk;
    private boolean dNs;
    private d eeQ;
    private com.baidu.afd.a.b eeR;
    private com.baidu.adp.widget.ListView.a eeS;
    RecyclerView.SmoothScroller eeV;
    private b eeu;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean eeT = false;
    private int dNt = -1;
    private int eeU = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2) {
        this.dNs = false;
        this.mContext = tbPageContext;
        this.bRk = bdTypeRecyclerView;
        this.dNs = z;
        this.eeu = bVar;
        this.mFrom = str;
        this.arh = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.eeQ = new d(this.mContext, this, this.eeu, this.dNs, this.mFrom, this.arh, this);
        this.eeR = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.RI, this, this.eeu, this);
        this.eeS = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.RH);
        this.mAdapters.add(this.eeQ);
        this.mAdapters.add(this.eeS);
        this.mAdapters.add(this.eeR);
        this.bRk.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.eeT) {
                this.eeT = false;
                this.bRk.setData(this.mDatas);
            } else {
                this.bRk.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.dNs && z) {
                aDa();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.kX() && !com.baidu.tieba.video.g.bHQ().bHR()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.dNt != -1 ? this.dNt : this.eeU;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bHQ().bHR()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.I(this.mDatas) && this.mDatas.get(0) != null) {
            this.eeT = true;
            ((com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0)).dNz.mcnLeadPage = gVar.dNz.mcnLeadPage;
        }
    }

    public void M(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dNy != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dNy.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dNy.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bRk != null && this.bRk.getListAdapter() != null) {
            this.bRk.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.eeQ.onDestroy();
        this.eeR.onDestory();
    }

    public boolean pB() {
        return this.eeQ.pB() || this.eeR.pB();
    }

    public void pz() {
        this.eeQ.pz();
        this.eeR.pz();
    }

    public void pA() {
        this.eeQ.pA();
        this.eeR.pA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eeQ.onConfigurationChanged(configuration);
    }

    public boolean mu(int i) {
        return this.eeQ.mu(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mt(int i) {
        nG(i);
    }

    public int aCY() {
        return this.dNt;
    }

    public void aCZ() {
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
        aDa();
    }

    private void aDa() {
        aCZ();
        this.dNt = 0;
        this.eeU = -1;
        pz();
    }

    public void nG(int i) {
        this.dNt = i;
        this.eeU = i;
        if (!v.I(this.mDatas) && this.bRk != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dNt < this.mDatas.size() - 1) {
                int nH = nH(i);
                int i2 = this.dNt + nH;
                this.dNt = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bHQ().bHR()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    if (this.eeV == null) {
                        this.eeV = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                    this.eeV.setTargetPosition(nH + this.bRk.getHeaderViewsCount() + i);
                    this.bRk.getLayoutManager().startSmoothScroll(this.eeV);
                    notifyDataSetChanged();
                }
            } else if (this.dNt == this.mDatas.size() - 1 && (this.mDatas.get(this.dNt) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dNt);
                hVar3.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bHQ().bHR()) {
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int nH(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean nI(int i) {
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
            com.baidu.afd.e pv = ((com.baidu.afd.d) hVar).pv();
            if (pv == null || pv.RW) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void nJ(int i) {
        if (this.dNt != i || this.Si == null || !this.Si.isPlaying()) {
            this.dNt = i;
            this.eeU = i;
            if (!v.I(this.mDatas) && this.bRk != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.dNt <= this.mDatas.size() - 1 && (this.mDatas.get(this.dNt) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dNt);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bHQ().bHR()) {
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

    public void hu(boolean z) {
        this.eeQ.hu(z);
    }
}
