package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.frs.aggregation.a, com.baidu.tieba.lego.card.view.f {
    private i Pq;
    private String agd;
    private b dEQ;
    private d dFp;
    private com.baidu.afd.a.b dFq;
    private com.baidu.adp.widget.ListView.a dFr;
    private boolean doz;
    private TbPageContext mContext;
    private String mFrom;
    private BdTypeListView mListView;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int doA = -1;
    private int dFs = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b bVar, boolean z, String str, String str2) {
        this.doz = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.doz = z;
        this.dEQ = bVar;
        this.mFrom = str;
        this.agd = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dFp = new d(this.mContext, this, this.dEQ, this.doz, this.mFrom, this.agd, this);
        this.dFq = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.OT, this, this.dEQ, this);
        this.dFr = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.OR);
        this.mAdapters.add(this.dFp);
        this.mAdapters.add(this.dFr);
        this.mAdapters.add(this.dFq);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.doz && z) {
                avL();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.jF() && !com.baidu.tieba.video.f.bBB().bBC()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            if (this.mDatas.size() > this.dFs && !z && this.dFs != -1 && (this.mDatas.get(this.dFs) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dFs);
                if (j.jE() || com.baidu.tieba.video.f.bBB().bBC()) {
                    hVar2.setAutoPlay(true);
                    hVar2.setWaitConfirm(false);
                    return;
                }
                hVar2.setAutoPlay(false);
                hVar2.setWaitConfirm(true);
            }
        }
    }

    public void D(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (h hVar : this.mDatas) {
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).doE != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).doE.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).doE.hasFocus = z;
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
        this.dFp.onDestroy();
        this.dFq.onDestory();
    }

    public boolean or() {
        return this.dFp.or() || this.dFq.or();
    }

    public void go(boolean z) {
        this.dFp.go(z);
    }

    public void op() {
        this.dFp.op();
        this.dFq.op();
    }

    public void oq() {
        this.dFp.oq();
        this.dFq.oq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dFp.onConfigurationChanged(configuration);
    }

    public boolean kB(int i) {
        return this.dFp.kB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kA(int i) {
        lL(i);
    }

    public int avJ() {
        return this.doA;
    }

    public void avK() {
        if (!w.A(this.mDatas)) {
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
        avL();
    }

    private void avL() {
        avK();
        this.doA = 0;
        this.dFs = -1;
        op();
    }

    public void lL(final int i) {
        this.doA = i;
        this.dFs = i;
        if (!w.A(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.doA < this.mDatas.size() - 1) {
                final int lM = lM(i);
                int i2 = this.doA + lM;
                this.doA = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    if (j.jE() || com.baidu.tieba.video.f.bBB().bBC()) {
                        hVar2.setAutoPlay(true);
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setAutoPlay(false);
                        hVar2.setWaitConfirm(true);
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mListView.smoothScrollToPositionFromTop(i + e.this.mListView.getHeaderViewsCount() + lM, l.e(e.this.mContext.getPageActivity(), d.e.ds88) + l.e(e.this.mContext.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.doA == this.mDatas.size() - 1 && (this.mDatas.get(this.doA) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.doA);
                if (j.jE() || com.baidu.tieba.video.f.bBB().bBC()) {
                    hVar3.setAutoPlay(true);
                    hVar3.setWaitConfirm(false);
                    return;
                }
                hVar3.setAutoPlay(false);
                hVar3.setWaitConfirm(true);
            }
        }
    }

    public int lM(int i) {
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
            com.baidu.afd.e ol = ((com.baidu.afd.d) hVar).ol();
            if (ol == null || ol.Pe) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void lN(int i) {
        this.doA = i;
        this.dFs = i;
        if (!w.A(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.doA <= this.mDatas.size() - 1 && (this.mDatas.get(this.doA) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.doA);
                if (j.jE() || com.baidu.tieba.video.f.bBB().bBC()) {
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
        i iVar2 = this.Pq;
        this.Pq = iVar;
        if (iVar2 != null && iVar2 != this.Pq) {
            iVar2.stopPlay();
        }
    }

    public void gq(boolean z) {
        this.dFp.gq(z);
    }
}
