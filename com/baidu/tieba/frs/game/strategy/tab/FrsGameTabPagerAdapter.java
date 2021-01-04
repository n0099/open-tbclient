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
    private a jwL;
    private c jwM;
    private FrsGameStrategyItemListView jwN;
    private Context mContext;
    private BdUniqueId mPageId;
    private final FrsGameStrategyItemListView[] jwK = new FrsGameStrategyItemListView[4];
    private int mCount = 0;
    private int mCurrentPosition = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.mContext = context;
        this.jwL = aVar;
        this.jwM = cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        FrsGameStrategyItemListView frsGameStrategyItemListView;
        e Bd;
        int i2 = i % 3;
        FrsGameStrategyItemListView Bc = Bc(i2);
        if (Bc == null) {
            FrsGameStrategyItemListView frsGameStrategyItemListView2 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
            frsGameStrategyItemListView2.setFrsGameTabDataLoadListener(this.jwL);
            a(i2, frsGameStrategyItemListView2);
            frsGameStrategyItemListView = frsGameStrategyItemListView2;
        } else {
            if (Bc == cKt()) {
                Bc = Bc(3);
                if (Bc == null) {
                    FrsGameStrategyItemListView frsGameStrategyItemListView3 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
                    frsGameStrategyItemListView3.setFrsGameTabDataLoadListener(this.jwL);
                    a(3, frsGameStrategyItemListView3);
                    frsGameStrategyItemListView = frsGameStrategyItemListView3;
                } else if (Bc.getParent() != null) {
                    viewGroup.removeView(Bc);
                    frsGameStrategyItemListView = Bc;
                }
            } else if (Bc.getParent() != null) {
                viewGroup.removeView(Bc);
            }
            frsGameStrategyItemListView = Bc;
        }
        viewGroup.addView(frsGameStrategyItemListView);
        if (this.jwM != null && (Bd = this.jwM.Bd(i)) != null && (Bd.extra instanceof LabelDataList)) {
            frsGameStrategyItemListView.cz(Bd.tabId, ((LabelDataList) Bd.extra).getSelectedLabelId());
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
            this.jwN = (FrsGameStrategyItemListView) obj;
            this.jwN.cKA();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    private FrsGameStrategyItemListView Bc(int i) {
        if (i >= this.jwK.length) {
            return null;
        }
        return this.jwK[i];
    }

    private void a(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        if (i < this.jwK.length) {
            this.jwK[i] = frsGameStrategyItemListView;
        }
    }

    public void setCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mCount = i;
        notifyDataSetChanged();
    }

    public FrsGameStrategyItemListView cy(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.jwK[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.jwK) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    public FrsGameStrategyItemListView cKt() {
        return this.jwN;
    }

    public void onChangeSkinType(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.jwK) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.jwK) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onDestory();
            }
        }
    }
}
