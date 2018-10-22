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
    private e dFD;
    private boolean dFE;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dFF = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dFE = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dFE = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dFD = new e(this.mContext, this, this.dFE);
        this.mAdapters.add(this.dFD);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dFE && j.kY()) {
                aBT();
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
                if (next != null && (next instanceof g) && ((g) next).dFK != null && str.equals(((g) next).dFK.userId)) {
                    ((g) next).dFK.hasFocus = z;
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
        this.dFD.onDestroy();
    }

    public boolean pE() {
        return this.dFD.pE();
    }

    public void pC() {
        this.dFD.pC();
    }

    public void pD() {
        this.dFD.pD();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dFD.onConfigurationChanged(configuration);
    }

    public boolean lM(int i) {
        return this.dFD.lM(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void lL(int i) {
        this.dFF = i;
        if (!v.J(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kY()) {
                if (this.dFF < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dFF + 1;
                    this.dFF = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dFF)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dFF == this.mDatas.size() - 1 && (this.mDatas.get(this.dFF) instanceof g)) {
                    ((g) this.mDatas.get(this.dFF)).autoPlay = false;
                }
            }
        }
    }

    public int aBR() {
        return this.dFF;
    }

    public void aBS() {
        if (!v.J(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        aBT();
    }

    private void aBT() {
        aBS();
        this.dFF = 0;
        pC();
    }
}
