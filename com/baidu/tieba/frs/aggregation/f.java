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
    private BdTypeListView gzp;
    private e jnY;
    private boolean jnZ;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private int joa = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jnZ = false;
        this.eUY = tbPageContext;
        this.gzp = bdTypeListView;
        this.jnZ = z;
        Kw();
    }

    private void Kw() {
        this.jnY = new e(this.eUY, this, this.jnZ);
        this.bns.add(this.jnY);
        this.gzp.addAdapters(this.bns);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gzp.setData(this.mDatas);
            if (z && list.size() > 0 && this.jnZ && j.isWifiNet()) {
                cFB();
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
                if (next != null && (next instanceof g) && ((g) next).jof != null && str.equals(((g) next).jof.userId)) {
                    ((g) next).jof.hasFocus = z;
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
        if (this.gzp != null && this.gzp.getAdapter() != null && (this.gzp.getAdapter() instanceof BaseAdapter)) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jnY.onDestroy();
    }

    public boolean qZ() {
        return this.jnY.qZ();
    }

    public void qX() {
        this.jnY.qX();
    }

    public void qY() {
        this.jnY.qY();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jnY.onConfigurationChanged(configuration);
    }

    public boolean zf(int i) {
        return this.jnY.zf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ze(int i) {
        this.joa = i;
        if (!y.isEmpty(this.mDatas) && this.gzp != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof g) {
                    ((g) nVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.joa < this.mDatas.size() - 1) {
                    List<n> list = this.mDatas;
                    int i2 = this.joa + 1;
                    this.joa = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.joa)).autoPlay = true;
                        this.gzp.smoothScrollToPositionFromTop(this.gzp.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.joa == this.mDatas.size() - 1 && (this.mDatas.get(this.joa) instanceof g)) {
                    ((g) this.mDatas.get(this.joa)).autoPlay = false;
                }
            }
        }
    }

    public int cFz() {
        return this.joa;
    }

    public void cFA() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<n> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cFB();
    }

    private void cFB() {
        cFA();
        this.joa = 0;
        qX();
    }
}
