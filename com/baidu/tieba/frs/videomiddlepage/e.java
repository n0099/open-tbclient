package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.frs.aggregation.a, com.baidu.tieba.lego.card.view.f {
    private i Jh;
    private String XM;
    private TbPageContext adf;
    private boolean dbt;
    private d drJ;
    private com.baidu.afd.a.b drK;
    private com.baidu.adp.widget.ListView.a drL;
    private b drk;
    private String mFrom;
    private BdTypeListView mListView;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dbu = -1;
    private int drM = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b bVar, boolean z, String str, String str2) {
        this.dbt = false;
        this.adf = tbPageContext;
        this.mListView = bdTypeListView;
        this.dbt = z;
        this.drk = bVar;
        this.mFrom = str;
        this.XM = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.drJ = new d(this.adf, this, this.drk, this.dbt, this.mFrom, this.XM, this);
        this.drK = new com.baidu.afd.a.b(this.adf, com.baidu.afd.b.II, this, this.drk, this);
        this.drL = new com.baidu.afd.a.c(this.adf, com.baidu.afd.b.IH);
        this.mAdapters.add(this.drJ);
        this.mAdapters.add(this.drL);
        this.mAdapters.add(this.drK);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.dbt && z) {
                ard();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.gR() && !com.baidu.tieba.video.f.bvW().bvX()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            if (this.mDatas.size() > this.drM && !z && this.drM != -1 && (this.mDatas.get(this.drM) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.drM);
                if (j.gQ() || com.baidu.tieba.video.f.bvW().bvX()) {
                    hVar2.setAutoPlay(true);
                    hVar2.setWaitConfirm(false);
                    return;
                }
                hVar2.setAutoPlay(false);
                hVar2.setWaitConfirm(true);
            }
        }
    }

    public void C(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dby != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dby.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dby.hasFocus = z;
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof BaseAdapter)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.drJ.onDestroy();
        this.drK.onDestory();
    }

    public boolean lC() {
        return this.drJ.lC() || this.drK.lC();
    }

    public void fY(boolean z) {
        this.drJ.fY(z);
    }

    public void lA() {
        this.drJ.lA();
        this.drK.lA();
    }

    public void lB() {
        this.drJ.lB();
        this.drK.lB();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.drJ.onConfigurationChanged(configuration);
    }

    public boolean kr(int i) {
        return this.drJ.kr(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kq(int i) {
        lz(i);
    }

    public int arb() {
        return this.dbu;
    }

    public void arc() {
        if (!v.w(this.mDatas)) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) hVar;
                    hVar2.setAutoPlay(false);
                    hVar2.setWaitConfirm(false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        ard();
    }

    private void ard() {
        arc();
        this.dbu = 0;
        this.drM = -1;
        lA();
    }

    public void lz(final int i) {
        this.dbu = i;
        this.drM = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dbu < this.mDatas.size() - 1) {
                final int lA = lA(i);
                int i2 = this.dbu + lA;
                this.dbu = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    if (j.gQ() || com.baidu.tieba.video.f.bvW().bvX()) {
                        hVar2.setAutoPlay(true);
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setAutoPlay(false);
                        hVar2.setWaitConfirm(true);
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mListView.smoothScrollToPositionFromTop(i + e.this.mListView.getHeaderViewsCount() + lA, l.e(e.this.adf.getPageActivity(), d.e.ds88) + l.e(e.this.adf.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.dbu == this.mDatas.size() - 1 && (this.mDatas.get(this.dbu) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dbu);
                if (j.gQ() || com.baidu.tieba.video.f.bvW().bvX()) {
                    hVar3.setAutoPlay(true);
                    hVar3.setWaitConfirm(false);
                    return;
                }
                hVar3.setAutoPlay(false);
                hVar3.setWaitConfirm(true);
            }
        }
    }

    public int lA(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    private boolean f(h hVar) {
        boolean z = true;
        if (hVar == null) {
            return false;
        }
        if (hVar instanceof com.baidu.tieba.frs.aggregation.g) {
            return true;
        }
        if (hVar instanceof com.baidu.afd.d) {
            com.baidu.afd.e lw = ((com.baidu.afd.d) hVar).lw();
            if (lw == null || lw.IU) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void lB(int i) {
        this.dbu = i;
        this.drM = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dbu <= this.mDatas.size() - 1 && (this.mDatas.get(this.dbu) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dbu);
                if (j.gQ() || com.baidu.tieba.video.f.bvW().bvX()) {
                    hVar2.setAutoPlay(true);
                    hVar2.setWaitConfirm(false);
                } else {
                    hVar2.setAutoPlay(false);
                    hVar2.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(i iVar) {
        i iVar2 = this.Jh;
        this.Jh = iVar;
        if (iVar2 != null && iVar2 != this.Jh) {
            iVar2.stopPlay();
        }
    }

    public void ga(boolean z) {
        this.drJ.ga(z);
    }
}
