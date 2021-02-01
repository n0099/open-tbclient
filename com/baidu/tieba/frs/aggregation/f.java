package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private TbPageContext eUY;
    private BdTypeListView gzb;
    private e jnK;
    private boolean jnL;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private int jnM = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jnL = false;
        this.eUY = tbPageContext;
        this.gzb = bdTypeListView;
        this.jnL = z;
        Kw();
    }

    private void Kw() {
        this.jnK = new e(this.eUY, this, this.jnL);
        this.bns.add(this.jnK);
        this.gzb.addAdapters(this.bns);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gzb.setData(this.mDatas);
            if (z && list.size() > 0 && this.jnL && j.isWifiNet()) {
                cFu();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aO(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).jnR != null && str.equals(((g) next).jnR.userId)) {
                    ((g) next).jnR.hasFocus = z;
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
        if (this.gzb != null && this.gzb.getAdapter() != null && (this.gzb.getAdapter() instanceof BaseAdapter)) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jnK.onDestroy();
    }

    public boolean qZ() {
        return this.jnK.qZ();
    }

    public void qX() {
        this.jnK.qX();
    }

    public void qY() {
        this.jnK.qY();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jnK.onConfigurationChanged(configuration);
    }

    public boolean zf(int i) {
        return this.jnK.zf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ze(int i) {
        this.jnM = i;
        if (!y.isEmpty(this.mDatas) && this.gzb != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof g) {
                    ((g) nVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.jnM < this.mDatas.size() - 1) {
                    List<n> list = this.mDatas;
                    int i2 = this.jnM + 1;
                    this.jnM = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.jnM)).autoPlay = true;
                        this.gzb.smoothScrollToPositionFromTop(this.gzb.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.jnM == this.mDatas.size() - 1 && (this.mDatas.get(this.jnM) instanceof g)) {
                    ((g) this.mDatas.get(this.jnM)).autoPlay = false;
                }
            }
        }
    }

    public int cFs() {
        return this.jnM;
    }

    public void cFt() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<n> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cFu();
    }

    private void cFu() {
        cFt();
        this.jnM = 0;
        qX();
    }
}
