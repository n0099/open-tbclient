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
/* loaded from: classes22.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Yf;
    private k aae;
    private String eGn;
    private TbPageContext eNx;
    private boolean jaw;
    private c jyS;
    private com.baidu.adp.widget.ListView.a jzA;
    private a jzD;
    RecyclerView.SmoothScroller jzE;
    private e jzy;
    private com.baidu.afd.a.b jzz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private boolean jzB = false;
    private int jax = -1;
    private int jzC = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.jaw = false;
        this.eNx = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Yf = bdTypeRecyclerView;
        this.jaw = z;
        this.jyS = cVar;
        this.mFrom = str;
        this.eGn = str2;
        Nt();
    }

    private void Nt() {
        this.jzy = new e(this.eNx, this, this.jyS, this.jaw, this.mFrom, this.eGn, this, this.mBdUniqueId, this, this);
        this.jzz = new com.baidu.afd.a.b(this.eNx, com.baidu.afd.b.ZI, this, this.jyS, this);
        this.jzA = new com.baidu.afd.a.c(this.eNx, com.baidu.afd.b.ZH);
        this.bnf.add(this.jzy);
        this.bnf.add(this.jzA);
        this.bnf.add(this.jzz);
        this.Yf.addAdapters(this.bnf);
    }

    public void setData(List<BaseCardInfo> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jzB) {
                this.jzB = false;
                this.Yf.setData(this.mDatas);
            } else {
                this.Yf.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.jaw && z) {
                cFe();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (j.isMobileNet() && !com.baidu.tieba.video.g.dTL().dTM()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.jax != -1 ? this.jax : this.jzC;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.g.dTL().dTM()) {
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
            this.jzB = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.jaD.mcnLeadPage = gVar.jaD.mcnLeadPage;
            gVar2.jaD.jaN = gVar.jaD.jaN;
        }
    }

    public void aP(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (q qVar : this.mDatas) {
                if (qVar != null && (qVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) qVar).jaC != null && str.equals(((com.baidu.tieba.frs.aggregation.g) qVar).jaC.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) qVar).jaC.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Yf != null && this.Yf.getListAdapter() != null) {
            this.Yf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jzy.onDestroy();
        this.jzz.onDestory();
    }

    public boolean rz() {
        return this.jzy.rz() || this.jzz.rz();
    }

    public boolean cLz() {
        return this.jzy.cLz();
    }

    public void rx() {
        this.jzy.rx();
        this.jzz.rx();
    }

    public void ry() {
        this.jzy.ry();
        this.jzz.ry();
    }

    public void cLM() {
        this.jzy.cLM();
    }

    public void cLN() {
        this.jzy.cLN();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jzy.onConfigurationChanged(configuration);
    }

    public boolean Ap(int i) {
        return this.jzy.Ap(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void Ao(int i) {
        Ca(i);
    }

    public int cFc() {
        return this.jax;
    }

    public void cFd() {
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
        cFe();
    }

    private void cFe() {
        cFd();
        this.jax = 0;
        this.jzC = -1;
        rx();
    }

    public void Ca(int i) {
        this.jax = i;
        this.jzC = i;
        if (!y.isEmpty(this.mDatas) && this.Yf != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof i) {
                    ((i) qVar).setAutoPlay(false);
                    ((i) qVar).setWaitConfirm(false);
                }
            }
            if (this.jax < this.mDatas.size() - 1) {
                int Cb = Cb(i);
                int i2 = this.jax + Cb;
                this.jax = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (j.isWifiNet() || com.baidu.tieba.video.g.dTL().dTM()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jzE == null) {
                        this.jzE = new LinearSmoothScroller(this.eNx.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.jzE.setTargetPosition(Cb + this.Yf.getHeaderViewsCount() + i);
                    this.Yf.getLayoutManager().startSmoothScroll(this.jzE);
                    notifyDataSetChanged();
                }
            } else if (this.jax == this.mDatas.size() - 1 && (this.mDatas.get(this.jax) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.jax);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.g.dTL().dTM()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int Cb(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean Cc(int i) {
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
            com.baidu.afd.e rt = ((com.baidu.afd.d) qVar).rt();
            if (rt == null || rt.ZS) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void Cd(int i) {
        if (this.jax != i || this.aae == null || !this.aae.isPlaying()) {
            if (this.jax != i || this.aae == null || !cLz()) {
                this.jax = i;
                this.jzC = i;
                if (!y.isEmpty(this.mDatas) && this.Yf != null) {
                    for (q qVar : this.mDatas) {
                        if (qVar instanceof i) {
                            ((i) qVar).setAutoPlay(false);
                            ((i) qVar).setWaitConfirm(false);
                        }
                    }
                    if (this.jax <= this.mDatas.size() - 1 && (this.mDatas.get(this.jax) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.jax);
                        iVar.setAutoPlay(true);
                        if (j.isWifiNet() || com.baidu.tieba.video.g.dTL().dTM()) {
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
        k kVar2 = this.aae;
        this.aae = kVar;
        if (kVar2 != null && kVar2 != this.aae) {
            kVar2.stopPlay();
        }
    }

    public a cLO() {
        return this.jzD;
    }

    public void rf(boolean z) {
        this.jzy.rf(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b LL(String str) {
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
        bVar.bg(i6);
        bVar.bf(i5);
        bVar.bh(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.b bVar) {
        if (bVar instanceof a) {
            this.jzD = (a) bVar;
        }
    }
}
