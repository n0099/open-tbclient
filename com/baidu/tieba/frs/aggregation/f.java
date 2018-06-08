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
    private e dlM;
    private boolean dlN;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.h> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dlO = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dlN = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.dlN = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dlM = new e(this.mContext, this, this.dlN);
        this.mAdapters.add(this.dlM);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dlN && j.jE()) {
                avh();
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
                if (next != null && (next instanceof g) && ((g) next).dlS != null && str.equals(((g) next).dlS.userId)) {
                    ((g) next).dlS.hasFocus = z;
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
        this.dlM.onDestroy();
    }

    public boolean or() {
        return this.dlM.or();
    }

    public void op() {
        this.dlM.op();
    }

    public void oq() {
        this.dlM.oq();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dlM.onConfigurationChanged(configuration);
    }

    public boolean ku(int i) {
        return this.dlM.ku(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void kt(int i) {
        this.dlO = i;
        if (!w.z(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.h hVar : this.mDatas) {
                if (hVar instanceof g) {
                    ((g) hVar).autoPlay = false;
                }
            }
            if (j.jE()) {
                if (this.dlO < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.h> list = this.mDatas;
                    int i2 = this.dlO + 1;
                    this.dlO = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.dlO)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dlO == this.mDatas.size() - 1 && (this.mDatas.get(this.dlO) instanceof g)) {
                    ((g) this.mDatas.get(this.dlO)).autoPlay = false;
                }
            }
        }
    }

    public int avf() {
        return this.dlO;
    }

    public void avg() {
        if (!w.z(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.h> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        avh();
    }

    private void avh() {
        avg();
        this.dlO = 0;
        op();
    }
}
