package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes16.dex */
public class f implements a {
    private TbPageContext dVN;
    private BdTypeListView frv;
    private e hMj;
    private boolean hMk;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private int hMl = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.hMk = false;
        this.dVN = tbPageContext;
        this.frv = bdTypeListView;
        this.hMk = z;
        DS();
    }

    private void DS() {
        this.hMj = new e(this.dVN, this, this.hMk);
        this.aWf.add(this.hMj);
        this.frv.addAdapters(this.aWf);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.frv.setData(this.mDatas);
            if (z && list.size() > 0 && this.hMk && j.isWifiNet()) {
                ceo();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aE(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).hMq != null && str.equals(((g) next).hMq.userId)) {
                    ((g) next).hMq.hasFocus = z;
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
        if (this.frv != null && this.frv.getAdapter() != null && (this.frv.getAdapter() instanceof BaseAdapter)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hMj.onDestroy();
    }

    public boolean pT() {
        return this.hMj.pT();
    }

    public void pR() {
        this.hMj.pR();
    }

    public void pS() {
        this.hMj.pS();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hMj.onConfigurationChanged(configuration);
    }

    public boolean vj(int i) {
        return this.hMj.vj(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void vi(int i) {
        this.hMl = i;
        if (!x.isEmpty(this.mDatas) && this.frv != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.hMl < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.hMl + 1;
                    this.hMl = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.hMl)).autoPlay = true;
                        this.frv.smoothScrollToPositionFromTop(this.frv.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.hMl == this.mDatas.size() - 1 && (this.mDatas.get(this.hMl) instanceof g)) {
                    ((g) this.mDatas.get(this.hMl)).autoPlay = false;
                }
            }
        }
    }

    public int cem() {
        return this.hMl;
    }

    public void cen() {
        if (!x.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        ceo();
    }

    private void ceo() {
        cen();
        this.hMl = 0;
        pR();
    }
}
