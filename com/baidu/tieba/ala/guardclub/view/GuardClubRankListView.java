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
    private a eIS;
    private boolean eIT;
    private LoadMoreFooter eIU;

    /* loaded from: classes3.dex */
    public interface a {
        void bfJ();

        void bfK();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eIS = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.eIT = z;
        if (z) {
            bfm();
        } else {
            iD(z2);
        }
    }

    public void release() {
        this.eIS = null;
        bfV();
    }

    public void bfV() {
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
        bfW();
        bfX();
        bfY();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bfW() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.eIS != null) {
                    GuardClubRankListView.this.eIS.bfJ();
                }
                if (GuardClubRankListView.this.eIS != null && GuardClubRankListView.this.eIT && !GuardClubRankListView.this.eIU.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bfZ();
                    GuardClubRankListView.this.eIS.bfK();
                }
            }
        });
    }

    private void bfX() {
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

    private void bfY() {
        this.eIU = new LoadMoreFooter(getContext());
        this.eIU.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.eIU.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfZ() {
        if (this.eIU != null) {
            if (this.eIU.getView().getParent() == null) {
                setNextPage(this.eIU);
            }
            this.eIU.showLoadView();
        }
    }

    private void bfm() {
        if (this.eIU != null) {
            this.eIU.endLoadData();
            setNextPage(null);
        }
    }

    private void iD(boolean z) {
        if (z) {
            if (this.eIU != null) {
                setNextPage(null);
            }
        } else if (this.eIU != null) {
            if (this.eIU.getView().getParent() == null) {
                setNextPage(this.eIU);
            }
            this.eIU.showNoMoreData();
        }
    }
}
