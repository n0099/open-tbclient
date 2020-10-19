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
    private a gtI;
    private boolean gtJ;
    private LoadMoreFooter gtK;

    /* loaded from: classes4.dex */
    public interface a {
        void bOw();

        void bOx();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gtI = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gtJ = z;
        if (z) {
            bOc();
        } else {
            lT(z2);
        }
    }

    public void release() {
        this.gtI = null;
        bOI();
    }

    public void bOI() {
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
        bOJ();
        bOK();
        bOL();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bOJ() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gtI != null) {
                    GuardClubRankListView.this.gtI.bOw();
                }
                if (GuardClubRankListView.this.gtI != null && GuardClubRankListView.this.gtJ && !GuardClubRankListView.this.gtK.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bOM();
                    GuardClubRankListView.this.gtI.bOx();
                }
            }
        });
    }

    private void bOK() {
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

    private void bOL() {
        this.gtK = new LoadMoreFooter(getContext());
        this.gtK.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.gtK.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOM() {
        if (this.gtK != null) {
            if (this.gtK.getView().getParent() == null) {
                setNextPage(this.gtK);
            }
            this.gtK.showLoadView();
        }
    }

    private void bOc() {
        if (this.gtK != null) {
            this.gtK.endLoadData();
            setNextPage(null);
        }
    }

    private void lT(boolean z) {
        if (z) {
            if (this.gtK != null) {
                setNextPage(null);
            }
        } else if (this.gtK != null) {
            if (this.gtK.getView().getParent() == null) {
                setNextPage(this.gtK);
            }
            this.gtK.showNoMoreData();
        }
    }
}
