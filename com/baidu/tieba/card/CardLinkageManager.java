package com.baidu.tieba.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public enum CardLinkageManager {
    INSTANCE;
    
    private List<Long> mThreadIdList;

    public void pressLinkage(com.baidu.adp.widget.ListView.v vVar, int i, boolean z) {
        View findViewByPosition;
        if (vVar instanceof BdTypeRecyclerView) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) vVar;
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                List<com.baidu.adp.widget.ListView.q> data = bdTypeRecyclerView.getData();
                Object item = com.baidu.tbadk.core.util.y.getItem(data, i);
                if (item instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                    int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                    for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                        Object item2 = com.baidu.tbadk.core.util.y.getItem(data, i2 - headerViewsCount);
                        if (item2 instanceof BaseCardInfo) {
                            BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                            if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                                if ((com.baidu.tbadk.a.d.bhw() && !baseCardInfo2.isSupportNone()) || baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                                    ap.setBackgroundColor(findViewByPosition, z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                } else if (baseCardInfo2.isSupportFull()) {
                                    com.baidu.tbadk.core.elementsMaven.c.bj(findViewByPosition).pa(0).pb(R.string.J_X06).setBackGroundColor(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                } else if (baseCardInfo2.isSupportTop()) {
                                    com.baidu.tbadk.core.elementsMaven.c.bj(findViewByPosition).pa(1).pb(R.string.J_X06).setBackGroundColor(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                } else if (baseCardInfo2.isSupportBottom()) {
                                    com.baidu.tbadk.core.elementsMaven.c.bj(findViewByPosition).pa(2).pb(R.string.J_X06).setBackGroundColor(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void translationY(BdTypeRecyclerView bdTypeRecyclerView, int i, float f) {
        View findViewByPosition;
        View findViewByPosition2;
        if (bdTypeRecyclerView != null) {
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                List<com.baidu.adp.widget.ListView.q> data = bdTypeRecyclerView.getData();
                Object item = com.baidu.tbadk.core.util.y.getItem(data, i - headerViewsCount);
                if (item instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                    for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                        Object item2 = com.baidu.tbadk.core.util.y.getItem(data, i2 - headerViewsCount);
                        if (!(item2 instanceof BaseCardInfo)) {
                            if ((item2 instanceof com.baidu.adp.widget.ListView.q) && (findViewByPosition2 = layoutManager.findViewByPosition(i2)) != null) {
                                findViewByPosition2.setTranslationY(f);
                            }
                        } else if (baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                            findViewByPosition.setTranslationY(f);
                        }
                    }
                }
            }
        }
    }

    public void addThreadId(long j) {
        if (this.mThreadIdList == null) {
            this.mThreadIdList = new ArrayList();
        }
        this.mThreadIdList.add(Long.valueOf(j));
    }

    public void deleteThreadIds() {
        if (this.mThreadIdList != null) {
            this.mThreadIdList.clear();
        }
    }
}
