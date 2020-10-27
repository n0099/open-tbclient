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
    private TbPageContext eCn;
    private String eve;
    private boolean iIV;
    private c jeH;
    private e jfn;
    private com.baidu.afd.a.b jfo;
    private com.baidu.adp.widget.ListView.a jfp;
    private a jfs;
    RecyclerView.SmoothScroller jft;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private boolean jfq = false;
    private int iIW = -1;
    private int jfr = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.iIV = false;
        this.eCn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Xe = bdTypeRecyclerView;
        this.iIV = z;
        this.jeH = cVar;
        this.mFrom = str;
        this.eve = str2;
        Ly();
    }

    private void Ly() {
        this.jfn = new e(this.eCn, this, this.jeH, this.iIV, this.mFrom, this.eve, this, this.mBdUniqueId, this, this);
        this.jfo = new com.baidu.afd.a.b(this.eCn, com.baidu.afd.b.YG, this, this.jeH, this);
        this.jfp = new com.baidu.afd.a.c(this.eCn, com.baidu.afd.b.YF);
        this.bje.add(this.jfn);
        this.bje.add(this.jfp);
        this.bje.add(this.jfo);
        this.Xe.addAdapters(this.bje);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jfq) {
                this.jfq = false;
                this.Xe.setData(this.mDatas);
            } else {
                this.Xe.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.iIV && z) {
                cyK();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dLS().dLT()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.iIW != -1 ? this.iIW : this.jfr;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dLS().dLT()) {
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
            this.jfq = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.iJc.mcnLeadPage = gVar.iJc.mcnLeadPage;
            gVar2.iJc.iJm = gVar.iJc.iJm;
        }
    }

    public void aO(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).iJb != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).iJb.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).iJb.hasFocus = z;
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
        this.jfn.onDestroy();
        this.jfo.onDestory();
    }

    public boolean rx() {
        return this.jfn.rx() || this.jfo.rx();
    }

    public boolean cEe() {
        return this.jfn.cEe();
    }

    public void rv() {
        this.jfn.rv();
        this.jfo.rv();
    }

    public void rw() {
        this.jfn.rw();
        this.jfo.rw();
    }

    public void cEr() {
        this.jfn.cEr();
    }

    public void cEs() {
        this.jfn.cEs();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jfn.onConfigurationChanged(configuration);
    }

    public boolean yZ(int i) {
        return this.jfn.yZ(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void yY(int i) {
        AA(i);
    }

    public int cyI() {
        return this.iIW;
    }

    public void cyJ() {
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
        cyK();
    }

    private void cyK() {
        cyJ();
        this.iIW = 0;
        this.jfr = -1;
        rv();
    }

    public void AA(int i) {
        this.iIW = i;
        this.jfr = i;
        if (!y.isEmpty(this.mDatas) && this.Xe != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.iIW < this.mDatas.size() - 1) {
                int AB = AB(i);
                int i2 = this.iIW + AB;
                this.iIW = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dLS().dLT()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jft == null) {
                        this.jft = new LinearSmoothScroller(this.eCn.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.jft.setTargetPosition(AB + this.Xe.getHeaderViewsCount() + i);
                    this.Xe.getLayoutManager().startSmoothScroll(this.jft);
                    notifyDataSetChanged();
                }
            } else if (this.iIW == this.mDatas.size() - 1 && (this.mDatas.get(this.iIW) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.iIW);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dLS().dLT()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int AB(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean AC(int i) {
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

    public void AD(int i) {
        if (this.iIW != i || this.Zc == null || !this.Zc.isPlaying()) {
            if (this.iIW != i || this.Zc == null || !cEe()) {
                this.iIW = i;
                this.jfr = i;
                if (!y.isEmpty(this.mDatas) && this.Xe != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.iIW <= this.mDatas.size() - 1 && (this.mDatas.get(this.iIW) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.iIW);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dLS().dLT()) {
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

    public a cEt() {
        return this.jfs;
    }

    public void qs(boolean z) {
        this.jfn.qs(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b KM(String str) {
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
            this.jfs = (a) bVar;
        }
    }
}
