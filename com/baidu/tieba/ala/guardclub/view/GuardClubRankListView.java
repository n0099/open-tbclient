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
    private a fBr;
    private boolean fBs;
    private LoadMoreFooter fBt;

    /* loaded from: classes3.dex */
    public interface a {
        void buU();

        void buV();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fBr = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.fBs = z;
        if (z) {
            buy();
        } else {
            jZ(z2);
        }
    }

    public void release() {
        this.fBr = null;
        bvg();
    }

    public void bvg() {
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
        bvh();
        bvi();
        bvj();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bvh() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.fBr != null) {
                    GuardClubRankListView.this.fBr.buU();
                }
                if (GuardClubRankListView.this.fBr != null && GuardClubRankListView.this.fBs && !GuardClubRankListView.this.fBt.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bvk();
                    GuardClubRankListView.this.fBr.buV();
                }
            }
        });
    }

    private void bvi() {
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

    private void bvj() {
        this.fBt = new LoadMoreFooter(getContext());
        this.fBt.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.fBt.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvk() {
        if (this.fBt != null) {
            if (this.fBt.getView().getParent() == null) {
                setNextPage(this.fBt);
            }
            this.fBt.showLoadView();
        }
    }

    private void buy() {
        if (this.fBt != null) {
            this.fBt.endLoadData();
            setNextPage(null);
        }
    }

    private void jZ(boolean z) {
        if (z) {
            if (this.fBt != null) {
                setNextPage(null);
            }
        } else if (this.fBt != null) {
            if (this.fBt.getView().getParent() == null) {
                setNextPage(this.fBt);
            }
            this.fBt.showNoMoreData();
        }
    }
}
