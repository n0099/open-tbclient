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
    private e fuM;
    private boolean fuN;
    private TbPageContext mContext;
    private BdTypeListView mListView;
    private List<m> mDatas = new ArrayList();
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private int fuO = -1;

    public f(TbPageContext tbPageContext, BdTypeListView bdTypeListView, boolean z) {
        this.fuN = false;
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        this.fuN = z;
        initAdapters();
    }

    private void initAdapters() {
        this.fuM = new e(this.mContext, this, this.fuN);
        this.mAdapters.add(this.fuM);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<g> list, boolean z) {
        if (list != null) {
            if (z) {
                this.mDatas.clear();
            }
            this.mDatas.addAll(list);
            this.mListView.setData(this.mDatas);
            if (z && list.size() > 0 && this.fuN && j.jT()) {
                bmo();
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
                if (next != null && (next instanceof g) && ((g) next).fuT != null && str.equals(((g) next).fuT.userId)) {
                    ((g) next).fuT.hasFocus = z;
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
        this.fuM.onDestroy();
    }

    public boolean oT() {
        return this.fuM.oT();
    }

    public void oR() {
        this.fuM.oR();
    }

    public void oS() {
        this.fuM.oS();
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.fuM.onConfigurationChanged(configuration);
    }

    public boolean rz(int i) {
        return this.fuM.rz(i);
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void ry(int i) {
        this.fuO = i;
        if (!v.aa(this.mDatas) && this.mListView != null) {
            for (m mVar : this.mDatas) {
                if (mVar instanceof g) {
                    ((g) mVar).autoPlay = false;
                }
            }
            if (j.jT()) {
                if (this.fuO < this.mDatas.size() - 1) {
                    List<m> list = this.mDatas;
                    int i2 = this.fuO + 1;
                    this.fuO = i2;
                    if (list.get(i2) instanceof g) {
                        ((g) this.mDatas.get(this.fuO)).autoPlay = true;
                        this.mListView.smoothScrollToPositionFromTop(this.mListView.getHeaderViewsCount() + i + 1, 0);
                        notifyDataSetChanged();
                    }
                } else if (this.fuO == this.mDatas.size() - 1 && (this.mDatas.get(this.fuO) instanceof g)) {
                    ((g) this.mDatas.get(this.fuO)).autoPlay = false;
                }
            }
        }
    }

    public int bmm() {
        return this.fuO;
    }

    public void bmn() {
        if (!v.aa(this.mDatas)) {
            Iterator<m> it = this.mDatas.iterator();
            while (it.hasNext()) {
                ((g) it.next()).autoPlay = false;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.a
    public void cancel() {
        bmo();
    }

    private void bmo() {
        bmn();
        this.fuO = 0;
        oR();
    }
}
