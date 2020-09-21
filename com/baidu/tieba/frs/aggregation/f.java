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
    private TbPageContext ehG;
    private BdTypeListView fGf;
    private e ihB;
    private boolean ihC;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private int ihD = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.ihC = false;
        this.ehG = tbPageContext;
        this.fGf = bdTypeListView;
        this.ihC = z;
        JZ();
    }

    private void JZ() {
        this.ihB = new e(this.ehG, this, this.ihC);
        this.bdV.add(this.ihB);
        this.fGf.addAdapters(this.bdV);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.fGf.setData(this.mDatas);
            if (z && list.size() > 0 && this.ihC && j.isWifiNet()) {
                csg();
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
                if (next != null && (next instanceof g) && ((g) next).ihI != null && str.equals(((g) next).ihI.userId)) {
                    ((g) next).ihI.hasFocus = z;
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
        if (this.fGf != null && this.fGf.getAdapter() != null && (this.fGf.getAdapter() instanceof BaseAdapter)) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.ihB.onDestroy();
    }

    public boolean rx() {
        return this.ihB.rx();
    }

    public void rv() {
        this.ihB.rv();
    }

    public void rw() {
        this.ihB.rw();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.ihB.onConfigurationChanged(configuration);
    }

    public boolean ya(int i) {
        return this.ihB.ya(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void xZ(int i) {
        this.ihD = i;
        if (!y.isEmpty(this.mDatas) && this.fGf != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.ihD < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.ihD + 1;
                    this.ihD = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.ihD)).autoPlay = true;
                        this.fGf.smoothScrollToPositionFromTop(this.fGf.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.ihD == this.mDatas.size() - 1 && (this.mDatas.get(this.ihD) instanceof g)) {
                    ((g) this.mDatas.get(this.ihD)).autoPlay = false;
                }
            }
        }
    }

    public int cse() {
        return this.ihD;
    }

    public void csf() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        csg();
    }

    private void csg() {
        csf();
        this.ihD = 0;
        rv();
    }
}
