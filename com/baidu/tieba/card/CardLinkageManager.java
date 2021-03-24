package com.baidu.tieba.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.h0.r.u.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public enum CardLinkageManager {
    INSTANCE;
    
    public List<Long> mThreadIdList;

    public void addThreadId(long j) {
        if (this.mThreadIdList == null) {
            this.mThreadIdList = new ArrayList();
        }
        this.mThreadIdList.add(Long.valueOf(j));
    }

    public void deleteThreadIds() {
        List<Long> list = this.mThreadIdList;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public void pressLinkage(s sVar, int i, boolean z) {
        View findViewByPosition;
        if (sVar instanceof BdTypeRecyclerView) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) sVar;
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            List<n> data = bdTypeRecyclerView.getData();
            Object item = ListUtils.getItem(data, i);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                    Object item2 = ListUtils.getItem(data, i2 - headerViewsCount);
                    if (item2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                        if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                            if (baseCardInfo2.isSupportFull()) {
                                c a2 = c.a(findViewByPosition);
                                a2.g(0);
                                a2.h(R.string.J_X06);
                                a2.c(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportTop()) {
                                c a3 = c.a(findViewByPosition);
                                a3.g(1);
                                a3.h(R.string.J_X06);
                                a3.c(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportBottom()) {
                                c a4 = c.a(findViewByPosition);
                                a4.g(2);
                                a4.h(R.string.J_X06);
                                a4.c(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                                SkinManager.setBackgroundColor(findViewByPosition, z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            }
                        }
                    }
                }
            }
        }
    }

    public void translationY(BdTypeRecyclerView bdTypeRecyclerView, int i, float f2) {
        View findViewByPosition;
        View findViewByPosition2;
        if (bdTypeRecyclerView == null) {
            return;
        }
        int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
        RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        List<n> data = bdTypeRecyclerView.getData();
        Object item = ListUtils.getItem(data, i - headerViewsCount);
        if (item instanceof BaseCardInfo) {
            BaseCardInfo baseCardInfo = (BaseCardInfo) item;
            for (int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                Object item2 = ListUtils.getItem(data, firstVisiblePosition - headerViewsCount);
                if (!(item2 instanceof BaseCardInfo)) {
                    if ((item2 instanceof n) && (findViewByPosition2 = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                        findViewByPosition2.setTranslationY(f2);
                    }
                } else if (baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                    findViewByPosition.setTranslationY(f2);
                }
            }
        }
    }
}
