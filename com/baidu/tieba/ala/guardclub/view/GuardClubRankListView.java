package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.m;
/* loaded from: classes3.dex */
public class GuardClubRankListView extends BdListView {
    private a fML;
    private boolean fMM;
    private LoadMoreFooter fMN;

    /* loaded from: classes3.dex */
    public interface a {
        void bxR();

        void bxS();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.fML = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.fMM = z;
        if (z) {
            bxv();
        } else {
            kn(z2);
        }
    }

    public void release() {
        this.fML = null;
        byd();
    }

    public void byd() {
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
        bye();
        byf();
        byg();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bye() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.fML != null) {
                    GuardClubRankListView.this.fML.bxR();
                }
                if (GuardClubRankListView.this.fML != null && GuardClubRankListView.this.fMM && !GuardClubRankListView.this.fMN.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.byh();
                    GuardClubRankListView.this.fML.bxS();
                }
            }
        });
    }

    private void byf() {
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

    private void byg() {
        this.fMN = new LoadMoreFooter(getContext());
        this.fMN.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.fMN.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byh() {
        if (this.fMN != null) {
            if (this.fMN.getView().getParent() == null) {
                setNextPage(this.fMN);
            }
            this.fMN.showLoadView();
        }
    }

    private void bxv() {
        if (this.fMN != null) {
            this.fMN.endLoadData();
            setNextPage(null);
        }
    }

    private void kn(boolean z) {
        if (z) {
            if (this.fMN != null) {
                setNextPage(null);
            }
        } else if (this.fMN != null) {
            if (this.fMN.getView().getParent() == null) {
                setNextPage(this.fMN);
            }
            this.fMN.showNoMoreData();
        }
    }
}
