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
    private TbPageContext efr;
    private BdTypeListView fCT;
    private e iaw;
    private boolean iax;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private int iay = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.iax = false;
        this.efr = tbPageContext;
        this.fCT = bdTypeListView;
        this.iax = z;
        Jv();
    }

    private void Jv() {
        this.iaw = new e(this.efr, this, this.iax);
        this.bbw.add(this.iaw);
        this.fCT.addAdapters(this.bbw);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.fCT.setData(this.mDatas);
            if (z && list.size() > 0 && this.iax && j.isWifiNet()) {
                coT();
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
                if (next != null && (next instanceof g) && ((g) next).iaD != null && str.equals(((g) next).iaD.userId)) {
                    ((g) next).iaD.hasFocus = z;
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
        if (this.fCT != null && this.fCT.getAdapter() != null && (this.fCT.getAdapter() instanceof BaseAdapter)) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iaw.onDestroy();
    }

    public boolean rs() {
        return this.iaw.rs();
    }

    public void rq() {
        this.iaw.rq();
    }

    public void rr() {
        this.iaw.rr();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iaw.onConfigurationChanged(configuration);
    }

    public boolean xB(int i) {
        return this.iaw.xB(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void xA(int i) {
        this.iay = i;
        if (!y.isEmpty(this.mDatas) && this.fCT != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.iay < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.iay + 1;
                    this.iay = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.iay)).autoPlay = true;
                        this.fCT.smoothScrollToPositionFromTop(this.fCT.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.iay == this.mDatas.size() - 1 && (this.mDatas.get(this.iay) instanceof g)) {
                    ((g) this.mDatas.get(this.iay)).autoPlay = false;
                }
            }
        }
    }

    public int coR() {
        return this.iay;
    }

    public void coS() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        coT();
    }

    private void coT() {
        coS();
        this.iay = 0;
        rq();
    }
}
