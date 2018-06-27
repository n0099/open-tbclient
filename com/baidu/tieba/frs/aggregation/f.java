package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class f implements a {
    private e doy;
    private boolean doz;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int doA = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.doz = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.doz = z;
        initAdapters();
    }

    private void initAdapters() {
        this.doy = new e(this.mContext, this, this.doz);
        this.mAdapters.add(this.doy);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.doz && j.jE()) {
                avL();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void D(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).doE != null && str.equals(((g) next).doE.userId)) {
                    ((g) next).doE.hasFocus = z;
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
        this.doy.onDestroy();
    }

    public boolean or() {
        return this.doy.or();
    }

    public void op() {
        this.doy.op();
    }

    public void oq() {
        this.doy.oq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.doy.onConfigurationChanged(configuration);
    }

    public boolean kB(int i) {
        return this.doy.kB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kA(int i) {
        this.doA = i;
        if (!w.A(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.jE()) {
                if (this.doA < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.doA + 1;
                    this.doA = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.doA)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.doA == this.mDatas.size() - 1 && (this.mDatas.get(this.doA) instanceof g)) {
                    ((g) this.mDatas.get(this.doA)).autoPlay = false;
                }
            }
        }
    }

    public int avJ() {
        return this.doA;
    }

    public void avK() {
        if (!w.A(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        avL();
    }

    private void avL() {
        avK();
        this.doA = 0;
        op();
    }
}
