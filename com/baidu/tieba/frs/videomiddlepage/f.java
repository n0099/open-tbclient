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
/* loaded from: classes6.dex */
public class f implements com.baidu.tieba.frs.aggregation.a, b, com.baidu.tieba.lego.card.view.f, com.baidu.tieba.lego.card.view.g {
    private BdTypeRecyclerView Bn;
    private j De;
    private String cKC;
    private TbPageContext cQU;
    private e gIS;
    private com.baidu.afd.a.b gIT;
    private com.baidu.adp.widget.ListView.a gIU;
    private a gIX;
    RecyclerView.SmoothScroller gIY;
    private c gIm;
    private boolean gpg;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private boolean gIV = false;
    private int gph = -1;
    private int gIW = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.gpg = false;
        this.cQU = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.Bn = bdTypeRecyclerView;
        this.gpg = z;
        this.gIm = cVar;
        this.mFrom = str;
        this.cKC = str2;
        uR();
    }

    private void uR() {
        this.gIS = new e(this.cQU, this, this.gIm, this.gpg, this.mFrom, this.cKC, this, this.mBdUniqueId, this, this);
        this.gIT = new com.baidu.afd.a.b(this.cQU, com.baidu.afd.b.CE, this, this.gIm, this);
        this.gIU = new com.baidu.afd.a.c(this.cQU, com.baidu.afd.b.CD);
        this.aoz.add(this.gIS);
        this.aoz.add(this.gIU);
        this.aoz.add(this.gIT);
        this.Bn.addAdapters(this.aoz);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.gIV) {
                this.gIV = false;
                this.Bn.setData(this.mDatas);
            } else {
                this.Bn.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.gpg && z) {
                bDN();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.cMD().cME()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.gph != -1 ? this.gph : this.gIW;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cMD().cME()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void l(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.gIV = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.gpn.mcnLeadPage = gVar.gpn.mcnLeadPage;
            gVar2.gpn.gpy = gVar.gpn.gpy;
        }
    }

    public void al(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).gpm != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).gpm.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).gpm.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.Bn != null && this.Bn.getListAdapter() != null) {
            this.Bn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gIS.onDestroy();
        this.gIT.onDestory();
    }

    public boolean kB() {
        return this.gIS.kB() || this.gIT.kB();
    }

    public boolean bIE() {
        return this.gIS.bIE();
    }

    public void kz() {
        this.gIS.kz();
        this.gIT.kz();
    }

    public void kA() {
        this.gIS.kA();
        this.gIT.kA();
    }

    public void bIR() {
        this.gIS.bIR();
    }

    public void bIS() {
        this.gIS.bIS();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gIS.onConfigurationChanged(configuration);
    }

    public boolean sU(int i) {
        return this.gIS.sU(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void sT(int i) {
        uo(i);
    }

    public int bDL() {
        return this.gph;
    }

    public void bDM() {
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
        bDN();
    }

    private void bDN() {
        bDM();
        this.gph = 0;
        this.gIW = -1;
        kz();
    }

    public void uo(int i) {
        this.gph = i;
        this.gIW = i;
        if (!v.isEmpty(this.mDatas) && this.Bn != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.gph < this.mDatas.size() - 1) {
                int up = up(i);
                int i2 = this.gph + up;
                this.gph = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cMD().cME()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.gIY == null) {
                        this.gIY = new LinearSmoothScroller(this.cQU.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.gIY.setTargetPosition(up + this.Bn.getHeaderViewsCount() + i);
                    this.Bn.getLayoutManager().startSmoothScroll(this.gIY);
                    notifyDataSetChanged();
                }
            } else if (this.gph == this.mDatas.size() - 1 && (this.mDatas.get(this.gph) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.gph);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cMD().cME()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int up(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean uq(int i) {
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
            com.baidu.afd.e kv = ((com.baidu.afd.d) mVar).kv();
            if (kv == null || kv.CQ) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void ur(int i) {
        if (this.gph != i || this.De == null || !this.De.isPlaying()) {
            if (this.gph != i || this.De == null || !bIE()) {
                this.gph = i;
                this.gIW = i;
                if (!v.isEmpty(this.mDatas) && this.Bn != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.gph <= this.mDatas.size() - 1 && (this.mDatas.get(this.gph) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.gph);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.cMD().cME()) {
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
        j jVar2 = this.De;
        this.De = jVar;
        if (jVar2 != null && jVar2 != this.De) {
            jVar2.stopPlay();
        }
    }

    public void ma(boolean z) {
        this.gIS.ma(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b Br(String str) {
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
            this.gIX = (a) aVar;
        }
    }
}
