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
    private e dQf;
    private boolean dQg;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dQh = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dQg = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dQg = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dQf = new e(this.mContext, this, this.dQg);
        this.mAdapters.add(this.dQf);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dQg && j.kW()) {
                aDP();
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
                if (next != null && (next instanceof g) && ((g) next).dQm != null && str.equals(((g) next).dQm.userId)) {
                    ((g) next).dQm.hasFocus = z;
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
        this.dQf.onDestroy();
    }

    public boolean pB() {
        return this.dQf.pB();
    }

    public void pz() {
        this.dQf.pz();
    }

    public void pA() {
        this.dQf.pA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dQf.onConfigurationChanged(configuration);
    }

    public boolean mH(int i) {
        return this.dQf.mH(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mG(int i) {
        this.dQh = i;
        if (!v.I(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kW()) {
                if (this.dQh < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dQh + 1;
                    this.dQh = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dQh)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dQh == this.mDatas.size() - 1 && (this.mDatas.get(this.dQh) instanceof g)) {
                    ((g) this.mDatas.get(this.dQh)).autoPlay = false;
                }
            }
        }
    }

    public int aDN() {
        return this.dQh;
    }

    public void aDO() {
        if (!v.I(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        aDP();
    }

    private void aDP() {
        aDO();
        this.dQh = 0;
        pz();
    }
}
