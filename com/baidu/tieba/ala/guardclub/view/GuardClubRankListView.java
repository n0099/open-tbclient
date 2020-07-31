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
    private a fSf;
    private boolean fSg;
    private LoadMoreFooter fSh;

    /* loaded from: classes4.dex */
    public interface a {
        void bBh();

        void bBi();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fSf = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.fSg = z;
        if (z) {
            bAM();
        } else {
            kR(z2);
        }
    }

    public void release() {
        this.fSf = null;
        bBt();
    }

    public void bBt() {
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
        bBu();
        bBv();
        bBw();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bBu() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.fSf != null) {
                    GuardClubRankListView.this.fSf.bBh();
                }
                if (GuardClubRankListView.this.fSf != null && GuardClubRankListView.this.fSg && !GuardClubRankListView.this.fSh.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bBx();
                    GuardClubRankListView.this.fSf.bBi();
                }
            }
        });
    }

    private void bBv() {
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

    private void bBw() {
        this.fSh = new LoadMoreFooter(getContext());
        this.fSh.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.fSh.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBx() {
        if (this.fSh != null) {
            if (this.fSh.getView().getParent() == null) {
                setNextPage(this.fSh);
            }
            this.fSh.showLoadView();
        }
    }

    private void bAM() {
        if (this.fSh != null) {
            this.fSh.endLoadData();
            setNextPage(null);
        }
    }

    private void kR(boolean z) {
        if (z) {
            if (this.fSh != null) {
                setNextPage(null);
            }
        } else if (this.fSh != null) {
            if (this.fSh.getView().getParent() == null) {
                setNextPage(this.fSh);
            }
            this.fSh.showNoMoreData();
        }
    }
}
