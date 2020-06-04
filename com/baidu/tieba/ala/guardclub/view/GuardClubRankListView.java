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
    private a fBC;
    private boolean fBD;
    private LoadMoreFooter fBE;

    /* loaded from: classes3.dex */
    public interface a {
        void buW();

        void buX();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fBC = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.fBD = z;
        if (z) {
            buA();
        } else {
            jZ(z2);
        }
    }

    public void release() {
        this.fBC = null;
        bvi();
    }

    public void bvi() {
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
        bvj();
        bvk();
        bvl();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bvj() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.fBC != null) {
                    GuardClubRankListView.this.fBC.buW();
                }
                if (GuardClubRankListView.this.fBC != null && GuardClubRankListView.this.fBD && !GuardClubRankListView.this.fBE.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bvm();
                    GuardClubRankListView.this.fBC.buX();
                }
            }
        });
    }

    private void bvk() {
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

    private void bvl() {
        this.fBE = new LoadMoreFooter(getContext());
        this.fBE.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.fBE.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvm() {
        if (this.fBE != null) {
            if (this.fBE.getView().getParent() == null) {
                setNextPage(this.fBE);
            }
            this.fBE.showLoadView();
        }
    }

    private void buA() {
        if (this.fBE != null) {
            this.fBE.endLoadData();
            setNextPage(null);
        }
    }

    private void jZ(boolean z) {
        if (z) {
            if (this.fBE != null) {
                setNextPage(null);
            }
        } else if (this.fBE != null) {
            if (this.fBE.getView().getParent() == null) {
                setNextPage(this.fBE);
            }
            this.fBE.showNoMoreData();
        }
    }
}
