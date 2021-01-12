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
    private boolean gZA;
    private LoadMoreFooter gZB;
    private a gZz;

    /* loaded from: classes10.dex */
    public interface a {
        void bVs();

        void bVt();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gZz = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gZA = z;
        if (z) {
            bUZ();
        } else {
            nk(z2);
        }
    }

    public void release() {
        this.gZz = null;
        bVE();
    }

    public void bVE() {
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
        bVF();
        bVG();
        bVH();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bVF() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gZz != null) {
                    GuardClubRankListView.this.gZz.bVs();
                }
                if (GuardClubRankListView.this.gZz != null && GuardClubRankListView.this.gZA && !GuardClubRankListView.this.gZB.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bVI();
                    GuardClubRankListView.this.gZz.bVt();
                }
            }
        });
    }

    private void bVG() {
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

    private void bVH() {
        this.gZB = new LoadMoreFooter(getContext());
        this.gZB.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.gZB.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        if (this.gZB != null) {
            if (this.gZB.getView().getParent() == null) {
                setNextPage(this.gZB);
            }
            this.gZB.showLoadView();
        }
    }

    private void bUZ() {
        if (this.gZB != null) {
            this.gZB.endLoadData();
            setNextPage(null);
        }
    }

    private void nk(boolean z) {
        if (z) {
            if (this.gZB != null) {
                setNextPage(null);
            }
        } else if (this.gZB != null) {
            if (this.gZB.getView().getParent() == null) {
                setNextPage(this.gZB);
            }
            this.gZB.showNoMoreData();
        }
    }
}
