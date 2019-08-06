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
    private String bGS;
    private boolean fAx;
    private e fTY;
    private com.baidu.afd.a.b fTZ;
    private c fTt;
    private com.baidu.adp.widget.ListView.a fUa;
    private a fUd;
    RecyclerView.SmoothScroller fUe;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean fUb = false;
    private int fAy = -1;
    private int fUc = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fAx = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Op = bdTypeRecyclerView;
        this.fAx = z;
        this.fTt = cVar;
        this.mFrom = str;
        this.bGS = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.fTY = new e(this.mContext, this, this.fTt, this.fAx, this.mFrom, this.bGS, this, this.mBdUniqueId, this, this);
        this.fTZ = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.Re, this, this.fTt, this);
        this.fUa = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.Rd);
        this.mAdapters.add(this.fTY);
        this.mAdapters.add(this.fUa);
        this.mAdapters.add(this.fTZ);
        this.Op.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fUb) {
                this.fUb = false;
                this.Op.setData(this.mDatas);
            } else {
                this.Op.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fAx && z) {
                boC();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.ke() && !com.baidu.tieba.video.g.cua().cub()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fAy != -1 ? this.fAy : this.fUc;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cua().cub()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.aa(this.mDatas) && this.mDatas.get(0) != null) {
            this.fUb = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.fAE.mcnLeadPage = gVar.fAE.mcnLeadPage;
            gVar2.fAE.fAO = gVar.fAE.fAO;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).fAD != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).fAD.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).fAD.hasFocus = z;
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
        this.fTY.onDestroy();
        this.fTZ.onDestory();
    }

    public boolean po() {
        return this.fTY.po() || this.fTZ.po();
    }

    public boolean bto() {
        return this.fTY.bto();
    }

    public void pm() {
        this.fTY.pm();
        this.fTZ.pm();
    }

    public void pn() {
        this.fTY.pn();
        this.fTZ.pn();
    }

    public void btB() {
        this.fTY.btB();
    }

    public void btC() {
        this.fTY.btC();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fTY.onConfigurationChanged(configuration);
    }

    public boolean rT(int i) {
        return this.fTY.rT(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void rS(int i) {
        tj(i);
    }

    public int boA() {
        return this.fAy;
    }

    public void boB() {
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
        boC();
    }

    private void boC() {
        boB();
        this.fAy = 0;
        this.fUc = -1;
        pm();
    }

    public void tj(int i) {
        this.fAy = i;
        this.fUc = i;
        if (!v.aa(this.mDatas) && this.Op != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.fAy < this.mDatas.size() - 1) {
                int tk = tk(i);
                int i2 = this.fAy + tk;
                this.fAy = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cua().cub()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.fUe == null) {
                        this.fUe = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fUe.setTargetPosition(tk + this.Op.getHeaderViewsCount() + i);
                    this.Op.getLayoutManager().startSmoothScroll(this.fUe);
                    notifyDataSetChanged();
                }
            } else if (this.fAy == this.mDatas.size() - 1 && (this.mDatas.get(this.fAy) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.fAy);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cua().cub()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int tk(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (g(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean tl(int i) {
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

    public void tm(int i) {
        if (this.fAy != i || this.RC == null || !this.RC.isPlaying()) {
            if (this.fAy != i || this.RC == null || !bto()) {
                this.fAy = i;
                this.fUc = i;
                if (!v.aa(this.mDatas) && this.Op != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fAy <= this.mDatas.size() - 1 && (this.mDatas.get(this.fAy) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.fAy);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.kd() || com.baidu.tieba.video.g.cua().cub()) {
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
        this.fTY.kW(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b xL(String str) {
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
            this.fUd = (a) aVar;
        }
    }
}
