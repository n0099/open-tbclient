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
    private e dGS;
    private boolean dGT;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dGU = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dGT = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dGT = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dGS = new e(this.mContext, this, this.dGT);
        this.mAdapters.add(this.dGS);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dGT && j.kW()) {
                aBq();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void K(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).dGZ != null && str.equals(((g) next).dGZ.userId)) {
                    ((g) next).dGZ.hasFocus = z;
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
        this.dGS.onDestroy();
    }

    public boolean pC() {
        return this.dGS.pC();
    }

    public void pA() {
        this.dGS.pA();
    }

    public void pB() {
        this.dGS.pB();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dGS.onConfigurationChanged(configuration);
    }

    public boolean me(int i) {
        return this.dGS.me(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void md(int i) {
        this.dGU = i;
        if (!v.I(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kW()) {
                if (this.dGU < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dGU + 1;
                    this.dGU = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dGU)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dGU == this.mDatas.size() - 1 && (this.mDatas.get(this.dGU) instanceof g)) {
                    ((g) this.mDatas.get(this.dGU)).autoPlay = false;
                }
            }
        }
    }

    public int aBo() {
        return this.dGU;
    }

    public void aBp() {
        if (!v.I(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        aBq();
    }

    private void aBq() {
        aBp();
        this.dGU = 0;
        pA();
    }
}
