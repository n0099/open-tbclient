package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private TbPageContext eSJ;
    private BdTypeListView gwr;
    private e jic;
    private boolean jie;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private int jif = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jie = false;
        this.eSJ = tbPageContext;
        this.gwr = bdTypeListView;
        this.jie = z;
        IY();
    }

    private void IY() {
        this.jic = new e(this.eSJ, this, this.jie);
        this.bjZ.add(this.jic);
        this.gwr.addAdapters(this.bjZ);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gwr.setData(this.mDatas);
            if (z && list.size() > 0 && this.jie && j.isWifiNet()) {
                cEi();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aP(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<n> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                if (next != null && (next instanceof g) && ((g) next).jik != null && str.equals(((g) next).jik.userId)) {
                    ((g) next).jik.hasFocus = z;
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
        if (this.gwr != null && this.gwr.getAdapter() != null && (this.gwr.getAdapter() instanceof BaseAdapter)) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jic.onDestroy();
    }

    public boolean rb() {
        return this.jic.rb();
    }

    public void qZ() {
        this.jic.qZ();
    }

    public void ra() {
        this.jic.ra();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jic.onConfigurationChanged(configuration);
    }

    public boolean yV(int i) {
        return this.jic.yV(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void yU(int i) {
        this.jif = i;
        if (!x.isEmpty(this.mDatas) && this.gwr != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof g) {
                    ((g) nVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.jif < this.mDatas.size() - 1) {
                    List<n> list = this.mDatas;
                    int i2 = this.jif + 1;
                    this.jif = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.jif)).autoPlay = true;
                        this.gwr.smoothScrollToPositionFromTop(this.gwr.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.jif == this.mDatas.size() - 1 && (this.mDatas.get(this.jif) instanceof g)) {
                    ((g) this.mDatas.get(this.jif)).autoPlay = false;
                }
            }
        }
    }

    public int cEg() {
        return this.jif;
    }

    public void cEh() {
        if (!x.isEmpty(this.mDatas)) {
            Iterator<n> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cEi();
    }

    private void cEi() {
        cEh();
        this.jif = 0;
        qZ();
    }
}
