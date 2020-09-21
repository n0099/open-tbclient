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
/* loaded from: classes21.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView WM;
    private j YL;
    private String eaC;
    private TbPageContext ehG;
    private c iDv;
    private e iEb;
    private com.baidu.afd.a.b iEc;
    private com.baidu.adp.widget.ListView.a iEd;
    private a iEg;
    RecyclerView.SmoothScroller iEh;
    private boolean ihC;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private boolean iEe = false;
    private int ihD = -1;
    private int iEf = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.ihC = false;
        this.ehG = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.WM = bdTypeRecyclerView;
        this.ihC = z;
        this.iDv = cVar;
        this.mFrom = str;
        this.eaC = str2;
        JZ();
    }

    private void JZ() {
        this.iEb = new e(this.ehG, this, this.iDv, this.ihC, this.mFrom, this.eaC, this, this.mBdUniqueId, this, this);
        this.iEc = new com.baidu.afd.a.b(this.ehG, com.baidu.afd.b.Yp, this, this.iDv, this);
        this.iEd = new com.baidu.afd.a.c(this.ehG, com.baidu.afd.b.Yo);
        this.bdV.add(this.iEb);
        this.bdV.add(this.iEd);
        this.bdV.add(this.iEc);
        this.WM.addAdapters(this.bdV);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.iEe) {
                this.iEe = false;
                this.WM.setData(this.mDatas);
            } else {
                this.WM.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.ihC && z) {
                csg();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dEY().dEZ()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.ihD != -1 ? this.ihD : this.iEf;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dEY().dEZ()) {
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
            this.iEe = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.ihJ.mcnLeadPage = gVar.ihJ.mcnLeadPage;
            gVar2.ihJ.ihT = gVar.ihJ.ihT;
        }
    }

    public void aI(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).ihI != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).ihI.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).ihI.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.WM != null && this.WM.getListAdapter() != null) {
            this.WM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iEb.onDestroy();
        this.iEc.onDestory();
    }

    public boolean rx() {
        return this.iEb.rx() || this.iEc.rx();
    }

    public boolean cxA() {
        return this.iEb.cxA();
    }

    public void rv() {
        this.iEb.rv();
        this.iEc.rv();
    }

    public void rw() {
        this.iEb.rw();
        this.iEc.rw();
    }

    public void cxN() {
        this.iEb.cxN();
    }

    public void cxO() {
        this.iEb.cxO();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iEb.onConfigurationChanged(configuration);
    }

    public boolean ya(int i) {
        return this.iEb.ya(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void xZ(int i) {
        zB(i);
    }

    public int cse() {
        return this.ihD;
    }

    public void csf() {
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
        csg();
    }

    private void csg() {
        csf();
        this.ihD = 0;
        this.iEf = -1;
        rv();
    }

    public void zB(int i) {
        this.ihD = i;
        this.iEf = i;
        if (!y.isEmpty(this.mDatas) && this.WM != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.ihD < this.mDatas.size() - 1) {
                int zC = zC(i);
                int i2 = this.ihD + zC;
                this.ihD = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dEY().dEZ()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.iEh == null) {
                        this.iEh = new LinearSmoothScroller(this.ehG.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.iEh.setTargetPosition(zC + this.WM.getHeaderViewsCount() + i);
                    this.WM.getLayoutManager().startSmoothScroll(this.iEh);
                    notifyDataSetChanged();
                }
            } else if (this.ihD == this.mDatas.size() - 1 && (this.mDatas.get(this.ihD) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.ihD);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dEY().dEZ()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int zC(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean zD(int i) {
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
            if (rr == null || rr.Yz) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void zE(int i) {
        if (this.ihD != i || this.YL == null || !this.YL.isPlaying()) {
            if (this.ihD != i || this.YL == null || !cxA()) {
                this.ihD = i;
                this.iEf = i;
                if (!y.isEmpty(this.mDatas) && this.WM != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.ihD <= this.mDatas.size() - 1 && (this.mDatas.get(this.ihD) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.ihD);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dEY().dEZ()) {
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
        j jVar2 = this.YL;
        this.YL = jVar;
        if (jVar2 != null && jVar2 != this.YL) {
            jVar2.stopPlay();
        }
    }

    public a cxP() {
        return this.iEg;
    }

    public void pv(boolean z) {
        this.iEb.pv(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b JA(String str) {
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
            this.iEg = (a) bVar;
        }
    }
}
