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
/* loaded from: classes6.dex */
public class f implements a {
    private TbPageContext cQU;
    private BdTypeListView efM;
    private e gpf;
    private boolean gpg;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private int gph = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.gpg = false;
        this.cQU = tbPageContext;
        this.efM = bdTypeListView;
        this.gpg = z;
        uR();
    }

    private void uR() {
        this.gpf = new e(this.cQU, this, this.gpg);
        this.aoz.add(this.gpf);
        this.efM.addAdapters(this.aoz);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.efM.setData(this.mDatas);
            if (z && list.size() > 0 && this.gpg && j.isWifiNet()) {
                bDN();
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
                if (next != null && (next instanceof g) && ((g) next).gpm != null && str.equals(((g) next).gpm.userId)) {
                    ((g) next).gpm.hasFocus = z;
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
        if (this.efM != null && this.efM.getAdapter() != null && (this.efM.getAdapter() instanceof BaseAdapter)) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.gpf.onDestroy();
    }

    public boolean kB() {
        return this.gpf.kB();
    }

    public void kz() {
        this.gpf.kz();
    }

    public void kA() {
        this.gpf.kA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.gpf.onConfigurationChanged(configuration);
    }

    public boolean sU(int i) {
        return this.gpf.sU(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void sT(int i) {
        this.gph = i;
        if (!v.isEmpty(this.mDatas) && this.efM != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.gph < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.gph + 1;
                    this.gph = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.gph)).autoPlay = true;
                        this.efM.smoothScrollToPositionFromTop(this.efM.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.gph == this.mDatas.size() - 1 && (this.mDatas.get(this.gph) instanceof g)) {
                    ((g) this.mDatas.get(this.gph)).autoPlay = false;
                }
            }
        }
    }

    public int bDL() {
        return this.gph;
    }

    public void bDM() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bDN();
    }

    private void bDN() {
        bDM();
        this.gph = 0;
        kz();
    }
}
