package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.n;
/* loaded from: classes4.dex */
public class GuardClubRankListView extends BdListView {
    private a gSq;
    private boolean gSr;
    private LoadMoreFooter gSs;

    /* loaded from: classes4.dex */
    public interface a {
        void bWD();

        void bWE();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gSq = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gSr = z;
        if (z) {
            bWk();
        } else {
            mO(z2);
        }
    }

    public void release() {
        this.gSq = null;
        bWP();
    }

    public void bWP() {
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
        bWQ();
        bWR();
        bWS();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bWQ() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gSq != null) {
                    GuardClubRankListView.this.gSq.bWD();
                }
                if (GuardClubRankListView.this.gSq != null && GuardClubRankListView.this.gSr && !GuardClubRankListView.this.gSs.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bWT();
                    GuardClubRankListView.this.gSq.bWE();
                }
            }
        });
    }

    private void bWR() {
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

    private void bWS() {
        this.gSs = new LoadMoreFooter(getContext());
        this.gSs.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.gSs.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWT() {
        if (this.gSs != null) {
            if (this.gSs.getView().getParent() == null) {
                setNextPage(this.gSs);
            }
            this.gSs.showLoadView();
        }
    }

    private void bWk() {
        if (this.gSs != null) {
            this.gSs.endLoadData();
            setNextPage(null);
        }
    }

    private void mO(boolean z) {
        if (z) {
            if (this.gSs != null) {
                setNextPage(null);
            }
        } else if (this.gSs != null) {
            if (this.gSs.getView().getParent() == null) {
                setNextPage(this.gSs);
            }
            this.gSs.showNoMoreData();
        }
    }
}
