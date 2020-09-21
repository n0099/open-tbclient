package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
/* loaded from: classes21.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    private a ioN;
    private c ioO;
    private FrsGameStrategyItemListView ioP;
    private Context mContext;
    private BdUniqueId mPageId;
    private final FrsGameStrategyItemListView[] ioM = new FrsGameStrategyItemListView[4];
    private int mCount = 0;
    private int mCurrentPosition = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.mContext = context;
        this.ioN = aVar;
        this.ioO = cVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        FrsGameStrategyItemListView frsGameStrategyItemListView;
        e yt;
        int i2 = i % 3;
        FrsGameStrategyItemListView ys = ys(i2);
        if (ys == null) {
            FrsGameStrategyItemListView frsGameStrategyItemListView2 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
            frsGameStrategyItemListView2.setFrsGameTabDataLoadListener(this.ioN);
            a(i2, frsGameStrategyItemListView2);
            frsGameStrategyItemListView = frsGameStrategyItemListView2;
        } else {
            if (ys == cty()) {
                ys = ys(3);
                if (ys == null) {
                    FrsGameStrategyItemListView frsGameStrategyItemListView3 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
                    frsGameStrategyItemListView3.setFrsGameTabDataLoadListener(this.ioN);
                    a(3, frsGameStrategyItemListView3);
                    frsGameStrategyItemListView = frsGameStrategyItemListView3;
                } else if (ys.getParent() != null) {
                    viewGroup.removeView(ys);
                    frsGameStrategyItemListView = ys;
                }
            } else if (ys.getParent() != null) {
                viewGroup.removeView(ys);
            }
            frsGameStrategyItemListView = ys;
        }
        viewGroup.addView(frsGameStrategyItemListView);
        if (this.ioO != null && (yt = this.ioO.yt(i)) != null && (yt.extra instanceof LabelDataList)) {
            frsGameStrategyItemListView.ct(yt.tabId, ((LabelDataList) yt.extra).getSelectedLabelId());
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
            this.ioP = (FrsGameStrategyItemListView) obj;
            this.ioP.ctF();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    private FrsGameStrategyItemListView ys(int i) {
        if (i >= this.ioM.length) {
            return null;
        }
        return this.ioM[i];
    }

    private void a(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        if (i < this.ioM.length) {
            this.ioM[i] = frsGameStrategyItemListView;
        }
    }

    public void setCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mCount = i;
        notifyDataSetChanged();
    }

    public FrsGameStrategyItemListView cs(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.ioM[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.ioM) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    public FrsGameStrategyItemListView cty() {
        return this.ioP;
    }

    public void onChangeSkinType(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.ioM) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.ioM) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onDestory();
            }
        }
    }
}
