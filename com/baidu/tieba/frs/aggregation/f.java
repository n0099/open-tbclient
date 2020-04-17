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
    private TbPageContext duG;
    private BdTypeListView eOe;
    private e hes;
    private boolean het;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private int heu = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.het = false;
        this.duG = tbPageContext;
        this.eOe = bdTypeListView;
        this.het = z;
        BC();
    }

    private void BC() {
        this.hes = new e(this.duG, this, this.het);
        this.aMd.add(this.hes);
        this.eOe.addAdapters(this.aMd);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.eOe.setData(this.mDatas);
            if (z && list.size() > 0 && this.het && j.isWifiNet()) {
                bRh();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void ar(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).hez != null && str.equals(((g) next).hez.userId)) {
                    ((g) next).hez.hasFocus = z;
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
        if (this.eOe != null && this.eOe.getAdapter() != null && (this.eOe.getAdapter() instanceof BaseAdapter)) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hes.onDestroy();
    }

    public boolean pv() {
        return this.hes.pv();
    }

    public void pt() {
        this.hes.pt();
    }

    public void pu() {
        this.hes.pu();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hes.onConfigurationChanged(configuration);
    }

    public boolean tF(int i) {
        return this.hes.tF(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void tE(int i) {
        this.heu = i;
        if (!v.isEmpty(this.mDatas) && this.eOe != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.heu < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.heu + 1;
                    this.heu = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.heu)).autoPlay = true;
                        this.eOe.smoothScrollToPositionFromTop(this.eOe.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.heu == this.mDatas.size() - 1 && (this.mDatas.get(this.heu) instanceof g)) {
                    ((g) this.mDatas.get(this.heu)).autoPlay = false;
                }
            }
        }
    }

    public int bRf() {
        return this.heu;
    }

    public void bRg() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bRh();
    }

    private void bRh() {
        bRg();
        this.heu = 0;
        pt();
    }
}
