package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
/* loaded from: classes22.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    private a iVZ;
    private c iWa;
    private FrsGameStrategyItemListView iWb;
    private Context mContext;
    private BdUniqueId mPageId;
    private final FrsGameStrategyItemListView[] iVY = new FrsGameStrategyItemListView[4];
    private int mCount = 0;
    private int mCurrentPosition = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.mContext = context;
        this.iVZ = aVar;
        this.iWa = cVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        FrsGameStrategyItemListView frsGameStrategyItemListView;
        e zF;
        int i2 = i % 3;
        FrsGameStrategyItemListView zE = zE(i2);
        if (zE == null) {
            FrsGameStrategyItemListView frsGameStrategyItemListView2 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
            frsGameStrategyItemListView2.setFrsGameTabDataLoadListener(this.iVZ);
            a(i2, frsGameStrategyItemListView2);
            frsGameStrategyItemListView = frsGameStrategyItemListView2;
        } else {
            if (zE == cCD()) {
                zE = zE(3);
                if (zE == null) {
                    FrsGameStrategyItemListView frsGameStrategyItemListView3 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
                    frsGameStrategyItemListView3.setFrsGameTabDataLoadListener(this.iVZ);
                    a(3, frsGameStrategyItemListView3);
                    frsGameStrategyItemListView = frsGameStrategyItemListView3;
                } else if (zE.getParent() != null) {
                    viewGroup.removeView(zE);
                    frsGameStrategyItemListView = zE;
                }
            } else if (zE.getParent() != null) {
                viewGroup.removeView(zE);
            }
            frsGameStrategyItemListView = zE;
        }
        viewGroup.addView(frsGameStrategyItemListView);
        if (this.iWa != null && (zF = this.iWa.zF(i)) != null && (zF.extra instanceof LabelDataList)) {
            frsGameStrategyItemListView.cx(zF.tabId, ((LabelDataList) zF.extra).getSelectedLabelId());
        }
        return frsGameStrategyItemListView;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if ((obj instanceof FrsGameStrategyItemListView) && this.mCurrentPosition != i) {
            this.mCurrentPosition = i;
            this.iWb = (FrsGameStrategyItemListView) obj;
            this.iWb.cCK();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    private FrsGameStrategyItemListView zE(int i) {
        if (i >= this.iVY.length) {
            return null;
        }
        return this.iVY[i];
    }

    private void a(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        if (i < this.iVY.length) {
            this.iVY[i] = frsGameStrategyItemListView;
        }
    }

    public void setCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mCount = i;
        notifyDataSetChanged();
    }

    public FrsGameStrategyItemListView cw(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.iVY[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.iVY) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    public FrsGameStrategyItemListView cCD() {
        return this.iWb;
    }

    public void onChangeSkinType(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.iVY) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.iVY) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onDestory();
            }
        }
    }
}
