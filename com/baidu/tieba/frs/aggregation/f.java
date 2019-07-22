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
    private e fzI;
    private boolean fzJ;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int fzK = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fzJ = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fzJ = z;
        initAdapters();
    }

    private void initAdapters() {
        this.fzI = new e(this.mContext, this, this.fzJ);
        this.mAdapters.add(this.fzI);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.fzJ && j.kd()) {
                bop();
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
                if (next != null && (next instanceof g) && ((g) next).fzP != null && str.equals(((g) next).fzP.userId)) {
                    ((g) next).fzP.hasFocus = z;
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
        this.fzI.onDestroy();
    }

    public boolean po() {
        return this.fzI.po();
    }

    public void pm() {
        this.fzI.pm();
    }

    public void pn() {
        this.fzI.pn();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fzI.onConfigurationChanged(configuration);
    }

    public boolean rR(int i) {
        return this.fzI.rR(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void rQ(int i) {
        this.fzK = i;
        if (!v.aa(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.kd()) {
                if (this.fzK < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fzK + 1;
                    this.fzK = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fzK)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fzK == this.mDatas.size() - 1 && (this.mDatas.get(this.fzK) instanceof g)) {
                    ((g) this.mDatas.get(this.fzK)).autoPlay = false;
                }
            }
        }
    }

    public int bon() {
        return this.fzK;
    }

    public void boo() {
        if (!v.aa(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bop();
    }

    private void bop() {
        boo();
        this.fzK = 0;
        pm();
    }
}
