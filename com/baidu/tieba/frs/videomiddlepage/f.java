package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView BK;
    private j DD;
    private String cPf;
    private TbPageContext cVv;
    private c gOT;
    private com.baidu.afd.a.b gPA;
    private com.baidu.adp.widget.ListView.a gPB;
    private a gPE;
    RecyclerView.SmoothScroller gPF;
    private e gPz;
    private boolean gvi;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private boolean gPC = false;
    private int gvj = -1;
    private int gPD = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.gvi = false;
        this.cVv = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.BK = bdTypeRecyclerView;
        this.gvi = z;
        this.gOT = cVar;
        this.mFrom = str;
        this.cPf = str2;
        wR();
    }

    private void wR() {
        this.gPz = new e(this.cVv, this, this.gOT, this.gvi, this.mFrom, this.cPf, this, this.mBdUniqueId, this, this);
        this.gPA = new com.baidu.afd.a.b(this.cVv, com.baidu.afd.b.De, this, this.gOT, this);
        this.gPB = new com.baidu.afd.a.c(this.cVv, com.baidu.afd.b.Dd);
        this.asP.add(this.gPz);
        this.asP.add(this.gPB);
        this.asP.add(this.gPA);
        this.BK.addAdapters(this.asP);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.gPC) {
                this.gPC = false;
                this.BK.setData(this.mDatas);
            } else {
                this.BK.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.gvi && z) {
                bGG();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPC().cPD()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.gvj != -1 ? this.gvj : this.gPD;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPC().cPD()) {
                    iVar2.setWaitConfirm(false);
                    return;
                }
                iVar2.setWaitConfirm(true);
                notifyDataSetChanged();
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.gPC = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.gvp.mcnLeadPage = gVar.gvp.mcnLeadPage;
            gVar2.gvp.gvA = gVar.gvp.gvA;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).gvo != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).gvo.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).gvo.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.BK != null && this.BK.getListAdapter() != null) {
            this.BK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gPz.onDestroy();
        this.gPA.onDestory();
    }

    public boolean kR() {
        return this.gPz.kR() || this.gPA.kR();
    }

    public boolean bLy() {
        return this.gPz.bLy();
    }

    public void kP() {
        this.gPz.kP();
        this.gPA.kP();
    }

    public void kQ() {
        this.gPz.kQ();
        this.gPA.kQ();
    }

    public void bLL() {
        this.gPz.bLL();
    }

    public void bLM() {
        this.gPz.bLM();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gPz.onConfigurationChanged(configuration);
    }

    public boolean th(int i) {
        return this.gPz.th(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void tg(int i) {
        uG(i);
    }

    public int bGE() {
        return this.gvj;
    }

    public void bGF() {
        if (!v.isEmpty(this.mDatas)) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    i iVar = (i) mVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bGG();
    }

    private void bGG() {
        bGF();
        this.gvj = 0;
        this.gPD = -1;
        kP();
    }

    public void uG(int i) {
        this.gvj = i;
        this.gPD = i;
        if (!v.isEmpty(this.mDatas) && this.BK != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.gvj < this.mDatas.size() - 1) {
                int uH = uH(i);
                int i2 = this.gvj + uH;
                this.gvj = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPC().cPD()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.gPF == null) {
                        this.gPF = new LinearSmoothScroller(this.cVv.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.gPF.setTargetPosition(uH + this.BK.getHeaderViewsCount() + i);
                    this.BK.getLayoutManager().startSmoothScroll(this.gPF);
                    notifyDataSetChanged();
                }
            } else if (this.gvj == this.mDatas.size() - 1 && (this.mDatas.get(this.gvj) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.gvj);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPC().cPD()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int uH(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean uI(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return f(this.mDatas.get(i));
    }

    private boolean f(m mVar) {
        boolean z = true;
        if (mVar == null) {
            return false;
        }
        if (mVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (mVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e kL = ((com.baidu.afd.d) mVar).kL();
            if (kL == null || kL.Dq) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void uJ(int i) {
        if (this.gvj != i || this.DD == null || !this.DD.isPlaying()) {
            if (this.gvj != i || this.DD == null || !bLy()) {
                this.gvj = i;
                this.gPD = i;
                if (!v.isEmpty(this.mDatas) && this.BK != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.gvj <= this.mDatas.size() - 1 && (this.mDatas.get(this.gvj) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.gvj);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPC().cPD()) {
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
        j jVar2 = this.DD;
        this.DD = jVar;
        if (jVar2 != null && jVar2 != this.DD) {
            jVar2.stopPlay();
        }
    }

    public a bLN() {
        return this.gPE;
    }

    public void mt(boolean z) {
        this.gPz.mt(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b BS(String str) {
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
        bVar.aA(i6);
        bVar.az(i5);
        bVar.aB(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.a aVar) {
        if (aVar instanceof a) {
            this.gPE = (a) aVar;
        }
    }
}
