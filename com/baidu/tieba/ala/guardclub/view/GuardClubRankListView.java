package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.guardclub.m;
/* loaded from: classes3.dex */
public class GuardClubRankListView extends BdListView {
    private a eIF;
    private boolean eIG;
    private LoadMoreFooter eIH;

    /* loaded from: classes3.dex */
    public interface a {
        void bfI();

        void bfJ();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eIF = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.eIG = z;
        if (z) {
            bfl();
        } else {
            iD(z2);
        }
    }

    public void release() {
        this.eIF = null;
        bfU();
    }

    public void bfU() {
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
        bfV();
        bfW();
        bfX();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bfV() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.eIF != null) {
                    GuardClubRankListView.this.eIF.bfI();
                }
                if (GuardClubRankListView.this.eIF != null && GuardClubRankListView.this.eIG && !GuardClubRankListView.this.eIH.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bfY();
                    GuardClubRankListView.this.eIF.bfJ();
                }
            }
        });
    }

    private void bfW() {
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

    private void bfX() {
        this.eIH = new LoadMoreFooter(getContext());
        this.eIH.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.eIH.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfY() {
        if (this.eIH != null) {
            if (this.eIH.getView().getParent() == null) {
                setNextPage(this.eIH);
            }
            this.eIH.showLoadView();
        }
    }

    private void bfl() {
        if (this.eIH != null) {
            this.eIH.endLoadData();
            setNextPage(null);
        }
    }

    private void iD(boolean z) {
        if (z) {
            if (this.eIH != null) {
                setNextPage(null);
            }
        } else if (this.eIH != null) {
            if (this.eIH.getView().getParent() == null) {
                setNextPage(this.eIH);
            }
            this.eIH.showNoMoreData();
        }
    }
}
