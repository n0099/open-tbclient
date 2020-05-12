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
    private BdTypeRecyclerView Vi;
    private j Xa;
    private String dop;
    private TbPageContext duK;
    private boolean hez;
    private c hyY;
    private e hzE;
    private com.baidu.afd.a.b hzF;
    private com.baidu.adp.widget.ListView.a hzG;
    private a hzJ;
    RecyclerView.SmoothScroller hzK;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private boolean hzH = false;
    private int heA = -1;
    private int hzI = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.hez = false;
        this.duK = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Vi = bdTypeRecyclerView;
        this.hez = z;
        this.hyY = cVar;
        this.mFrom = str;
        this.dop = str2;
        BB();
    }

    private void BB() {
        this.hzE = new e(this.duK, this, this.hyY, this.hez, this.mFrom, this.dop, this, this.mBdUniqueId, this, this);
        this.hzF = new com.baidu.afd.a.b(this.duK, com.baidu.afd.b.WC, this, this.hyY, this);
        this.hzG = new com.baidu.afd.a.c(this.duK, com.baidu.afd.b.WB);
        this.aMj.add(this.hzE);
        this.aMj.add(this.hzG);
        this.aMj.add(this.hzF);
        this.Vi.addAdapters(this.aMj);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.hzH) {
                this.hzH = false;
                this.Vi.setData(this.mDatas);
            } else {
                this.Vi.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.hez && z) {
                bRg();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.daw().dax()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.heA != -1 ? this.heA : this.hzI;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.daw().dax()) {
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
            this.hzH = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.heG.mcnLeadPage = gVar.heG.mcnLeadPage;
            gVar2.heG.heR = gVar.heG.heR;
        }
    }

    public void ar(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).heF != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).heF.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).heF.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Vi != null && this.Vi.getListAdapter() != null) {
            this.Vi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hzE.onDestroy();
        this.hzF.onDestory();
    }

    public boolean pv() {
        return this.hzE.pv() || this.hzF.pv();
    }

    public boolean bWd() {
        return this.hzE.bWd();
    }

    public void pt() {
        this.hzE.pt();
        this.hzF.pt();
    }

    public void pu() {
        this.hzE.pu();
        this.hzF.pu();
    }

    public void bWq() {
        this.hzE.bWq();
    }

    public void bWr() {
        this.hzE.bWr();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hzE.onConfigurationChanged(configuration);
    }

    public boolean tF(int i) {
        return this.hzE.tF(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void tE(int i) {
        ve(i);
    }

    public int bRe() {
        return this.heA;
    }

    public void bRf() {
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
        bRg();
    }

    private void bRg() {
        bRf();
        this.heA = 0;
        this.hzI = -1;
        pt();
    }

    public void ve(int i) {
        this.heA = i;
        this.hzI = i;
        if (!v.isEmpty(this.mDatas) && this.Vi != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.heA < this.mDatas.size() - 1) {
                int vf = vf(i);
                int i2 = this.heA + vf;
                this.heA = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.daw().dax()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.hzK == null) {
                        this.hzK = new LinearSmoothScroller(this.duK.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.hzK.setTargetPosition(vf + this.Vi.getHeaderViewsCount() + i);
                    this.Vi.getLayoutManager().startSmoothScroll(this.hzK);
                    notifyDataSetChanged();
                }
            } else if (this.heA == this.mDatas.size() - 1 && (this.mDatas.get(this.heA) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.heA);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.daw().dax()) {
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
            if (pp == null || pp.WO) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void vh(int i) {
        if (this.heA != i || this.Xa == null || !this.Xa.isPlaying()) {
            if (this.heA != i || this.Xa == null || !bWd()) {
                this.heA = i;
                this.hzI = i;
                if (!v.isEmpty(this.mDatas) && this.Vi != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.heA <= this.mDatas.size() - 1 && (this.mDatas.get(this.heA) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.heA);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.daw().dax()) {
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
        j jVar2 = this.Xa;
        this.Xa = jVar;
        if (jVar2 != null && jVar2 != this.Xa) {
            jVar2.stopPlay();
        }
    }

    public a bWs() {
        return this.hzJ;
    }

    public void nx(boolean z) {
        this.hzE.nx(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b DD(String str) {
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
            this.hzJ = (a) aVar;
        }
    }
}
