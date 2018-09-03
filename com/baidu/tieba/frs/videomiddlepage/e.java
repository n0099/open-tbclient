package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.frs.aggregation.a, com.baidu.tieba.lego.card.view.f {
    private j Pn;
    private String afx;
    private d dHZ;
    private b dHz;
    private com.baidu.afd.a.b dIa;
    private com.baidu.adp.widget.ListView.a dIb;
    private boolean drp;
    private TbPageContext mContext;
    private String mFrom;
    private BdTypeListView mListView;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int drq = -1;
    private int dIc = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b bVar, boolean z, String str, String str2) {
        this.drp = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.drp = z;
        this.dHz = bVar;
        this.mFrom = str;
        this.afx = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dHZ = new d(this.mContext, this, this.dHz, this.drp, this.mFrom, this.afx, this);
        this.dIa = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.OP, this, this.dHz, this);
        this.dIb = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.OO);
        this.mAdapters.add(this.dHZ);
        this.mAdapters.add(this.dIb);
        this.mAdapters.add(this.dIa);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.drp && z) {
                awp();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.jG() && !com.baidu.tieba.video.g.bAk().bAl()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            if (this.mDatas.size() > this.dIc && !z && this.dIc != -1 && (this.mDatas.get(this.dIc) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dIc);
                if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAk().bAl()) {
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
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dru != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dru.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dru.hasFocus = z;
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
        this.dHZ.onDestroy();
        this.dIa.onDestory();
    }

    public boolean oq() {
        return this.dHZ.oq() || this.dIa.oq();
    }

    public void gq(boolean z) {
        this.dHZ.gq(z);
    }

    public void oo() {
        this.dHZ.oo();
        this.dIa.oo();
    }

    public void op() {
        this.dHZ.op();
        this.dIa.op();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dHZ.onConfigurationChanged(configuration);
    }

    public boolean kL(int i) {
        return this.dHZ.kL(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kK(int i) {
        lW(i);
    }

    public int awn() {
        return this.drq;
    }

    public void awo() {
        if (!w.z(this.mDatas)) {
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
        awp();
    }

    private void awp() {
        awo();
        this.drq = 0;
        this.dIc = -1;
        oo();
    }

    public void lW(final int i) {
        this.drq = i;
        this.dIc = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.drq < this.mDatas.size() - 1) {
                final int lX = lX(i);
                int i2 = this.drq + lX;
                this.drq = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAk().bAl()) {
                        hVar2.setAutoPlay(true);
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setAutoPlay(false);
                        hVar2.setWaitConfirm(true);
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mListView.smoothScrollToPositionFromTop(i + e.this.mListView.getHeaderViewsCount() + lX, l.f(e.this.mContext.getPageActivity(), f.e.ds88) + l.f(e.this.mContext.getPageActivity(), f.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.drq == this.mDatas.size() - 1 && (this.mDatas.get(this.drq) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.drq);
                if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAk().bAl()) {
                    hVar3.setAutoPlay(true);
                    hVar3.setWaitConfirm(false);
                } else {
                    hVar3.setAutoPlay(false);
                    hVar3.setWaitConfirm(true);
                }
                notifyDataSetChanged();
            }
        }
    }

    public int lX(int i) {
        int size = this.mDatas.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            if (f(this.mDatas.get(i2))) {
                return i2 - i;
            }
        }
        return 1;
    }

    public boolean lY(int i) {
        if (i < 0 || i >= this.mDatas.size()) {
            return false;
        }
        return f(this.mDatas.get(i));
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
            com.baidu.afd.e ok = ((com.baidu.afd.d) hVar).ok();
            if (ok == null || ok.Pb) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void lZ(int i) {
        if (this.drq != i || this.Pn == null || !this.Pn.isPlaying()) {
            this.drq = i;
            this.dIc = i;
            if (!w.z(this.mDatas) && this.mListView != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.drq <= this.mDatas.size() - 1 && (this.mDatas.get(this.drq) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.drq);
                    if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAk().bAl()) {
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
    }

    @Override // com.baidu.tieba.lego.card.view.f
    public void a(j jVar) {
        j jVar2 = this.Pn;
        this.Pn = jVar;
        if (jVar2 != null && jVar2 != this.Pn) {
            jVar2.stopPlay();
        }
    }

    public void gs(boolean z) {
        this.dHZ.gs(z);
    }
}
