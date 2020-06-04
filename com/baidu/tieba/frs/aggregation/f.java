package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private TbPageContext dIF;
    private BdTypeListView fbb;
    private e htx;
    private boolean hty;
    private List<o> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private int htz = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.hty = false;
        this.dIF = tbPageContext;
        this.fbb = bdTypeListView;
        this.hty = z;
        CY();
    }

    private void CY() {
        this.htx = new e(this.dIF, this, this.hty);
        this.aSj.add(this.htx);
        this.fbb.addAdapters(this.aSj);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.fbb.setData(this.mDatas);
            if (z && list.size() > 0 && this.hty && j.isWifiNet()) {
                bXE();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aE(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<o> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next != null && (next instanceof g) && ((g) next).htE != null && str.equals(((g) next).htE.userId)) {
                    ((g) next).htE.hasFocus = z;
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
        if (this.fbb != null && this.fbb.getAdapter() != null && (this.fbb.getAdapter() instanceof BaseAdapter)) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.htx.onDestroy();
    }

    public boolean pB() {
        return this.htx.pB();
    }

    public void pz() {
        this.htx.pz();
    }

    public void pA() {
        this.htx.pA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.htx.onConfigurationChanged(configuration);
    }

    public boolean um(int i) {
        return this.htx.um(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ul(int i) {
        this.htz = i;
        if (!v.isEmpty(this.mDatas) && this.fbb != null) {
            for (o oVar : this.mDatas) {
                if (oVar instanceof g) {
                    ((g) oVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.htz < this.mDatas.size() - 1) {
                    List<o> list = this.mDatas;
                    int i2 = this.htz + 1;
                    this.htz = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.htz)).autoPlay = true;
                        this.fbb.smoothScrollToPositionFromTop(this.fbb.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.htz == this.mDatas.size() - 1 && (this.mDatas.get(this.htz) instanceof g)) {
                    ((g) this.mDatas.get(this.htz)).autoPlay = false;
                }
            }
        }
    }

    public int bXC() {
        return this.htz;
    }

    public void bXD() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<o> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bXE();
    }

    private void bXE() {
        bXD();
        this.htz = 0;
        pz();
    }
}
