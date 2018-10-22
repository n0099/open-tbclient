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
    private i Sg;
    private String amT;
    private BdTypeRecyclerView bMI;
    private boolean dFE;
    private b dWE;
    private d dXa;
    private com.baidu.afd.a.b dXb;
    private com.baidu.adp.widget.ListView.a dXc;
    RecyclerView.SmoothScroller dXe;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dFF = -1;
    private int dXd = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2) {
        this.dFE = false;
        this.mContext = tbPageContext;
        this.bMI = bdTypeRecyclerView;
        this.dFE = z;
        this.dWE = bVar;
        this.mFrom = str;
        this.amT = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dXa = new d(this.mContext, this, this.dWE, this.dFE, this.mFrom, this.amT, this);
        this.dXb = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.RG, this, this.dWE, this);
        this.dXc = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.RF);
        this.mAdapters.add(this.dXa);
        this.mAdapters.add(this.dXc);
        this.mAdapters.add(this.dXb);
        this.bMI.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            this.bMI.setDataWithPartChange(this.mDatas, size, list.size());
            if (list.size() > 0 && this.dFE && z) {
                aBT();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.kZ() && !com.baidu.tieba.video.g.bGn().bGo()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.dFF != -1 ? this.dFF : this.dXd;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kY() || com.baidu.tieba.video.g.bGn().bGo()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void K(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dFK != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dFK.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dFK.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.bMI != null && this.bMI.getListAdapter() != null) {
            this.bMI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dXa.onDestroy();
        this.dXb.onDestory();
    }

    public boolean pE() {
        return this.dXa.pE() || this.dXb.pE();
    }

    public void pC() {
        this.dXa.pC();
        this.dXb.pC();
    }

    public void pD() {
        this.dXa.pD();
        this.dXb.pD();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dXa.onConfigurationChanged(configuration);
    }

    public boolean lM(int i) {
        return this.dXa.lM(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void lL(int i) {
        mY(i);
    }

    public int aBR() {
        return this.dFF;
    }

    public void aBS() {
        if (!v.J(this.mDatas)) {
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
        aBT();
    }

    private void aBT() {
        aBS();
        this.dFF = 0;
        this.dXd = -1;
        pC();
    }

    public void mY(int i) {
        this.dFF = i;
        this.dXd = i;
        if (!v.J(this.mDatas) && this.bMI != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dFF < this.mDatas.size() - 1) {
                int mZ = mZ(i);
                int i2 = this.dFF + mZ;
                this.dFF = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar2.setAutoPlay(true);
                    if (j.kY() || com.baidu.tieba.video.g.bGn().bGo()) {
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setWaitConfirm(true);
                    }
                    if (this.dXe == null) {
                        this.dXe = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                    this.dXe.setTargetPosition(mZ + this.bMI.getHeaderViewsCount() + i);
                    this.bMI.getLayoutManager().startSmoothScroll(this.dXe);
                    notifyDataSetChanged();
                }
            } else if (this.dFF == this.mDatas.size() - 1 && (this.mDatas.get(this.dFF) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dFF);
                hVar3.setAutoPlay(true);
                if (j.kY() || com.baidu.tieba.video.g.bGn().bGo()) {
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int mZ(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean na(int i) {
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
            com.baidu.afd.e py = ((com.baidu.afd.d) hVar).py();
            if (py == null || py.RU) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void nb(int i) {
        if (this.dFF != i || this.Sg == null || !this.Sg.isPlaying()) {
            this.dFF = i;
            this.dXd = i;
            if (!v.J(this.mDatas) && this.bMI != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.dFF <= this.mDatas.size() - 1 && (this.mDatas.get(this.dFF) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dFF);
                    hVar2.setAutoPlay(true);
                    if (j.kY() || com.baidu.tieba.video.g.bGn().bGo()) {
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
        i iVar2 = this.Sg;
        this.Sg = iVar;
        if (iVar2 != null && iVar2 != this.Sg) {
            iVar2.stopPlay();
        }
    }

    public void hi(boolean z) {
        this.dXa.hi(z);
    }
}
