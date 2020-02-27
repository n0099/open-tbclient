package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private TbPageContext cVg;
    private BdTypeListView eka;
    private e gup;
    private boolean guq;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private int gur = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.guq = false;
        this.cVg = tbPageContext;
        this.eka = bdTypeListView;
        this.guq = z;
        wM();
    }

    private void wM() {
        this.gup = new e(this.cVg, this, this.guq);
        this.asE.add(this.gup);
        this.eka.addAdapters(this.asE);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.eka.setData(this.mDatas);
            if (z && list.size() > 0 && this.guq && j.isWifiNet()) {
                bGr();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void al(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<m> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                m next = it.next();
                if (next != null && (next instanceof g) && ((g) next).guw != null && str.equals(((g) next).guw.userId)) {
                    ((g) next).guw.hasFocus = z;
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
        if (this.eka != null && this.eka.getAdapter() != null && (this.eka.getAdapter() instanceof BaseAdapter)) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gup.onDestroy();
    }

    public boolean kR() {
        return this.gup.kR();
    }

    public void kP() {
        this.gup.kP();
    }

    public void kQ() {
        this.gup.kQ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gup.onConfigurationChanged(configuration);
    }

    public boolean tf(int i) {
        return this.gup.tf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void te(int i) {
        this.gur = i;
        if (!v.isEmpty(this.mDatas) && this.eka != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.gur < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.gur + 1;
                    this.gur = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.gur)).autoPlay = true;
                        this.eka.smoothScrollToPositionFromTop(this.eka.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.gur == this.mDatas.size() - 1 && (this.mDatas.get(this.gur) instanceof g)) {
                    ((g) this.mDatas.get(this.gur)).autoPlay = false;
                }
            }
        }
    }

    public int bGp() {
        return this.gur;
    }

    public void bGq() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bGr();
    }

    private void bGr() {
        bGq();
        this.gur = 0;
        kP();
    }
}
