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
    private BdTypeRecyclerView bRn;
    private boolean dQg;
    private d ehH;
    private com.baidu.afd.a.b ehI;
    private com.baidu.adp.widget.ListView.a ehJ;
    RecyclerView.SmoothScroller ehM;
    private b ehl;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean ehK = false;
    private int dQh = -1;
    private int ehL = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2) {
        this.dQg = false;
        this.mContext = tbPageContext;
        this.bRn = bdTypeRecyclerView;
        this.dQg = z;
        this.ehl = bVar;
        this.mFrom = str;
        this.arh = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.ehH = new d(this.mContext, this, this.ehl, this.dQg, this.mFrom, this.arh, this);
        this.ehI = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.RI, this, this.ehl, this);
        this.ehJ = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.RH);
        this.mAdapters.add(this.ehH);
        this.mAdapters.add(this.ehJ);
        this.mAdapters.add(this.ehI);
        this.bRn.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.ehK) {
                this.ehK = false;
                this.bRn.setData(this.mDatas);
            } else {
                this.bRn.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.dQg && z) {
                aDP();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.kX() && !com.baidu.tieba.video.g.bIG().bIH()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.dQh != -1 ? this.dQh : this.ehL;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bIG().bIH()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.I(this.mDatas) && this.mDatas.get(0) != null) {
            this.ehK = true;
            ((com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0)).dQn.mcnLeadPage = gVar.dQn.mcnLeadPage;
        }
    }

    public void M(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dQm != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dQm.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dQm.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bRn != null && this.bRn.getListAdapter() != null) {
            this.bRn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ehH.onDestroy();
        this.ehI.onDestory();
    }

    public boolean pB() {
        return this.ehH.pB() || this.ehI.pB();
    }

    public void pz() {
        this.ehH.pz();
        this.ehI.pz();
    }

    public void pA() {
        this.ehH.pA();
        this.ehI.pA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.ehH.onConfigurationChanged(configuration);
    }

    public boolean mH(int i) {
        return this.ehH.mH(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mG(int i) {
        nT(i);
    }

    public int aDN() {
        return this.dQh;
    }

    public void aDO() {
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
        aDP();
    }

    private void aDP() {
        aDO();
        this.dQh = 0;
        this.ehL = -1;
        pz();
    }

    public void nT(int i) {
        this.dQh = i;
        this.ehL = i;
        if (!v.I(this.mDatas) && this.bRn != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dQh < this.mDatas.size() - 1) {
                int nU = nU(i);
                int i2 = this.dQh + nU;
                this.dQh = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bIG().bIH()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    if (this.ehM == null) {
                        this.ehM = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                    this.ehM.setTargetPosition(nU + this.bRn.getHeaderViewsCount() + i);
                    this.bRn.getLayoutManager().startSmoothScroll(this.ehM);
                    notifyDataSetChanged();
                }
            } else if (this.dQh == this.mDatas.size() - 1 && (this.mDatas.get(this.dQh) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dQh);
                hVar3.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bIG().bIH()) {
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int nU(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean nV(int i) {
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

    public void nW(int i) {
        if (this.dQh != i || this.Si == null || !this.Si.isPlaying()) {
            this.dQh = i;
            this.ehL = i;
            if (!v.I(this.mDatas) && this.bRn != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.dQh <= this.mDatas.size() - 1 && (this.mDatas.get(this.dQh) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dQh);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bIG().bIH()) {
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

    public void hx(boolean z) {
        this.ehH.hx(z);
    }
}
