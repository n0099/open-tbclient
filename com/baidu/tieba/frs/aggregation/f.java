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
/* loaded from: classes16.dex */
public class f implements a {
    private TbPageContext efn;
    private BdTypeListView fCP;
    private e iaq;
    private boolean iar;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private int ias = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.iar = false;
        this.efn = tbPageContext;
        this.fCP = bdTypeListView;
        this.iar = z;
        Jv();
    }

    private void Jv() {
        this.iaq = new e(this.efn, this, this.iar);
        this.bbu.add(this.iaq);
        this.fCP.addAdapters(this.bbu);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.fCP.setData(this.mDatas);
            if (z && list.size() > 0 && this.iar && j.isWifiNet()) {
                coS();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aI(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).iax != null && str.equals(((g) next).iax.userId)) {
                    ((g) next).iax.hasFocus = z;
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
        if (this.fCP != null && this.fCP.getAdapter() != null && (this.fCP.getAdapter() instanceof BaseAdapter)) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iaq.onDestroy();
    }

    public boolean rs() {
        return this.iaq.rs();
    }

    public void rq() {
        this.iaq.rq();
    }

    public void rr() {
        this.iaq.rr();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iaq.onConfigurationChanged(configuration);
    }

    public boolean xB(int i) {
        return this.iaq.xB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void xA(int i) {
        this.ias = i;
        if (!y.isEmpty(this.mDatas) && this.fCP != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.ias < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.ias + 1;
                    this.ias = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.ias)).autoPlay = true;
                        this.fCP.smoothScrollToPositionFromTop(this.fCP.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.ias == this.mDatas.size() - 1 && (this.mDatas.get(this.ias) instanceof g)) {
                    ((g) this.mDatas.get(this.ias)).autoPlay = false;
                }
            }
        }
    }

    public int coQ() {
        return this.ias;
    }

    public void coR() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        coS();
    }

    private void coS() {
        coR();
        this.ias = 0;
        rq();
    }
}
