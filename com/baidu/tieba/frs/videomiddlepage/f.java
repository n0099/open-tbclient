package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView VT;
    private j XL;
    private String dOV;
    private TbPageContext dVN;
    private boolean hMk;
    private c ihM;
    private e iis;
    private com.baidu.afd.a.b iit;
    private com.baidu.adp.widget.ListView.a iiu;
    private a iix;
    RecyclerView.SmoothScroller iiy;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private boolean iiv = false;
    private int hMl = -1;
    private int iiw = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.hMk = false;
        this.dVN = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.VT = bdTypeRecyclerView;
        this.hMk = z;
        this.ihM = cVar;
        this.mFrom = str;
        this.dOV = str2;
        DS();
    }

    private void DS() {
        this.iis = new e(this.dVN, this, this.ihM, this.hMk, this.mFrom, this.dOV, this, this.mBdUniqueId, this, this);
        this.iit = new com.baidu.afd.a.b(this.dVN, com.baidu.afd.b.Xp, this, this.ihM, this);
        this.iiu = new com.baidu.afd.a.c(this.dVN, com.baidu.afd.b.Xo);
        this.aWf.add(this.iis);
        this.aWf.add(this.iiu);
        this.aWf.add(this.iit);
        this.VT.addAdapters(this.aWf);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.iiv) {
                this.iiv = false;
                this.VT.setData(this.mDatas);
            } else {
                this.VT.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.hMk && z) {
                ceo();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dpz().dpA()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.hMl != -1 ? this.hMl : this.iiw;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dpz().dpA()) {
                    iVar2.setWaitConfirm(false);
                    return;
                }
                iVar2.setWaitConfirm(true);
                notifyDataSetChanged();
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !x.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.iiv = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.hMr.mcnLeadPage = gVar.hMr.mcnLeadPage;
            gVar2.hMr.hMB = gVar.hMr.hMB;
        }
    }

    public void aE(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).hMq != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).hMq.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).hMq.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.VT != null && this.VT.getListAdapter() != null) {
            this.VT.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iis.onDestroy();
        this.iit.onDestory();
    }

    public boolean pT() {
        return this.iis.pT() || this.iit.pT();
    }

    public boolean cjC() {
        return this.iis.cjC();
    }

    public void pR() {
        this.iis.pR();
        this.iit.pR();
    }

    public void pS() {
        this.iis.pS();
        this.iit.pS();
    }

    public void cjP() {
        this.iis.cjP();
    }

    public void cjQ() {
        this.iis.cjQ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iis.onConfigurationChanged(configuration);
    }

    public boolean vj(int i) {
        return this.iis.vj(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void vi(int i) {
        wJ(i);
    }

    public int cem() {
        return this.hMl;
    }

    public void cen() {
        if (!x.isEmpty(this.mDatas)) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    i iVar = (i) qVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        ceo();
    }

    private void ceo() {
        cen();
        this.hMl = 0;
        this.iiw = -1;
        pR();
    }

    public void wJ(int i) {
        this.hMl = i;
        this.iiw = i;
        if (!x.isEmpty(this.mDatas) && this.VT != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.hMl < this.mDatas.size() - 1) {
                int wK = wK(i);
                int i2 = this.hMl + wK;
                this.hMl = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dpz().dpA()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.iiy == null) {
                        this.iiy = new LinearSmoothScroller(this.dVN.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.iiy.setTargetPosition(wK + this.VT.getHeaderViewsCount() + i);
                    this.VT.getLayoutManager().startSmoothScroll(this.iiy);
                    notifyDataSetChanged();
                }
            } else if (this.hMl == this.mDatas.size() - 1 && (this.mDatas.get(this.hMl) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.hMl);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dpz().dpA()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int wK(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean wL(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return f(this.mDatas.get(i));
    }

    private boolean f(q qVar) {
        boolean z = true;
        if (qVar == null) {
            return false;
        }
        if (qVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (qVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e pN = ((com.baidu.afd.d) qVar).pN();
            if (pN == null || pN.Xz) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void wM(int i) {
        if (this.hMl != i || this.XL == null || !this.XL.isPlaying()) {
            if (this.hMl != i || this.XL == null || !cjC()) {
                this.hMl = i;
                this.iiw = i;
                if (!x.isEmpty(this.mDatas) && this.VT != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.hMl <= this.mDatas.size() - 1 && (this.mDatas.get(this.hMl) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.hMl);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dpz().dpA()) {
                            iVar.setWaitConfirm(false);
                        } else {
                            iVar.setWaitConfirm(true);
                        }
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        j jVar2 = this.XL;
        this.XL = jVar;
        if (jVar2 != null && jVar2 != this.XL) {
            jVar2.stopPlay();
        }
    }

    public a cjR() {
        return this.iix;
    }

    public void oJ(boolean z) {
        this.iis.oJ(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Gz(String str) {
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
                if (f(this.mDatas.get(i3))) {
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
        bVar.aV(i6);
        bVar.aU(i5);
        bVar.aW(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.b bVar) {
        if (bVar instanceof a) {
            this.iix = (a) bVar;
        }
    }
}
