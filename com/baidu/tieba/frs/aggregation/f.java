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
    private e drr;
    private boolean drs;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int drt = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.drs = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.drs = z;
        initAdapters();
    }

    private void initAdapters() {
        this.drr = new e(this.mContext, this, this.drs);
        this.mAdapters.add(this.drr);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.drs && j.jF()) {
                awq();
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
                if (next != null && (next instanceof g) && ((g) next).drx != null && str.equals(((g) next).drx.userId)) {
                    ((g) next).drx.hasFocus = z;
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
        this.drr.onDestroy();
    }

    public boolean ot() {
        return this.drr.ot();
    }

    public void or() {
        this.drr.or();
    }

    public void os() {
        this.drr.os();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.drr.onConfigurationChanged(configuration);
    }

    public boolean kM(int i) {
        return this.drr.kM(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kL(int i) {
        this.drt = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.jF()) {
                if (this.drt < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.drt + 1;
                    this.drt = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.drt)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.drt == this.mDatas.size() - 1 && (this.mDatas.get(this.drt) instanceof g)) {
                    ((g) this.mDatas.get(this.drt)).autoPlay = false;
                }
            }
        }
    }

    public int awo() {
        return this.drt;
    }

    public void awp() {
        if (!w.z(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        awq();
    }

    private void awq() {
        awp();
        this.drt = 0;
        or();
    }
}
