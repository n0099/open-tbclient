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
    private TbPageContext eXu;
    private BdTypeListView gAY;
    private e jmK;
    private boolean jmL;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private int jmM = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jmL = false;
        this.eXu = tbPageContext;
        this.gAY = bdTypeListView;
        this.jmL = z;
        MT();
    }

    private void MT() {
        this.jmK = new e(this.eXu, this, this.jmL);
        this.boM.add(this.jmK);
        this.gAY.addAdapters(this.boM);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gAY.setData(this.mDatas);
            if (z && list.size() > 0 && this.jmL && j.isWifiNet()) {
                cIa();
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
                if (next != null && (next instanceof g) && ((g) next).jmR != null && str.equals(((g) next).jmR.userId)) {
                    ((g) next).jmR.hasFocus = z;
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
        if (this.gAY != null && this.gAY.getAdapter() != null && (this.gAY.getAdapter() instanceof BaseAdapter)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.jmK.onDestroy();
    }

    public boolean rb() {
        return this.jmK.rb();
    }

    public void qZ() {
        this.jmK.qZ();
    }

    public void ra() {
        this.jmK.ra();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jmK.onConfigurationChanged(configuration);
    }

    public boolean AB(int i) {
        return this.jmK.AB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void AA(int i) {
        this.jmM = i;
        if (!x.isEmpty(this.mDatas) && this.gAY != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof g) {
                    ((g) nVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.jmM < this.mDatas.size() - 1) {
                    List<n> list = this.mDatas;
                    int i2 = this.jmM + 1;
                    this.jmM = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.jmM)).autoPlay = true;
                        this.gAY.smoothScrollToPositionFromTop(this.gAY.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.jmM == this.mDatas.size() - 1 && (this.mDatas.get(this.jmM) instanceof g)) {
                    ((g) this.mDatas.get(this.jmM)).autoPlay = false;
                }
            }
        }
    }

    public int cHY() {
        return this.jmM;
    }

    public void cHZ() {
        if (!x.isEmpty(this.mDatas)) {
            Iterator<n> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cIa();
    }

    private void cIa() {
        cHZ();
        this.jmM = 0;
        qZ();
    }
}
