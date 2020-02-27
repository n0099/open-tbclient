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
    private String cOQ;
    private TbPageContext cVg;
    private c gNy;
    private e gOe;
    private com.baidu.afd.a.b gOf;
    private com.baidu.adp.widget.ListView.a gOg;
    private a gOj;
    RecyclerView.SmoothScroller gOk;
    private boolean guq;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private boolean gOh = false;
    private int gur = -1;
    private int gOi = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.guq = false;
        this.cVg = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.BK = bdTypeRecyclerView;
        this.guq = z;
        this.gNy = cVar;
        this.mFrom = str;
        this.cOQ = str2;
        wM();
    }

    private void wM() {
        this.gOe = new e(this.cVg, this, this.gNy, this.guq, this.mFrom, this.cOQ, this, this.mBdUniqueId, this, this);
        this.gOf = new com.baidu.afd.a.b(this.cVg, com.baidu.afd.b.De, this, this.gNy, this);
        this.gOg = new com.baidu.afd.a.c(this.cVg, com.baidu.afd.b.Dd);
        this.asE.add(this.gOe);
        this.asE.add(this.gOg);
        this.asE.add(this.gOf);
        this.BK.addAdapters(this.asE);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.gOh) {
                this.gOh = false;
                this.BK.setData(this.mDatas);
            } else {
                this.BK.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.guq && z) {
                bGr();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cPf().cPg()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.gur != -1 ? this.gur : this.gOi;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPf().cPg()) {
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
            this.gOh = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.gux.mcnLeadPage = gVar.gux.mcnLeadPage;
            gVar2.gux.guI = gVar.gux.guI;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).guw != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).guw.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).guw.hasFocus = z;
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
        this.gOe.onDestroy();
        this.gOf.onDestory();
    }

    public boolean kR() {
        return this.gOe.kR() || this.gOf.kR();
    }

    public boolean bLh() {
        return this.gOe.bLh();
    }

    public void kP() {
        this.gOe.kP();
        this.gOf.kP();
    }

    public void kQ() {
        this.gOe.kQ();
        this.gOf.kQ();
    }

    public void bLu() {
        this.gOe.bLu();
    }

    public void bLv() {
        this.gOe.bLv();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gOe.onConfigurationChanged(configuration);
    }

    public boolean tf(int i) {
        return this.gOe.tf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void te(int i) {
        uz(i);
    }

    public int bGp() {
        return this.gur;
    }

    public void bGq() {
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
        bGr();
    }

    private void bGr() {
        bGq();
        this.gur = 0;
        this.gOi = -1;
        kP();
    }

    public void uz(int i) {
        this.gur = i;
        this.gOi = i;
        if (!v.isEmpty(this.mDatas) && this.BK != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.gur < this.mDatas.size() - 1) {
                int uA = uA(i);
                int i2 = this.gur + uA;
                this.gur = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPf().cPg()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.gOk == null) {
                        this.gOk = new LinearSmoothScroller(this.cVg.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.gOk.setTargetPosition(uA + this.BK.getHeaderViewsCount() + i);
                    this.BK.getLayoutManager().startSmoothScroll(this.gOk);
                    notifyDataSetChanged();
                }
            } else if (this.gur == this.mDatas.size() - 1 && (this.mDatas.get(this.gur) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.gur);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPf().cPg()) {
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
        if (this.gur != i || this.DD == null || !this.DD.isPlaying()) {
            if (this.gur != i || this.DD == null || !bLh()) {
                this.gur = i;
                this.gOi = i;
                if (!v.isEmpty(this.mDatas) && this.BK != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.gur <= this.mDatas.size() - 1 && (this.mDatas.get(this.gur) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.gur);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cPf().cPg()) {
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

    public a bLw() {
        return this.gOj;
    }

    public void mn(boolean z) {
        this.gOe.mn(z);
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
            this.gOj = (a) aVar;
        }
    }
}
