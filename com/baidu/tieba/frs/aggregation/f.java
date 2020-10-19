package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class f implements a {
    private TbPageContext etO;
    private BdTypeListView fSo;
    private e iwy;
    private boolean iwz;
    private List<q> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private int iwA = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.iwz = false;
        this.etO = tbPageContext;
        this.fSo = bdTypeListView;
        this.iwz = z;
        Le();
    }

    private void Le() {
        this.iwy = new e(this.etO, this, this.iwz);
        this.bhH.add(this.iwy);
        this.fSo.addAdapters(this.bhH);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.fSo.setData(this.mDatas);
            if (z && list.size() > 0 && this.iwz && j.isWifiNet()) {
                cvD();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void aM(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).iwF != null && str.equals(((g) next).iwF.userId)) {
                    ((g) next).iwF.hasFocus = z;
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
        if (this.fSo != null && this.fSo.getAdapter() != null && (this.fSo.getAdapter() instanceof BaseAdapter)) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.iwy.onDestroy();
    }

    public boolean rx() {
        return this.iwy.rx();
    }

    public void rv() {
        this.iwy.rv();
    }

    public void rw() {
        this.iwy.rw();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.iwy.onConfigurationChanged(configuration);
    }

    public boolean yG(int i) {
        return this.iwy.yG(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void yF(int i) {
        this.iwA = i;
        if (!y.isEmpty(this.mDatas) && this.fSo != null) {
            for (q qVar : this.mDatas) {
                if (qVar instanceof g) {
                    ((g) qVar).autoPlay = false;
                }
            }
            if (j.isWifiNet()) {
                if (this.iwA < this.mDatas.size() - 1) {
                    List<q> list = this.mDatas;
                    int i2 = this.iwA + 1;
                    this.iwA = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.iwA)).autoPlay = true;
                        this.fSo.smoothScrollToPositionFromTop(this.fSo.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.iwA == this.mDatas.size() - 1 && (this.mDatas.get(this.iwA) instanceof g)) {
                    ((g) this.mDatas.get(this.iwA)).autoPlay = false;
                }
            }
        }
    }

    public int cvB() {
        return this.iwA;
    }

    public void cvC() {
        if (!y.isEmpty(this.mDatas)) {
            Iterator<q> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        cvD();
    }

    private void cvD() {
        cvC();
        this.iwA = 0;
        rv();
    }
}
