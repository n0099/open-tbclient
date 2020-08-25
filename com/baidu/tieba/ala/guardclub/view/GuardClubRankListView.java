package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.m;
/* loaded from: classes7.dex */
public class GuardClubRankListView extends BdListView {
    private a ged;
    private boolean gee;
    private LoadMoreFooter gef;

    /* loaded from: classes7.dex */
    public interface a {
        void bKB();

        void bKC();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.ged = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gee = z;
        if (z) {
            bKh();
        } else {
            lr(z2);
        }
    }

    public void release() {
        this.ged = null;
        bKN();
    }

    public void bKN() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if (tag instanceof m.b) {
                        ((m.b) tag).recycle();
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
        bKO();
        bKP();
        bKQ();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bKO() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.ged != null) {
                    GuardClubRankListView.this.ged.bKB();
                }
                if (GuardClubRankListView.this.ged != null && GuardClubRankListView.this.gee && !GuardClubRankListView.this.gef.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bKR();
                    GuardClubRankListView.this.ged.bKC();
                }
            }
        });
    }

    private void bKP() {
        setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof m.b) {
                    ((m.b) tag).recycle();
                }
            }
        });
    }

    private void bKQ() {
        this.gef = new LoadMoreFooter(getContext());
        this.gef.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.gef.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKR() {
        if (this.gef != null) {
            if (this.gef.getView().getParent() == null) {
                setNextPage(this.gef);
            }
            this.gef.showLoadView();
        }
    }

    private void bKh() {
        if (this.gef != null) {
            this.gef.endLoadData();
            setNextPage(null);
        }
    }

    private void lr(boolean z) {
        if (z) {
            if (this.gef != null) {
                setNextPage(null);
            }
        } else if (this.gef != null) {
            if (this.gef.getView().getParent() == null) {
                setNextPage(this.gef);
            }
            this.gef.showNoMoreData();
        }
    }
}
