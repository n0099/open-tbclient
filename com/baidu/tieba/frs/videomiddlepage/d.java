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
    private String aMq;
    private TbPageContext aRG;
    private boolean dIz;
    private c dWG;
    private a.InterfaceC0159a dWd;
    private String mFrom;
    private BdTypeListView mListView;
    private List<i> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dIA = -1;
    private int dWH = -1;

    public d(TbPageContext tbPageContext, BdTypeListView bdTypeListView, a.InterfaceC0159a interfaceC0159a, boolean z, String str, String str2) {
        this.dIz = false;
        this.aRG = tbPageContext;
        this.mListView = bdTypeListView;
        this.dIz = z;
        this.dWd = interfaceC0159a;
        this.mFrom = str;
        this.aMq = str2;
        initAdapters();
    }

    private void initAdapters() {
        this.dWG = new c(this.aRG, this, this.dWd, this.dIz, this.mFrom, this.aMq);
        this.mAdapters.add(this.dWG);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<com.baidu.tieba.frs.aggregation.f> list, boolean z) {
        if (list != null) {
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (list.size() > 0 && this.dIz && z) {
                awL();
                list.get(0).autoPlay = true;
                if (j.oL()) {
                    list.get(0).waitConfirm = true;
                } else {
                    list.get(0).waitConfirm = false;
                }
            }
            if (this.mDatas.size() > this.dWH && !z && this.dWH != -1 && (this.mDatas.get(this.dWH) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWH)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWH)).waitConfirm = false;
                    return;
                }
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWH)).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dWH)).waitConfirm = true;
            }
        }
    }

    public void F(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            for (i iVar : this.mDatas) {
                if (iVar != null && (iVar instanceof com.baidu.tieba.frs.aggregation.f) && ((com.baidu.tieba.frs.aggregation.f) iVar).dIE != null && str.equals(((com.baidu.tieba.frs.aggregation.f) iVar).dIE.userId)) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).dIE.hasFocus = z;
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
        this.dWG.onDestroy();
    }

    public boolean awG() {
        return this.dWG.awG();
    }

    public void gu(boolean z) {
        this.dWG.gu(z);
    }

    public void awH() {
        this.dWG.awH();
    }

    public void awI() {
        this.dWG.awI();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dWG.onConfigurationChanged(configuration);
    }

    public boolean nc(int i) {
        return this.dWG.nc(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void nd(int i) {
        oa(i);
    }

    public int awJ() {
        return this.dIA;
    }

    public void awK() {
        if (!v.E(this.mDatas)) {
            for (i iVar : this.mDatas) {
                ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void cancel() {
        awL();
    }

    private void awL() {
        awK();
        this.dIA = 0;
        this.dWH = -1;
        awH();
    }

    public void oa(final int i) {
        this.dIA = i;
        this.dWH = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (i iVar : this.mDatas) {
                if (iVar instanceof com.baidu.tieba.frs.aggregation.f) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
                }
            }
            if (this.dIA < this.mDatas.size() - 1) {
                List<i> list = this.mDatas;
                int i2 = this.dIA + 1;
                this.dIA = i2;
                if (list.get(i2) instanceof com.baidu.tieba.frs.aggregation.f) {
                    if (j.oK()) {
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).autoPlay = true;
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).waitConfirm = false;
                    } else {
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).autoPlay = false;
                        ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).waitConfirm = true;
                    }
                    this.mListView.post(new Runnable() { // from class: com.baidu.tieba.frs.videomiddlepage.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.mListView.smoothScrollToPositionFromTop(i + d.this.mListView.getHeaderViewsCount() + 1, l.t(d.this.aRG.getPageActivity(), d.e.ds88) + l.t(d.this.aRG.getPageActivity(), d.e.tbds42));
                        }
                    });
                    notifyDataSetChanged();
                }
            } else if (this.dIA == this.mDatas.size() - 1 && (this.mDatas.get(this.dIA) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).waitConfirm = false;
                    return;
                }
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).autoPlay = false;
                ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).waitConfirm = true;
            }
        }
    }

    public void ob(int i) {
        this.dIA = i;
        this.dWH = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (i iVar : this.mDatas) {
                if (iVar instanceof com.baidu.tieba.frs.aggregation.f) {
                    ((com.baidu.tieba.frs.aggregation.f) iVar).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) iVar).waitConfirm = false;
                }
            }
            if (this.dIA <= this.mDatas.size() - 1 && (this.mDatas.get(this.dIA) instanceof com.baidu.tieba.frs.aggregation.f)) {
                if (j.oK()) {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).autoPlay = true;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).waitConfirm = false;
                } else {
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).autoPlay = false;
                    ((com.baidu.tieba.frs.aggregation.f) this.mDatas.get(this.dIA)).waitConfirm = true;
                }
                notifyDataSetChanged();
            }
        }
    }
}
