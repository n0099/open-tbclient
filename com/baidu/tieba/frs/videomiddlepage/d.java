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
    private String aMr;
    private TbPageContext aRI;
    private boolean dIE;
    private c dWM;
    private a.InterfaceC0159a dWj;
    private String mFrom;
    private BdTypeListView mListView;
    private List<i> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dIF = -1;
    private int dWN = -1;

    public d(TbPageContext tbPageContext, BdTypeListView bdTypeListView, a.InterfaceC0159a interfaceC0159a, boolean z, String str, String str2) {
        this.dIE = false;
        this.aRI = tbPageContext;
        this.mListView = bdTypeListView;
        this.dIE = z;
        this.dWj = interfaceC0159a;
        this.mFrom = str;
        this.aMr = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dWM = new c(this.aRI, this, this.dWj, this.dIE, this.mFrom, this.aMr);
        this.mAdapters.add(this.dWM);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.dIE && z) {
                awN();
                list.get(0).autoPlay = true;
                if (j.oL()) {
                    list.get(0).waitConfirm = true;
                } else {
                    list.get(0).waitConfirm = false;
                }
            }
            if (this.mDatas.size() > this.dWN && !z && this.dWN != -1 && (this.mDatas.get(this.dWN) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWN)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWN)).waitConfirm = false;
                    return;
                }
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWN)).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWN)).waitConfirm = true;
            }
        }
    }

    public void F(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (i iVar : this.mDatas) {
                if (iVar != null && (iVar instanceof com.baidu.tieba.frs.aggregation.f) && ((com.baidu.tieba.frs.aggregation.f) iVar).dIJ != null && str.equals(((com.baidu.tieba.frs.aggregation.f) iVar).dIJ.userId)) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).dIJ.hasFocus = z;
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
        this.dWM.onDestroy();
    }

    public boolean awI() {
        return this.dWM.awI();
    }

    public void gw(boolean z) {
        this.dWM.gw(z);
    }

    public void awJ() {
        this.dWM.awJ();
    }

    public void awK() {
        this.dWM.awK();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dWM.onConfigurationChanged(configuration);
    }

    public boolean nc(int i) {
        return this.dWM.nc(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void nd(int i) {
        oa(i);
    }

    public int awL() {
        return this.dIF;
    }

    public void awM() {
        if (!v.E(this.mDatas)) {
            for (i iVar : this.mDatas) {
                ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void cancel() {
        awN();
    }

    private void awN() {
        awM();
        this.dIF = 0;
        this.dWN = -1;
        awJ();
    }

    public void oa(final int i) {
        this.dIF = i;
        this.dWN = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (i iVar : this.mDatas) {
                if (iVar instanceof com.baidu.tieba.frs.aggregation.f) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
                }
            }
            if (this.dIF < this.mDatas.size() - 1) {
                List<i> list = this.mDatas;
                int i2 = this.dIF + 1;
                this.dIF = i2;
                if (list.get(i2) instanceof com.baidu.tieba.frs.aggregation.f) {
                    if (j.oK()) {
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).autoPlay = true;
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).waitConfirm = false;
                    } else {
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).autoPlay = false;
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).waitConfirm = true;
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.mListView.smoothScrollToPositionFromTop(i + d.this.mListView.getHeaderViewsCount() + 1, l.t(d.this.aRI.getPageActivity(), d.e.ds88) + l.t(d.this.aRI.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.dIF == this.mDatas.size() - 1 && (this.mDatas.get(this.dIF) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).waitConfirm = false;
                    return;
                }
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).waitConfirm = true;
            }
        }
    }

    public void ob(int i) {
        this.dIF = i;
        this.dWN = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (i iVar : this.mDatas) {
                if (iVar instanceof com.baidu.tieba.frs.aggregation.f) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
                }
            }
            if (this.dIF <= this.mDatas.size() - 1 && (this.mDatas.get(this.dIF) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).waitConfirm = false;
                } else {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIF)).waitConfirm = true;
                }
                notifyDataSetChanged();
            }
        }
    }
}
