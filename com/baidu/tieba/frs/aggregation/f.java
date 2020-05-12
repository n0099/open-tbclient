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
    private TbPageContext duK;
    private BdTypeListView eOj;
    private e hey;
    private boolean hez;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private int heA = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.hez = false;
        this.duK = tbPageContext;
        this.eOj = bdTypeListView;
        this.hez = z;
        BB();
    }

    private void BB() {
        this.hey = new e(this.duK, this, this.hez);
        this.aMj.add(this.hey);
        this.eOj.addAdapters(this.aMj);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.eOj.setData(this.mDatas);
            if (z && list.size() > 0 && this.hez && j.isWifiNet()) {
                bRg();
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
                if (next != null && (next instanceof g) && ((g) next).heF != null && str.equals(((g) next).heF.userId)) {
                    ((g) next).heF.hasFocus = z;
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
        if (this.eOj != null && this.eOj.getAdapter() != null && (this.eOj.getAdapter() instanceof BaseAdapter)) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hey.onDestroy();
    }

    public boolean pv() {
        return this.hey.pv();
    }

    public void pt() {
        this.hey.pt();
    }

    public void pu() {
        this.hey.pu();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hey.onConfigurationChanged(configuration);
    }

    public boolean tF(int i) {
        return this.hey.tF(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void tE(int i) {
        this.heA = i;
        if (!v.isEmpty(this.mDatas) && this.eOj != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.heA < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.heA + 1;
                    this.heA = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.heA)).autoPlay = true;
                        this.eOj.smoothScrollToPositionFromTop(this.eOj.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.heA == this.mDatas.size() - 1 && (this.mDatas.get(this.heA) instanceof g)) {
                    ((g) this.mDatas.get(this.heA)).autoPlay = false;
                }
            }
        }
    }

    public int bRe() {
        return this.heA;
    }

    public void bRf() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bRg();
    }

    private void bRg() {
        bRf();
        this.heA = 0;
        pt();
    }
}
