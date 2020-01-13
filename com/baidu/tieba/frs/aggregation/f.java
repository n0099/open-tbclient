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
/* loaded from: classes7.dex */
public class f implements a {
    private TbPageContext cRe;
    private BdTypeListView efW;
    private e gso;
    private boolean gsp;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> apl = new ArrayList();
    private int gsq = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.gsp = false;
        this.cRe = tbPageContext;
        this.efW = bdTypeListView;
        this.gsp = z;
        vi();
    }

    private void vi() {
        this.gso = new e(this.cRe, this, this.gsp);
        this.apl.add(this.gso);
        this.efW.addAdapters(this.apl);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.efW.setData(this.mDatas);
            if (z && list.size() > 0 && this.gsp && j.isWifiNet()) {
                bEP();
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
                if (next != null && (next instanceof g) && ((g) next).gsv != null && str.equals(((g) next).gsv.userId)) {
                    ((g) next).gsv.hasFocus = z;
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
        if (this.efW != null && this.efW.getAdapter() != null && (this.efW.getAdapter() instanceof BaseAdapter)) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gso.onDestroy();
    }

    public boolean kC() {
        return this.gso.kC();
    }

    public void kA() {
        this.gso.kA();
    }

    public void kB() {
        this.gso.kB();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gso.onConfigurationChanged(configuration);
    }

    public boolean sZ(int i) {
        return this.gso.sZ(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void sY(int i) {
        this.gsq = i;
        if (!v.isEmpty(this.mDatas) && this.efW != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.gsq < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.gsq + 1;
                    this.gsq = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.gsq)).autoPlay = true;
                        this.efW.smoothScrollToPositionFromTop(this.efW.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.gsq == this.mDatas.size() - 1 && (this.mDatas.get(this.gsq) instanceof g)) {
                    ((g) this.mDatas.get(this.gsq)).autoPlay = false;
                }
            }
        }
    }

    public int bEN() {
        return this.gsq;
    }

    public void bEO() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bEP();
    }

    private void bEP() {
        bEO();
        this.gsq = 0;
        kA();
    }
}
