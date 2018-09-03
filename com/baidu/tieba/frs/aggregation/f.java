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
    private e dro;
    private boolean drp;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int drq = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.drp = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.drp = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dro = new e(this.mContext, this, this.drp);
        this.mAdapters.add(this.dro);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.drp && j.jF()) {
                awp();
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
                if (next != null && (next instanceof g) && ((g) next).dru != null && str.equals(((g) next).dru.userId)) {
                    ((g) next).dru.hasFocus = z;
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
        this.dro.onDestroy();
    }

    public boolean oq() {
        return this.dro.oq();
    }

    public void oo() {
        this.dro.oo();
    }

    public void op() {
        this.dro.op();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dro.onConfigurationChanged(configuration);
    }

    public boolean kL(int i) {
        return this.dro.kL(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kK(int i) {
        this.drq = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.jF()) {
                if (this.drq < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.drq + 1;
                    this.drq = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.drq)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.drq == this.mDatas.size() - 1 && (this.mDatas.get(this.drq) instanceof g)) {
                    ((g) this.mDatas.get(this.drq)).autoPlay = false;
                }
            }
        }
    }

    public int awn() {
        return this.drq;
    }

    public void awo() {
        if (!w.z(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        awp();
    }

    private void awp() {
        awo();
        this.drq = 0;
        oo();
    }
}
