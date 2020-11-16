package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Xi;
    private k Zi;
    private TbPageContext eGu;
    private String ezo;
    private boolean iPF;
    private e jlV;
    private com.baidu.afd.a.b jlW;
    private com.baidu.adp.widget.ListView.a jlX;
    private c jlp;
    private a jma;
    RecyclerView.SmoothScroller jmb;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private boolean jlY = false;
    private int iPG = -1;
    private int jlZ = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.iPF = false;
        this.eGu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Xi = bdTypeRecyclerView;
        this.iPF = z;
        this.jlp = cVar;
        this.mFrom = str;
        this.ezo = str2;
        Lp();
    }

    private void Lp() {
        this.jlV = new e(this.eGu, this, this.jlp, this.iPF, this.mFrom, this.ezo, this, this.mBdUniqueId, this, this);
        this.jlW = new com.baidu.afd.a.b(this.eGu, com.baidu.afd.b.YL, this, this.jlp, this);
        this.jlX = new com.baidu.afd.a.c(this.eGu, com.baidu.afd.b.YK);
        this.biN.add(this.jlV);
        this.biN.add(this.jlX);
        this.biN.add(this.jlW);
        this.Xi.addAdapters(this.biN);
    }

    public void setData(List<BaseCardInfo> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jlY) {
                this.jlY = false;
                this.Xi.setData(this.mDatas);
            } else {
                this.Xi.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.iPF && z) {
                cAO();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dOt().dOu()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.iPG != -1 ? this.iPG : this.jlZ;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.g.dOt().dOu()) {
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
            this.jlY = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.iPM.mcnLeadPage = gVar.iPM.mcnLeadPage;
            gVar2.iPM.iPW = gVar.iPM.iPW;
        }
    }

    public void aO(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).iPL != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).iPL.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).iPL.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Xi != null && this.Xi.getListAdapter() != null) {
            this.Xi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jlV.onDestroy();
        this.jlW.onDestory();
    }

    public boolean rx() {
        return this.jlV.rx() || this.jlW.rx();
    }

    public boolean cGk() {
        return this.jlV.cGk();
    }

    public void rv() {
        this.jlV.rv();
        this.jlW.rv();
    }

    public void rw() {
        this.jlV.rw();
        this.jlW.rw();
    }

    public void cGx() {
        this.jlV.cGx();
    }

    public void cGy() {
        this.jlV.cGy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jlV.onConfigurationChanged(configuration);
    }

    public boolean zK(int i) {
        return this.jlV.zK(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void zJ(int i) {
        Bl(i);
    }

    public int cAM() {
        return this.iPG;
    }

    public void cAN() {
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
        cAO();
    }

    private void cAO() {
        cAN();
        this.iPG = 0;
        this.jlZ = -1;
        rv();
    }

    public void Bl(int i) {
        this.iPG = i;
        this.jlZ = i;
        if (!y.isEmpty(this.mDatas) && this.Xi != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.iPG < this.mDatas.size() - 1) {
                int Bm = Bm(i);
                int i2 = this.iPG + Bm;
                this.iPG = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (j.isWifiNet() || com.baidu.tieba.video.g.dOt().dOu()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jmb == null) {
                        this.jmb = new LinearSmoothScroller(this.eGu.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.jmb.setTargetPosition(Bm + this.Xi.getHeaderViewsCount() + i);
                    this.Xi.getLayoutManager().startSmoothScroll(this.jmb);
                    notifyDataSetChanged();
                }
            } else if (this.iPG == this.mDatas.size() - 1 && (this.mDatas.get(this.iPG) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.iPG);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.g.dOt().dOu()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int Bm(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean Bn(int i) {
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
            if (rr == null || rr.YV) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void Bo(int i) {
        if (this.iPG != i || this.Zi == null || !this.Zi.isPlaying()) {
            if (this.iPG != i || this.Zi == null || !cGk()) {
                this.iPG = i;
                this.jlZ = i;
                if (!y.isEmpty(this.mDatas) && this.Xi != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.iPG <= this.mDatas.size() - 1 && (this.mDatas.get(this.iPG) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.iPG);
                        iVar.setAutoPlay(true);
                        if (j.isWifiNet() || com.baidu.tieba.video.g.dOt().dOu()) {
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
    public void a(k kVar) {
        k kVar2 = this.Zi;
        this.Zi = kVar;
        if (kVar2 != null && kVar2 != this.Zi) {
            kVar2.stopPlay();
        }
    }

    public a cGz() {
        return this.jma;
    }

    public void qE(boolean z) {
        this.jlV.qE(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b KE(String str) {
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
            this.jma = (a) bVar;
        }
    }
}
