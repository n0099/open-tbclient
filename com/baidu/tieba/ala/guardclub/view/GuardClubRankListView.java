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
    private a fnF;
    private boolean fnG;
    private LoadMoreFooter fnH;

    /* loaded from: classes3.dex */
    public interface a {
        void bpf();

        void bpg();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fnF = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.fnG = z;
        if (z) {
            boI();
        } else {
            jG(z2);
        }
    }

    public void release() {
        this.fnF = null;
        bpr();
    }

    public void bpr() {
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
        bps();
        bpt();
        bpu();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bps() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.fnF != null) {
                    GuardClubRankListView.this.fnF.bpf();
                }
                if (GuardClubRankListView.this.fnF != null && GuardClubRankListView.this.fnG && !GuardClubRankListView.this.fnH.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bpv();
                    GuardClubRankListView.this.fnF.bpg();
                }
            }
        });
    }

    private void bpt() {
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

    private void bpu() {
        this.fnH = new LoadMoreFooter(getContext());
        this.fnH.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.fnH.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpv() {
        if (this.fnH != null) {
            if (this.fnH.getView().getParent() == null) {
                setNextPage(this.fnH);
            }
            this.fnH.showLoadView();
        }
    }

    private void boI() {
        if (this.fnH != null) {
            this.fnH.endLoadData();
            setNextPage(null);
        }
    }

    private void jG(boolean z) {
        if (z) {
            if (this.fnH != null) {
                setNextPage(null);
            }
        } else if (this.fnH != null) {
            if (this.fnH.getView().getParent() == null) {
                setNextPage(this.fnH);
            }
            this.fnH.showNoMoreData();
        }
    }
}
