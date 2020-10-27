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
    private a gDM;
    private boolean gDN;
    private LoadMoreFooter gDO;

    /* loaded from: classes4.dex */
    public interface a {
        void bRb();

        void bRc();
    }

    public GuardClubRankListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.gDM = aVar;
    }

    public void setLoadMoreEnabled(boolean z, boolean z2) {
        this.gDN = z;
        if (z) {
            bQH();
        } else {
            mj(z2);
        }
    }

    public void release() {
        this.gDM = null;
        bRn();
    }

    public void bRn() {
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
        bRo();
        bRp();
        bRq();
    }

    private void initUI() {
        setDivider(null);
        setDividerHeight(0);
        setOverScrollMode(2);
        setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        setFastScrollEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    private void bRo() {
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.ala.guardclub.view.GuardClubRankListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (GuardClubRankListView.this.gDM != null) {
                    GuardClubRankListView.this.gDM.bRb();
                }
                if (GuardClubRankListView.this.gDM != null && GuardClubRankListView.this.gDN && !GuardClubRankListView.this.gDO.isLoading() && i + i2 > i3 - 2) {
                    GuardClubRankListView.this.bRr();
                    GuardClubRankListView.this.gDM.bRc();
                }
            }
        });
    }

    private void bRp() {
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

    private void bRq() {
        this.gDO = new LoadMoreFooter(getContext());
        this.gDO.setBackgroundColor(getResources().getColor(a.d.live_gcb_primary));
        this.gDO.createView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        if (this.gDO != null) {
            if (this.gDO.getView().getParent() == null) {
                setNextPage(this.gDO);
            }
            this.gDO.showLoadView();
        }
    }

    private void bQH() {
        if (this.gDO != null) {
            this.gDO.endLoadData();
            setNextPage(null);
        }
    }

    private void mj(boolean z) {
        if (z) {
            if (this.gDO != null) {
                setNextPage(null);
            }
        } else if (this.gDO != null) {
            if (this.gDO.getView().getParent() == null) {
                setNextPage(this.gDO);
            }
            this.gDO.showNoMoreData();
        }
    }
}
