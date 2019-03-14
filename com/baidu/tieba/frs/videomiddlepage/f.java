package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f {
    private BdTypeRecyclerView Qr;
    private i Tz;
    private String byA;
    private boolean feL;
    private c fwZ;
    private e fxB;
    private com.baidu.afd.a.b fxC;
    private com.baidu.adp.widget.ListView.a fxD;
    RecyclerView.SmoothScroller fxG;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean fxE = false;
    private int feM = -1;
    private int fxF = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.feL = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Qr = bdTypeRecyclerView;
        this.feL = z;
        this.fwZ = cVar;
        this.mFrom = str;
        this.byA = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.fxB = new e(this.mContext, this, this.fwZ, this.feL, this.mFrom, this.byA, this, this.mBdUniqueId, this);
        this.fxC = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.Tc, this, this.fwZ, this);
        this.fxD = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.Tb);
        this.mAdapters.add(this.fxB);
        this.mAdapters.add(this.fxD);
        this.mAdapters.add(this.fxC);
        this.Qr.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fxE) {
                this.fxE = false;
                this.Qr.setData(this.mDatas);
            } else {
                this.Qr.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.feL && z) {
                beV();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.la() && !com.baidu.tieba.video.g.ciP().ciQ()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.feM != -1 ? this.feM : this.fxF;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kZ() || com.baidu.tieba.video.g.ciP().ciQ()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.T(this.mDatas) && this.mDatas.get(0) != null) {
            this.fxE = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.feS.mcnLeadPage = gVar.feS.mcnLeadPage;
            gVar2.feS.ffc = gVar.feS.ffc;
        }
    }

    public void af(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).feR != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).feR.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).feR.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Qr != null && this.Qr.getListAdapter() != null) {
            this.Qr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fxB.onDestroy();
        this.fxC.onDestory();
    }

    public boolean pY() {
        return this.fxB.pY() || this.fxC.pY();
    }

    public boolean bjF() {
        return this.fxB.bjF();
    }

    public void pW() {
        this.fxB.pW();
        this.fxC.pW();
    }

    public void pX() {
        this.fxB.pX();
        this.fxC.pX();
    }

    public void bjS() {
        this.fxB.bjS();
    }

    public void bjT() {
        this.fxB.bjT();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fxB.onConfigurationChanged(configuration);
    }

    public boolean qw(int i) {
        return this.fxB.qw(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qv(int i) {
        rL(i);
    }

    public int beT() {
        return this.feM;
    }

    public void beU() {
        if (!v.T(this.mDatas)) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) mVar;
                    hVar.setAutoPlay(false);
                    hVar.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        beV();
    }

    private void beV() {
        beU();
        this.feM = 0;
        this.fxF = -1;
        pW();
    }

    public void rL(int i) {
        this.feM = i;
        this.fxF = i;
        if (!v.T(this.mDatas) && this.Qr != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) mVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) mVar).setWaitConfirm(false);
                }
            }
            if (this.feM < this.mDatas.size() - 1) {
                int rM = rM(i);
                int i2 = this.feM + rM;
                this.feM = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar.setAutoPlay(true);
                    if (j.kZ() || com.baidu.tieba.video.g.ciP().ciQ()) {
                        hVar.setWaitConfirm(false);
                    } else {
                        hVar.setWaitConfirm(true);
                    }
                    if (this.fxG == null) {
                        this.fxG = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fxG.setTargetPosition(rM + this.Qr.getHeaderViewsCount() + i);
                    this.Qr.getLayoutManager().startSmoothScroll(this.fxG);
                    notifyDataSetChanged();
                }
            } else if (this.feM == this.mDatas.size() - 1 && (this.mDatas.get(this.feM) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.feM);
                hVar2.setAutoPlay(true);
                if (j.kZ() || com.baidu.tieba.video.g.ciP().ciQ()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int rM(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (g(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean rN(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return g(this.mDatas.get(i));
    }

    private boolean g(m mVar) {
        boolean z = true;
        if (mVar == null) {
            return false;
        }
        if (mVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (mVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e pS = ((com.baidu.afd.d) mVar).pS();
            if (pS == null || pS.Tn) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void rO(int i) {
        if (this.feM != i || this.Tz == null || !this.Tz.isPlaying()) {
            if (this.feM != i || this.Tz == null || !bjF()) {
                this.feM = i;
                this.fxF = i;
                if (!v.T(this.mDatas) && this.Qr != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof com.baidu.tieba.lego.card.view.h) {
                            ((com.baidu.tieba.lego.card.view.h) mVar).setAutoPlay(false);
                            ((com.baidu.tieba.lego.card.view.h) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.feM <= this.mDatas.size() - 1 && (this.mDatas.get(this.feM) instanceof com.baidu.tieba.lego.card.view.h)) {
                        com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.feM);
                        hVar.setAutoPlay(true);
                        if (j.kZ() || com.baidu.tieba.video.g.ciP().ciQ()) {
                            hVar.setWaitConfirm(false);
                        } else {
                            hVar.setWaitConfirm(true);
                        }
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        i iVar2 = this.Tz;
        this.Tz = iVar;
        if (iVar2 != null && iVar2 != this.Tz) {
            iVar2.stopPlay();
        }
    }

    public void jW(boolean z) {
        this.fxB.jW(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b vP(String str) {
        int i;
        int i2 = -1;
        if (this.mDatas == null || this.mDatas.isEmpty() || str == null) {
            return null;
        }
        com.baidu.afd.videopaster.data.b bVar = new com.baidu.afd.videopaster.data.b();
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i3 >= this.mDatas.size()) {
                i = -1;
                break;
            }
            if (this.mDatas.get(i3) instanceof com.baidu.afd.d) {
                if (g(this.mDatas.get(i3))) {
                    if (z) {
                        i = i3;
                        break;
                    }
                    i6 = i3;
                } else if (z) {
                    i4++;
                }
            }
            if ((this.mDatas.get(i3) instanceof com.baidu.tieba.frs.aggregation.g) && str.equals(((com.baidu.tieba.frs.aggregation.g) this.mDatas.get(i3)).getThreadId())) {
                z = true;
                i5 = i3;
            }
            i3++;
        }
        if (i == -1 || (i = i - i4) >= -1) {
            i2 = i;
        }
        bVar.setVideoId(str);
        bVar.bn(i6);
        bVar.bm(i5);
        bVar.bo(i2);
        return bVar;
    }
}
