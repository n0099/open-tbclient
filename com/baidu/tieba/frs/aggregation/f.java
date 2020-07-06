package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private TbPageContext dPv;
    private BdTypeListView fml;
    private e hGn;
    private boolean hGo;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private int hGp = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.hGo = false;
        this.dPv = tbPageContext;
        this.fml = bdTypeListView;
        this.hGo = z;
        Dz();
    }

    private void Dz() {
        this.hGn = new e(this.dPv, this, this.hGo);
        this.aUP.add(this.hGn);
        this.fml.addAdapters(this.aUP);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.fml.setData(this.mDatas);
            if (z && list.size() > 0 && this.hGo && j.isWifiNet()) {
                caQ();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aG(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            boolean z3 = false;
            Iterator<q> it = this.mDatas.iterator();
            while (true) {
                z2 = z3;
                if (!it.hasNext()) {
                    break;
                }
                q next = it.next();
                if (next != null && (next instanceof g) && ((g) next).hGu != null && str.equals(((g) next).hGu.userId)) {
                    ((g) next).hGu.hasFocus = z;
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
        if (this.fml != null && this.fml.getAdapter() != null && (this.fml.getAdapter() instanceof BaseAdapter)) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.hGn.onDestroy();
    }

    public boolean pS() {
        return this.hGn.pS();
    }

    public void pQ() {
        this.hGn.pQ();
    }

    public void pR() {
        this.hGn.pR();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.hGn.onConfigurationChanged(configuration);
    }

    public boolean uR(int i) {
        return this.hGn.uR(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void uQ(int i) {
        this.hGp = i;
        if (!w.isEmpty(this.mDatas) && this.fml != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.hGp < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.hGp + 1;
                    this.hGp = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.hGp)).autoPlay = true;
                        this.fml.smoothScrollToPositionFromTop(this.fml.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.hGp == this.mDatas.size() - 1 && (this.mDatas.get(this.hGp) instanceof g)) {
                    ((g) this.mDatas.get(this.hGp)).autoPlay = false;
                }
            }
        }
    }

    public int caO() {
        return this.hGp;
    }

    public void caP() {
        if (!w.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        caQ();
    }

    private void caQ() {
        caP();
        this.hGp = 0;
        pQ();
    }
}
