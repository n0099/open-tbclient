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
    private TbPageContext eWx;
    private BdTypeListView gAY;
    private e jpH;
    private boolean jpI;
    private List<n> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private int jpJ = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.jpI = false;
        this.eWx = tbPageContext;
        this.gAY = bdTypeListView;
        this.jpI = z;
        Kz();
    }

    private void Kz() {
        this.jpH = new e(this.eWx, this, this.jpI);
        this.boS.add(this.jpH);
        this.gAY.addAdapters(this.boS);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gAY.setData(this.mDatas);
            if (z && list.size() > 0 && this.jpI && j.isWifiNet()) {
                cFH();
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
                if (next != null && (next instanceof g) && ((g) next).jpO != null && str.equals(((g) next).jpO.userId)) {
                    ((g) next).jpO.hasFocus = z;
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
        this.jpH.onDestroy();
    }

    public boolean qZ() {
        return this.jpH.qZ();
    }

    public void qX() {
        this.jpH.qX();
    }

    public void qY() {
        this.jpH.qY();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.jpH.onConfigurationChanged(configuration);
    }

    public boolean zg(int i) {
        return this.jpH.zg(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void zf(int i) {
        this.jpJ = i;
        if (!y.isEmpty(this.mDatas) && this.gAY != null) {
            for (n nVar : this.mDatas) {
                if (nVar instanceof g) {
                    ((g) nVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.jpJ < this.mDatas.size() - 1) {
                    List<n> list = this.mDatas;
                    int i2 = this.jpJ + 1;
                    this.jpJ = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.jpJ)).autoPlay = true;
                        this.gAY.smoothScrollToPositionFromTop(this.gAY.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.jpJ == this.mDatas.size() - 1 && (this.mDatas.get(this.jpJ) instanceof g)) {
                    ((g) this.mDatas.get(this.jpJ)).autoPlay = false;
                }
            }
        }
    }

    public int cFF() {
        return this.jpJ;
    }

    public void cFG() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<n> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cFH();
    }

    private void cFH() {
        cFG();
        this.jpJ = 0;
        qX();
    }
}
