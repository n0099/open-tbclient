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
    private a geh;
    private boolean gei;
    private LoadMoreFooter gej;

    /* loaded from: classes7.dex */
    public interface a {
        void bKC();

        void bKD();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.geh = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gei = z;
        if (z) {
            bKi();
        } else {
            lt(z2);
        }
    }

    public void release() {
        this.geh = null;
        bKO();
    }

    public void bKO() {
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
        bKP();
        bKQ();
        bKR();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bKP() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.geh != null) {
                    GuardClubRankListView.this.geh.bKC();
                }
                if (GuardClubRankListView.this.geh != null && GuardClubRankListView.this.gei && !GuardClubRankListView.this.gej.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bKS();
                    GuardClubRankListView.this.geh.bKD();
                }
            }
        });
    }

    private void bKQ() {
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

    private void bKR() {
        this.gej = new LoadMoreFooter(getContext());
        this.gej.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.gej.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKS() {
        if (this.gej != null) {
            if (this.gej.getView().getParent() == null) {
                setNextPage(this.gej);
            }
            this.gej.showLoadView();
        }
    }

    private void bKi() {
        if (this.gej != null) {
            this.gej.endLoadData();
            setNextPage(null);
        }
    }

    private void lt(boolean z) {
        if (z) {
            if (this.gej != null) {
                setNextPage(null);
            }
        } else if (this.gej != null) {
            if (this.gej.getView().getParent() == null) {
                setNextPage(this.gej);
            }
            this.gej.showNoMoreData();
        }
    }
}
