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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Wu;
    private j Yt;
    private String dYs;
    private TbPageContext efr;
    private boolean iax;
    private c ivZ;
    private e iwF;
    private com.baidu.afd.a.b iwG;
    private com.baidu.adp.widget.ListView.a iwH;
    private a iwK;
    RecyclerView.SmoothScroller iwL;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private boolean iwI = false;
    private int iay = -1;
    private int iwJ = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.iax = false;
        this.efr = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Wu = bdTypeRecyclerView;
        this.iax = z;
        this.ivZ = cVar;
        this.mFrom = str;
        this.dYs = str2;
        Jv();
    }

    private void Jv() {
        this.iwF = new e(this.efr, this, this.ivZ, this.iax, this.mFrom, this.dYs, this, this.mBdUniqueId, this, this);
        this.iwG = new com.baidu.afd.a.b(this.efr, com.baidu.afd.b.XW, this, this.ivZ, this);
        this.iwH = new com.baidu.afd.a.c(this.efr, com.baidu.afd.b.XV);
        this.bbw.add(this.iwF);
        this.bbw.add(this.iwH);
        this.bbw.add(this.iwG);
        this.Wu.addAdapters(this.bbw);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.iwI) {
                this.iwI = false;
                this.Wu.setData(this.mDatas);
            } else {
                this.Wu.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.iax && z) {
                coT();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dBe().dBf()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.iay != -1 ? this.iay : this.iwJ;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dBe().dBf()) {
                    iVar2.setWaitConfirm(false);
                    return;
                }
                iVar2.setWaitConfirm(true);
                notifyDataSetChanged();
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !y.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.iwI = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.iaE.mcnLeadPage = gVar.iaE.mcnLeadPage;
            gVar2.iaE.iaO = gVar.iaE.iaO;
        }
    }

    public void aI(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).iaD != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).iaD.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).iaD.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Wu != null && this.Wu.getListAdapter() != null) {
            this.Wu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iwF.onDestroy();
        this.iwG.onDestory();
    }

    public boolean rs() {
        return this.iwF.rs() || this.iwG.rs();
    }

    public boolean cuh() {
        return this.iwF.cuh();
    }

    public void rq() {
        this.iwF.rq();
        this.iwG.rq();
    }

    public void rr() {
        this.iwF.rr();
        this.iwG.rr();
    }

    public void cuu() {
        this.iwF.cuu();
    }

    public void cuv() {
        this.iwF.cuv();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iwF.onConfigurationChanged(configuration);
    }

    public boolean xB(int i) {
        return this.iwF.xB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void xA(int i) {
        zd(i);
    }

    public int coR() {
        return this.iay;
    }

    public void coS() {
        if (!y.isEmpty(this.mDatas)) {
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
        coT();
    }

    private void coT() {
        coS();
        this.iay = 0;
        this.iwJ = -1;
        rq();
    }

    public void zd(int i) {
        this.iay = i;
        this.iwJ = i;
        if (!y.isEmpty(this.mDatas) && this.Wu != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.iay < this.mDatas.size() - 1) {
                int ze = ze(i);
                int i2 = this.iay + ze;
                this.iay = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dBe().dBf()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.iwL == null) {
                        this.iwL = new LinearSmoothScroller(this.efr.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.iwL.setTargetPosition(ze + this.Wu.getHeaderViewsCount() + i);
                    this.Wu.getLayoutManager().startSmoothScroll(this.iwL);
                    notifyDataSetChanged();
                }
            } else if (this.iay == this.mDatas.size() - 1 && (this.mDatas.get(this.iay) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.iay);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dBe().dBf()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int ze(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean zf(int i) {
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
            com.baidu.afd.e rm = ((com.baidu.afd.d) qVar).rm();
            if (rm == null || rm.Yh) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void zg(int i) {
        if (this.iay != i || this.Yt == null || !this.Yt.isPlaying()) {
            if (this.iay != i || this.Yt == null || !cuh()) {
                this.iay = i;
                this.iwJ = i;
                if (!y.isEmpty(this.mDatas) && this.Wu != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.iay <= this.mDatas.size() - 1 && (this.mDatas.get(this.iay) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.iay);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dBe().dBf()) {
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
        j jVar2 = this.Yt;
        this.Yt = jVar;
        if (jVar2 != null && jVar2 != this.Yt) {
            jVar2.stopPlay();
        }
    }

    public a cuw() {
        return this.iwK;
    }

    public void pp(boolean z) {
        this.iwF.pp(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Jc(String str) {
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
        bVar.aY(i6);
        bVar.aX(i5);
        bVar.aZ(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.b bVar) {
        if (bVar instanceof a) {
            this.iwK = (a) bVar;
        }
    }
}
