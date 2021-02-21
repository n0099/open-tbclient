package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
/* loaded from: classes2.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    private a jxZ;
    private c jya;
    private FrsGameStrategyItemListView jyb;
    private Context mContext;
    private BdUniqueId mPageId;
    private final FrsGameStrategyItemListView[] jxY = new FrsGameStrategyItemListView[4];
    private int mCount = 0;
    private int mCurrentPosition = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.mContext = context;
        this.jxZ = aVar;
        this.jya = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        FrsGameStrategyItemListView frsGameStrategyItemListView;
        e zH;
        int i2 = i % 3;
        FrsGameStrategyItemListView zG = zG(i2);
        if (zG == null) {
            FrsGameStrategyItemListView frsGameStrategyItemListView2 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
            frsGameStrategyItemListView2.setFrsGameTabDataLoadListener(this.jxZ);
            a(i2, frsGameStrategyItemListView2);
            frsGameStrategyItemListView = frsGameStrategyItemListView2;
        } else {
            if (zG == cHW()) {
                zG = zG(3);
                if (zG == null) {
                    FrsGameStrategyItemListView frsGameStrategyItemListView3 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
                    frsGameStrategyItemListView3.setFrsGameTabDataLoadListener(this.jxZ);
                    a(3, frsGameStrategyItemListView3);
                    frsGameStrategyItemListView = frsGameStrategyItemListView3;
                } else if (zG.getParent() != null) {
                    viewGroup.removeView(zG);
                    frsGameStrategyItemListView = zG;
                }
            } else if (zG.getParent() != null) {
                viewGroup.removeView(zG);
            }
            frsGameStrategyItemListView = zG;
        }
        viewGroup.addView(frsGameStrategyItemListView);
        if (this.jya != null && (zH = this.jya.zH(i)) != null && (zH.extra instanceof LabelDataList)) {
            frsGameStrategyItemListView.cx(zH.tabId, ((LabelDataList) zH.extra).getSelectedLabelId());
        }
        return frsGameStrategyItemListView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if ((obj instanceof FrsGameStrategyItemListView) && this.mCurrentPosition != i) {
            this.mCurrentPosition = i;
            this.jyb = (FrsGameStrategyItemListView) obj;
            this.jyb.cId();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    private FrsGameStrategyItemListView zG(int i) {
        if (i >= this.jxY.length) {
            return null;
        }
        return this.jxY[i];
    }

    private void a(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        if (i < this.jxY.length) {
            this.jxY[i] = frsGameStrategyItemListView;
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
            return this.jxY[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.jxY) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    public FrsGameStrategyItemListView cHW() {
        return this.jyb;
    }

    public void onChangeSkinType(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.jxY) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.jxY) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onDestory();
            }
        }
    }
}
