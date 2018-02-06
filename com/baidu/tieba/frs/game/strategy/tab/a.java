package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
/* loaded from: classes3.dex */
public class a extends PagerAdapter {
    private b dOn;
    private d dOo;
    private com.baidu.tieba.frs.game.strategy.view.d dOp;
    private Context mContext;
    private BdUniqueId mPageId;
    private final com.baidu.tieba.frs.game.strategy.view.d[] dOm = new com.baidu.tieba.frs.game.strategy.view.d[4];
    private int mCount = 0;
    private int Po = -1;

    public a(Context context, b bVar, d dVar) {
        this.mContext = context;
        this.dOn = bVar;
        this.dOo = dVar;
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
            dVar2.setFrsGameTabDataLoadListener(this.dOn);
            a(i2, dVar2);
            dVar = dVar2;
        } else {
            if (nq == axT()) {
                nq = nq(3);
                if (nq == null) {
                    com.baidu.tieba.frs.game.strategy.view.d dVar3 = new com.baidu.tieba.frs.game.strategy.view.d(this.mContext, this.mPageId);
                    dVar3.setFrsGameTabDataLoadListener(this.dOn);
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
        if (this.dOo != null && (nr = this.dOo.nr(i)) != null && (nr.extra instanceof LabelDataList)) {
            dVar.bE(nr.tabId, ((LabelDataList) nr.extra).getSelectedLabelId());
        }
        return dVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if ((obj instanceof com.baidu.tieba.frs.game.strategy.view.d) && this.Po != i) {
            this.Po = i;
            this.dOp = (com.baidu.tieba.frs.game.strategy.view.d) obj;
            this.dOp.aya();
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
        if (i >= this.dOm.length) {
            return null;
        }
        return this.dOm[i];
    }

    private void a(int i, com.baidu.tieba.frs.game.strategy.view.d dVar) {
        if (i < this.dOm.length) {
            this.dOm[i] = dVar;
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
            return this.dOm[0];
        }
        for (com.baidu.tieba.frs.game.strategy.view.d dVar : this.dOm) {
            if (dVar != null && i == dVar.getTabId() && i2 == dVar.getLabelId()) {
                return dVar;
            }
        }
        return null;
    }

    public com.baidu.tieba.frs.game.strategy.view.d axT() {
        return this.dOp;
    }

    public void onChangeSkinType(int i) {
        com.baidu.tieba.frs.game.strategy.view.d[] dVarArr;
        for (com.baidu.tieba.frs.game.strategy.view.d dVar : this.dOm) {
            if (dVar != null) {
                dVar.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        com.baidu.tieba.frs.game.strategy.view.d[] dVarArr;
        for (com.baidu.tieba.frs.game.strategy.view.d dVar : this.dOm) {
            if (dVar != null) {
                dVar.onDestory();
            }
        }
    }
}
