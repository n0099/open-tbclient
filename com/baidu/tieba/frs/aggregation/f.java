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
    private TbPageContext ceu;
    private BdTypeListView duK;
    private e fAJ;
    private boolean fAK;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private int fAL = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fAK = false;
        this.ceu = tbPageContext;
        this.duK = bdTypeListView;
        this.fAK = z;
        sY();
    }

    private void sY() {
        this.fAJ = new e(this.ceu, this, this.fAK);
        this.agy.add(this.fAJ);
        this.duK.addAdapters(this.agy);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.duK.setData(this.mDatas);
            if (z && list.size() > 0 && this.fAK && j.isWifiNet()) {
                bmq();
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
                if (next != null && (next instanceof g) && ((g) next).fAQ != null && str.equals(((g) next).fAQ.userId)) {
                    ((g) next).fAQ.hasFocus = z;
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
        if (this.duK != null && this.duK.getAdapter() != null && (this.duK.getAdapter() instanceof BaseAdapter)) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fAJ.onDestroy();
    }

    public boolean kk() {
        return this.fAJ.kk();
    }

    public void ki() {
        this.fAJ.ki();
    }

    public void kj() {
        this.fAJ.kj();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fAJ.onConfigurationChanged(configuration);
    }

    public boolean qO(int i) {
        return this.fAJ.qO(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qN(int i) {
        this.fAL = i;
        if (!v.isEmpty(this.mDatas) && this.duK != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.fAL < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fAL + 1;
                    this.fAL = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fAL)).autoPlay = true;
                        this.duK.smoothScrollToPositionFromTop(this.duK.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fAL == this.mDatas.size() - 1 && (this.mDatas.get(this.fAL) instanceof g)) {
                    ((g) this.mDatas.get(this.fAL)).autoPlay = false;
                }
            }
        }
    }

    public int bmo() {
        return this.fAL;
    }

    public void bmp() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bmq();
    }

    private void bmq() {
        bmp();
        this.fAL = 0;
        ki();
    }
}
