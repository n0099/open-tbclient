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
    private i Jd;
    private String XN;
    private boolean dcy;
    private d dsO;
    private com.baidu.afd.a.b dsP;
    private com.baidu.adp.widget.ListView.a dsQ;
    private b dsp;
    private TbPageContext mContext;
    private String mFrom;
    private BdTypeListView mListView;
    private List<h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dcz = -1;
    private int dsR = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, b bVar, boolean z, String str, String str2) {
        this.dcy = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dcy = z;
        this.dsp = bVar;
        this.mFrom = str;
        this.XN = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dsO = new d(this.mContext, this, this.dsp, this.dcy, this.mFrom, this.XN, this);
        this.dsP = new com.baidu.afd.a.b(this.mContext, com.baidu.afd.b.IE, this, this.dsp, this);
        this.dsQ = new com.baidu.afd.a.c(this.mContext, com.baidu.afd.b.IC);
        this.mAdapters.add(this.dsO);
        this.mAdapters.add(this.dsQ);
        this.mAdapters.add(this.dsP);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.card.data.b> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.dcy && z) {
                arc();
                if (list.get(0) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar = (com.baidu.tieba.lego.card.view.h) list.get(0);
                    hVar.setAutoPlay(true);
                    if (j.gR() && !com.baidu.tieba.video.f.bvU().bvV()) {
                        hVar.setWaitConfirm(true);
                    } else {
                        hVar.setWaitConfirm(false);
                    }
                }
            }
            if (this.mDatas.size() > this.dsR && !z && this.dsR != -1 && (this.mDatas.get(this.dsR) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dsR);
                if (j.gQ() || com.baidu.tieba.video.f.bvU().bvV()) {
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
                if (hVar != null && (hVar instanceof com.baidu.tieba.frs.aggregation.g) && ((com.baidu.tieba.frs.aggregation.g) hVar).dcD != null && str.equals(((com.baidu.tieba.frs.aggregation.g) hVar).dcD.userId)) {
                    ((com.baidu.tieba.frs.aggregation.g) hVar).dcD.hasFocus = z;
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
        this.dsO.onDestroy();
        this.dsP.onDestory();
    }

    public boolean lB() {
        return this.dsO.lB() || this.dsP.lB();
    }

    public void fZ(boolean z) {
        this.dsO.fZ(z);
    }

    public void lz() {
        this.dsO.lz();
        this.dsP.lz();
    }

    public void lA() {
        this.dsO.lA();
        this.dsP.lA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dsO.onConfigurationChanged(configuration);
    }

    public boolean kp(int i) {
        return this.dsO.kp(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ko(int i) {
        lx(i);
    }

    public int ara() {
        return this.dcz;
    }

    public void arb() {
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
        arc();
    }

    private void arc() {
        arb();
        this.dcz = 0;
        this.dsR = -1;
        lz();
    }

    public void lx(final int i) {
        this.dcz = i;
        this.dsR = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dcz < this.mDatas.size() - 1) {
                final int ly = ly(i);
                int i2 = this.dcz + ly;
                this.dcz = i2;
                if (this.mDatas.get(i2) instanceof com.baidu.tieba.lego.card.view.h) {
                    com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(i2);
                    if (j.gQ() || com.baidu.tieba.video.f.bvU().bvV()) {
                        hVar2.setAutoPlay(true);
                        hVar2.setWaitConfirm(false);
                    } else {
                        hVar2.setAutoPlay(false);
                        hVar2.setWaitConfirm(true);
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.mListView.smoothScrollToPositionFromTop(i + e.this.mListView.getHeaderViewsCount() + ly, l.e(e.this.mContext.getPageActivity(), d.e.ds88) + l.e(e.this.mContext.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.dcz == this.mDatas.size() - 1 && (this.mDatas.get(this.dcz) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar3 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dcz);
                if (j.gQ() || com.baidu.tieba.video.f.bvU().bvV()) {
                    hVar3.setAutoPlay(true);
                    hVar3.setWaitConfirm(false);
                    return;
                }
                hVar3.setAutoPlay(false);
                hVar3.setWaitConfirm(true);
            }
        }
    }

    public int ly(int i) {
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
            com.baidu.afd.e lv = ((com.baidu.afd.d) hVar).lv();
            if (lv == null || lv.IQ) {
                z = false;
            }
            return z;
        }
        return false;
    }

    public void lz(int i) {
        this.dcz = i;
        this.dsR = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (h hVar : this.mDatas) {
                if (hVar instanceof com.baidu.tieba.lego.card.view.h) {
                    ((com.baidu.tieba.lego.card.view.h) hVar).setAutoPlay(false);
                    ((com.baidu.tieba.lego.card.view.h) hVar).setWaitConfirm(false);
                }
            }
            if (this.dcz <= this.mDatas.size() - 1 && (this.mDatas.get(this.dcz) instanceof com.baidu.tieba.lego.card.view.h)) {
                com.baidu.tieba.lego.card.view.h hVar2 = (com.baidu.tieba.lego.card.view.h) this.mDatas.get(this.dcz);
                if (j.gQ() || com.baidu.tieba.video.f.bvU().bvV()) {
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
        i iVar2 = this.Jd;
        this.Jd = iVar;
        if (iVar2 != null && iVar2 != this.Jd) {
            iVar2.stopPlay();
        }
    }

    public void gb(boolean z) {
        this.dsO.gb(z);
    }
}
