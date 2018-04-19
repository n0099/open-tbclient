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
    private e dbs;
    private boolean dbt;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dbu = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dbt = false;
        this.adf = tbPageContext;
        this.mListView = bdTypeListView;
        this.dbt = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dbs = new e(this.adf, this, this.dbt);
        this.mAdapters.add(this.dbs);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dbt && j.gQ()) {
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
                if (next != null && (next instanceof g) && ((g) next).dby != null && str.equals(((g) next).dby.userId)) {
                    ((g) next).dby.hasFocus = z;
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
        this.dbs.onDestroy();
    }

    public boolean lC() {
        return this.dbs.lC();
    }

    public void lA() {
        this.dbs.lA();
    }

    public void lB() {
        this.dbs.lB();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dbs.onConfigurationChanged(configuration);
    }

    public boolean kq(int i) {
        return this.dbs.kq(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kp(int i) {
        this.dbu = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.gQ()) {
                if (this.dbu < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dbu + 1;
                    this.dbu = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dbu)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dbu == this.mDatas.size() - 1 && (this.mDatas.get(this.dbu) instanceof g)) {
                    ((g) this.mDatas.get(this.dbu)).autoPlay = false;
                }
            }
        }
    }

    public int arb() {
        return this.dbu;
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
        this.dbu = 0;
        lA();
    }
}
