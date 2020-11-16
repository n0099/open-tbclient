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
/* loaded from: classes21.dex */
public class f implements a {
    private TbPageContext eGu;
    private BdTypeListView ghN;
    private e iPE;
    private boolean iPF;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private int iPG = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.iPF = false;
        this.eGu = tbPageContext;
        this.ghN = bdTypeListView;
        this.iPF = z;
        Lp();
    }

    private void Lp() {
        this.iPE = new e(this.eGu, this, this.iPF);
        this.biN.add(this.iPE);
        this.ghN.addAdapters(this.biN);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.ghN.setData(this.mDatas);
            if (z && list.size() > 0 && this.iPF && j.isWifiNet()) {
                cAO();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aO(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).iPL != null && str.equals(((g) next).iPL.userId)) {
                    ((g) next).iPL.hasFocus = z;
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
        if (this.ghN != null && this.ghN.getAdapter() != null && (this.ghN.getAdapter() instanceof BaseAdapter)) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iPE.onDestroy();
    }

    public boolean rx() {
        return this.iPE.rx();
    }

    public void rv() {
        this.iPE.rv();
    }

    public void rw() {
        this.iPE.rw();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iPE.onConfigurationChanged(configuration);
    }

    public boolean zK(int i) {
        return this.iPE.zK(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void zJ(int i) {
        this.iPG = i;
        if (!y.isEmpty(this.mDatas) && this.ghN != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.iPG < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.iPG + 1;
                    this.iPG = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.iPG)).autoPlay = true;
                        this.ghN.smoothScrollToPositionFromTop(this.ghN.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.iPG == this.mDatas.size() - 1 && (this.mDatas.get(this.iPG) instanceof g)) {
                    ((g) this.mDatas.get(this.iPG)).autoPlay = false;
                }
            }
        }
    }

    public int cAM() {
        return this.iPG;
    }

    public void cAN() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cAO();
    }

    private void cAO() {
        cAN();
        this.iPG = 0;
        rv();
    }
}
