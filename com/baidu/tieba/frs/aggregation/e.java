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
    private TbPageContext aRI;
    private d dID;
    private boolean dIE;
    private BdTypeListView mListView;
    private List<com.baidu.adp.widget.ListView.i> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int dIF = -1;

    public e(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.dIE = false;
        this.aRI = tbPageContext;
        this.mListView = bdTypeListView;
        this.dIE = z;
        initAdapters();
    }

    private void initAdapters() {
        this.dID = new d(this.aRI, this, this.dIE);
        this.mAdapters.add(this.dID);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<f> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.dIE && j.oK()) {
                awN();
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
                if (next != null && (next instanceof f) && ((f) next).dIJ != null && str.equals(((f) next).dIJ.userId)) {
                    ((f) next).dIJ.hasFocus = z;
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
        this.dID.onDestroy();
    }

    public boolean awI() {
        return this.dID.awI();
    }

    public void awJ() {
        this.dID.awJ();
    }

    public void awK() {
        this.dID.awK();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.dID.onConfigurationChanged(configuration);
    }

    public boolean nc(int i) {
        return this.dID.nc(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void nd(int i) {
        this.dIF = i;
        if (!v.E(this.mDatas) && this.mListView != null) {
            for (com.baidu.adp.widget.ListView.i iVar : this.mDatas) {
                if (iVar instanceof f) {
                    ((f) iVar).autoPlay = false;
                }
            }
            if (j.oK()) {
                if (this.dIF < this.mDatas.size() - 1) {
                    List<com.baidu.adp.widget.ListView.i> list = this.mDatas;
                    int i2 = this.dIF + 1;
                    this.dIF = i2;
                    if (list.get(i2) instanceof f) {
                        ((f) this.mDatas.get(this.dIF)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.dIF == this.mDatas.size() - 1 && (this.mDatas.get(this.dIF) instanceof f)) {
                    ((f) this.mDatas.get(this.dIF)).autoPlay = false;
                }
            }
        }
    }

    public int awL() {
        return this.dIF;
    }

    public void awM() {
        if (!v.E(this.mDatas)) {
            Iterator<com.baidu.adp.widget.ListView.i> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((f) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.d.a
    public void cancel() {
        awN();
    }

    private void awN() {
        awM();
        this.dIF = 0;
        awJ();
    }
}
