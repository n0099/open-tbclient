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
    private j Ay;
    private String bYk;
    private TbPageContext ceu;
    private boolean fAK;
    private c fTN;
    private e fUs;
    private com.baidu.afd.a.b fUt;
    private com.baidu.adp.widget.ListView.a fUu;
    private a fUx;
    RecyclerView.SmoothScroller fUy;
    private BdUniqueId mBdUniqueId;
    private String mFrom;
    private BdTypeRecyclerView yJ;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private boolean fUv = false;
    private int fAL = -1;
    private int fUw = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fAK = false;
        this.ceu = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.yJ = bdTypeRecyclerView;
        this.fAK = z;
        this.fTN = cVar;
        this.mFrom = str;
        this.bYk = str2;
        sY();
    }

    private void sY() {
        this.fUs = new e(this.ceu, this, this.fTN, this.fAK, this.mFrom, this.bYk, this, this.mBdUniqueId, this, this);
        this.fUt = new com.baidu.afd.a.b(this.ceu, com.baidu.afd.b.zZ, this, this.fTN, this);
        this.fUu = new com.baidu.afd.a.c(this.ceu, com.baidu.afd.b.zY);
        this.agy.add(this.fUs);
        this.agy.add(this.fUu);
        this.agy.add(this.fUt);
        this.yJ.addAdapters(this.agy);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fUv) {
                this.fUv = false;
                this.yJ.setData(this.mDatas);
            } else {
                this.yJ.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fAK && z) {
                bmq();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isMobileNet() && !com.baidu.tieba.video.g.csB().csC()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fAL != -1 ? this.fAL : this.fUw;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csB().csC()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.isEmpty(this.mDatas) && this.mDatas.get(0) != null) {
            this.fUv = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.fAR.mcnLeadPage = gVar.fAR.mcnLeadPage;
            gVar2.fAR.fBb = gVar.fAR.fBb;
        }
    }

    public void ah(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).fAQ != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).fAQ.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).fAQ.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.yJ != null && this.yJ.getListAdapter() != null) {
            this.yJ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fUs.onDestroy();
        this.fUt.onDestory();
    }

    public boolean kk() {
        return this.fUs.kk() || this.fUt.kk();
    }

    public boolean brd() {
        return this.fUs.brd();
    }

    public void ki() {
        this.fUs.ki();
        this.fUt.ki();
    }

    public void kj() {
        this.fUs.kj();
        this.fUt.kj();
    }

    public void brp() {
        this.fUs.brp();
    }

    public void brq() {
        this.fUs.brq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fUs.onConfigurationChanged(configuration);
    }

    public boolean qO(int i) {
        return this.fUs.qO(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qN(int i) {
        sg(i);
    }

    public int bmo() {
        return this.fAL;
    }

    public void bmp() {
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
        bmq();
    }

    private void bmq() {
        bmp();
        this.fAL = 0;
        this.fUw = -1;
        ki();
    }

    public void sg(int i) {
        this.fAL = i;
        this.fUw = i;
        if (!v.isEmpty(this.mDatas) && this.yJ != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.fAL < this.mDatas.size() - 1) {
                int sh = sh(i);
                int i2 = this.fAL + sh;
                this.fAL = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csB().csC()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.fUy == null) {
                        this.fUy = new LinearSmoothScroller(this.ceu.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fUy.setTargetPosition(sh + this.yJ.getHeaderViewsCount() + i);
                    this.yJ.getLayoutManager().startSmoothScroll(this.fUy);
                    notifyDataSetChanged();
                }
            } else if (this.fAL == this.mDatas.size() - 1 && (this.mDatas.get(this.fAL) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.fAL);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csB().csC()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int sh(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean si(int i) {
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
            if (ke == null || ke.Am) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void sj(int i) {
        if (this.fAL != i || this.Ay == null || !this.Ay.isPlaying()) {
            if (this.fAL != i || this.Ay == null || !brd()) {
                this.fAL = i;
                this.fUw = i;
                if (!v.isEmpty(this.mDatas) && this.yJ != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fAL <= this.mDatas.size() - 1 && (this.mDatas.get(this.fAL) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.fAL);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.isWifiNet() || com.baidu.tieba.video.g.csB().csC()) {
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
        j jVar2 = this.Ay;
        this.Ay = jVar;
        if (jVar2 != null && jVar2 != this.Ay) {
            jVar2.stopPlay();
        }
    }

    public void kM(boolean z) {
        this.fUs.kM(z);
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
            this.fUx = (a) aVar;
        }
    }
}
