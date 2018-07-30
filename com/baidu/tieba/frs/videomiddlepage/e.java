package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.view.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.frs.aggregation.a, com.baidu.tieba.lego.card.view.f {
    private j Pn;
    private String afx;
    private b dHD;
    private d dId;
    private com.baidu.afd.a.b dIe;
    private com.baidu.adp.widget.ListView.a dIf;
    private boolean drs;
    private TbPageContext mContext;
    private String mFrom;
    private BdTypeListView mListView;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int drt = -1;
    private int dIg = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b bVar, boolean z, String str, String str2) {
        this.drs = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.drs = z;
        this.dHD = bVar;
        this.mFrom = str;
        this.afx = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dId = new d(this.mContext, this, this.dHD, this.drs, this.mFrom, this.afx, this);
        this.dIe = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.OP, this, this.dHD, this);
        this.dIf = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.OO);
        this.mAdapters.add(this.dId);
        this.mAdapters.add(this.dIf);
        this.mAdapters.add(this.dIe);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.drs && z) {
                awq();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (com.baidu.adp.lib.util.j.jG() && !com.baidu.tieba.video.g.bAi().bAj()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            if (this.mDatas.size() > this.dIg && !z && this.dIg != -1 && (this.mDatas.get(this.dIg) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dIg);
                if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAi().bAj()) {
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
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).drx != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).drx.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).drx.hasFocus = z;
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
        this.dId.onDestroy();
        this.dIe.onDestory();
    }

    public boolean ot() {
        return this.dId.ot() || this.dIe.ot();
    }

    public void gq(boolean z) {
        this.dId.gq(z);
    }

    public void or() {
        this.dId.or();
        this.dIe.or();
    }

    public void os() {
        this.dId.os();
        this.dIe.os();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dId.onConfigurationChanged(configuration);
    }

    public boolean kM(int i) {
        return this.dId.kM(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kL(int i) {
        lW(i);
    }

    public int awo() {
        return this.drt;
    }

    public void awp() {
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
        awq();
    }

    private void awq() {
        awp();
        this.drt = 0;
        this.dIg = -1;
        or();
    }

    public void lW(final int i) {
        this.drt = i;
        this.dIg = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.drt < this.mDatas.size() - 1) {
                final int lX = lX(i);
                int i2 = this.drt + lX;
                this.drt = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAi().bAj()) {
                        hVar2.setAutoPlay(true);
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setAutoPlay(false);
                        hVar2.setWaitConfirm(true);
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mListView.smoothScrollToPositionFromTop(i + e.this.mListView.getHeaderViewsCount() + lX, l.f(e.this.mContext.getPageActivity(), d.e.ds88) + l.f(e.this.mContext.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.drt == this.mDatas.size() - 1 && (this.mDatas.get(this.drt) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.drt);
                if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAi().bAj()) {
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
            com.baidu.afd.e on = ((com.baidu.afd.d) hVar).on();
            if (on == null || on.Pb) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void lZ(int i) {
        if (this.drt != i || this.Pn == null || !this.Pn.isPlaying()) {
            this.drt = i;
            this.dIg = i;
            if (!w.z(this.mDatas) && this.mListView != null) {
                for (h hVar : this.mDatas) {
                    if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                        ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                        ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                    }
                }
                if (this.drt <= this.mDatas.size() - 1 && (this.mDatas.get(this.drt) instanceof com.baidu.tieba.lego.card.view.h)) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.drt);
                    if (com.baidu.adp.lib.util.j.jF() || com.baidu.tieba.video.g.bAi().bAj()) {
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
        this.dId.gs(z);
    }
}
