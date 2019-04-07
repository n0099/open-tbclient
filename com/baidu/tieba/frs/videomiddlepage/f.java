package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f {
    private BdTypeRecyclerView Qr;
    private i Tz;
    private String byD;
    private boolean fey;
    private c fwM;
    private e fxp;
    private com.baidu.afd.a.b fxq;
    private com.baidu.adp.widget.ListView.a fxr;
    RecyclerView.SmoothScroller fxu;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean fxs = false;
    private int fez = -1;
    private int fxt = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fey = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Qr = bdTypeRecyclerView;
        this.fey = z;
        this.fwM = cVar;
        this.mFrom = str;
        this.byD = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.fxp = new e(this.mContext, this, this.fwM, this.fey, this.mFrom, this.byD, this, this.mBdUniqueId, this);
        this.fxq = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.Tc, this, this.fwM, this);
        this.fxr = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.Tb);
        this.mAdapters.add(this.fxp);
        this.mAdapters.add(this.fxr);
        this.mAdapters.add(this.fxq);
        this.Qr.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fxs) {
                this.fxs = false;
                this.Qr.setData(this.mDatas);
            } else {
                this.Qr.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fey && z) {
                beT();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.la() && !com.baidu.tieba.video.g.ciN().ciO()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fez != -1 ? this.fez : this.fxt;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i);
                hVar2.setAutoPlay(true);
                if (j.kZ() || com.baidu.tieba.video.g.ciN().ciO()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.T(this.mDatas) && this.mDatas.get(0) != null) {
            this.fxs = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.feF.mcnLeadPage = gVar.feF.mcnLeadPage;
            gVar2.feF.feP = gVar.feF.feP;
        }
    }

    public void af(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).feE != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).feE.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).feE.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Qr != null && this.Qr.getListAdapter() != null) {
            this.Qr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fxp.onDestroy();
        this.fxq.onDestory();
    }

    public boolean pY() {
        return this.fxp.pY() || this.fxq.pY();
    }

    public boolean bjD() {
        return this.fxp.bjD();
    }

    public void pW() {
        this.fxp.pW();
        this.fxq.pW();
    }

    public void pX() {
        this.fxp.pX();
        this.fxq.pX();
    }

    public void bjQ() {
        this.fxp.bjQ();
    }

    public void bjR() {
        this.fxp.bjR();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fxp.onConfigurationChanged(configuration);
    }

    public boolean qs(int i) {
        return this.fxp.qs(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qr(int i) {
        rH(i);
    }

    public int beR() {
        return this.fez;
    }

    public void beS() {
        if (!v.T(this.mDatas)) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) mVar;
                    hVar.setAutoPlay(false);
                    hVar.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        beT();
    }

    private void beT() {
        beS();
        this.fez = 0;
        this.fxt = -1;
        pW();
    }

    public void rH(int i) {
        this.fez = i;
        this.fxt = i;
        if (!v.T(this.mDatas) && this.Qr != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) mVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) mVar).setWaitConfirm(false);
                }
            }
            if (this.fez < this.mDatas.size() - 1) {
                int rI = rI(i);
                int i2 = this.fez + rI;
                this.fez = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    hVar.setAutoPlay(true);
                    if (j.kZ() || com.baidu.tieba.video.g.ciN().ciO()) {
                        hVar.setWaitConfirm(false);
                    } else {
                        hVar.setWaitConfirm(true);
                    }
                    if (this.fxu == null) {
                        this.fxu = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fxu.setTargetPosition(rI + this.Qr.getHeaderViewsCount() + i);
                    this.Qr.getLayoutManager().startSmoothScroll(this.fxu);
                    notifyDataSetChanged();
                }
            } else if (this.fez == this.mDatas.size() - 1 && (this.mDatas.get(this.fez) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.fez);
                hVar2.setAutoPlay(true);
                if (j.kZ() || com.baidu.tieba.video.g.ciN().ciO()) {
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int rI(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (g(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean rJ(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return g(this.mDatas.get(i));
    }

    private boolean g(m mVar) {
        boolean z = true;
        if (mVar == null) {
            return false;
        }
        if (mVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (mVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e pS = ((com.baidu.afd.d) mVar).pS();
            if (pS == null || pS.Tn) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void rK(int i) {
        if (this.fez != i || this.Tz == null || !this.Tz.isPlaying()) {
            if (this.fez != i || this.Tz == null || !bjD()) {
                this.fez = i;
                this.fxt = i;
                if (!v.T(this.mDatas) && this.Qr != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof com.baidu.tieba.lego.card.view.h) {
                            ((com.baidu.tieba.lego.card.view.h) mVar).setAutoPlay(false);
                            ((com.baidu.tieba.lego.card.view.h) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fez <= this.mDatas.size() - 1 && (this.mDatas.get(this.fez) instanceof com.baidu.tieba.lego.card.view.h)) {
                        com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.fez);
                        hVar.setAutoPlay(true);
                        if (j.kZ() || com.baidu.tieba.video.g.ciN().ciO()) {
                            hVar.setWaitConfirm(false);
                        } else {
                            hVar.setWaitConfirm(true);
                        }
                        notifyDataSetChanged();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        i iVar2 = this.Tz;
        this.Tz = iVar;
        if (iVar2 != null && iVar2 != this.Tz) {
            iVar2.stopPlay();
        }
    }

    public void jW(boolean z) {
        this.fxp.jW(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b vO(String str) {
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
                if (g(this.mDatas.get(i3))) {
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
        bVar.bm(i6);
        bVar.bl(i5);
        bVar.bn(i2);
        return bVar;
    }
}
