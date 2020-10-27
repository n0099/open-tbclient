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
    private TbPageContext eCn;
    private BdTypeListView gcr;
    private e iIU;
    private boolean iIV;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private int iIW = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.iIV = false;
        this.eCn = tbPageContext;
        this.gcr = bdTypeListView;
        this.iIV = z;
        Ly();
    }

    private void Ly() {
        this.iIU = new e(this.eCn, this, this.iIV);
        this.bje.add(this.iIU);
        this.gcr.addAdapters(this.bje);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gcr.setData(this.mDatas);
            if (z && list.size() > 0 && this.iIV && j.isWifiNet()) {
                cyK();
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
                if (next != null && (next instanceof g) && ((g) next).iJb != null && str.equals(((g) next).iJb.userId)) {
                    ((g) next).iJb.hasFocus = z;
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
        if (this.gcr != null && this.gcr.getAdapter() != null && (this.gcr.getAdapter() instanceof BaseAdapter)) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iIU.onDestroy();
    }

    public boolean rx() {
        return this.iIU.rx();
    }

    public void rv() {
        this.iIU.rv();
    }

    public void rw() {
        this.iIU.rw();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iIU.onConfigurationChanged(configuration);
    }

    public boolean yZ(int i) {
        return this.iIU.yZ(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void yY(int i) {
        this.iIW = i;
        if (!y.isEmpty(this.mDatas) && this.gcr != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.iIW < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.iIW + 1;
                    this.iIW = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.iIW)).autoPlay = true;
                        this.gcr.smoothScrollToPositionFromTop(this.gcr.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.iIW == this.mDatas.size() - 1 && (this.mDatas.get(this.iIW) instanceof g)) {
                    ((g) this.mDatas.get(this.iIW)).autoPlay = false;
                }
            }
        }
    }

    public int cyI() {
        return this.iIW;
    }

    public void cyJ() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cyK();
    }

    private void cyK() {
        cyJ();
        this.iIW = 0;
        rv();
    }
}
