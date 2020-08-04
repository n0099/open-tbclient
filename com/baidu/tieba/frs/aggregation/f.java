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
    private e hMl;
    private boolean hMm;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private int hMn = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.hMm = false;
        this.dVN = tbPageContext;
        this.frv = bdTypeListView;
        this.hMm = z;
        DS();
    }

    private void DS() {
        this.hMl = new e(this.dVN, this, this.hMm);
        this.aWf.add(this.hMl);
        this.frv.addAdapters(this.aWf);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.frv.setData(this.mDatas);
            if (z && list.size() > 0 && this.hMm && j.isWifiNet()) {
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
                if (next != null && (next instanceof g) && ((g) next).hMs != null && str.equals(((g) next).hMs.userId)) {
                    ((g) next).hMs.hasFocus = z;
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
        this.hMl.onDestroy();
    }

    public boolean pT() {
        return this.hMl.pT();
    }

    public void pR() {
        this.hMl.pR();
    }

    public void pS() {
        this.hMl.pS();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hMl.onConfigurationChanged(configuration);
    }

    public boolean vj(int i) {
        return this.hMl.vj(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void vi(int i) {
        this.hMn = i;
        if (!x.isEmpty(this.mDatas) && this.frv != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.hMn < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.hMn + 1;
                    this.hMn = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.hMn)).autoPlay = true;
                        this.frv.smoothScrollToPositionFromTop(this.frv.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.hMn == this.mDatas.size() - 1 && (this.mDatas.get(this.hMn) instanceof g)) {
                    ((g) this.mDatas.get(this.hMn)).autoPlay = false;
                }
            }
        }
    }

    public int cem() {
        return this.hMn;
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
        this.hMn = 0;
        pR();
    }
}
