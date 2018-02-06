package com.baidu.tieba.frs.videomiddlepage;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aggregation.d;
import com.baidu.tieba.frs.videomiddlepage.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class d implements d.a {
    private String aMB;
    private TbPageContext aRR;
    private boolean dIL;
    private c dWS;
    private a.InterfaceC0158a dWp;
    private String mFrom;
    private BdTypeListView mListView;
    private List<i> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dIM = -1;
    private int dWT = -1;

    public d(TbPageContext tbPageContext, BdTypeListView bdTypeListView, a.InterfaceC0158a interfaceC0158a, boolean z, String str, String str2) {
        this.dIL = false;
        this.aRR = tbPageContext;
        this.mListView = bdTypeListView;
        this.dIL = z;
        this.dWp = interfaceC0158a;
        this.mFrom = str;
        this.aMB = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dWS = new c(this.aRR, this, this.dWp, this.dIL, this.mFrom, this.aMB);
        this.mAdapters.add(this.dWS);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.dIL && z) {
                awM();
                list.get(0).autoPlay = true;
                if (j.oL()) {
                    list.get(0).waitConfirm = true;
                } else {
                    list.get(0).waitConfirm = false;
                }
            }
            if (this.mDatas.size() > this.dWT && !z && this.dWT != -1 && (this.mDatas.get(this.dWT) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWT)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWT)).waitConfirm = false;
                    return;
                }
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWT)).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWT)).waitConfirm = true;
            }
        }
    }

    public void G(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (i iVar : this.mDatas) {
                if (iVar != null && (iVar instanceof com.baidu.tieba.frs.aggregation.f) && ((com.baidu.tieba.frs.aggregation.f) iVar).dIQ != null && str.equals(((com.baidu.tieba.frs.aggregation.f) iVar).dIQ.userId)) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).dIQ.hasFocus = z;
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
        this.dWS.onDestroy();
    }

    public boolean awH() {
        return this.dWS.awH();
    }

    public void gu(boolean z) {
        this.dWS.gu(z);
    }

    public void awI() {
        this.dWS.awI();
    }

    public void awJ() {
        this.dWS.awJ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dWS.onConfigurationChanged(configuration);
    }

    public boolean nc(int i) {
        return this.dWS.nc(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void nd(int i) {
        oa(i);
    }

    public int awK() {
        return this.dIM;
    }

    public void awL() {
        if (!v.E(this.mDatas)) {
            for (i iVar : this.mDatas) {
                ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void cancel() {
        awM();
    }

    private void awM() {
        awL();
        this.dIM = 0;
        this.dWT = -1;
        awI();
    }

    public void oa(final int i) {
        this.dIM = i;
        this.dWT = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (i iVar : this.mDatas) {
                if (iVar instanceof com.baidu.tieba.frs.aggregation.f) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
                }
            }
            if (this.dIM < this.mDatas.size() - 1) {
                List<i> list = this.mDatas;
                int i2 = this.dIM + 1;
                this.dIM = i2;
                if (list.get(i2) instanceof com.baidu.tieba.frs.aggregation.f) {
                    if (j.oK()) {
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).autoPlay = true;
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).waitConfirm = false;
                    } else {
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).autoPlay = false;
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).waitConfirm = true;
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.mListView.smoothScrollToPositionFromTop(i + d.this.mListView.getHeaderViewsCount() + 1, l.t(d.this.aRR.getPageActivity(), d.e.ds88) + l.t(d.this.aRR.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.dIM == this.mDatas.size() - 1 && (this.mDatas.get(this.dIM) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).waitConfirm = false;
                    return;
                }
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).waitConfirm = true;
            }
        }
    }

    public void ob(int i) {
        this.dIM = i;
        this.dWT = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (i iVar : this.mDatas) {
                if (iVar instanceof com.baidu.tieba.frs.aggregation.f) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
                }
            }
            if (this.dIM <= this.mDatas.size() - 1 && (this.mDatas.get(this.dIM) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).waitConfirm = false;
                } else {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIM)).waitConfirm = true;
                }
                notifyDataSetChanged();
            }
        }
    }
}
