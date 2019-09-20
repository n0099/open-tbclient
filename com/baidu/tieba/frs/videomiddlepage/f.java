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
/* loaded from: classes4.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Oo;
    private j RB;
    private String bHq;
    private boolean fCk;
    private e fVP;
    private com.baidu.afd.a.b fVQ;
    private com.baidu.adp.widget.ListView.a fVR;
    private a fVU;
    RecyclerView.SmoothScroller fVV;
    private c fVk;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean fVS = false;
    private int fCl = -1;
    private int fVT = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fCk = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Oo = bdTypeRecyclerView;
        this.fCk = z;
        this.fVk = cVar;
        this.mFrom = str;
        this.bHq = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.fVP = new e(this.mContext, this, this.fVk, this.fCk, this.mFrom, this.bHq, this, this.mBdUniqueId, this, this);
        this.fVQ = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.Rd, this, this.fVk, this);
        this.fVR = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.Rc);
        this.mAdapters.add(this.fVP);
        this.mAdapters.add(this.fVR);
        this.mAdapters.add(this.fVQ);
        this.Oo.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fVS) {
                this.fVS = false;
                this.Oo.setData(this.mDatas);
            } else {
                this.Oo.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fCk && z) {
                bpn();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.ke() && !com.baidu.tieba.video.g.cuO().cuP()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fCl != -1 ? this.fCl : this.fVT;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cuO().cuP()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.aa(this.mDatas) && this.mDatas.get(0) != null) {
            this.fVS = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.fCr.mcnLeadPage = gVar.fCr.mcnLeadPage;
            gVar2.fCr.fCB = gVar.fCr.fCB;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).fCq != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).fCq.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).fCq.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Oo != null && this.Oo.getListAdapter() != null) {
            this.Oo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fVP.onDestroy();
        this.fVQ.onDestory();
    }

    public boolean pp() {
        return this.fVP.pp() || this.fVQ.pp();
    }

    public boolean buc() {
        return this.fVP.buc();
    }

    public void pn() {
        this.fVP.pn();
        this.fVQ.pn();
    }

    public void po() {
        this.fVP.po();
        this.fVQ.po();
    }

    public void bup() {
        this.fVP.bup();
    }

    public void buq() {
        this.fVP.buq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fVP.onConfigurationChanged(configuration);
    }

    public boolean rW(int i) {
        return this.fVP.rW(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void rV(int i) {
        tn(i);
    }

    public int bpl() {
        return this.fCl;
    }

    public void bpm() {
        if (!v.aa(this.mDatas)) {
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
        bpn();
    }

    private void bpn() {
        bpm();
        this.fCl = 0;
        this.fVT = -1;
        pn();
    }

    public void tn(int i) {
        this.fCl = i;
        this.fVT = i;
        if (!v.aa(this.mDatas) && this.Oo != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.fCl < this.mDatas.size() - 1) {
                int i2 = to(i);
                int i3 = this.fCl + i2;
                this.fCl = i3;
                if (this.mDatas.get(i3) instanceof i) {
                    i iVar = (i) this.mDatas.get(i3);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cuO().cuP()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.fVV == null) {
                        this.fVV = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
                            @Override // android.support.v7.widget.LinearSmoothScroller
                            public int calculateDtToFit(int i4, int i5, int i6, int i7, int i8) {
                                return (((i7 - i6) / 5) + i6) - (((i5 - i4) / 5) + i4);
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
                    this.fVV.setTargetPosition(i2 + this.Oo.getHeaderViewsCount() + i);
                    this.Oo.getLayoutManager().startSmoothScroll(this.fVV);
                    notifyDataSetChanged();
                }
            } else if (this.fCl == this.mDatas.size() - 1 && (this.mDatas.get(this.fCl) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.fCl);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cuO().cuP()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int to(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (g(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean tp(int i) {
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
            com.baidu.afd.e pj = ((com.baidu.afd.d) mVar).pj();
            if (pj == null || pj.Rp) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void tq(int i) {
        if (this.fCl != i || this.RB == null || !this.RB.isPlaying()) {
            if (this.fCl != i || this.RB == null || !buc()) {
                this.fCl = i;
                this.fVT = i;
                if (!v.aa(this.mDatas) && this.Oo != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fCl <= this.mDatas.size() - 1 && (this.mDatas.get(this.fCl) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.fCl);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cuO().cuP()) {
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
        j jVar2 = this.RB;
        this.RB = jVar;
        if (jVar2 != null && jVar2 != this.RB) {
            jVar2.stopPlay();
        }
    }

    public void kZ(boolean z) {
        this.fVP.kZ(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b yk(String str) {
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
        bVar.bf(i6);
        bVar.be(i5);
        bVar.bg(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.a aVar) {
        if (aVar instanceof a) {
            this.fVU = (a) aVar;
        }
    }
}
