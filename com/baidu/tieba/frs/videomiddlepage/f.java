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
    private BdTypeRecyclerView Op;
    private j RC;
    private String bGR;
    private c fSD;
    private e fTi;
    private com.baidu.afd.a.b fTj;
    private com.baidu.adp.widget.ListView.a fTk;
    private a fTn;
    RecyclerView.SmoothScroller fTo;
    private boolean fzJ;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean fTl = false;
    private int fzK = -1;
    private int fTm = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fzJ = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Op = bdTypeRecyclerView;
        this.fzJ = z;
        this.fSD = cVar;
        this.mFrom = str;
        this.bGR = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.fTi = new e(this.mContext, this, this.fSD, this.fzJ, this.mFrom, this.bGR, this, this.mBdUniqueId, this, this);
        this.fTj = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.Re, this, this.fSD, this);
        this.fTk = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.Rd);
        this.mAdapters.add(this.fTi);
        this.mAdapters.add(this.fTk);
        this.mAdapters.add(this.fTj);
        this.Op.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fTl) {
                this.fTl = false;
                this.Op.setData(this.mDatas);
            } else {
                this.Op.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fzJ && z) {
                bop();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.ke() && !com.baidu.tieba.video.g.ctE().ctF()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fzK != -1 ? this.fzK : this.fTm;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.ctE().ctF()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.aa(this.mDatas) && this.mDatas.get(0) != null) {
            this.fTl = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.fzQ.mcnLeadPage = gVar.fzQ.mcnLeadPage;
            gVar2.fzQ.fAa = gVar.fzQ.fAa;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).fzP != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).fzP.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).fzP.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Op != null && this.Op.getListAdapter() != null) {
            this.Op.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fTi.onDestroy();
        this.fTj.onDestory();
    }

    public boolean po() {
        return this.fTi.po() || this.fTj.po();
    }

    public boolean btb() {
        return this.fTi.btb();
    }

    public void pm() {
        this.fTi.pm();
        this.fTj.pm();
    }

    public void pn() {
        this.fTi.pn();
        this.fTj.pn();
    }

    public void bto() {
        this.fTi.bto();
    }

    public void btp() {
        this.fTi.btp();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fTi.onConfigurationChanged(configuration);
    }

    public boolean rR(int i) {
        return this.fTi.rR(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void rQ(int i) {
        th(i);
    }

    public int bon() {
        return this.fzK;
    }

    public void boo() {
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
        bop();
    }

    private void bop() {
        boo();
        this.fzK = 0;
        this.fTm = -1;
        pm();
    }

    public void th(int i) {
        this.fzK = i;
        this.fTm = i;
        if (!v.aa(this.mDatas) && this.Op != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.fzK < this.mDatas.size() - 1) {
                int ti = ti(i);
                int i2 = this.fzK + ti;
                this.fzK = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.ctE().ctF()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.fTo == null) {
                        this.fTo = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fTo.setTargetPosition(ti + this.Op.getHeaderViewsCount() + i);
                    this.Op.getLayoutManager().startSmoothScroll(this.fTo);
                    notifyDataSetChanged();
                }
            } else if (this.fzK == this.mDatas.size() - 1 && (this.mDatas.get(this.fzK) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.fzK);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.ctE().ctF()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int ti(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (g(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean tj(int i) {
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
            com.baidu.afd.e pi = ((com.baidu.afd.d) mVar).pi();
            if (pi == null || pi.Rq) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void tk(int i) {
        if (this.fzK != i || this.RC == null || !this.RC.isPlaying()) {
            if (this.fzK != i || this.RC == null || !btb()) {
                this.fzK = i;
                this.fTm = i;
                if (!v.aa(this.mDatas) && this.Op != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fzK <= this.mDatas.size() - 1 && (this.mDatas.get(this.fzK) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.fzK);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.ctE().ctF()) {
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
        j jVar2 = this.RC;
        this.RC = jVar;
        if (jVar2 != null && jVar2 != this.RC) {
            jVar2.stopPlay();
        }
    }

    public void kW(boolean z) {
        this.fTi.kW(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b xK(String str) {
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
            this.fTn = (a) aVar;
        }
    }
}
