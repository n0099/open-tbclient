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
    private a ght;
    private boolean ghu;
    private LoadMoreFooter ghv;

    /* loaded from: classes4.dex */
    public interface a {
        void bLM();

        void bLN();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.ght = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.ghu = z;
        if (z) {
            bLs();
        } else {
            lv(z2);
        }
    }

    public void release() {
        this.ght = null;
        bLY();
    }

    public void bLY() {
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
        bLZ();
        bMa();
        bMb();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bLZ() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.ght != null) {
                    GuardClubRankListView.this.ght.bLM();
                }
                if (GuardClubRankListView.this.ght != null && GuardClubRankListView.this.ghu && !GuardClubRankListView.this.ghv.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bMc();
                    GuardClubRankListView.this.ght.bLN();
                }
            }
        });
    }

    private void bMa() {
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

    private void bMb() {
        this.ghv = new LoadMoreFooter(getContext());
        this.ghv.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.ghv.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMc() {
        if (this.ghv != null) {
            if (this.ghv.getView().getParent() == null) {
                setNextPage(this.ghv);
            }
            this.ghv.showLoadView();
        }
    }

    private void bLs() {
        if (this.ghv != null) {
            this.ghv.endLoadData();
            setNextPage(null);
        }
    }

    private void lv(boolean z) {
        if (z) {
            if (this.ghv != null) {
                setNextPage(null);
            }
        } else if (this.ghv != null) {
            if (this.ghv.getView().getParent() == null) {
                setNextPage(this.ghv);
            }
            this.ghv.showNoMoreData();
        }
    }
}
