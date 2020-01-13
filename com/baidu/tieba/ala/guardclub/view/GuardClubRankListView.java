package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.LoadMoreFooter;
import com.baidu.tieba.ala.guardclub.k;
/* loaded from: classes2.dex */
public class GuardClubRankListView extends BdListView {
    private a eEK;
    private boolean eEL;
    private LoadMoreFooter eEM;

    /* loaded from: classes2.dex */
    public interface a {
        void bdy();

        void bdz();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.eEK = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.eEL = z;
        if (z) {
            bcU();
        } else {
            iw(z2);
        }
    }

    public void release() {
        this.eEK = null;
        bdI();
    }

    public void bdI() {
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
        bdJ();
        bdK();
        bdL();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bdJ() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.eEK != null) {
                    GuardClubRankListView.this.eEK.bdy();
                }
                if (GuardClubRankListView.this.eEK != null && GuardClubRankListView.this.eEL && !GuardClubRankListView.this.eEM.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bdM();
                    GuardClubRankListView.this.eEK.bdz();
                }
            }
        });
    }

    private void bdK() {
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

    private void bdL() {
        this.eEM = new LoadMoreFooter(getContext());
        this.eEM.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.eEM.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdM() {
        if (this.eEM != null) {
            if (this.eEM.getView().getParent() == null) {
                setNextPage(this.eEM);
            }
            this.eEM.showLoadView();
        }
    }

    private void bcU() {
        if (this.eEM != null) {
            this.eEM.endLoadData();
            setNextPage(null);
        }
    }

    private void iw(boolean z) {
        if (z) {
            if (this.eEM != null) {
                setNextPage(null);
            }
        } else if (this.eEM != null) {
            if (this.eEM.getView().getParent() == null) {
                setNextPage(this.eEM);
            }
            this.eEM.showNoMoreData();
        }
    }
}
