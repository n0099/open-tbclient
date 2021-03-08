package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.n;
/* loaded from: classes10.dex */
public class GuardClubRankListView extends BdListView {
    private a heg;
    private boolean heh;
    private LoadMoreFooter hei;

    /* loaded from: classes10.dex */
    public interface a {
        void bWk();

        void onScroll();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.heg = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.heh = z;
        if (z) {
            bVR();
        } else {
            np(z2);
        }
    }

    public void release() {
        this.heg = null;
        bWv();
    }

    public void bWv() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if (tag instanceof n.b) {
                        ((n.b) tag).recycle();
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void init() {
        initUI();
        bWw();
        bWx();
        bWy();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bWw() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.heg != null) {
                    GuardClubRankListView.this.heg.onScroll();
                }
                if (GuardClubRankListView.this.heg != null && GuardClubRankListView.this.heh && !GuardClubRankListView.this.hei.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bWz();
                    GuardClubRankListView.this.heg.bWk();
                }
            }
        });
    }

    private void bWx() {
        setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof n.b) {
                    ((n.b) tag).recycle();
                }
            }
        });
    }

    private void bWy() {
        this.hei = new LoadMoreFooter(getContext());
        this.hei.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.hei.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWz() {
        if (this.hei != null) {
            if (this.hei.getView().getParent() == null) {
                setNextPage(this.hei);
            }
            this.hei.showLoadView();
        }
    }

    private void bVR() {
        if (this.hei != null) {
            this.hei.endLoadData();
            setNextPage(null);
        }
    }

    private void np(boolean z) {
        if (z) {
            if (this.hei != null) {
                setNextPage(null);
            }
        } else if (this.hei != null) {
            if (this.hei.getView().getParent() == null) {
                setNextPage(this.hei);
            }
            this.hei.showNoMoreData();
        }
    }
}
