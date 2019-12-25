package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.k;
/* loaded from: classes2.dex */
public class GuardClubRankListView extends BdListView {
    private boolean eDA;
    private LoadMoreFooter eDB;
    private a eDz;

    /* loaded from: classes2.dex */
    public interface a {
        void bdd();

        void bde();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eDz = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.eDA = z;
        if (z) {
            bcz();
        } else {
            im(z2);
        }
    }

    public void release() {
        this.eDz = null;
        bdn();
    }

    public void bdn() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                View childAt = getChildAt(i2);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if (tag instanceof k.b) {
                        ((k.b) tag).recycle();
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
        bdo();
        bdp();
        bdq();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bdo() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.eDz != null) {
                    GuardClubRankListView.this.eDz.bdd();
                }
                if (GuardClubRankListView.this.eDz != null && GuardClubRankListView.this.eDA && !GuardClubRankListView.this.eDB.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bdr();
                    GuardClubRankListView.this.eDz.bde();
                }
            }
        });
    }

    private void bdp() {
        setRecyclerListener(new AbsListView.RecyclerListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.2
            @Override // android.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                Object tag = view.getTag();
                if (tag instanceof k.b) {
                    ((k.b) tag).recycle();
                }
            }
        });
    }

    private void bdq() {
        this.eDB = new LoadMoreFooter(getContext());
        this.eDB.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.eDB.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdr() {
        if (this.eDB != null) {
            if (this.eDB.getView().getParent() == null) {
                setNextPage(this.eDB);
            }
            this.eDB.showLoadView();
        }
    }

    private void bcz() {
        if (this.eDB != null) {
            this.eDB.endLoadData();
            setNextPage(null);
        }
    }

    private void im(boolean z) {
        if (z) {
            if (this.eDB != null) {
                setNextPage(null);
            }
        } else if (this.eDB != null) {
            if (this.eDB.getView().getParent() == null) {
                setNextPage(this.eDB);
            }
            this.eDB.showNoMoreData();
        }
    }
}
