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
    private e dQP;
    private boolean dQQ;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dQR = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dQQ = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dQQ = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dQP = new e(this.mContext, this, this.dQQ);
        this.mAdapters.add(this.dQP);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dQQ && j.kW()) {
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
                if (next != null && (next instanceof g) && ((g) next).dQW != null && str.equals(((g) next).dQW.userId)) {
                    ((g) next).dQW.hasFocus = z;
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
        this.dQP.onDestroy();
    }

    public boolean pF() {
        return this.dQP.pF();
    }

    public void pD() {
        this.dQP.pD();
    }

    public void pE() {
        this.dQP.pE();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dQP.onConfigurationChanged(configuration);
    }

    public boolean mI(int i) {
        return this.dQP.mI(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void mH(int i) {
        this.dQR = i;
        if (!v.I(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kW()) {
                if (this.dQR < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dQR + 1;
                    this.dQR = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dQR)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dQR == this.mDatas.size() - 1 && (this.mDatas.get(this.dQR) instanceof g)) {
                    ((g) this.mDatas.get(this.dQR)).autoPlay = false;
                }
            }
        }
    }

    public int aEk() {
        return this.dQR;
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
        this.dQR = 0;
        pD();
    }
}
