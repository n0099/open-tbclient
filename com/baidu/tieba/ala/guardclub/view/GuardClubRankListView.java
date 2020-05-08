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
    private a fnK;
    private boolean fnL;
    private LoadMoreFooter fnM;

    /* loaded from: classes3.dex */
    public interface a {
        void bpd();

        void bpe();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fnK = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.fnL = z;
        if (z) {
            boG();
        } else {
            jG(z2);
        }
    }

    public void release() {
        this.fnK = null;
        bpp();
    }

    public void bpp() {
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
        bpq();
        bpr();
        bps();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bpq() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.fnK != null) {
                    GuardClubRankListView.this.fnK.bpd();
                }
                if (GuardClubRankListView.this.fnK != null && GuardClubRankListView.this.fnL && !GuardClubRankListView.this.fnM.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bpt();
                    GuardClubRankListView.this.fnK.bpe();
                }
            }
        });
    }

    private void bpr() {
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

    private void bps() {
        this.fnM = new LoadMoreFooter(getContext());
        this.fnM.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.fnM.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpt() {
        if (this.fnM != null) {
            if (this.fnM.getView().getParent() == null) {
                setNextPage(this.fnM);
            }
            this.fnM.showLoadView();
        }
    }

    private void boG() {
        if (this.fnM != null) {
            this.fnM.endLoadData();
            setNextPage(null);
        }
    }

    private void jG(boolean z) {
        if (z) {
            if (this.fnM != null) {
                setNextPage(null);
            }
        } else if (this.fnM != null) {
            if (this.fnM.getView().getParent() == null) {
                setNextPage(this.fnM);
            }
            this.fnM.showNoMoreData();
        }
    }
}
