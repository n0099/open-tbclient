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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Wa;
    private j XT;
    private String dIK;
    private TbPageContext dPv;
    private boolean hGo;
    private c ibK;
    private e icq;
    private com.baidu.afd.a.b icr;
    private com.baidu.adp.widget.ListView.a ics;
    private a icv;
    RecyclerView.SmoothScroller icw;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private boolean ict = false;
    private int hGp = -1;
    private int icu = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.hGo = false;
        this.dPv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Wa = bdTypeRecyclerView;
        this.hGo = z;
        this.ibK = cVar;
        this.mFrom = str;
        this.dIK = str2;
        Dz();
    }

    private void Dz() {
        this.icq = new e(this.dPv, this, this.ibK, this.hGo, this.mFrom, this.dIK, this, this.mBdUniqueId, this, this);
        this.icr = new com.baidu.afd.a.b(this.dPv, com.baidu.afd.b.Xw, this, this.ibK, this);
        this.ics = new com.baidu.afd.a.c(this.dPv, com.baidu.afd.b.Xv);
        this.aUP.add(this.icq);
        this.aUP.add(this.ics);
        this.aUP.add(this.icr);
        this.Wa.addAdapters(this.aUP);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.ict) {
                this.ict = false;
                this.Wa.setData(this.mDatas);
            } else {
                this.Wa.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.hGo && z) {
                caP();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.h.dmk().dml()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.hGp != -1 ? this.hGp : this.icu;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.h.dmk().dml()) {
                    iVar2.setWaitConfirm(false);
                    return;
                }
                iVar2.setWaitConfirm(true);
                notifyDataSetChanged();
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !w.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.ict = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.hGv.mcnLeadPage = gVar.hGv.mcnLeadPage;
            gVar2.hGv.hGG = gVar.hGv.hGG;
        }
    }

    public void aG(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).hGu != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).hGu.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).hGu.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Wa != null && this.Wa.getListAdapter() != null) {
            this.Wa.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.icq.onDestroy();
        this.icr.onDestory();
    }

    public boolean pS() {
        return this.icq.pS() || this.icr.pS();
    }

    public boolean cgc() {
        return this.icq.cgc();
    }

    public void pQ() {
        this.icq.pQ();
        this.icr.pQ();
    }

    public void pR() {
        this.icq.pR();
        this.icr.pR();
    }

    public void cgp() {
        this.icq.cgp();
    }

    public void cgq() {
        this.icq.cgq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.icq.onConfigurationChanged(configuration);
    }

    public boolean uR(int i) {
        return this.icq.uR(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void uQ(int i) {
        wr(i);
    }

    public int caN() {
        return this.hGp;
    }

    public void caO() {
        if (!w.isEmpty(this.mDatas)) {
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
        caP();
    }

    private void caP() {
        caO();
        this.hGp = 0;
        this.icu = -1;
        pQ();
    }

    public void wr(int i) {
        this.hGp = i;
        this.icu = i;
        if (!w.isEmpty(this.mDatas) && this.Wa != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.hGp < this.mDatas.size() - 1) {
                int ws = ws(i);
                int i2 = this.hGp + ws;
                this.hGp = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.h.dmk().dml()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.icw == null) {
                        this.icw = new LinearSmoothScroller(this.dPv.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.icw.setTargetPosition(ws + this.Wa.getHeaderViewsCount() + i);
                    this.Wa.getLayoutManager().startSmoothScroll(this.icw);
                    notifyDataSetChanged();
                }
            } else if (this.hGp == this.mDatas.size() - 1 && (this.mDatas.get(this.hGp) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.hGp);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.h.dmk().dml()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int ws(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean wt(int i) {
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
            com.baidu.afd.e pM = ((com.baidu.afd.d) qVar).pM();
            if (pM == null || pM.XH) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void wu(int i) {
        if (this.hGp != i || this.XT == null || !this.XT.isPlaying()) {
            if (this.hGp != i || this.XT == null || !cgc()) {
                this.hGp = i;
                this.icu = i;
                if (!w.isEmpty(this.mDatas) && this.Wa != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.hGp <= this.mDatas.size() - 1 && (this.mDatas.get(this.hGp) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.hGp);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.h.dmk().dml()) {
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
        j jVar2 = this.XT;
        this.XT = jVar;
        if (jVar2 != null && jVar2 != this.XT) {
            jVar2.stopPlay();
        }
    }

    public a cgr() {
        return this.icv;
    }

    public void oe(boolean z) {
        this.icq.oe(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b FN(String str) {
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
        bVar.aT(i6);
        bVar.aS(i5);
        bVar.aU(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.b bVar) {
        if (bVar instanceof a) {
            this.icv = (a) bVar;
        }
    }
}
