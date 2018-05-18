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
    private e dcx;
    private boolean dcy;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dcz = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dcy = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dcy = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dcx = new e(this.mContext, this, this.dcy);
        this.mAdapters.add(this.dcx);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dcy && j.gQ()) {
                arc();
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
                if (next != null && (next instanceof g) && ((g) next).dcD != null && str.equals(((g) next).dcD.userId)) {
                    ((g) next).dcD.hasFocus = z;
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
        this.dcx.onDestroy();
    }

    public boolean lB() {
        return this.dcx.lB();
    }

    public void lz() {
        this.dcx.lz();
    }

    public void lA() {
        this.dcx.lA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dcx.onConfigurationChanged(configuration);
    }

    public boolean kp(int i) {
        return this.dcx.kp(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ko(int i) {
        this.dcz = i;
        if (!v.w(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.gQ()) {
                if (this.dcz < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dcz + 1;
                    this.dcz = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dcz)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dcz == this.mDatas.size() - 1 && (this.mDatas.get(this.dcz) instanceof g)) {
                    ((g) this.mDatas.get(this.dcz)).autoPlay = false;
                }
            }
        }
    }

    public int ara() {
        return this.dcz;
    }

    public void arb() {
        if (!v.w(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        arc();
    }

    private void arc() {
        arb();
        this.dcz = 0;
        lz();
    }
}
