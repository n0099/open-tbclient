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
    private a gSs;
    private boolean gSt;
    private LoadMoreFooter gSu;

    /* loaded from: classes4.dex */
    public interface a {
        void bWE();

        void bWF();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gSs = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gSt = z;
        if (z) {
            bWl();
        } else {
            mO(z2);
        }
    }

    public void release() {
        this.gSs = null;
        bWQ();
    }

    public void bWQ() {
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
        bWR();
        bWS();
        bWT();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bWR() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gSs != null) {
                    GuardClubRankListView.this.gSs.bWE();
                }
                if (GuardClubRankListView.this.gSs != null && GuardClubRankListView.this.gSt && !GuardClubRankListView.this.gSu.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bWU();
                    GuardClubRankListView.this.gSs.bWF();
                }
            }
        });
    }

    private void bWS() {
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

    private void bWT() {
        this.gSu = new LoadMoreFooter(getContext());
        this.gSu.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.gSu.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWU() {
        if (this.gSu != null) {
            if (this.gSu.getView().getParent() == null) {
                setNextPage(this.gSu);
            }
            this.gSu.showLoadView();
        }
    }

    private void bWl() {
        if (this.gSu != null) {
            this.gSu.endLoadData();
            setNextPage(null);
        }
    }

    private void mO(boolean z) {
        if (z) {
            if (this.gSu != null) {
                setNextPage(null);
            }
        } else if (this.gSu != null) {
            if (this.gSu.getView().getParent() == null) {
                setNextPage(this.gSu);
            }
            this.gSu.showNoMoreData();
        }
    }
}
