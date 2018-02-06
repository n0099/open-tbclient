package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.aggregation.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements d.a {
    private TbPageContext aRR;
    private d dIK;
    private boolean dIL;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.i> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dIM = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dIL = false;
        this.aRR = tbPageContext;
        this.mListView = bdTypeListView;
        this.dIL = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dIK = new d(this.aRR, this, this.dIL);
        this.mAdapters.add(this.dIK);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<f> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dIL && j.oK()) {
                awM();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void G(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<com.baidu.adp.widget.ListView.i> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && (next instanceof f) && ((f) next).dIQ != null && str.equals(((f) next).dIQ.userId)) {
                    ((f) next).dIQ.hasFocus = z;
                    z2 = true;
                }
                z3 = z2;
            }
            if (z2) {
                notifyDataSetChanged();
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof BaseAdapter)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.dIK.onDestroy();
    }

    public boolean awH() {
        return this.dIK.awH();
    }

    public void awI() {
        this.dIK.awI();
    }

    public void awJ() {
        this.dIK.awJ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dIK.onConfigurationChanged(configuration);
    }

    public boolean nc(int i) {
        return this.dIK.nc(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void nd(int i) {
        this.dIM = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.i iVar : this.mDatas) {
                if (iVar instanceof f) {
                    ((f) iVar).autoPlay = false;
                }
            }
            if (j.oK()) {
                if (this.dIM < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.i> list = this.mDatas;
                    int i2 = this.dIM + 1;
                    this.dIM = i2;
                    if (list.get(i2) instanceof f) {
                        ((f) this.mDatas.get(this.dIM)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dIM == this.mDatas.size() - 1 && (this.mDatas.get(this.dIM) instanceof f)) {
                    ((f) this.mDatas.get(this.dIM)).autoPlay = false;
                }
            }
        }
    }

    public int awK() {
        return this.dIM;
    }

    public void awL() {
        if (!v.E(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((f) it.next()).autoPlay = false;
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
        awI();
    }
}
