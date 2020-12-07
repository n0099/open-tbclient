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
    private BdTypeListView gpX;
    private e jav;
    private boolean jaw;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private int jax = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jaw = false;
        this.eNx = tbPageContext;
        this.gpX = bdTypeListView;
        this.jaw = z;
        Nt();
    }

    private void Nt() {
        this.jav = new e(this.eNx, this, this.jaw);
        this.bnf.add(this.jav);
        this.gpX.addAdapters(this.bnf);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gpX.setData(this.mDatas);
            if (z && list.size() > 0 && this.jaw && j.isWifiNet()) {
                cFe();
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
                if (next != null && (next instanceof g) && ((g) next).jaC != null && str.equals(((g) next).jaC.userId)) {
                    ((g) next).jaC.hasFocus = z;
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
        if (this.gpX != null && this.gpX.getAdapter() != null && (this.gpX.getAdapter() instanceof BaseAdapter)) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jav.onDestroy();
    }

    public boolean rz() {
        return this.jav.rz();
    }

    public void rx() {
        this.jav.rx();
    }

    public void ry() {
        this.jav.ry();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jav.onConfigurationChanged(configuration);
    }

    public boolean Ap(int i) {
        return this.jav.Ap(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void Ao(int i) {
        this.jax = i;
        if (!y.isEmpty(this.mDatas) && this.gpX != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.jax < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.jax + 1;
                    this.jax = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.jax)).autoPlay = true;
                        this.gpX.smoothScrollToPositionFromTop(this.gpX.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.jax == this.mDatas.size() - 1 && (this.mDatas.get(this.jax) instanceof g)) {
                    ((g) this.mDatas.get(this.jax)).autoPlay = false;
                }
            }
        }
    }

    public int cFc() {
        return this.jax;
    }

    public void cFd() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cFe();
    }

    private void cFe() {
        cFd();
        this.jax = 0;
        rx();
    }
}
