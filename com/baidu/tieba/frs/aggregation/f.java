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
    private e fex;
    private boolean fey;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int fez = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fey = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fey = z;
        initAdapters();
    }

    private void initAdapters() {
        this.fex = new e(this.mContext, this, this.fey);
        this.mAdapters.add(this.fex);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.fey && j.kZ()) {
                beT();
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
                if (next != null && (next instanceof g) && ((g) next).feE != null && str.equals(((g) next).feE.userId)) {
                    ((g) next).feE.hasFocus = z;
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
        this.fex.onDestroy();
    }

    public boolean pY() {
        return this.fex.pY();
    }

    public void pW() {
        this.fex.pW();
    }

    public void pX() {
        this.fex.pX();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fex.onConfigurationChanged(configuration);
    }

    public boolean qs(int i) {
        return this.fex.qs(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void qr(int i) {
        this.fez = i;
        if (!v.T(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.kZ()) {
                if (this.fez < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fez + 1;
                    this.fez = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fez)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fez == this.mDatas.size() - 1 && (this.mDatas.get(this.fez) instanceof g)) {
                    ((g) this.mDatas.get(this.fez)).autoPlay = false;
                }
            }
        }
    }

    public int beR() {
        return this.fez;
    }

    public void beS() {
        if (!v.T(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        beT();
    }

    private void beT() {
        beS();
        this.fez = 0;
        pW();
    }
}
