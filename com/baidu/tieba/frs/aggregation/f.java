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
    private BdTypeListView faQ;
    private e htm;
    private boolean htn;
    private List<o> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private int hto = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.htn = false;
        this.dIF = tbPageContext;
        this.faQ = bdTypeListView;
        this.htn = z;
        CY();
    }

    private void CY() {
        this.htm = new e(this.dIF, this, this.htn);
        this.aSj.add(this.htm);
        this.faQ.addAdapters(this.aSj);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.faQ.setData(this.mDatas);
            if (z && list.size() > 0 && this.htn && j.isWifiNet()) {
                bXC();
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
                if (next != null && (next instanceof g) && ((g) next).htt != null && str.equals(((g) next).htt.userId)) {
                    ((g) next).htt.hasFocus = z;
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
        if (this.faQ != null && this.faQ.getAdapter() != null && (this.faQ.getAdapter() instanceof BaseAdapter)) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.htm.onDestroy();
    }

    public boolean pB() {
        return this.htm.pB();
    }

    public void pz() {
        this.htm.pz();
    }

    public void pA() {
        this.htm.pA();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.htm.onConfigurationChanged(configuration);
    }

    public boolean uk(int i) {
        return this.htm.uk(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void uj(int i) {
        this.hto = i;
        if (!v.isEmpty(this.mDatas) && this.faQ != null) {
            for (o oVar : this.mDatas) {
                if (oVar instanceof g) {
                    ((g) oVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.hto < this.mDatas.size() - 1) {
                    List<o> list = this.mDatas;
                    int i2 = this.hto + 1;
                    this.hto = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.hto)).autoPlay = true;
                        this.faQ.smoothScrollToPositionFromTop(this.faQ.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.hto == this.mDatas.size() - 1 && (this.mDatas.get(this.hto) instanceof g)) {
                    ((g) this.mDatas.get(this.hto)).autoPlay = false;
                }
            }
        }
    }

    public int bXA() {
        return this.hto;
    }

    public void bXB() {
        if (!v.isEmpty(this.mDatas)) {
            Iterator<o> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bXC();
    }

    private void bXC() {
        bXB();
        this.hto = 0;
        pz();
    }
}
