package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.m;
/* loaded from: classes4.dex */
public class GuardClubRankListView extends BdListView {
    private a gJg;
    private boolean gJh;
    private LoadMoreFooter gJi;

    /* loaded from: classes4.dex */
    public interface a {
        void bST();

        void bSU();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gJg = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gJh = z;
        if (z) {
            bSA();
        } else {
            mt(z2);
        }
    }

    public void release() {
        this.gJg = null;
        bTf();
    }

    public void bTf() {
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
        bTg();
        bTh();
        bTi();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bTg() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gJg != null) {
                    GuardClubRankListView.this.gJg.bST();
                }
                if (GuardClubRankListView.this.gJg != null && GuardClubRankListView.this.gJh && !GuardClubRankListView.this.gJi.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bTj();
                    GuardClubRankListView.this.gJg.bSU();
                }
            }
        });
    }

    private void bTh() {
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

    private void bTi() {
        this.gJi = new LoadMoreFooter(getContext());
        this.gJi.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.gJi.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTj() {
        if (this.gJi != null) {
            if (this.gJi.getView().getParent() == null) {
                setNextPage(this.gJi);
            }
            this.gJi.showLoadView();
        }
    }

    private void bSA() {
        if (this.gJi != null) {
            this.gJi.endLoadData();
            setNextPage(null);
        }
    }

    private void mt(boolean z) {
        if (z) {
            if (this.gJi != null) {
                setNextPage(null);
            }
        } else if (this.gJi != null) {
            if (this.gJi.getView().getParent() == null) {
                setNextPage(this.gJi);
            }
            this.gJi.showNoMoreData();
        }
    }
}
