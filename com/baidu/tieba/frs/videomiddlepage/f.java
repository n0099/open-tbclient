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
    private BdTypeRecyclerView NZ;
    private j Rl;
    private String bFP;
    private c fNE;
    private e fOj;
    private com.baidu.afd.a.b fOk;
    private com.baidu.adp.widget.ListView.a fOl;
    private a fOo;
    RecyclerView.SmoothScroller fOp;
    private boolean fuN;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private String mFrom;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private boolean fOm = false;
    private int fuO = -1;
    private int fOn = -1;

    public f(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, c cVar, boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        this.fuN = false;
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        this.NZ = bdTypeRecyclerView;
        this.fuN = z;
        this.fNE = cVar;
        this.mFrom = str;
        this.bFP = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.fOj = new e(this.mContext, this, this.fNE, this.fuN, this.mFrom, this.bFP, this, this.mBdUniqueId, this, this);
        this.fOk = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.QM, this, this.fNE, this);
        this.fOl = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.QL);
        this.mAdapters.add(this.fOj);
        this.mAdapters.add(this.fOl);
        this.mAdapters.add(this.fOk);
        this.NZ.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            int size = this.mDatas.size();
            this.mDatas.addAll(list);
            if (this.fOm) {
                this.fOm = false;
                this.NZ.setData(this.mDatas);
            } else {
                this.NZ.setDataWithPartChange(this.mDatas, size, list.size());
            }
            if (list.size() > 0 && this.fuN && z) {
                bmo();
                if (list.get(0) instanceof i) {
                    i iVar = (i) list.get(0);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.jU() && !com.baidu.tieba.video.g.cqS().cqT()) {
                        iVar.setWaitConfirm(true);
                    } else {
                        iVar.setWaitConfirm(false);
                    }
                }
            }
            int i = this.fuO != -1 ? this.fuO : this.fOn;
            if (this.mDatas.size() > i && !z && i != -1 && (this.mDatas.get(i) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(i);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.jT() || com.baidu.tieba.video.g.cqS().cqT()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
            }
        }
    }

    public void j(com.baidu.tieba.frs.aggregation.g gVar) {
        if (gVar != null && !v.aa(this.mDatas) && this.mDatas.get(0) != null) {
            this.fOm = true;
            com.baidu.tieba.frs.aggregation.g gVar2 = (com.baidu.tieba.frs.aggregation.g) this.mDatas.get(0);
            gVar2.fuU.mcnLeadPage = gVar.fuU.mcnLeadPage;
            gVar2.fuU.fve = gVar.fuU.fve;
        }
    }

    public void ah(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (m mVar : this.mDatas) {
                if (mVar != null && (mVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) mVar).fuT != null && str.equals(((com.baidu.tieba.frs.aggregation.g) mVar).fuT.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) mVar).fuT.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.NZ != null && this.NZ.getListAdapter() != null) {
            this.NZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fOj.onDestroy();
        this.fOk.onDestory();
    }

    public boolean oT() {
        return this.fOj.oT() || this.fOk.oT();
    }

    public boolean bqY() {
        return this.fOj.bqY();
    }

    public void oR() {
        this.fOj.oR();
        this.fOk.oR();
    }

    public void oS() {
        this.fOj.oS();
        this.fOk.oS();
    }

    public void brl() {
        this.fOj.brl();
    }

    public void brm() {
        this.fOj.brm();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fOj.onConfigurationChanged(configuration);
    }

    public boolean rz(int i) {
        return this.fOj.rz(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ry(int i) {
        sP(i);
    }

    public int bmm() {
        return this.fuO;
    }

    public void bmn() {
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
        bmo();
    }

    private void bmo() {
        bmn();
        this.fuO = 0;
        this.fOn = -1;
        oR();
    }

    public void sP(int i) {
        this.fuO = i;
        this.fOn = i;
        if (!v.aa(this.mDatas) && this.NZ != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof i) {
                    ((i) mVar).setAutoPlay(false);
                    ((i) mVar).setWaitConfirm(false);
                }
            }
            if (this.fuO < this.mDatas.size() - 1) {
                int sQ = sQ(i);
                int i2 = this.fuO + sQ;
                this.fuO = i2;
                if (this.mDatas.get(i2) instanceof i) {
                    i iVar = (i) this.mDatas.get(i2);
                    iVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.jT() || com.baidu.tieba.video.g.cqS().cqT()) {
                        iVar.setWaitConfirm(false);
                    } else {
                        iVar.setWaitConfirm(true);
                    }
                    if (this.fOp == null) {
                        this.fOp = new LinearSmoothScroller(this.mContext.getContext()) { // from class: com.baidu.tieba.frs.videomiddlepage.f.1
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
                    this.fOp.setTargetPosition(sQ + this.NZ.getHeaderViewsCount() + i);
                    this.NZ.getLayoutManager().startSmoothScroll(this.fOp);
                    notifyDataSetChanged();
                }
            } else if (this.fuO == this.mDatas.size() - 1 && (this.mDatas.get(this.fuO) instanceof i)) {
                i iVar2 = (i) this.mDatas.get(this.fuO);
                iVar2.setAutoPlay(true);
                if (com.baidu.adp.lib.util.j.jT() || com.baidu.tieba.video.g.cqS().cqT()) {
                    iVar2.setWaitConfirm(false);
                } else {
                    iVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int sQ(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (g(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean sR(int i) {
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
            com.baidu.afd.e oN = ((com.baidu.afd.d) mVar).oN();
            if (oN == null || oN.QZ) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void sS(int i) {
        if (this.fuO != i || this.Rl == null || !this.Rl.isPlaying()) {
            if (this.fuO != i || this.Rl == null || !bqY()) {
                this.fuO = i;
                this.fOn = i;
                if (!v.aa(this.mDatas) && this.NZ != null) {
                    for (m mVar : this.mDatas) {
                        if (mVar instanceof i) {
                            ((i) mVar).setAutoPlay(false);
                            ((i) mVar).setWaitConfirm(false);
                        }
                    }
                    if (this.fuO <= this.mDatas.size() - 1 && (this.mDatas.get(this.fuO) instanceof i)) {
                        i iVar = (i) this.mDatas.get(this.fuO);
                        iVar.setAutoPlay(true);
                        if (com.baidu.adp.lib.util.j.jT() || com.baidu.tieba.video.g.cqS().cqT()) {
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
        j jVar2 = this.Rl;
        this.Rl = jVar;
        if (jVar2 != null && jVar2 != this.Rl) {
            jVar2.stopPlay();
        }
    }

    public void kL(boolean z) {
        this.fOj.kL(z);
    }

    @Override // com.baidu.tieba.frs.videomiddlepage.b
    public com.baidu.afd.videopaster.data.b xd(String str) {
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
            this.fOo = (a) aVar;
        }
    }
}
