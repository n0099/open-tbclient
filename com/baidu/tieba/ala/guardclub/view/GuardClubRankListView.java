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
    private a hef;
    private boolean heg;
    private LoadMoreFooter heh;

    /* loaded from: classes11.dex */
    public interface a {
        void bZk();

        void bZl();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.hef = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.heg = z;
        if (z) {
            bYR();
        } else {
            no(z2);
        }
    }

    public void release() {
        this.hef = null;
        bZw();
    }

    public void bZw() {
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
        bZx();
        bZy();
        bZz();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bZx() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.hef != null) {
                    GuardClubRankListView.this.hef.bZk();
                }
                if (GuardClubRankListView.this.hef != null && GuardClubRankListView.this.heg && !GuardClubRankListView.this.heh.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bZA();
                    GuardClubRankListView.this.hef.bZl();
                }
            }
        });
    }

    private void bZy() {
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

    private void bZz() {
        this.heh = new LoadMoreFooter(getContext());
        this.heh.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.heh.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZA() {
        if (this.heh != null) {
            if (this.heh.getView().getParent() == null) {
                setNextPage(this.heh);
            }
            this.heh.showLoadView();
        }
    }

    private void bYR() {
        if (this.heh != null) {
            this.heh.endLoadData();
            setNextPage(null);
        }
    }

    private void no(boolean z) {
        if (z) {
            if (this.heh != null) {
                setNextPage(null);
            }
        } else if (this.heh != null) {
            if (this.heh.getView().getParent() == null) {
                setNextPage(this.heh);
            }
            this.heh.showNoMoreData();
        }
    }
}
