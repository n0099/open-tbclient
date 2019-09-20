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

    public void pressLinkage(com.baidu.adp.widget.ListView.r rVar, int i, boolean z) {
        View findViewByPosition;
        if (rVar instanceof BdTypeRecyclerView) {
            int firstVisiblePosition = ((BdTypeRecyclerView) rVar).getFirstVisiblePosition();
            int lastVisiblePosition = ((BdTypeRecyclerView) rVar).getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) rVar).getLayoutManager();
            if (layoutManager != null) {
                List<com.baidu.adp.widget.ListView.m> data = rVar.getData();
                Object c = com.baidu.tbadk.core.util.v.c(data, i);
                if (c instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) c;
                    int headerViewsCount = ((BdTypeRecyclerView) rVar).getHeaderViewsCount();
                    for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                        Object c2 = com.baidu.tbadk.core.util.v.c(data, i2 - headerViewsCount);
                        if ((c2 instanceof com.baidu.tieba.card.data.b) && bVar.position == ((com.baidu.tieba.card.data.b) c2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                            if (z) {
                                am.l(findViewByPosition, R.color.cp_bg_line_c);
                            } else {
                                am.l(findViewByPosition, R.color.cp_bg_line_e);
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
                List<com.baidu.adp.widget.ListView.m> data = bdTypeRecyclerView.getData();
                Object c = com.baidu.tbadk.core.util.v.c(data, i - headerViewsCount);
                if (c instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) c;
                    for (int i2 = firstVisiblePosition; i2 <= lastVisiblePosition; i2++) {
                        Object c2 = com.baidu.tbadk.core.util.v.c(data, i2 - headerViewsCount);
                        if (!(c2 instanceof com.baidu.tieba.card.data.b)) {
                            if ((c2 instanceof com.baidu.adp.widget.ListView.m) && (findViewByPosition2 = layoutManager.findViewByPosition(i2)) != null) {
                                findViewByPosition2.setTranslationY(f);
                            }
                        } else if (bVar.position == ((com.baidu.tieba.card.data.b) c2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
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
