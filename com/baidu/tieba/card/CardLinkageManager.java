package com.baidu.tieba.card;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public enum CardLinkageManager {
    INSTANCE;
    
    private List<Long> mThreadIdList;

    public void pressLinkage(r rVar, int i, boolean z) {
        if (rVar instanceof BdTypeRecyclerView) {
            int lastVisiblePosition = ((BdTypeRecyclerView) rVar).getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = ((BdTypeRecyclerView) rVar).getLayoutManager();
            if (layoutManager != null) {
                List<com.baidu.adp.widget.ListView.m> data = rVar.getData();
                Object c = com.baidu.tbadk.core.util.v.c(data, i);
                if (c instanceof com.baidu.tieba.card.data.b) {
                    com.baidu.tieba.card.data.b bVar = (com.baidu.tieba.card.data.b) c;
                    boolean z2 = ((BdTypeRecyclerView) rVar).getHeaderViewsCount() > 0;
                    for (int firstVisiblePosition = ((BdTypeRecyclerView) rVar).getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                        Object c2 = com.baidu.tbadk.core.util.v.c(data, firstVisiblePosition);
                        if ((c2 instanceof com.baidu.tieba.card.data.b) && bVar.position == ((com.baidu.tieba.card.data.b) c2).position) {
                            View findViewByPosition = layoutManager.findViewByPosition(z2 ? firstVisiblePosition + 1 : firstVisiblePosition);
                            if (findViewByPosition != null) {
                                if (z) {
                                    al.k(findViewByPosition, d.C0236d.cp_bg_line_e);
                                } else {
                                    al.k(findViewByPosition, d.C0236d.cp_bg_line_d);
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
                List<com.baidu.adp.widget.ListView.m> data = bdTypeRecyclerView.getData();
                Object c = com.baidu.tbadk.core.util.v.c(data, i);
                if (c instanceof com.baidu.tieba.card.data.b) {
                    int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
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
