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
/* loaded from: classes22.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Xe;
    private j Zc;
    private String eAX;
    private TbPageContext eIc;
    private boolean iOS;
    private c jkF;
    private e jll;
    private com.baidu.afd.a.b jlm;
    private com.baidu.adp.widget.ListView.a jln;
    private a jlq;
    RecyclerView.SmoothScroller jlr;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private boolean jlo = false;
    private int iOT = -1;
    private int jlp = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.iOS = false;
        this.eIc = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Xe = bdTypeRecyclerView;
        this.iOS = z;
        this.jkF = cVar;
        this.mFrom = str;
        this.eAX = str2;
        LY();
    }

    private void LY() {
        this.jll = new e(this.eIc, this, this.jkF, this.iOS, this.mFrom, this.eAX, this, this.mBdUniqueId, this, this);
        this.jlm = new com.baidu.afd.a.b(this.eIc, com.baidu.afd.b.YG, this, this.jkF, this);
        this.jln = new com.baidu.afd.a.c(this.eIc, com.baidu.afd.b.YF);
        this.bky.add(this.jll);
        this.bky.add(this.jln);
        this.bky.add(this.jlm);
        this.Xe.addAdapters(this.bky);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jlo) {
                this.jlo = false;
                this.Xe.setData(this.mDatas);
            } else {
                this.Xe.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.iOS && z) {
                cBl();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dOu().dOv()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.iOT != -1 ? this.iOT : this.jlp;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dOu().dOv()) {
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
            this.jlo = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.iOZ.mcnLeadPage = gVar.iOZ.mcnLeadPage;
            gVar2.iOZ.iPj = gVar.iOZ.iPj;
        }
    }

    public void aO(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).iOY != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).iOY.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).iOY.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Xe != null && this.Xe.getListAdapter() != null) {
            this.Xe.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jll.onDestroy();
        this.jlm.onDestory();
    }

    public boolean rx() {
        return this.jll.rx() || this.jlm.rx();
    }

    public boolean cGF() {
        return this.jll.cGF();
    }

    public void rv() {
        this.jll.rv();
        this.jlm.rv();
    }

    public void rw() {
        this.jll.rw();
        this.jlm.rw();
    }

    public void cGS() {
        this.jll.cGS();
    }

    public void cGT() {
        this.jll.cGT();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jll.onConfigurationChanged(configuration);
    }

    public boolean zm(int i) {
        return this.jll.zm(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void zl(int i) {
        AN(i);
    }

    public int cBj() {
        return this.iOT;
    }

    public void cBk() {
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
        cBl();
    }

    private void cBl() {
        cBk();
        this.iOT = 0;
        this.jlp = -1;
        rv();
    }

    public void AN(int i) {
        this.iOT = i;
        this.jlp = i;
        if (!y.isEmpty(this.mDatas) && this.Xe != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.iOT < this.mDatas.size() - 1) {
                int AO = AO(i);
                int i2 = this.iOT + AO;
                this.iOT = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dOu().dOv()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jlr == null) {
                        this.jlr = new LinearSmoothScroller(this.eIc.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.jlr.setTargetPosition(AO + this.Xe.getHeaderViewsCount() + i);
                    this.Xe.getLayoutManager().startSmoothScroll(this.jlr);
                    notifyDataSetChanged();
                }
            } else if (this.iOT == this.mDatas.size() - 1 && (this.mDatas.get(this.iOT) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.iOT);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dOu().dOv()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int AO(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean AP(int i) {
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
            com.baidu.afd.e rr = ((com.baidu.afd.d) qVar).rr();
            if (rr == null || rr.YQ) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void AQ(int i) {
        if (this.iOT != i || this.Zc == null || !this.Zc.isPlaying()) {
            if (this.iOT != i || this.Zc == null || !cGF()) {
                this.iOT = i;
                this.jlp = i;
                if (!y.isEmpty(this.mDatas) && this.Xe != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.iOT <= this.mDatas.size() - 1 && (this.mDatas.get(this.iOT) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.iOT);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dOu().dOv()) {
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
        j jVar2 = this.Zc;
        this.Zc = jVar;
        if (jVar2 != null && jVar2 != this.Zc) {
            jVar2.stopPlay();
        }
    }

    public a cGU() {
        return this.jlq;
    }

    public void qB(boolean z) {
        this.jll.qB(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Ld(String str) {
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
        bVar.bc(i6);
        bVar.bb(i5);
        bVar.bd(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.b bVar) {
        if (bVar instanceof a) {
            this.jlq = (a) bVar;
        }
    }
}
