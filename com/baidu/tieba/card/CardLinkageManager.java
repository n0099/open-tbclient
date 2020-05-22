package com.baidu.tieba.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public enum CardLinkageManager {
    INSTANCE;
    
    private List<Long> mThreadIdList;

    public void pressLinkage(com.baidu.adp.widget.ListView.t tVar, int i, boolean z) {
        View findViewByPosition;
        if (tVar instanceof BdTypeRecyclerView) {
            int firstVisiblePosition = ((BdTypeRecyclerView) tVar).getFirstVisiblePosition();
            int lastVisiblePosition = ((BdTypeRecyclerView) tVar).getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) tVar).getLayoutManager();
            if (layoutManager != null) {
                List<com.baidu.adp.widget.ListView.o> data = tVar.getData();
                Object item = com.baidu.tbadk.core.util.v.getItem(data, i);
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    int headerViewsCount = ((BdTypeRecyclerView) tVar).getHeaderViewsCount();
                    for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                        Object item2 = com.baidu.tbadk.core.util.v.getItem(data, i2 - headerViewsCount);
                        if ((item2 instanceof com.baidu.tieba.card.data.b) && bVar.position == ((com.baidu.tieba.card.data.b) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                            if (z) {
                                am.setBackgroundColor(findViewByPosition, R.color.cp_bg_line_c);
                            } else {
                                am.setBackgroundColor(findViewByPosition, R.color.cp_bg_line_e);
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
                List<com.baidu.adp.widget.ListView.o> data = bdTypeRecyclerView.getData();
                Object item = com.baidu.tbadk.core.util.v.getItem(data, i - headerViewsCount);
                if (item instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) item;
                    for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                        Object item2 = com.baidu.tbadk.core.util.v.getItem(data, i2 - headerViewsCount);
                        if (!(item2 instanceof com.baidu.tieba.card.data.b)) {
                            if ((item2 instanceof com.baidu.adp.widget.ListView.o) && (findViewByPosition2 = layoutManager.findViewByPosition(i2)) != null) {
                                findViewByPosition2.setTranslationY(f);
                            }
                        } else if (bVar.position == ((com.baidu.tieba.card.data.b) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
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
