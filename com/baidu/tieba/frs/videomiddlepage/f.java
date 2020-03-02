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
    private String cOR;
    private TbPageContext cVh;
    private c gNA;
    private e gOg;
    private com.baidu.afd.a.b gOh;
    private com.baidu.adp.widget.ListView.a gOi;
    private a gOl;
    RecyclerView.SmoothScroller gOm;
    private boolean gus;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private boolean gOj = false;
    private int gut = -1;
    private int gOk = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.gus = false;
        this.cVh = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.BK = bdTypeRecyclerView;
        this.gus = z;
        this.gNA = cVar;
        this.mFrom = str;
        this.cOR = str2;
        wM();
    }

    private void wM() {
        this.gOg = new e(this.cVh, this, this.gNA, this.gus, this.mFrom, this.cOR, this, this.mBdUniqueId, this, this);
        this.gOh = new com.baidu.afd.a.b(this.cVh, com.baidu.afd.b.De, this, this.gNA, this);
        this.gOi = new com.baidu.afd.a.c(this.cVh, com.baidu.afd.b.Dd);
        this.asE.add(this.gOg);
        this.asE.add(this.gOi);
        this.asE.add(this.gOh);
        this.BK.addAdapters(this.asE);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.gOj) {
                this.gOj = false;
                this.BK.setData(this.mDatas);
            } else {
                this.BK.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.gus && z) {
                bGt();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPh().cPi()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.gut != -1 ? this.gut : this.gOk;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPh().cPi()) {
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
            this.gOj = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.guz.mcnLeadPage = gVar.guz.mcnLeadPage;
            gVar2.guz.guK = gVar.guz.guK;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).guy != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).guy.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).guy.hasFocus = z;
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
        this.gOg.onDestroy();
        this.gOh.onDestory();
    }

    public boolean kR() {
        return this.gOg.kR() || this.gOh.kR();
    }

    public boolean bLj() {
        return this.gOg.bLj();
    }

    public void kP() {
        this.gOg.kP();
        this.gOh.kP();
    }

    public void kQ() {
        this.gOg.kQ();
        this.gOh.kQ();
    }

    public void bLw() {
        this.gOg.bLw();
    }

    public void bLx() {
        this.gOg.bLx();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gOg.onConfigurationChanged(configuration);
    }

    public boolean tf(int i) {
        return this.gOg.tf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void te(int i) {
        uz(i);
    }

    public int bGr() {
        return this.gut;
    }

    public void bGs() {
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
        bGt();
    }

    private void bGt() {
        bGs();
        this.gut = 0;
        this.gOk = -1;
        kP();
    }

    public void uz(int i) {
        this.gut = i;
        this.gOk = i;
        if (!v.isEmpty(this.mDatas) && this.BK != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.gut < this.mDatas.size() - 1) {
                int uA = uA(i);
                int i2 = this.gut + uA;
                this.gut = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPh().cPi()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.gOm == null) {
                        this.gOm = new LinearSmoothScroller(this.cVh.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.gOm.setTargetPosition(uA + this.BK.getHeaderViewsCount() + i);
                    this.BK.getLayoutManager().startSmoothScroll(this.gOm);
                    notifyDataSetChanged();
                }
            } else if (this.gut == this.mDatas.size() - 1 && (this.mDatas.get(this.gut) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.gut);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPh().cPi()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int uA(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean uB(int i) {
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

    public void uC(int i) {
        if (this.gut != i || this.DD == null || !this.DD.isPlaying()) {
            if (this.gut != i || this.DD == null || !bLj()) {
                this.gut = i;
                this.gOk = i;
                if (!v.isEmpty(this.mDatas) && this.BK != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.gut <= this.mDatas.size() - 1 && (this.mDatas.get(this.gut) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.gut);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPh().cPi()) {
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

    public a bLy() {
        return this.gOl;
    }

    public void mn(boolean z) {
        this.gOg.mn(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b BR(String str) {
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
            this.gOl = (a) aVar;
        }
    }
}
