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
    private a eJo;
    private boolean eJp;
    private LoadMoreFooter eJq;

    /* loaded from: classes3.dex */
    public interface a {
        void bfO();

        void bfP();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eJo = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.eJp = z;
        if (z) {
            bfr();
        } else {
            iF(z2);
        }
    }

    public void release() {
        this.eJo = null;
        bga();
    }

    public void bga() {
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
        bgb();
        bgc();
        bgd();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bgb() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.eJo != null) {
                    GuardClubRankListView.this.eJo.bfO();
                }
                if (GuardClubRankListView.this.eJo != null && GuardClubRankListView.this.eJp && !GuardClubRankListView.this.eJq.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bge();
                    GuardClubRankListView.this.eJo.bfP();
                }
            }
        });
    }

    private void bgc() {
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

    private void bgd() {
        this.eJq = new LoadMoreFooter(getContext());
        this.eJq.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.eJq.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bge() {
        if (this.eJq != null) {
            if (this.eJq.getView().getParent() == null) {
                setNextPage(this.eJq);
            }
            this.eJq.showLoadView();
        }
    }

    private void bfr() {
        if (this.eJq != null) {
            this.eJq.endLoadData();
            setNextPage(null);
        }
    }

    private void iF(boolean z) {
        if (z) {
            if (this.eJq != null) {
                setNextPage(null);
            }
        } else if (this.eJq != null) {
            if (this.eJq.getView().getParent() == null) {
                setNextPage(this.eJq);
            }
            this.eJq.showNoMoreData();
        }
    }
}
