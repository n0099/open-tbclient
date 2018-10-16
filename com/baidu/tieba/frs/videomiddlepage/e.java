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
    private b dWD;
    private d dWZ;
    private com.baidu.afd.a.b dXa;
    private com.baidu.adp.widget.ListView.a dXb;
    RecyclerView.SmoothScroller dXd;
    private TbPageContext mContext;
    private String mFrom;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dFF = -1;
    private int dXc = -1;

    public e(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b bVar, boolean z, String str, String str2) {
        this.dFE = false;
        this.mContext = tbPageContext;
        this.bMI = bdTypeRecyclerView;
        this.dFE = z;
        this.dWD = bVar;
        this.mFrom = str;
        this.amT = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dWZ = new d(this.mContext, this, this.dWD, this.dFE, this.mFrom, this.amT, this);
        this.dXa = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.RG, this, this.dWD, this);
        this.dXb = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.RF);
        this.mAdapters.add(this.dWZ);
        this.mAdapters.add(this.dXb);
        this.mAdapters.add(this.dXa);
        this.bMI.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            this.bMI.setDataWithPartChange(this.mDatas, size, list.size());
            if (list.size() > 0 && this.dFE && z) {
                aBS();
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
            int i = this.dFF != -1 ? this.dFF : this.dXc;
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
        this.dWZ.onDestroy();
        this.dXa.onDestory();
    }

    public boolean pE() {
        return this.dWZ.pE() || this.dXa.pE();
    }

    public void pC() {
        this.dWZ.pC();
        this.dXa.pC();
    }

    public void pD() {
        this.dWZ.pD();
        this.dXa.pD();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dWZ.onConfigurationChanged(configuration);
    }

    public boolean lM(int i) {
        return this.dWZ.lM(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void lL(int i) {
        mY(i);
    }

    public int aBQ() {
        return this.dFF;
    }

    public void aBR() {
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
        aBS();
    }

    private void aBS() {
        aBR();
        this.dFF = 0;
        this.dXc = -1;
        pC();
    }

    public void mY(int i) {
        this.dFF = i;
        this.dXc = i;
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
                    if (this.dXd == null) {
                        this.dXd = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
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
                    this.dXd.setTargetPosition(mZ + this.bMI.getHeaderViewsCount() + i);
                    this.bMI.getLayoutManager().startSmoothScroll(this.dXd);
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
            this.dXc = i;
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
        this.dWZ.hi(z);
    }
}
