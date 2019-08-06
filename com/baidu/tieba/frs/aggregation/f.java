package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {
    private e fAw;
    private boolean fAx;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int fAy = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fAx = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fAx = z;
        initAdapters();
    }

    private void initAdapters() {
        this.fAw = new e(this.mContext, this, this.fAx);
        this.mAdapters.add(this.fAw);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.fAx && j.kd()) {
                boC();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void al(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<m> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next != null && (next instanceof g) && ((g) next).fAD != null && str.equals(((g) next).fAD.userId)) {
                    ((g) next).fAD.hasFocus = z;
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
        this.fAw.onDestroy();
    }

    public boolean po() {
        return this.fAw.po();
    }

    public void pm() {
        this.fAw.pm();
    }

    public void pn() {
        this.fAw.pn();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fAw.onConfigurationChanged(configuration);
    }

    public boolean rT(int i) {
        return this.fAw.rT(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void rS(int i) {
        this.fAy = i;
        if (!v.aa(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.kd()) {
                if (this.fAy < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fAy + 1;
                    this.fAy = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fAy)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fAy == this.mDatas.size() - 1 && (this.mDatas.get(this.fAy) instanceof g)) {
                    ((g) this.mDatas.get(this.fAy)).autoPlay = false;
                }
            }
        }
    }

    public int boA() {
        return this.fAy;
    }

    public void boB() {
        if (!v.aa(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        boC();
    }

    private void boC() {
        boB();
        this.fAy = 0;
        pm();
    }
}
