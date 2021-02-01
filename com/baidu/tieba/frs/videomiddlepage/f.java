package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView XW;
    private k aaH;
    private String eNE;
    private TbPageContext eUY;
    private e jMX;
    private com.baidu.afd.adapter.a jMY;
    private com.baidu.adp.widget.ListView.a jMZ;
    private c jMr;
    private a jNc;
    RecyclerView.SmoothScroller jNd;
    private boolean jnL;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private boolean jNa = false;
    private int jnM = -1;
    private int jNb = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.jnL = false;
        this.eUY = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.XW = bdTypeRecyclerView;
        this.jnL = z;
        this.jMr = cVar;
        this.mFrom = str;
        this.eNE = str2;
        Kw();
    }

    private void Kw() {
        this.jMX = new e(this.eUY, this, this.jMr, this.jnL, this.mFrom, this.eNE, this, this.mBdUniqueId, this, this);
        this.jMY = new com.baidu.afd.adapter.a(this.eUY, com.baidu.afd.b.aal, this, this.jMr, this);
        this.jMZ = new com.baidu.afd.adapter.b(this.eUY, com.baidu.afd.b.aak);
        this.bns.add(this.jMX);
        this.bns.add(this.jMZ);
        this.bns.add(this.jMY);
        this.XW.addAdapters(this.bns);
    }

    public void setData(List<BaseCardInfo> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jNa) {
                this.jNa = false;
                this.XW.setData(this.mDatas);
            } else {
                this.XW.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.jnL && z) {
                cFu();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dRX().dRY()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.jnM != -1 ? this.jnM : this.jNb;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.f.dRX().dRY()) {
                    iVar2.setWaitConfirm(false);
                    return;
                }
                iVar2.setWaitConfirm(true);
                notifyDataSetChanged();
            }
        }
    }

    public void m(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !y.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.jNa = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.jnS.mcnLeadPage = gVar.jnS.mcnLeadPage;
            gVar2.jnS.joc = gVar.jnS.joc;
        }
    }

    public void aO(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (n nVar : this.mDatas) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) nVar).jnR != null && str.equals(((com.baidu.tieba.frs.aggregation.g) nVar).jnR.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) nVar).jnR.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.XW != null && this.XW.getListAdapter() != null) {
            this.XW.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jMX.onDestroy();
        this.jMY.onDestory();
    }

    public boolean qZ() {
        return this.jMX.qZ() || this.jMY.qZ();
    }

    public boolean cMa() {
        return this.jMX.cMa();
    }

    public void qX() {
        this.jMX.qX();
        this.jMY.qX();
    }

    public void qY() {
        this.jMX.qY();
        this.jMY.qY();
    }

    public void cMn() {
        this.jMX.cMn();
    }

    public void cMo() {
        this.jMX.cMo();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jMX.onConfigurationChanged(configuration);
    }

    public boolean zf(int i) {
        return this.jMX.zf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ze(int i) {
        AQ(i);
    }

    public int cFs() {
        return this.jnM;
    }

    public void cFt() {
        if (!y.isEmpty(this.mDatas)) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof i) {
                    i iVar = (i) nVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cFu();
    }

    private void cFu() {
        cFt();
        this.jnM = 0;
        this.jNb = -1;
        qX();
    }

    public void AQ(int i) {
        this.jnM = i;
        this.jNb = i;
        if (!y.isEmpty(this.mDatas) && this.XW != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof i) {
                    ((i) nVar).setAutoPlay(false);
                    ((i) nVar).setWaitConfirm(false);
                }
            }
            if (this.jnM < this.mDatas.size() - 1) {
                int AR = AR(i);
                int i2 = this.jnM + AR;
                this.jnM = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (j.isWifiNet() || com.baidu.tieba.video.f.dRX().dRY()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jNd == null) {
                        this.jNd = new LinearSmoothScroller(this.eUY.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
                            @Override // androidx.recyclerview.widget.LinearSmoothScroller
                            public int calculateDtToFit(int i3, int i4, int i5, int i6, int i7) {
                                return (((i6 - i5) / 5) + i5) - (((i4 - i3) / 5) + i3);
                            }

                            @Override // androidx.recyclerview.widget.LinearSmoothScroller
                            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                                return 0.2f;
                            }

                            @Override // androidx.recyclerview.widget.LinearSmoothScroller
                            protected int getVerticalSnapPreference() {
                                return -1;
                            }
                        };
                    }
                    this.jNd.setTargetPosition(AR + this.XW.getHeaderViewsCount() + i);
                    this.XW.getLayoutManager().startSmoothScroll(this.jNd);
                    notifyDataSetChanged();
                }
            } else if (this.jnM == this.mDatas.size() - 1 && (this.mDatas.get(this.jnM) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.jnM);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.f.dRX().dRY()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int AR(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean AS(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return f(this.mDatas.get(i));
    }

    private boolean f(n nVar) {
        boolean z = true;
        if (nVar == null) {
            return false;
        }
        if (nVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (nVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e qT = ((com.baidu.afd.d) nVar).qT();
            if (qT == null || qT.aav) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void AT(int i) {
        if (this.jnM != i || this.aaH == null || !this.aaH.isPlaying()) {
            if (this.jnM != i || this.aaH == null || !cMa()) {
                this.jnM = i;
                this.jNb = i;
                if (!y.isEmpty(this.mDatas) && this.XW != null) {
                    for (n nVar : this.mDatas) {
                        if (nVar instanceof i) {
                            ((i) nVar).setAutoPlay(false);
                            ((i) nVar).setWaitConfirm(false);
                        }
                    }
                    if (this.jnM <= this.mDatas.size() - 1 && (this.mDatas.get(this.jnM) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.jnM);
                        iVar.setAutoPlay(true);
                        if (j.isWifiNet() || com.baidu.tieba.video.f.dRX().dRY()) {
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
        k kVar2 = this.aaH;
        this.aaH = kVar;
        if (kVar2 != null && kVar2 != this.aaH) {
            kVar2.stopPlay();
        }
    }

    public a cMp() {
        return this.jNc;
    }

    public void rK(boolean z) {
        this.jMX.rK(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Ll(String str) {
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
            this.jNc = (a) bVar;
        }
    }
}
