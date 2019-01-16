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
    private e dQO;
    private boolean dQP;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dQQ = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dQP = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dQP = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dQO = new e(this.mContext, this, this.dQP);
        this.mAdapters.add(this.dQO);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dQP && j.kW()) {
                aEm();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void L(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).dQV != null && str.equals(((g) next).dQV.userId)) {
                    ((g) next).dQV.hasFocus = z;
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
        this.dQO.onDestroy();
    }

    public boolean pF() {
        return this.dQO.pF();
    }

    public void pD() {
        this.dQO.pD();
    }

    public void pE() {
        this.dQO.pE();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dQO.onConfigurationChanged(configuration);
    }

    public boolean mI(int i) {
        return this.dQO.mI(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mH(int i) {
        this.dQQ = i;
        if (!v.I(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kW()) {
                if (this.dQQ < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dQQ + 1;
                    this.dQQ = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dQQ)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dQQ == this.mDatas.size() - 1 && (this.mDatas.get(this.dQQ) instanceof g)) {
                    ((g) this.mDatas.get(this.dQQ)).autoPlay = false;
                }
            }
        }
    }

    public int aEk() {
        return this.dQQ;
    }

    public void aEl() {
        if (!v.I(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        aEm();
    }

    private void aEm() {
        aEl();
        this.dQQ = 0;
        pD();
    }
}
