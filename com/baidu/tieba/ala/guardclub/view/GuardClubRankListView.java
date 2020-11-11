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
    private boolean gJA;
    private LoadMoreFooter gJB;
    private a gJz;

    /* loaded from: classes4.dex */
    public interface a {
        void bTA();

        void bTB();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gJz = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gJA = z;
        if (z) {
            bTh();
        } else {
            ms(z2);
        }
    }

    public void release() {
        this.gJz = null;
        bTM();
    }

    public void bTM() {
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
        bTN();
        bTO();
        bTP();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bTN() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gJz != null) {
                    GuardClubRankListView.this.gJz.bTA();
                }
                if (GuardClubRankListView.this.gJz != null && GuardClubRankListView.this.gJA && !GuardClubRankListView.this.gJB.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bTQ();
                    GuardClubRankListView.this.gJz.bTB();
                }
            }
        });
    }

    private void bTO() {
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

    private void bTP() {
        this.gJB = new LoadMoreFooter(getContext());
        this.gJB.setBackgroundColor(getResources().getColor(a.c.live_gcb_primary));
        this.gJB.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTQ() {
        if (this.gJB != null) {
            if (this.gJB.getView().getParent() == null) {
                setNextPage(this.gJB);
            }
            this.gJB.showLoadView();
        }
    }

    private void bTh() {
        if (this.gJB != null) {
            this.gJB.endLoadData();
            setNextPage(null);
        }
    }

    private void ms(boolean z) {
        if (z) {
            if (this.gJB != null) {
                setNextPage(null);
            }
        } else if (this.gJB != null) {
            if (this.gJB.getView().getParent() == null) {
                setNextPage(this.gJB);
            }
            this.gJB.showNoMoreData();
        }
    }
}
