package com.baidu.tieba.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.m0.r.u.c;
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

    public void pressLinkage(s sVar, int i2, boolean z) {
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
            Object item = ListUtils.getItem(data, i2);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i3 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i3 <= lastVisiblePosition; i3++) {
                    Object item2 = ListUtils.getItem(data, i3 - headerViewsCount);
                    if (item2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                        if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i3)) != null) {
                            if (baseCardInfo2.isSupportFull()) {
                                c d2 = c.d(findViewByPosition);
                                d2.l(0);
                                d2.m(R.string.J_X06);
                                d2.f(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportTop()) {
                                c d3 = c.d(findViewByPosition);
                                d3.l(1);
                                d3.m(R.string.J_X06);
                                d3.f(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportBottom()) {
                                c d4 = c.d(findViewByPosition);
                                d4.l(2);
                                d4.m(R.string.J_X06);
                                d4.f(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                                SkinManager.setBackgroundColor(findViewByPosition, z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            }
                        }
                    }
                }
            }
        }
    }

    public void translationY(BdTypeRecyclerView bdTypeRecyclerView, int i2, float f2) {
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
        Object item = ListUtils.getItem(data, i2 - headerViewsCount);
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
