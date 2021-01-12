package com.baidu.tieba.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public enum CardLinkageManager {
    INSTANCE;
    
    private List<Long> mThreadIdList;

    public void pressLinkage(com.baidu.adp.widget.ListView.s sVar, int i, boolean z) {
        View findViewByPosition;
        if (sVar instanceof BdTypeRecyclerView) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) sVar;
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager != null) {
                List<com.baidu.adp.widget.ListView.n> data = bdTypeRecyclerView.getData();
                Object item = com.baidu.tbadk.core.util.x.getItem(data, i);
                if (item instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                    int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                    for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                        Object item2 = com.baidu.tbadk.core.util.x.getItem(data, i2 - headerViewsCount);
                        if (item2 instanceof BaseCardInfo) {
                            BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                            if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                                if (baseCardInfo2.isSupportFull()) {
                                    com.baidu.tbadk.core.elementsMaven.c.bv(findViewByPosition).oc(0).od(R.string.J_X06).setBackGroundColor(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                } else if (baseCardInfo2.isSupportTop()) {
                                    com.baidu.tbadk.core.elementsMaven.c.bv(findViewByPosition).oc(1).od(R.string.J_X06).setBackGroundColor(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                } else if (baseCardInfo2.isSupportBottom()) {
                                    com.baidu.tbadk.core.elementsMaven.c.bv(findViewByPosition).oc(2).od(R.string.J_X06).setBackGroundColor(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                                } else if (baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                                    ao.setBackgroundColor(findViewByPosition, z ? R.color.CAM_X0206 : R.color.CAM_X0205);
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
                List<com.baidu.adp.widget.ListView.n> data = bdTypeRecyclerView.getData();
                Object item = com.baidu.tbadk.core.util.x.getItem(data, i - headerViewsCount);
                if (item instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                    for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                        Object item2 = com.baidu.tbadk.core.util.x.getItem(data, i2 - headerViewsCount);
                        if (!(item2 instanceof BaseCardInfo)) {
                            if ((item2 instanceof com.baidu.adp.widget.ListView.n) && (findViewByPosition2 = layoutManager.findViewByPosition(i2)) != null) {
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
