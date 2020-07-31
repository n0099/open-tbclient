package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
/* loaded from: classes16.dex */
public class FrsGameTabPagerAdapter extends PagerAdapter {
    private a hTv;
    private c hTw;
    private FrsGameStrategyItemListView hTx;
    private Context mContext;
    private BdUniqueId mPageId;
    private final FrsGameStrategyItemListView[] hTu = new FrsGameStrategyItemListView[4];
    private int mCount = 0;
    private int mCurrentPosition = -1;

    public FrsGameTabPagerAdapter(Context context, a aVar, c cVar) {
        this.mContext = context;
        this.hTv = aVar;
        this.hTw = cVar;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mCount;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        FrsGameStrategyItemListView frsGameStrategyItemListView;
        e vB;
        int i2 = i % 3;
        FrsGameStrategyItemListView vA = vA(i2);
        if (vA == null) {
            FrsGameStrategyItemListView frsGameStrategyItemListView2 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
            frsGameStrategyItemListView2.setFrsGameTabDataLoadListener(this.hTv);
            a(i2, frsGameStrategyItemListView2);
            frsGameStrategyItemListView = frsGameStrategyItemListView2;
        } else {
            if (vA == cfF()) {
                vA = vA(3);
                if (vA == null) {
                    FrsGameStrategyItemListView frsGameStrategyItemListView3 = new FrsGameStrategyItemListView(this.mContext, this.mPageId);
                    frsGameStrategyItemListView3.setFrsGameTabDataLoadListener(this.hTv);
                    a(3, frsGameStrategyItemListView3);
                    frsGameStrategyItemListView = frsGameStrategyItemListView3;
                } else if (vA.getParent() != null) {
                    viewGroup.removeView(vA);
                    frsGameStrategyItemListView = vA;
                }
            } else if (vA.getParent() != null) {
                viewGroup.removeView(vA);
            }
            frsGameStrategyItemListView = vA;
        }
        viewGroup.addView(frsGameStrategyItemListView);
        if (this.hTw != null && (vB = this.hTw.vB(i)) != null && (vB.extra instanceof LabelDataList)) {
            frsGameStrategyItemListView.ci(vB.tabId, ((LabelDataList) vB.extra).getSelectedLabelId());
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
            this.hTx = (FrsGameStrategyItemListView) obj;
            this.hTx.cfM();
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof FrsGameStrategyItemListView) && obj == view;
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }

    private FrsGameStrategyItemListView vA(int i) {
        if (i >= this.hTu.length) {
            return null;
        }
        return this.hTu[i];
    }

    private void a(int i, FrsGameStrategyItemListView frsGameStrategyItemListView) {
        if (i < this.hTu.length) {
            this.hTu[i] = frsGameStrategyItemListView;
        }
    }

    public void setCount(int i) {
        if (i < 0) {
            i = 0;
        }
        this.mCount = i;
        notifyDataSetChanged();
    }

    public FrsGameStrategyItemListView ch(int i, int i2) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        if (i == 0 && i2 == 0) {
            return this.hTu[0];
        }
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.hTu) {
            if (frsGameStrategyItemListView != null && i == frsGameStrategyItemListView.getTabId() && i2 == frsGameStrategyItemListView.getLabelId()) {
                return frsGameStrategyItemListView;
            }
        }
        return null;
    }

    public FrsGameStrategyItemListView cfF() {
        return this.hTx;
    }

    public void onChangeSkinType(int i) {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.hTu) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onChangeSkinType(i);
            }
        }
    }

    public void onDestory() {
        FrsGameStrategyItemListView[] frsGameStrategyItemListViewArr;
        for (FrsGameStrategyItemListView frsGameStrategyItemListView : this.hTu) {
            if (frsGameStrategyItemListView != null) {
                frsGameStrategyItemListView.onDestory();
            }
        }
    }
}
