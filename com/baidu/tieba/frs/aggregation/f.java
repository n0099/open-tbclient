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
    private e fuL;
    private boolean fuM;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int fuN = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fuM = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fuM = z;
        initAdapters();
    }

    private void initAdapters() {
        this.fuL = new e(this.mContext, this, this.fuM);
        this.mAdapters.add(this.fuL);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.fuM && j.jT()) {
                bml();
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
                if (next != null && (next instanceof g) && ((g) next).fuS != null && str.equals(((g) next).fuS.userId)) {
                    ((g) next).fuS.hasFocus = z;
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
        if (this.mListView != null && this.mListView.getAdapter() != null && (this.mListView.getAdapter() instanceof BaseAdapter)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onDestroy() {
        this.fuL.onDestroy();
    }

    public boolean oT() {
        return this.fuL.oT();
    }

    public void oR() {
        this.fuL.oR();
    }

    public void oS() {
        this.fuL.oS();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fuL.onConfigurationChanged(configuration);
    }

    public boolean rz(int i) {
        return this.fuL.rz(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ry(int i) {
        this.fuN = i;
        if (!v.aa(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.jT()) {
                if (this.fuN < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fuN + 1;
                    this.fuN = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fuN)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fuN == this.mDatas.size() - 1 && (this.mDatas.get(this.fuN) instanceof g)) {
                    ((g) this.mDatas.get(this.fuN)).autoPlay = false;
                }
            }
        }
    }

    public int bmj() {
        return this.fuN;
    }

    public void bmk() {
        if (!v.aa(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bml();
    }

    private void bml() {
        bmk();
        this.fuN = 0;
        oR();
    }
}
