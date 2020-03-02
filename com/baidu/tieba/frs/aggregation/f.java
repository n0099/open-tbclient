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
    private TbPageContext cVh;
    private BdTypeListView ekb;
    private e gur;
    private boolean gus;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private int gut = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.gus = false;
        this.cVh = tbPageContext;
        this.ekb = bdTypeListView;
        this.gus = z;
        wM();
    }

    private void wM() {
        this.gur = new e(this.cVh, this, this.gus);
        this.asE.add(this.gur);
        this.ekb.addAdapters(this.asE);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.ekb.setData(this.mDatas);
            if (z && list.size() > 0 && this.gus && j.isWifiNet()) {
                bGt();
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
                if (next != null && (next instanceof g) && ((g) next).guy != null && str.equals(((g) next).guy.userId)) {
                    ((g) next).guy.hasFocus = z;
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
        if (this.ekb != null && this.ekb.getAdapter() != null && (this.ekb.getAdapter() instanceof BaseAdapter)) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gur.onDestroy();
    }

    public boolean kR() {
        return this.gur.kR();
    }

    public void kP() {
        this.gur.kP();
    }

    public void kQ() {
        this.gur.kQ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gur.onConfigurationChanged(configuration);
    }

    public boolean tf(int i) {
        return this.gur.tf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void te(int i) {
        this.gut = i;
        if (!v.isEmpty(this.mDatas) && this.ekb != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.gut < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.gut + 1;
                    this.gut = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.gut)).autoPlay = true;
                        this.ekb.smoothScrollToPositionFromTop(this.ekb.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.gut == this.mDatas.size() - 1 && (this.mDatas.get(this.gut) instanceof g)) {
                    ((g) this.mDatas.get(this.gut)).autoPlay = false;
                }
            }
        }
    }

    public int bGr() {
        return this.gut;
    }

    public void bGs() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bGt();
    }

    private void bGt() {
        bGs();
        this.gut = 0;
        kP();
    }
}
