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
    private e dNr;
    private boolean dNs;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dNt = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dNs = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dNs = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dNr = new e(this.mContext, this, this.dNs);
        this.mAdapters.add(this.dNr);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dNs && j.kW()) {
                aDa();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void M(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).dNy != null && str.equals(((g) next).dNy.userId)) {
                    ((g) next).dNy.hasFocus = z;
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
        this.dNr.onDestroy();
    }

    public boolean pB() {
        return this.dNr.pB();
    }

    public void pz() {
        this.dNr.pz();
    }

    public void pA() {
        this.dNr.pA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dNr.onConfigurationChanged(configuration);
    }

    public boolean mu(int i) {
        return this.dNr.mu(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mt(int i) {
        this.dNt = i;
        if (!v.I(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kW()) {
                if (this.dNt < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dNt + 1;
                    this.dNt = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dNt)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dNt == this.mDatas.size() - 1 && (this.mDatas.get(this.dNt) instanceof g)) {
                    ((g) this.mDatas.get(this.dNt)).autoPlay = false;
                }
            }
        }
    }

    public int aCY() {
        return this.dNt;
    }

    public void aCZ() {
        if (!v.I(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        aDa();
    }

    private void aDa() {
        aCZ();
        this.dNt = 0;
        pz();
    }
}
