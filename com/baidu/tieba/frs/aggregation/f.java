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
    private e fCj;
    private boolean fCk;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int fCl = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fCk = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fCk = z;
        initAdapters();
    }

    private void initAdapters() {
        this.fCj = new e(this.mContext, this, this.fCk);
        this.mAdapters.add(this.fCj);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.fCk && j.kd()) {
                bpn();
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
                if (next != null && (next instanceof g) && ((g) next).fCq != null && str.equals(((g) next).fCq.userId)) {
                    ((g) next).fCq.hasFocus = z;
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
        this.fCj.onDestroy();
    }

    public boolean pp() {
        return this.fCj.pp();
    }

    public void pn() {
        this.fCj.pn();
    }

    public void po() {
        this.fCj.po();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fCj.onConfigurationChanged(configuration);
    }

    public boolean rW(int i) {
        return this.fCj.rW(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void rV(int i) {
        this.fCl = i;
        if (!v.aa(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.kd()) {
                if (this.fCl < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fCl + 1;
                    this.fCl = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fCl)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fCl == this.mDatas.size() - 1 && (this.mDatas.get(this.fCl) instanceof g)) {
                    ((g) this.mDatas.get(this.fCl)).autoPlay = false;
                }
            }
        }
    }

    public int bpl() {
        return this.fCl;
    }

    public void bpm() {
        if (!v.aa(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bpn();
    }

    private void bpn() {
        bpm();
        this.fCl = 0;
        pn();
    }
}
