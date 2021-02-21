package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.n;
/* loaded from: classes11.dex */
public class GuardClubRankListView extends BdListView {
    private a hcx;
    private boolean hcy;
    private LoadMoreFooter hcz;

    /* loaded from: classes11.dex */
    public interface a {
        void bWe();

        void onScroll();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hcx = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.hcy = z;
        if (z) {
            bVL();
        } else {
            np(z2);
        }
    }

    public void release() {
        this.hcx = null;
        bWp();
    }

    public void bWp() {
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
        bWq();
        bWr();
        bWs();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bWq() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.hcx != null) {
                    GuardClubRankListView.this.hcx.onScroll();
                }
                if (GuardClubRankListView.this.hcx != null && GuardClubRankListView.this.hcy && !GuardClubRankListView.this.hcz.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bWt();
                    GuardClubRankListView.this.hcx.bWe();
                }
            }
        });
    }

    private void bWr() {
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

    private void bWs() {
        this.hcz = new LoadMoreFooter(getContext());
        this.hcz.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.hcz.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWt() {
        if (this.hcz != null) {
            if (this.hcz.getView().getParent() == null) {
                setNextPage(this.hcz);
            }
            this.hcz.showLoadView();
        }
    }

    private void bVL() {
        if (this.hcz != null) {
            this.hcz.endLoadData();
            setNextPage(null);
        }
    }

    private void np(boolean z) {
        if (z) {
            if (this.hcz != null) {
                setNextPage(null);
            }
        } else if (this.hcz != null) {
            if (this.hcz.getView().getParent() == null) {
                setNextPage(this.hcz);
            }
            this.hcz.showNoMoreData();
        }
    }
}
