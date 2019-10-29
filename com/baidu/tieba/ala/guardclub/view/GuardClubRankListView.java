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
    private a dQk;
    private boolean dQl;
    private LoadMoreFooter dQm;

    /* loaded from: classes6.dex */
    public interface a {
        void aLW();

        void aLX();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.dQk = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.dQl = z;
        if (z) {
            aLr();
        } else {
            hf(z2);
        }
    }

    public void release() {
        this.dQk = null;
        aMg();
    }

    public void aMg() {
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
        aMh();
        aMi();
        aMj();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void aMh() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.dQk != null) {
                    GuardClubRankListView.this.dQk.aLW();
                }
                if (GuardClubRankListView.this.dQk != null && GuardClubRankListView.this.dQl && !GuardClubRankListView.this.dQm.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.aMk();
                    GuardClubRankListView.this.dQk.aLX();
                }
            }
        });
    }

    private void aMi() {
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

    private void aMj() {
        this.dQm = new LoadMoreFooter(getContext());
        this.dQm.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.dQm.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMk() {
        if (this.dQm != null) {
            if (this.dQm.getView().getParent() == null) {
                setNextPage(this.dQm);
            }
            this.dQm.showLoadView();
        }
    }

    private void aLr() {
        if (this.dQm != null) {
            this.dQm.endLoadData();
            setNextPage(null);
        }
    }

    private void hf(boolean z) {
        if (z) {
            if (this.dQm != null) {
                setNextPage(null);
            }
        } else if (this.dQm != null) {
            if (this.dQm.getView().getParent() == null) {
                setNextPage(this.dQm);
            }
            this.dQm.showNoMoreData();
        }
    }
}
