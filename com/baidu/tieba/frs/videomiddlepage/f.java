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
    private BdTypeRecyclerView Xc;
    private j Zb;
    private String emE;
    private TbPageContext etO;
    private e iSR;
    private com.baidu.afd.a.b iSS;
    private com.baidu.adp.widget.ListView.a iST;
    private a iSW;
    RecyclerView.SmoothScroller iSX;
    private c iSl;
    private boolean iwz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private boolean iSU = false;
    private int iwA = -1;
    private int iSV = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.iwz = false;
        this.etO = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Xc = bdTypeRecyclerView;
        this.iwz = z;
        this.iSl = cVar;
        this.mFrom = str;
        this.emE = str2;
        Le();
    }

    private void Le() {
        this.iSR = new e(this.etO, this, this.iSl, this.iwz, this.mFrom, this.emE, this, this.mBdUniqueId, this, this);
        this.iSS = new com.baidu.afd.a.b(this.etO, com.baidu.afd.b.YF, this, this.iSl, this);
        this.iST = new com.baidu.afd.a.c(this.etO, com.baidu.afd.b.YE);
        this.bhH.add(this.iSR);
        this.bhH.add(this.iST);
        this.bhH.add(this.iSS);
        this.Xc.addAdapters(this.bhH);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.iSU) {
                this.iSU = false;
                this.Xc.setData(this.mDatas);
            } else {
                this.Xc.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.iwz && z) {
                cvD();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dIK().dIL()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.iwA != -1 ? this.iwA : this.iSV;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dIK().dIL()) {
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
            this.iSU = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.iwG.mcnLeadPage = gVar.iwG.mcnLeadPage;
            gVar2.iwG.iwQ = gVar.iwG.iwQ;
        }
    }

    public void aM(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).iwF != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).iwF.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).iwF.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Xc != null && this.Xc.getListAdapter() != null) {
            this.Xc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iSR.onDestroy();
        this.iSS.onDestory();
    }

    public boolean rx() {
        return this.iSR.rx() || this.iSS.rx();
    }

    public boolean cAX() {
        return this.iSR.cAX();
    }

    public void rv() {
        this.iSR.rv();
        this.iSS.rv();
    }

    public void rw() {
        this.iSR.rw();
        this.iSS.rw();
    }

    public void cBk() {
        this.iSR.cBk();
    }

    public void cBl() {
        this.iSR.cBl();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iSR.onConfigurationChanged(configuration);
    }

    public boolean yG(int i) {
        return this.iSR.yG(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void yF(int i) {
        Ah(i);
    }

    public int cvB() {
        return this.iwA;
    }

    public void cvC() {
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
        cvD();
    }

    private void cvD() {
        cvC();
        this.iwA = 0;
        this.iSV = -1;
        rv();
    }

    public void Ah(int i) {
        this.iwA = i;
        this.iSV = i;
        if (!y.isEmpty(this.mDatas) && this.Xc != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.iwA < this.mDatas.size() - 1) {
                int Ai = Ai(i);
                int i2 = this.iwA + Ai;
                this.iwA = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dIK().dIL()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.iSX == null) {
                        this.iSX = new LinearSmoothScroller(this.etO.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.iSX.setTargetPosition(Ai + this.Xc.getHeaderViewsCount() + i);
                    this.Xc.getLayoutManager().startSmoothScroll(this.iSX);
                    notifyDataSetChanged();
                }
            } else if (this.iwA == this.mDatas.size() - 1 && (this.mDatas.get(this.iwA) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.iwA);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dIK().dIL()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int Ai(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean Aj(int i) {
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
            if (rr == null || rr.YP) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void Ak(int i) {
        if (this.iwA != i || this.Zb == null || !this.Zb.isPlaying()) {
            if (this.iwA != i || this.Zb == null || !cAX()) {
                this.iwA = i;
                this.iSV = i;
                if (!y.isEmpty(this.mDatas) && this.Xc != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.iwA <= this.mDatas.size() - 1 && (this.mDatas.get(this.iwA) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.iwA);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dIK().dIL()) {
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
        j jVar2 = this.Zb;
        this.Zb = jVar;
        if (jVar2 != null && jVar2 != this.Zb) {
            jVar2.stopPlay();
        }
    }

    public a cBm() {
        return this.iSW;
    }

    public void qa(boolean z) {
        this.iSR.qa(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Kn(String str) {
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
            this.iSW = (a) bVar;
        }
    }
}
