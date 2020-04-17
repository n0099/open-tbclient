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
    private BdTypeRecyclerView Vf;
    private j WX;
    private String dol;
    private TbPageContext duG;
    private boolean het;
    private c hyS;
    private com.baidu.adp.widget.ListView.a hzA;
    private a hzD;
    RecyclerView.SmoothScroller hzE;
    private e hzy;
    private com.baidu.afd.a.b hzz;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private boolean hzB = false;
    private int heu = -1;
    private int hzC = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.het = false;
        this.duG = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Vf = bdTypeRecyclerView;
        this.het = z;
        this.hyS = cVar;
        this.mFrom = str;
        this.dol = str2;
        BC();
    }

    private void BC() {
        this.hzy = new e(this.duG, this, this.hyS, this.het, this.mFrom, this.dol, this, this.mBdUniqueId, this, this);
        this.hzz = new com.baidu.afd.a.b(this.duG, com.baidu.afd.b.Wz, this, this.hyS, this);
        this.hzA = new com.baidu.afd.a.c(this.duG, com.baidu.afd.b.Wy);
        this.aMd.add(this.hzy);
        this.aMd.add(this.hzA);
        this.aMd.add(this.hzz);
        this.Vf.addAdapters(this.aMd);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.hzB) {
                this.hzB = false;
                this.Vf.setData(this.mDatas);
            } else {
                this.Vf.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.het && z) {
                bRh();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.day().daz()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.heu != -1 ? this.heu : this.hzC;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.day().daz()) {
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
            this.hzB = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.heA.mcnLeadPage = gVar.heA.mcnLeadPage;
            gVar2.heA.heL = gVar.heA.heL;
        }
    }

    public void ar(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).hez != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).hez.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).hez.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Vf != null && this.Vf.getListAdapter() != null) {
            this.Vf.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hzy.onDestroy();
        this.hzz.onDestory();
    }

    public boolean pv() {
        return this.hzy.pv() || this.hzz.pv();
    }

    public boolean bWe() {
        return this.hzy.bWe();
    }

    public void pt() {
        this.hzy.pt();
        this.hzz.pt();
    }

    public void pu() {
        this.hzy.pu();
        this.hzz.pu();
    }

    public void bWr() {
        this.hzy.bWr();
    }

    public void bWs() {
        this.hzy.bWs();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hzy.onConfigurationChanged(configuration);
    }

    public boolean tF(int i) {
        return this.hzy.tF(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void tE(int i) {
        ve(i);
    }

    public int bRf() {
        return this.heu;
    }

    public void bRg() {
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
        bRh();
    }

    private void bRh() {
        bRg();
        this.heu = 0;
        this.hzC = -1;
        pt();
    }

    public void ve(int i) {
        this.heu = i;
        this.hzC = i;
        if (!v.isEmpty(this.mDatas) && this.Vf != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.heu < this.mDatas.size() - 1) {
                int vf = vf(i);
                int i2 = this.heu + vf;
                this.heu = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.day().daz()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.hzE == null) {
                        this.hzE = new LinearSmoothScroller(this.duG.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.hzE.setTargetPosition(vf + this.Vf.getHeaderViewsCount() + i);
                    this.Vf.getLayoutManager().startSmoothScroll(this.hzE);
                    notifyDataSetChanged();
                }
            } else if (this.heu == this.mDatas.size() - 1 && (this.mDatas.get(this.heu) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.heu);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.day().daz()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int vf(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean vg(int i) {
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
            com.baidu.afd.e pp = ((com.baidu.afd.d) mVar).pp();
            if (pp == null || pp.WL) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void vh(int i) {
        if (this.heu != i || this.WX == null || !this.WX.isPlaying()) {
            if (this.heu != i || this.WX == null || !bWe()) {
                this.heu = i;
                this.hzC = i;
                if (!v.isEmpty(this.mDatas) && this.Vf != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.heu <= this.mDatas.size() - 1 && (this.mDatas.get(this.heu) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.heu);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.day().daz()) {
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
        j jVar2 = this.WX;
        this.WX = jVar;
        if (jVar2 != null && jVar2 != this.WX) {
            jVar2.stopPlay();
        }
    }

    public a bWt() {
        return this.hzD;
    }

    public void nx(boolean z) {
        this.hzy.nx(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b DA(String str) {
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
        bVar.aM(i6);
        bVar.aL(i5);
        bVar.aN(i2);
        return bVar;
    }

    @Override // com.baidu.tieba.lego.card.view.g
    public void a(com.baidu.tieba.card.a aVar) {
        if (aVar instanceof a) {
            this.hzD = (a) aVar;
        }
    }
}
