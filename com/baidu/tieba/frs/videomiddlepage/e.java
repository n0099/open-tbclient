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
    private i Po;
    private String afO;
    private b dBC;
    private d dCb;
    private com.baidu.afd.a.b dCc;
    private com.baidu.adp.widget.ListView.a dCd;
    private boolean dlN;
    private TbPageContext mContext;
    private String mFrom;
    private BdTypeListView mListView;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dlO = -1;
    private int dCe = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b bVar, boolean z, String str, String str2) {
        this.dlN = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dlN = z;
        this.dBC = bVar;
        this.mFrom = str;
        this.afO = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dCb = new d(this.mContext, this, this.dBC, this.dlN, this.mFrom, this.afO, this);
        this.dCc = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.OQ, this, this.dBC, this);
        this.dCd = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.OP);
        this.mAdapters.add(this.dCb);
        this.mAdapters.add(this.dCd);
        this.mAdapters.add(this.dCc);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.dlN && z) {
                avh();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.jF() && !com.baidu.tieba.video.f.bBb().bBc()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            if (this.mDatas.size() > this.dCe && !z && this.dCe != -1 && (this.mDatas.get(this.dCe) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dCe);
                if (j.jE() || com.baidu.tieba.video.f.bBb().bBc()) {
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
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dlS != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dlS.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dlS.hasFocus = z;
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
        this.dCb.onDestroy();
        this.dCc.onDestory();
    }

    public boolean or() {
        return this.dCb.or() || this.dCc.or();
    }

    public void ge(boolean z) {
        this.dCb.ge(z);
    }

    public void op() {
        this.dCb.op();
        this.dCc.op();
    }

    public void oq() {
        this.dCb.oq();
        this.dCc.oq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dCb.onConfigurationChanged(configuration);
    }

    public boolean ku(int i) {
        return this.dCb.ku(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kt(int i) {
        lE(i);
    }

    public int avf() {
        return this.dlO;
    }

    public void avg() {
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
        avh();
    }

    private void avh() {
        avg();
        this.dlO = 0;
        this.dCe = -1;
        op();
    }

    public void lE(final int i) {
        this.dlO = i;
        this.dCe = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dlO < this.mDatas.size() - 1) {
                final int lF = lF(i);
                int i2 = this.dlO + lF;
                this.dlO = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    if (j.jE() || com.baidu.tieba.video.f.bBb().bBc()) {
                        hVar2.setAutoPlay(true);
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setAutoPlay(false);
                        hVar2.setWaitConfirm(true);
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mListView.smoothScrollToPositionFromTop(i + e.this.mListView.getHeaderViewsCount() + lF, l.e(e.this.mContext.getPageActivity(), d.e.ds88) + l.e(e.this.mContext.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.dlO == this.mDatas.size() - 1 && (this.mDatas.get(this.dlO) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dlO);
                if (j.jE() || com.baidu.tieba.video.f.bBb().bBc()) {
                    hVar3.setAutoPlay(true);
                    hVar3.setWaitConfirm(false);
                    return;
                }
                hVar3.setAutoPlay(false);
                hVar3.setWaitConfirm(true);
            }
        }
    }

    public int lF(int i) {
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
            if (ol == null || ol.Pc) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void lG(int i) {
        this.dlO = i;
        this.dCe = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dlO <= this.mDatas.size() - 1 && (this.mDatas.get(this.dlO) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dlO);
                if (j.jE() || com.baidu.tieba.video.f.bBb().bBc()) {
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
        i iVar2 = this.Po;
        this.Po = iVar;
        if (iVar2 != null && iVar2 != this.Po) {
            iVar2.stopPlay();
        }
    }

    public void gg(boolean z) {
        this.dCb.gg(z);
    }
}
