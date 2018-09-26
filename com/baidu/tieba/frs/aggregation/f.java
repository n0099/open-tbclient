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
    private e dxC;
    private boolean dxD;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dxE = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dxD = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dxD = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dxC = new e(this.mContext, this, this.dxD);
        this.mAdapters.add(this.dxC);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dxD && j.kL()) {
                ayz();
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
                if (next != null && (next instanceof g) && ((g) next).dxJ != null && str.equals(((g) next).dxJ.userId)) {
                    ((g) next).dxJ.hasFocus = z;
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
        this.dxC.onDestroy();
    }

    public boolean pw() {
        return this.dxC.pw();
    }

    public void pu() {
        this.dxC.pu();
    }

    public void pv() {
        this.dxC.pv();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dxC.onConfigurationChanged(configuration);
    }

    public boolean lo(int i) {
        return this.dxC.lo(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ln(int i) {
        this.dxE = i;
        if (!v.z(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.kL()) {
                if (this.dxE < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dxE + 1;
                    this.dxE = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dxE)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dxE == this.mDatas.size() - 1 && (this.mDatas.get(this.dxE) instanceof g)) {
                    ((g) this.mDatas.get(this.dxE)).autoPlay = false;
                }
            }
        }
    }

    public int ayx() {
        return this.dxE;
    }

    public void ayy() {
        if (!v.z(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        ayz();
    }

    private void ayz() {
        ayy();
        this.dxE = 0;
        pu();
    }
}
