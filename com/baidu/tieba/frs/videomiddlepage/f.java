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
    private BdTypeRecyclerView Ya;
    private k aaL;
    private String eLs;
    private TbPageContext eSJ;
    private c jGN;
    private e jHt;
    private com.baidu.afd.adapter.a jHu;
    private com.baidu.adp.widget.ListView.a jHv;
    private a jHy;
    RecyclerView.SmoothScroller jHz;
    private boolean jie;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private boolean jHw = false;
    private int jif = -1;
    private int jHx = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.jie = false;
        this.eSJ = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Ya = bdTypeRecyclerView;
        this.jie = z;
        this.jGN = cVar;
        this.mFrom = str;
        this.eLs = str2;
        IY();
    }

    private void IY() {
        this.jHt = new e(this.eSJ, this, this.jGN, this.jie, this.mFrom, this.eLs, this, this.mBdUniqueId, this, this);
        this.jHu = new com.baidu.afd.adapter.a(this.eSJ, com.baidu.afd.b.aap, this, this.jGN, this);
        this.jHv = new com.baidu.afd.adapter.b(this.eSJ, com.baidu.afd.b.aao);
        this.bjZ.add(this.jHt);
        this.bjZ.add(this.jHv);
        this.bjZ.add(this.jHu);
        this.Ya.addAdapters(this.bjZ);
    }

    public void setData(List<BaseCardInfo> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.jHw) {
                this.jHw = false;
                this.Ya.setData(this.mDatas);
            } else {
                this.Ya.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.jie && z) {
                cEi();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (j.isMobileNet() && !com.baidu.tieba.video.f.dPM().dPN()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.jif != -1 ? this.jif : this.jHx;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.f.dPM().dPN()) {
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
            this.jHw = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.jil.mcnLeadPage = gVar.jil.mcnLeadPage;
            gVar2.jil.jiv = gVar.jil.jiv;
        }
    }

    public void aP(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (n nVar : this.mDatas) {
                if (nVar != null && (nVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) nVar).jik != null && str.equals(((com.baidu.tieba.frs.aggregation.g) nVar).jik.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) nVar).jik.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Ya != null && this.Ya.getListAdapter() != null) {
            this.Ya.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jHt.onDestroy();
        this.jHu.onDestory();
    }

    public boolean rb() {
        return this.jHt.rb() || this.jHu.rb();
    }

    public boolean cKM() {
        return this.jHt.cKM();
    }

    public void qZ() {
        this.jHt.qZ();
        this.jHu.qZ();
    }

    public void ra() {
        this.jHt.ra();
        this.jHu.ra();
    }

    public void cKZ() {
        this.jHt.cKZ();
    }

    public void cLa() {
        this.jHt.cLa();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jHt.onConfigurationChanged(configuration);
    }

    public boolean yV(int i) {
        return this.jHt.yV(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void yU(int i) {
        AG(i);
    }

    public int cEg() {
        return this.jif;
    }

    public void cEh() {
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
        cEi();
    }

    private void cEi() {
        cEh();
        this.jif = 0;
        this.jHx = -1;
        qZ();
    }

    public void AG(int i) {
        this.jif = i;
        this.jHx = i;
        if (!x.isEmpty(this.mDatas) && this.Ya != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof i) {
                    ((i) nVar).setAutoPlay(false);
                    ((i) nVar).setWaitConfirm(false);
                }
            }
            if (this.jif < this.mDatas.size() - 1) {
                int AH = AH(i);
                int i2 = this.jif + AH;
                this.jif = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (j.isWifiNet() || com.baidu.tieba.video.f.dPM().dPN()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.jHz == null) {
                        this.jHz = new LinearSmoothScroller(this.eSJ.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.jHz.setTargetPosition(AH + this.Ya.getHeaderViewsCount() + i);
                    this.Ya.getLayoutManager().startSmoothScroll(this.jHz);
                    notifyDataSetChanged();
                }
            } else if (this.jif == this.mDatas.size() - 1 && (this.mDatas.get(this.jif) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.jif);
                iVar2.setAutoPlay(true);
                if (j.isWifiNet() || com.baidu.tieba.video.f.dPM().dPN()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int AH(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean AI(int i) {
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
            if (qV == null || qV.aaz) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void AJ(int i) {
        if (this.jif != i || this.aaL == null || !this.aaL.isPlaying()) {
            if (this.jif != i || this.aaL == null || !cKM()) {
                this.jif = i;
                this.jHx = i;
                if (!x.isEmpty(this.mDatas) && this.Ya != null) {
                    for (n nVar : this.mDatas) {
                        if (nVar instanceof i) {
                            ((i) nVar).setAutoPlay(false);
                            ((i) nVar).setWaitConfirm(false);
                        }
                    }
                    if (this.jif <= this.mDatas.size() - 1 && (this.mDatas.get(this.jif) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.jif);
                        iVar.setAutoPlay(true);
                        if (j.isWifiNet() || com.baidu.tieba.video.f.dPM().dPN()) {
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
        k kVar2 = this.aaL;
        this.aaL = kVar;
        if (kVar2 != null && kVar2 != this.aaL) {
            kVar2.stopPlay();
        }
    }

    public a cLb() {
        return this.jHy;
    }

    public void rA(boolean z) {
        this.jHt.rA(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b KA(String str) {
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
            this.jHy = (a) bVar;
        }
    }
}
