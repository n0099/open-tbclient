package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
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
    private i Sr;
    private String arK;
    private BdTypeRecyclerView bRZ;
    private boolean dQQ;
    private b ehS;
    private d eio;
    private com.baidu.afd.a.b eip;
    private com.baidu.adp.widget.ListView.a eiq;
    RecyclerView.SmoothScroller eit;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean eir = false;
    private int dQR = -1;
    private int eis = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.dQQ = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.bRZ = bdTypeRecyclerView;
        this.dQQ = z;
        this.ehS = bVar;
        this.mFrom = str;
        this.arK = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.eio = new d(this.mContext, this, this.ehS, this.dQQ, this.mFrom, this.arK, this, this.mBdUniqueId);
        this.eip = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.RU, this, this.ehS, this);
        this.eiq = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.RT);
        this.mAdapters.add(this.eio);
        this.mAdapters.add(this.eiq);
        this.mAdapters.add(this.eip);
        this.bRZ.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.eir) {
                this.eir = false;
                this.bRZ.setData(this.mDatas);
            } else {
                this.bRZ.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.dQQ && z) {
                aEm();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.kX() && !com.baidu.tieba.video.g.bJp().bJq()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.dQR != -1 ? this.dQR : this.eis;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bJp().bJq()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.I(this.mDatas) && this.mDatas.get(0) != null) {
            this.eir = true;
            ((com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0)).dQX.mcnLeadPage = gVar.dQX.mcnLeadPage;
        }
    }

    public void L(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dQW != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dQW.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dQW.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bRZ != null && this.bRZ.getListAdapter() != null) {
            this.bRZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.eio.onDestroy();
        this.eip.onDestory();
    }

    public boolean pF() {
        return this.eio.pF() || this.eip.pF();
    }

    public void pD() {
        this.eio.pD();
        this.eip.pD();
    }

    public void pE() {
        this.eio.pE();
        this.eip.pE();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.eio.onConfigurationChanged(configuration);
    }

    public boolean mI(int i) {
        return this.eio.mI(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mH(int i) {
        nU(i);
    }

    public int aEk() {
        return this.dQR;
    }

    public void aEl() {
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
        aEm();
    }

    private void aEm() {
        aEl();
        this.dQR = 0;
        this.eis = -1;
        pD();
    }

    public void nU(int i) {
        this.dQR = i;
        this.eis = i;
        if (!v.I(this.mDatas) && this.bRZ != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dQR < this.mDatas.size() - 1) {
                int nV = nV(i);
                int i2 = this.dQR + nV;
                this.dQR = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bJp().bJq()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    if (this.eit == null) {
                        this.eit = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                    this.eit.setTargetPosition(nV + this.bRZ.getHeaderViewsCount() + i);
                    this.bRZ.getLayoutManager().startSmoothScroll(this.eit);
                    notifyDataSetChanged();
                }
            } else if (this.dQR == this.mDatas.size() - 1 && (this.mDatas.get(this.dQR) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dQR);
                hVar3.setAutoPlay(true);
                if (j.kW() || com.baidu.tieba.video.g.bJp().bJq()) {
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int nV(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean nW(int i) {
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
            com.baidu.afd.e pz = ((com.baidu.afd.d) hVar).pz();
            if (pz == null || pz.Sf) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void nX(int i) {
        if (this.dQR != i || this.Sr == null || !this.Sr.isPlaying()) {
            this.dQR = i;
            this.eis = i;
            if (!v.I(this.mDatas) && this.bRZ != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.dQR <= this.mDatas.size() - 1 && (this.mDatas.get(this.dQR) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dQR);
                    hVar2.setAutoPlay(true);
                    if (j.kW() || com.baidu.tieba.video.g.bJp().bJq()) {
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
        i iVar2 = this.Sr;
        this.Sr = iVar;
        if (iVar2 != null && iVar2 != this.Sr) {
            iVar2.stopPlay();
        }
    }

    public void hA(boolean z) {
        this.eio.hA(z);
    }
}
