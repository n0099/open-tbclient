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
    private c hOy;
    private e hPe;
    private com.baidu.afd.a.b hPf;
    private com.baidu.adp.widget.ListView.a hPg;
    private a hPj;
    RecyclerView.SmoothScroller hPk;
    private boolean hty;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<o> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private boolean hPh = false;
    private int htz = -1;
    private int hPi = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.hty = false;
        this.dIF = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Vw = bdTypeRecyclerView;
        this.hty = z;
        this.hOy = cVar;
        this.mFrom = str;
        this.dCp = str2;
        CY();
    }

    private void CY() {
        this.hPe = new e(this.dIF, this, this.hOy, this.hty, this.mFrom, this.dCp, this, this.mBdUniqueId, this, this);
        this.hPf = new com.baidu.afd.a.b(this.dIF, com.baidu.afd.b.WQ, this, this.hOy, this);
        this.hPg = new com.baidu.afd.a.c(this.dIF, com.baidu.afd.b.WP);
        this.aSj.add(this.hPe);
        this.aSj.add(this.hPg);
        this.aSj.add(this.hPf);
        this.Vw.addAdapters(this.aSj);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.hPh) {
                this.hPh = false;
                this.Vw.setData(this.mDatas);
            } else {
                this.Vw.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.hty && z) {
                bXE();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.dhZ().dia()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.htz != -1 ? this.htz : this.hPi;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhZ().dia()) {
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
            this.hPh = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.htF.mcnLeadPage = gVar.htF.mcnLeadPage;
            gVar2.htF.htQ = gVar.htF.htQ;
        }
    }

    public void aE(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (o oVar : this.mDatas) {
                if (oVar != null && (oVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) oVar).htE != null && str.equals(((com.baidu.tieba.frs.aggregation.g) oVar).htE.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) oVar).htE.hasFocus = z;
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
        this.hPe.onDestroy();
        this.hPf.onDestory();
    }

    public boolean pB() {
        return this.hPe.pB() || this.hPf.pB();
    }

    public boolean ccJ() {
        return this.hPe.ccJ();
    }

    public void pz() {
        this.hPe.pz();
        this.hPf.pz();
    }

    public void pA() {
        this.hPe.pA();
        this.hPf.pA();
    }

    public void ccW() {
        this.hPe.ccW();
    }

    public void ccX() {
        this.hPe.ccX();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hPe.onConfigurationChanged(configuration);
    }

    public boolean um(int i) {
        return this.hPe.um(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ul(int i) {
        vM(i);
    }

    public int bXC() {
        return this.htz;
    }

    public void bXD() {
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
        bXE();
    }

    private void bXE() {
        bXD();
        this.htz = 0;
        this.hPi = -1;
        pz();
    }

    public void vM(int i) {
        this.htz = i;
        this.hPi = i;
        if (!v.isEmpty(this.mDatas) && this.Vw != null) {
            for (o oVar : this.mDatas) {
                if (oVar instanceof i) {
                    ((i) oVar).setAutoPlay(false);
                    ((i) oVar).setWaitConfirm(false);
                }
            }
            if (this.htz < this.mDatas.size() - 1) {
                int vN = vN(i);
                int i2 = this.htz + vN;
                this.htz = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhZ().dia()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.hPk == null) {
                        this.hPk = new LinearSmoothScroller(this.dIF.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.hPk.setTargetPosition(vN + this.Vw.getHeaderViewsCount() + i);
                    this.Vw.getLayoutManager().startSmoothScroll(this.hPk);
                    notifyDataSetChanged();
                }
            } else if (this.htz == this.mDatas.size() - 1 && (this.mDatas.get(this.htz) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.htz);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhZ().dia()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int vN(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean vO(int i) {
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

    public void vP(int i) {
        if (this.htz != i || this.Xp == null || !this.Xp.isPlaying()) {
            if (this.htz != i || this.Xp == null || !ccJ()) {
                this.htz = i;
                this.hPi = i;
                if (!v.isEmpty(this.mDatas) && this.Vw != null) {
                    for (o oVar : this.mDatas) {
                        if (oVar instanceof i) {
                            ((i) oVar).setAutoPlay(false);
                            ((i) oVar).setWaitConfirm(false);
                        }
                    }
                    if (this.htz <= this.mDatas.size() - 1 && (this.mDatas.get(this.htz) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.htz);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.dhZ().dia()) {
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

    public a ccY() {
        return this.hPj;
    }

    public void nS(boolean z) {
        this.hPe.nS(z);
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
            this.hPj = (a) bVar;
        }
    }
}
