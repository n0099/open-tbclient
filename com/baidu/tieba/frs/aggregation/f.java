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
    private TbPageContext eIc;
    private BdTypeListView gih;
    private e iOR;
    private boolean iOS;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private int iOT = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.iOS = false;
        this.eIc = tbPageContext;
        this.gih = bdTypeListView;
        this.iOS = z;
        LY();
    }

    private void LY() {
        this.iOR = new e(this.eIc, this, this.iOS);
        this.bky.add(this.iOR);
        this.gih.addAdapters(this.bky);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.gih.setData(this.mDatas);
            if (z && list.size() > 0 && this.iOS && j.isWifiNet()) {
                cBl();
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
                if (next != null && (next instanceof g) && ((g) next).iOY != null && str.equals(((g) next).iOY.userId)) {
                    ((g) next).iOY.hasFocus = z;
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
        if (this.gih != null && this.gih.getAdapter() != null && (this.gih.getAdapter() instanceof BaseAdapter)) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iOR.onDestroy();
    }

    public boolean rx() {
        return this.iOR.rx();
    }

    public void rv() {
        this.iOR.rv();
    }

    public void rw() {
        this.iOR.rw();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iOR.onConfigurationChanged(configuration);
    }

    public boolean zm(int i) {
        return this.iOR.zm(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void zl(int i) {
        this.iOT = i;
        if (!y.isEmpty(this.mDatas) && this.gih != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.iOT < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.iOT + 1;
                    this.iOT = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.iOT)).autoPlay = true;
                        this.gih.smoothScrollToPositionFromTop(this.gih.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.iOT == this.mDatas.size() - 1 && (this.mDatas.get(this.iOT) instanceof g)) {
                    ((g) this.mDatas.get(this.iOT)).autoPlay = false;
                }
            }
        }
    }

    public int cBj() {
        return this.iOT;
    }

    public void cBk() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cBl();
    }

    private void cBl() {
        cBk();
        this.iOT = 0;
        rv();
    }
}
