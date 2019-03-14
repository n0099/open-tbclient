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
    private e feK;
    private boolean feL;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int feM = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.feL = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.feL = z;
        initAdapters();
    }

    private void initAdapters() {
        this.feK = new e(this.mContext, this, this.feL);
        this.mAdapters.add(this.feK);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.feL && j.kZ()) {
                beV();
                list.get(0).autoPlay = true;
            }
        }
    }

    public void af(String str, boolean z) {
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
                if (next != null && (next instanceof g) && ((g) next).feR != null && str.equals(((g) next).feR.userId)) {
                    ((g) next).feR.hasFocus = z;
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
        this.feK.onDestroy();
    }

    public boolean pY() {
        return this.feK.pY();
    }

    public void pW() {
        this.feK.pW();
    }

    public void pX() {
        this.feK.pX();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.feK.onConfigurationChanged(configuration);
    }

    public boolean qw(int i) {
        return this.feK.qw(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qv(int i) {
        this.feM = i;
        if (!v.T(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.kZ()) {
                if (this.feM < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.feM + 1;
                    this.feM = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.feM)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.feM == this.mDatas.size() - 1 && (this.mDatas.get(this.feM) instanceof g)) {
                    ((g) this.mDatas.get(this.feM)).autoPlay = false;
                }
            }
        }
    }

    public int beT() {
        return this.feM;
    }

    public void beU() {
        if (!v.T(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        beV();
    }

    private void beV() {
        beU();
        this.feM = 0;
        pW();
    }
}
