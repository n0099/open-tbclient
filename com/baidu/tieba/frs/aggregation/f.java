package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements a {
    private TbPageContext adf;
    private e dbp;
    private boolean dbq;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dbr = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dbq = false;
        this.adf = tbPageContext;
        this.mListView = bdTypeListView;
        this.dbq = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dbp = new e(this.adf, this, this.dbq);
        this.mAdapters.add(this.dbp);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dbq && j.gQ()) {
                ard();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void C(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.h next = it.next();
                if (next != null && (next instanceof g) && ((g) next).dbv != null && str.equals(((g) next).dbv.userId)) {
                    ((g) next).dbv.hasFocus = z;
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
        this.dbp.onDestroy();
    }

    public boolean lC() {
        return this.dbp.lC();
    }

    public void lA() {
        this.dbp.lA();
    }

    public void lB() {
        this.dbp.lB();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dbp.onConfigurationChanged(configuration);
    }

    public boolean kq(int i) {
        return this.dbp.kq(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kp(int i) {
        this.dbr = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.gQ()) {
                if (this.dbr < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dbr + 1;
                    this.dbr = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dbr)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dbr == this.mDatas.size() - 1 && (this.mDatas.get(this.dbr) instanceof g)) {
                    ((g) this.mDatas.get(this.dbr)).autoPlay = false;
                }
            }
        }
    }

    public int arb() {
        return this.dbr;
    }

    public void arc() {
        if (!v.w(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        ard();
    }

    private void ard() {
        arc();
        this.dbr = 0;
        lA();
    }
}
