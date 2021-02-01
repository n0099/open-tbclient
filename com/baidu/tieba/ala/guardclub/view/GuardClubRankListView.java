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
    private a hcj;
    private boolean hck;
    private LoadMoreFooter hcl;

    /* loaded from: classes11.dex */
    public interface a {
        void bVX();

        void onScroll();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hcj = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.hck = z;
        if (z) {
            bVE();
        } else {
            np(z2);
        }
    }

    public void release() {
        this.hcj = null;
        bWi();
    }

    public void bWi() {
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
        bWj();
        bWk();
        bWl();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bWj() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.hcj != null) {
                    GuardClubRankListView.this.hcj.onScroll();
                }
                if (GuardClubRankListView.this.hcj != null && GuardClubRankListView.this.hck && !GuardClubRankListView.this.hcl.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bWm();
                    GuardClubRankListView.this.hcj.bVX();
                }
            }
        });
    }

    private void bWk() {
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

    private void bWl() {
        this.hcl = new LoadMoreFooter(getContext());
        this.hcl.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.hcl.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWm() {
        if (this.hcl != null) {
            if (this.hcl.getView().getParent() == null) {
                setNextPage(this.hcl);
            }
            this.hcl.showLoadView();
        }
    }

    private void bVE() {
        if (this.hcl != null) {
            this.hcl.endLoadData();
            setNextPage(null);
        }
    }

    private void np(boolean z) {
        if (z) {
            if (this.hcl != null) {
                setNextPage(null);
            }
        } else if (this.hcl != null) {
            if (this.hcl.getView().getParent() == null) {
                setNextPage(this.hcl);
            }
            this.hcl.showNoMoreData();
        }
    }
}
