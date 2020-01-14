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
/* loaded from: classes7.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Bs;
    private j Dj;
    private String cKN;
    private TbPageContext cRe;
    private c gLz;
    private e gMf;
    private com.baidu.afd.a.b gMg;
    private com.baidu.adp.widget.ListView.a gMh;
    private a gMk;
    RecyclerView.SmoothScroller gMl;
    private boolean gsp;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private boolean gMi = false;
    private int gsq = -1;
    private int gMj = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.gsp = false;
        this.cRe = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Bs = bdTypeRecyclerView;
        this.gsp = z;
        this.gLz = cVar;
        this.mFrom = str;
        this.cKN = str2;
        vi();
    }

    private void vi() {
        this.gMf = new e(this.cRe, this, this.gLz, this.gsp, this.mFrom, this.cKN, this, this.mBdUniqueId, this, this);
        this.gMg = new com.baidu.afd.a.b(this.cRe, com.baidu.afd.b.CJ, this, this.gLz, this);
        this.gMh = new com.baidu.afd.a.c(this.cRe, com.baidu.afd.b.CI);
        this.apl.add(this.gMf);
        this.apl.add(this.gMh);
        this.apl.add(this.gMg);
        this.Bs.addAdapters(this.apl);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.gMi) {
                this.gMi = false;
                this.Bs.setData(this.mDatas);
            } else {
                this.Bs.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.gsp && z) {
                bEP();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cNK().cNL()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.gsq != -1 ? this.gsq : this.gMj;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cNK().cNL()) {
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
            this.gMi = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.gsw.mcnLeadPage = gVar.gsw.mcnLeadPage;
            gVar2.gsw.gsH = gVar.gsw.gsH;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).gsv != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).gsv.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).gsv.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Bs != null && this.Bs.getListAdapter() != null) {
            this.Bs.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gMf.onDestroy();
        this.gMg.onDestory();
    }

    public boolean kC() {
        return this.gMf.kC() || this.gMg.kC();
    }

    public boolean bJG() {
        return this.gMf.bJG();
    }

    public void kA() {
        this.gMf.kA();
        this.gMg.kA();
    }

    public void kB() {
        this.gMf.kB();
        this.gMg.kB();
    }

    public void bJT() {
        this.gMf.bJT();
    }

    public void bJU() {
        this.gMf.bJU();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gMf.onConfigurationChanged(configuration);
    }

    public boolean sZ(int i) {
        return this.gMf.sZ(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void sY(int i) {
        ut(i);
    }

    public int bEN() {
        return this.gsq;
    }

    public void bEO() {
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
        bEP();
    }

    private void bEP() {
        bEO();
        this.gsq = 0;
        this.gMj = -1;
        kA();
    }

    public void ut(int i) {
        this.gsq = i;
        this.gMj = i;
        if (!v.isEmpty(this.mDatas) && this.Bs != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.gsq < this.mDatas.size() - 1) {
                int uu = uu(i);
                int i2 = this.gsq + uu;
                this.gsq = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cNK().cNL()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.gMl == null) {
                        this.gMl = new LinearSmoothScroller(this.cRe.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.gMl.setTargetPosition(uu + this.Bs.getHeaderViewsCount() + i);
                    this.Bs.getLayoutManager().startSmoothScroll(this.gMl);
                    notifyDataSetChanged();
                }
            } else if (this.gsq == this.mDatas.size() - 1 && (this.mDatas.get(this.gsq) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.gsq);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cNK().cNL()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int uu(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean uv(int i) {
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
            com.baidu.afd.e kw = ((com.baidu.afd.d) mVar).kw();
            if (kw == null || kw.CX) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void uw(int i) {
        if (this.gsq != i || this.Dj == null || !this.Dj.isPlaying()) {
            if (this.gsq != i || this.Dj == null || !bJG()) {
                this.gsq = i;
                this.gMj = i;
                if (!v.isEmpty(this.mDatas) && this.Bs != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.gsq <= this.mDatas.size() - 1 && (this.mDatas.get(this.gsq) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.gsq);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cNK().cNL()) {
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
        j jVar2 = this.Dj;
        this.Dj = jVar;
        if (jVar2 != null && jVar2 != this.Dj) {
            jVar2.stopPlay();
        }
    }

    public void ml(boolean z) {
        this.gMf.ml(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b BB(String str) {
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
        bVar.ax(i6);
        bVar.aw(i5);
        bVar.ay(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.a aVar) {
        if (aVar instanceof a) {
            this.gMk = (a) aVar;
        }
    }
}
