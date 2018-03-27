package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class a extends PagerAdapter {
    private b dOg;
    private d dOh;
    private com.baidu.tieba.frs.game.strategy.view.d dOi;
    private Context mContext;
    private BdUniqueId mPageId;
    private final com.baidu.tieba.frs.game.strategy.view.d[] dOf = new com.baidu.tieba.frs.game.strategy.view.d[4];
    private int mCount = 0;
    private int Pj = -1;

    public a(Context context, b bVar, d dVar) {
        this.mContext = context;
        this.dOg = bVar;
        this.dOh = dVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        com.baidu.tieba.frs.game.strategy.view.d dVar;
        f nr;
        int i2 = i % 3;
        com.baidu.tieba.frs.game.strategy.view.d nq = nq(i2);
        if (nq == null) {
            com.baidu.tieba.frs.game.strategy.view.d dVar2 = new com.baidu.tieba.frs.game.strategy.view.d(this.mContext, this.mPageId);
            dVar2.setFrsGameTabDataLoadListener(this.dOg);
            a(i2, dVar2);
            dVar = dVar2;
        } else {
            if (nq == axU()) {
                nq = nq(3);
                if (nq == null) {
                    com.baidu.tieba.frs.game.strategy.view.d dVar3 = new com.baidu.tieba.frs.game.strategy.view.d(this.mContext, this.mPageId);
                    dVar3.setFrsGameTabDataLoadListener(this.dOg);
                    a(3, dVar3);
                    dVar = dVar3;
                } else if (nq.getParent() != null) {
                    viewGroup.removeView(nq);
                    dVar = nq;
                }
            } else if (nq.getParent() != null) {
                viewGroup.removeView(nq);
            }
            dVar = nq;
        }
        viewGroup.addView(dVar);
        if (this.dOh != null && (nr = this.dOh.nr(i)) != null && (nr.extra instanceof LabelDataList)) {
            dVar.bE(nr.tabId, ((LabelDataList) nr.extra).getSelectedLabelId());
        }
        return dVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if ((obj instanceof com.baidu.tieba.frs.game.strategy.view.d) && this.Pj != i) {
            this.Pj = i;
            this.dOi = (com.baidu.tieba.frs.game.strategy.view.d) obj;
            this.dOi.ayb();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof com.baidu.tieba.frs.game.strategy.view.d) && obj == view;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    private com.baidu.tieba.frs.game.strategy.view.d nq(int i) {
        if (i >= this.dOf.length) {
            return null;
        }
        return this.dOf[i];
    }

    private void a(int i, com.baidu.tieba.frs.game.strategy.view.d dVar) {
        if (i < this.dOf.length) {
            this.dOf[i] = dVar;
        }
    }

    public void setCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mCount = i;
        notifyDataSetChanged();
    }

    public com.baidu.tieba.frs.game.strategy.view.d bC(int i, int i2) {
        com.baidu.tieba.frs.game.strategy.view.d[] dVarArr;
        if (i == 0 && i2 == 0) {
            return this.dOf[0];
        }
        for (com.baidu.tieba.frs.game.strategy.view.d dVar : this.dOf) {
            if (dVar != null && i == dVar.getTabId() && i2 == dVar.getLabelId()) {
                return dVar;
            }
        }
        return null;
    }

    public com.baidu.tieba.frs.game.strategy.view.d axU() {
        return this.dOi;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.frs.game.strategy.view.d[] dVarArr;
        for (com.baidu.tieba.frs.game.strategy.view.d dVar : this.dOf) {
            if (dVar != null) {
                dVar.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        com.baidu.tieba.frs.game.strategy.view.d[] dVarArr;
        for (com.baidu.tieba.frs.game.strategy.view.d dVar : this.dOf) {
            if (dVar != null) {
                dVar.onDestory();
            }
        }
    }
}
