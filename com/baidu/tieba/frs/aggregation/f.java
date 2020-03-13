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
    private TbPageContext cVi;
    private BdTypeListView eko;
    private e guD;
    private boolean guE;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private int guF = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.guE = false;
        this.cVi = tbPageContext;
        this.eko = bdTypeListView;
        this.guE = z;
        wM();
    }

    private void wM() {
        this.guD = new e(this.cVi, this, this.guE);
        this.asF.add(this.guD);
        this.eko.addAdapters(this.asF);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.eko.setData(this.mDatas);
            if (z && list.size() > 0 && this.guE && j.isWifiNet()) {
                bGu();
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
                if (next != null && (next instanceof g) && ((g) next).guK != null && str.equals(((g) next).guK.userId)) {
                    ((g) next).guK.hasFocus = z;
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
        if (this.eko != null && this.eko.getAdapter() != null && (this.eko.getAdapter() instanceof BaseAdapter)) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.guD.onDestroy();
    }

    public boolean kR() {
        return this.guD.kR();
    }

    public void kP() {
        this.guD.kP();
    }

    public void kQ() {
        this.guD.kQ();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.guD.onConfigurationChanged(configuration);
    }

    public boolean tf(int i) {
        return this.guD.tf(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void te(int i) {
        this.guF = i;
        if (!v.isEmpty(this.mDatas) && this.eko != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.guF < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.guF + 1;
                    this.guF = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.guF)).autoPlay = true;
                        this.eko.smoothScrollToPositionFromTop(this.eko.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.guF == this.mDatas.size() - 1 && (this.mDatas.get(this.guF) instanceof g)) {
                    ((g) this.mDatas.get(this.guF)).autoPlay = false;
                }
            }
        }
    }

    public int bGs() {
        return this.guF;
    }

    public void bGt() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bGu();
    }

    private void bGu() {
        bGt();
        this.guF = 0;
        kP();
    }
}
