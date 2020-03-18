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
    private TbPageContext cVv;
    private BdTypeListView ekE;
    private e gvh;
    private boolean gvi;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private int gvj = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.gvi = false;
        this.cVv = tbPageContext;
        this.ekE = bdTypeListView;
        this.gvi = z;
        wR();
    }

    private void wR() {
        this.gvh = new e(this.cVv, this, this.gvi);
        this.asP.add(this.gvh);
        this.ekE.addAdapters(this.asP);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.ekE.setData(this.mDatas);
            if (z && list.size() > 0 && this.gvi && j.isWifiNet()) {
                bGG();
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
                if (next != null && (next instanceof g) && ((g) next).gvo != null && str.equals(((g) next).gvo.userId)) {
                    ((g) next).gvo.hasFocus = z;
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
        if (this.ekE != null && this.ekE.getAdapter() != null && (this.ekE.getAdapter() instanceof BaseAdapter)) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gvh.onDestroy();
    }

    public boolean kR() {
        return this.gvh.kR();
    }

    public void kP() {
        this.gvh.kP();
    }

    public void kQ() {
        this.gvh.kQ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gvh.onConfigurationChanged(configuration);
    }

    public boolean th(int i) {
        return this.gvh.th(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void tg(int i) {
        this.gvj = i;
        if (!v.isEmpty(this.mDatas) && this.ekE != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.gvj < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.gvj + 1;
                    this.gvj = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.gvj)).autoPlay = true;
                        this.ekE.smoothScrollToPositionFromTop(this.ekE.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.gvj == this.mDatas.size() - 1 && (this.mDatas.get(this.gvj) instanceof g)) {
                    ((g) this.mDatas.get(this.gvj)).autoPlay = false;
                }
            }
        }
    }

    public int bGE() {
        return this.gvj;
    }

    public void bGF() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bGG();
    }

    private void bGG() {
        bGF();
        this.gvj = 0;
        kP();
    }
}
