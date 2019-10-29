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
/* loaded from: classes4.dex */
public class f implements a {
    private TbPageContext cfl;
    private BdTypeListView dvB;
    private e fBA;
    private boolean fBB;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private int fBC = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fBB = false;
        this.cfl = tbPageContext;
        this.dvB = bdTypeListView;
        this.fBB = z;
        sX();
    }

    private void sX() {
        this.fBA = new e(this.cfl, this, this.fBB);
        this.agQ.add(this.fBA);
        this.dvB.addAdapters(this.agQ);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.dvB.setData(this.mDatas);
            if (z && list.size() > 0 && this.fBB && j.isWifiNet()) {
                bms();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void ah(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).fBH != null && str.equals(((g) next).fBH.userId)) {
                    ((g) next).fBH.hasFocus = z;
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
        if (this.dvB != null && this.dvB.getAdapter() != null && (this.dvB.getAdapter() instanceof BaseAdapter)) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fBA.onDestroy();
    }

    public boolean kk() {
        return this.fBA.kk();
    }

    public void ki() {
        this.fBA.ki();
    }

    public void kj() {
        this.fBA.kj();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fBA.onConfigurationChanged(configuration);
    }

    public boolean qP(int i) {
        return this.fBA.qP(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qO(int i) {
        this.fBC = i;
        if (!v.isEmpty(this.mDatas) && this.dvB != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.fBC < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fBC + 1;
                    this.fBC = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fBC)).autoPlay = true;
                        this.dvB.smoothScrollToPositionFromTop(this.dvB.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fBC == this.mDatas.size() - 1 && (this.mDatas.get(this.fBC) instanceof g)) {
                    ((g) this.mDatas.get(this.fBC)).autoPlay = false;
                }
            }
        }
    }

    public int bmq() {
        return this.fBC;
    }

    public void bmr() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bms();
    }

    private void bms() {
        bmr();
        this.fBC = 0;
        ki();
    }
}
