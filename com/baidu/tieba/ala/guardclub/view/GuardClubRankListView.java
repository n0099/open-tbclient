package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.l;
/* loaded from: classes6.dex */
public class GuardClubRankListView extends BdListView {
    private a dPt;
    private boolean dPu;
    private LoadMoreFooter dPv;

    /* loaded from: classes6.dex */
    public interface a {
        void aLU();

        void aLV();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.dPt = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.dPu = z;
        if (z) {
            aLp();
        } else {
            hf(z2);
        }
    }

    public void release() {
        this.dPt = null;
        aMe();
    }

    public void aMe() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if (tag instanceof l.b) {
                        ((l.b) tag).recycle();
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
        aMf();
        aMg();
        aMh();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void aMf() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.dPt != null) {
                    GuardClubRankListView.this.dPt.aLU();
                }
                if (GuardClubRankListView.this.dPt != null && GuardClubRankListView.this.dPu && !GuardClubRankListView.this.dPv.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.aMi();
                    GuardClubRankListView.this.dPt.aLV();
                }
            }
        });
    }

    private void aMg() {
        setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof l.b) {
                    ((l.b) tag).recycle();
                }
            }
        });
    }

    private void aMh() {
        this.dPv = new LoadMoreFooter(getContext());
        this.dPv.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.dPv.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMi() {
        if (this.dPv != null) {
            if (this.dPv.getView().getParent() == null) {
                setNextPage(this.dPv);
            }
            this.dPv.showLoadView();
        }
    }

    private void aLp() {
        if (this.dPv != null) {
            this.dPv.endLoadData();
            setNextPage(null);
        }
    }

    private void hf(boolean z) {
        if (z) {
            if (this.dPv != null) {
                setNextPage(null);
            }
        } else if (this.dPv != null) {
            if (this.dPv.getView().getParent() == null) {
                setNextPage(this.dPv);
            }
            this.dPv.showNoMoreData();
        }
    }
}
