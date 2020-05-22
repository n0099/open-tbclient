package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.view.i;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Vw;
    private j Xp;
    private String dCp;
    private TbPageContext dIF;
    private c hNL;
    private e hOr;
    private com.baidu.afd.a.b hOs;
    private com.baidu.adp.widget.ListView.a hOt;
    private a hOw;
    RecyclerView.SmoothScroller hOx;
    private boolean htn;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<o> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private boolean hOu = false;
    private int hto = -1;
    private int hOv = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.htn = false;
        this.dIF = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Vw = bdTypeRecyclerView;
        this.htn = z;
        this.hNL = cVar;
        this.mFrom = str;
        this.dCp = str2;
        CY();
    }

    private void CY() {
        this.hOr = new e(this.dIF, this, this.hNL, this.htn, this.mFrom, this.dCp, this, this.mBdUniqueId, this, this);
        this.hOs = new com.baidu.afd.a.b(this.dIF, com.baidu.afd.b.WQ, this, this.hNL, this);
        this.hOt = new com.baidu.afd.a.c(this.dIF, com.baidu.afd.b.WP);
        this.aSj.add(this.hOr);
        this.aSj.add(this.hOt);
        this.aSj.add(this.hOs);
        this.Vw.addAdapters(this.aSj);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.hOu) {
                this.hOu = false;
                this.Vw.setData(this.mDatas);
            } else {
                this.Vw.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.htn && z) {
                bXC();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dhK().dhL()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.hto != -1 ? this.hto : this.hOv;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhK().dhL()) {
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
            this.hOu = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.htu.mcnLeadPage = gVar.htu.mcnLeadPage;
            gVar2.htu.htF = gVar.htu.htF;
        }
    }

    public void aE(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (o oVar : this.mDatas) {
                if (oVar != null && (oVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) oVar).htt != null && str.equals(((com.baidu.tieba.frs.aggregation.g) oVar).htt.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) oVar).htt.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Vw != null && this.Vw.getListAdapter() != null) {
            this.Vw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hOr.onDestroy();
        this.hOs.onDestory();
    }

    public boolean pB() {
        return this.hOr.pB() || this.hOs.pB();
    }

    public boolean ccB() {
        return this.hOr.ccB();
    }

    public void pz() {
        this.hOr.pz();
        this.hOs.pz();
    }

    public void pA() {
        this.hOr.pA();
        this.hOs.pA();
    }

    public void ccO() {
        this.hOr.ccO();
    }

    public void ccP() {
        this.hOr.ccP();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hOr.onConfigurationChanged(configuration);
    }

    public boolean uk(int i) {
        return this.hOr.uk(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void uj(int i) {
        vK(i);
    }

    public int bXA() {
        return this.hto;
    }

    public void bXB() {
        if (!v.isEmpty(this.mDatas)) {
            for (o oVar : this.mDatas) {
                if (oVar instanceof i) {
                    i iVar = (i) oVar;
                    iVar.setAutoPlay(false);
                    iVar.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bXC();
    }

    private void bXC() {
        bXB();
        this.hto = 0;
        this.hOv = -1;
        pz();
    }

    public void vK(int i) {
        this.hto = i;
        this.hOv = i;
        if (!v.isEmpty(this.mDatas) && this.Vw != null) {
            for (o oVar : this.mDatas) {
                if (oVar instanceof i) {
                    ((i) oVar).setAutoPlay(false);
                    ((i) oVar).setWaitConfirm(false);
                }
            }
            if (this.hto < this.mDatas.size() - 1) {
                int vL = vL(i);
                int i2 = this.hto + vL;
                this.hto = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhK().dhL()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.hOx == null) {
                        this.hOx = new LinearSmoothScroller(this.dIF.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.hOx.setTargetPosition(vL + this.Vw.getHeaderViewsCount() + i);
                    this.Vw.getLayoutManager().startSmoothScroll(this.hOx);
                    notifyDataSetChanged();
                }
            } else if (this.hto == this.mDatas.size() - 1 && (this.mDatas.get(this.hto) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.hto);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhK().dhL()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int vL(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean vM(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return f(this.mDatas.get(i));
    }

    private boolean f(o oVar) {
        boolean z = true;
        if (oVar == null) {
            return false;
        }
        if (oVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (oVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e pv = ((com.baidu.afd.d) oVar).pv();
            if (pv == null || pv.Xc) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void vN(int i) {
        if (this.hto != i || this.Xp == null || !this.Xp.isPlaying()) {
            if (this.hto != i || this.Xp == null || !ccB()) {
                this.hto = i;
                this.hOv = i;
                if (!v.isEmpty(this.mDatas) && this.Vw != null) {
                    for (o oVar : this.mDatas) {
                        if (oVar instanceof i) {
                            ((i) oVar).setAutoPlay(false);
                            ((i) oVar).setWaitConfirm(false);
                        }
                    }
                    if (this.hto <= this.mDatas.size() - 1 && (this.mDatas.get(this.hto) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.hto);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhK().dhL()) {
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
        j jVar2 = this.Xp;
        this.Xp = jVar;
        if (jVar2 != null && jVar2 != this.Xp) {
            jVar2.stopPlay();
        }
    }

    public a ccQ() {
        return this.hOw;
    }

    public void nS(boolean z) {
        this.hOr.nS(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Fm(String str) {
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
        bVar.aN(i6);
        bVar.aM(i5);
        bVar.aO(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.b bVar) {
        if (bVar instanceof a) {
            this.hOw = (a) bVar;
        }
    }
}
