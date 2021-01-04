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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Yc;
    private k aaN;
    private String eQd;
    private TbPageContext eXu;
    private e jLZ;
    private c jLt;
    private com.baidu.afd.adapter.a jMa;
    private com.baidu.adp.widget.ListView.a jMb;
    private a jMe;
    RecyclerView.SmoothScroller jMf;
    private boolean jmL;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private boolean jMc = false;
    private int jmM = -1;
    private int jMd = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.jmL = false;
        this.eXu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Yc = bdTypeRecyclerView;
        this.jmL = z;
        this.jLt = cVar;
        this.mFrom = str;
        this.eQd = str2;
        MT();
    }

    private void MT() {
        this.jLZ = new e(this.eXu, this, this.jLt, this.jmL, this.mFrom, this.eQd, this, this.mBdUniqueId, this, this);
        this.jMa = new com.baidu.afd.adapter.a(this.eXu, com.baidu.afd.b.aar, this, this.jLt, this);
        this.jMb = new com.baidu.afd.adapter.b(this.eXu, com.baidu.afd.b.aaq);
        this.boM.add(this.jLZ);
        this.boM.add(this.jMb);
        this.boM.add(this.jMa);
        this.Yc.addAdapters(this.boM);
    }

    public void setData(List<BaseCardInfo> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jMc) {
                this.jMc = false;
                this.Yc.setData(this.mDatas);
            } else {
                this.Yc.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.jmL && z) {
                cHZ();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dTD().dTE()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.jmM != -1 ? this.jmM : this.jMd;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.f.dTD().dTE()) {
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
            this.jMc = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.jmS.mcnLeadPage = gVar.jmS.mcnLeadPage;
            gVar2.jmS.jnc = gVar.jmS.jnc;
        }
    }

    public void aP(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (n nVar : this.mDatas) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) nVar).jmR != null && str.equals(((com.baidu.tieba.frs.aggregation.g) nVar).jmR.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) nVar).jmR.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Yc != null && this.Yc.getListAdapter() != null) {
            this.Yc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jLZ.onDestroy();
        this.jMa.onDestory();
    }

    public boolean rb() {
        return this.jLZ.rb() || this.jMa.rb();
    }

    public boolean cOD() {
        return this.jLZ.cOD();
    }

    public void qZ() {
        this.jLZ.qZ();
        this.jMa.qZ();
    }

    public void ra() {
        this.jLZ.ra();
        this.jMa.ra();
    }

    public void cOQ() {
        this.jLZ.cOQ();
    }

    public void cOR() {
        this.jLZ.cOR();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jLZ.onConfigurationChanged(configuration);
    }

    public boolean AB(int i) {
        return this.jLZ.AB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void AA(int i) {
        Cm(i);
    }

    public int cHX() {
        return this.jmM;
    }

    public void cHY() {
        if (!x.isEmpty(this.mDatas)) {
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
        cHZ();
    }

    private void cHZ() {
        cHY();
        this.jmM = 0;
        this.jMd = -1;
        qZ();
    }

    public void Cm(int i) {
        this.jmM = i;
        this.jMd = i;
        if (!x.isEmpty(this.mDatas) && this.Yc != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof i) {
                    ((i) nVar).setAutoPlay(false);
                    ((i) nVar).setWaitConfirm(false);
                }
            }
            if (this.jmM < this.mDatas.size() - 1) {
                int Cn = Cn(i);
                int i2 = this.jmM + Cn;
                this.jmM = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (j.isWifiNet() || com.baidu.tieba.video.f.dTD().dTE()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jMf == null) {
                        this.jMf = new LinearSmoothScroller(this.eXu.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.jMf.setTargetPosition(Cn + this.Yc.getHeaderViewsCount() + i);
                    this.Yc.getLayoutManager().startSmoothScroll(this.jMf);
                    notifyDataSetChanged();
                }
            } else if (this.jmM == this.mDatas.size() - 1 && (this.mDatas.get(this.jmM) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.jmM);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.f.dTD().dTE()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int Cn(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean Co(int i) {
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
            com.baidu.afd.e qV = ((com.baidu.afd.d) nVar).qV();
            if (qV == null || qV.aaB) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void Cp(int i) {
        if (this.jmM != i || this.aaN == null || !this.aaN.isPlaying()) {
            if (this.jmM != i || this.aaN == null || !cOD()) {
                this.jmM = i;
                this.jMd = i;
                if (!x.isEmpty(this.mDatas) && this.Yc != null) {
                    for (n nVar : this.mDatas) {
                        if (nVar instanceof i) {
                            ((i) nVar).setAutoPlay(false);
                            ((i) nVar).setWaitConfirm(false);
                        }
                    }
                    if (this.jmM <= this.mDatas.size() - 1 && (this.mDatas.get(this.jmM) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.jmM);
                        iVar.setAutoPlay(true);
                        if (j.isWifiNet() || com.baidu.tieba.video.f.dTD().dTE()) {
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
        k kVar2 = this.aaN;
        this.aaN = kVar;
        if (kVar2 != null && kVar2 != this.aaN) {
            kVar2.stopPlay();
        }
    }

    public a cOS() {
        return this.jMe;
    }

    public void rE(boolean z) {
        this.jLZ.rE(z);
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
            this.jMe = (a) bVar;
        }
    }
}
