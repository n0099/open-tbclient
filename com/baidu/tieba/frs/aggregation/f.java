package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class f implements a {
    private TbPageContext eNx;
    private BdTypeListView gpZ;
    private e jax;
    private boolean jay;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private int jaz = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jay = false;
        this.eNx = tbPageContext;
        this.gpZ = bdTypeListView;
        this.jay = z;
        Nt();
    }

    private void Nt() {
        this.jax = new e(this.eNx, this, this.jay);
        this.bnf.add(this.jax);
        this.gpZ.addAdapters(this.bnf);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gpZ.setData(this.mDatas);
            if (z && list.size() > 0 && this.jay && j.isWifiNet()) {
                cFf();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aP(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<q> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof g) && ((g) next).jaE != null && str.equals(((g) next).jaE.userId)) {
                    ((g) next).jaE.hasFocus = z;
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
        if (this.gpZ != null && this.gpZ.getAdapter() != null && (this.gpZ.getAdapter() instanceof BaseAdapter)) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jax.onDestroy();
    }

    public boolean rz() {
        return this.jax.rz();
    }

    public void rx() {
        this.jax.rx();
    }

    public void ry() {
        this.jax.ry();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jax.onConfigurationChanged(configuration);
    }

    public boolean Ap(int i) {
        return this.jax.Ap(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void Ao(int i) {
        this.jaz = i;
        if (!y.isEmpty(this.mDatas) && this.gpZ != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.jaz < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.jaz + 1;
                    this.jaz = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.jaz)).autoPlay = true;
                        this.gpZ.smoothScrollToPositionFromTop(this.gpZ.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.jaz == this.mDatas.size() - 1 && (this.mDatas.get(this.jaz) instanceof g)) {
                    ((g) this.mDatas.get(this.jaz)).autoPlay = false;
                }
            }
        }
    }

    public int cFd() {
        return this.jaz;
    }

    public void cFe() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cFf();
    }

    private void cFf() {
        cFe();
        this.jaz = 0;
        rx();
    }
}
