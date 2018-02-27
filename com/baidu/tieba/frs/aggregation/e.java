package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.aggregation.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class e implements d.a {
    private TbPageContext aRG;
    private d dIy;
    private boolean dIz;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.i> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dIA = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dIz = false;
        this.aRG = tbPageContext;
        this.mListView = bdTypeListView;
        this.dIz = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dIy = new d(this.aRG, this, this.dIz);
        this.mAdapters.add(this.dIy);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<f> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dIz && j.oK()) {
                awL();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void F(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<com.baidu.adp.widget.ListView.i> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                com.baidu.adp.widget.ListView.i next = it.next();
                if (next != null && (next instanceof f) && ((f) next).dIE != null && str.equals(((f) next).dIE.userId)) {
                    ((f) next).dIE.hasFocus = z;
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
        this.dIy.onDestroy();
    }

    public boolean awG() {
        return this.dIy.awG();
    }

    public void awH() {
        this.dIy.awH();
    }

    public void awI() {
        this.dIy.awI();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dIy.onConfigurationChanged(configuration);
    }

    public boolean nc(int i) {
        return this.dIy.nc(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void nd(int i) {
        this.dIA = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.i iVar : this.mDatas) {
                if (iVar instanceof f) {
                    ((f) iVar).autoPlay = false;
                }
            }
            if (j.oK()) {
                if (this.dIA < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.i> list = this.mDatas;
                    int i2 = this.dIA + 1;
                    this.dIA = i2;
                    if (list.get(i2) instanceof f) {
                        ((f) this.mDatas.get(this.dIA)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dIA == this.mDatas.size() - 1 && (this.mDatas.get(this.dIA) instanceof f)) {
                    ((f) this.mDatas.get(this.dIA)).autoPlay = false;
                }
            }
        }
    }

    public int awJ() {
        return this.dIA;
    }

    public void awK() {
        if (!v.E(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((f) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void cancel() {
        awL();
    }

    private void awL() {
        awK();
        this.dIA = 0;
        awH();
    }
}
