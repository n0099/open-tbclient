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
    private j Ba;
    private String bZb;
    private TbPageContext cfl;
    private boolean fBB;
    private c fUE;
    private e fVj;
    private com.baidu.afd.a.b fVk;
    private com.baidu.adp.widget.ListView.a fVl;
    private a fVo;
    RecyclerView.SmoothScroller fVp;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private BdTypeRecyclerView zj;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private boolean fVm = false;
    private int fBC = -1;
    private int fVn = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fBB = false;
        this.cfl = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.zj = bdTypeRecyclerView;
        this.fBB = z;
        this.fUE = cVar;
        this.mFrom = str;
        this.bZb = str2;
        sX();
    }

    private void sX() {
        this.fVj = new e(this.cfl, this, this.fUE, this.fBB, this.mFrom, this.bZb, this, this.mBdUniqueId, this, this);
        this.fVk = new com.baidu.afd.a.b(this.cfl, com.baidu.afd.b.AA, this, this.fUE, this);
        this.fVl = new com.baidu.afd.a.c(this.cfl, com.baidu.afd.b.Az);
        this.agQ.add(this.fVj);
        this.agQ.add(this.fVl);
        this.agQ.add(this.fVk);
        this.zj.addAdapters(this.agQ);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fVm) {
                this.fVm = false;
                this.zj.setData(this.mDatas);
            } else {
                this.zj.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fBB && z) {
                bms();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.csD().csE()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fBC != -1 ? this.fBC : this.fVn;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csD().csE()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.fVm = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.fBI.mcnLeadPage = gVar.fBI.mcnLeadPage;
            gVar2.fBI.fBS = gVar.fBI.fBS;
        }
    }

    public void ah(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).fBH != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).fBH.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).fBH.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.zj != null && this.zj.getListAdapter() != null) {
            this.zj.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fVj.onDestroy();
        this.fVk.onDestory();
    }

    public boolean kk() {
        return this.fVj.kk() || this.fVk.kk();
    }

    public boolean brf() {
        return this.fVj.brf();
    }

    public void ki() {
        this.fVj.ki();
        this.fVk.ki();
    }

    public void kj() {
        this.fVj.kj();
        this.fVk.kj();
    }

    public void brr() {
        this.fVj.brr();
    }

    public void brs() {
        this.fVj.brs();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fVj.onConfigurationChanged(configuration);
    }

    public boolean qP(int i) {
        return this.fVj.qP(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qO(int i) {
        sh(i);
    }

    public int bmq() {
        return this.fBC;
    }

    public void bmr() {
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
        bms();
    }

    private void bms() {
        bmr();
        this.fBC = 0;
        this.fVn = -1;
        ki();
    }

    public void sh(int i) {
        this.fBC = i;
        this.fVn = i;
        if (!v.isEmpty(this.mDatas) && this.zj != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.fBC < this.mDatas.size() - 1) {
                int si = si(i);
                int i2 = this.fBC + si;
                this.fBC = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csD().csE()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.fVp == null) {
                        this.fVp = new LinearSmoothScroller(this.cfl.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fVp.setTargetPosition(si + this.zj.getHeaderViewsCount() + i);
                    this.zj.getLayoutManager().startSmoothScroll(this.fVp);
                    notifyDataSetChanged();
                }
            } else if (this.fBC == this.mDatas.size() - 1 && (this.mDatas.get(this.fBC) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.fBC);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csD().csE()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int si(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean sj(int i) {
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
            com.baidu.afd.e ke = ((com.baidu.afd.d) mVar).ke();
            if (ke == null || ke.AN) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void sk(int i) {
        if (this.fBC != i || this.Ba == null || !this.Ba.isPlaying()) {
            if (this.fBC != i || this.Ba == null || !brf()) {
                this.fBC = i;
                this.fVn = i;
                if (!v.isEmpty(this.mDatas) && this.zj != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fBC <= this.mDatas.size() - 1 && (this.mDatas.get(this.fBC) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.fBC);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csD().csE()) {
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
        j jVar2 = this.Ba;
        this.Ba = jVar;
        if (jVar2 != null && jVar2 != this.Ba) {
            jVar2.stopPlay();
        }
    }

    public void kM(boolean z) {
        this.fVj.kM(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b wC(String str) {
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
        bVar.au(i6);
        bVar.at(i5);
        bVar.av(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.a aVar) {
        if (aVar instanceof a) {
            this.fVo = (a) aVar;
        }
    }
}
