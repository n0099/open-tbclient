package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private BdTypeRecyclerView BK;
    private BdSwipeRefreshLayout enY;
    private View enZ;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a eoa;
    private InterfaceC0423a eob;
    private AlphaAnimation eoc;
    private AlphaAnimation eod;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int eog = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.eog != i) {
                this.eog = i;
                if (this.eog != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bcS();
                        return;
                    } else {
                        a.this.bcR();
                        return;
                    }
                }
                a.this.bcR();
            }
        }
    };
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0423a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bcO();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.enZ = this.mRootView.findViewById(R.id.divider_shadow);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.BK.addOnScrollListener(this.mOnScrollListener);
        this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.eob != null) {
                    a.this.eob.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (a.this.eob != null) {
                    a.this.eob.onListPullRefresh(z);
                }
            }
        });
        this.enY = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.enY.setProgressView(this.mPullView);
        this.eoa = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.BK.addAdapters(this.eoa.bcJ());
    }

    private void bcO() {
        this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_navigationbar);
        this.mNavigationBar.setCenterTextTitle(this.mTbPageContext.getResources().getString(R.string.live_tab_my_concern));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mTbPageContext != null && a.this.mTbPageContext.getPageActivity() != null) {
                    a.this.mTbPageContext.getPageActivity().finish();
                }
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public View bcP() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.BK, R.color.cp_bg_line_d);
    }

    private boolean bcQ() {
        return this.enZ.getVisibility() == 0;
    }

    public void bcR() {
        if (!bcQ()) {
            this.enZ.setVisibility(0);
            if (this.eoc == null) {
                this.eoc = new AlphaAnimation(0.0f, 1.0f);
                this.eoc.setFillAfter(true);
                this.eoc.setDuration(300L);
            }
            this.enZ.startAnimation(this.eoc);
        }
    }

    public void bcS() {
        if (bcQ()) {
            if (this.eod == null) {
                this.eod = new AlphaAnimation(1.0f, 0.0f);
                this.eod.setFillAfter(true);
                this.eod.setDuration(300L);
                this.eod.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.enZ.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.enZ.startAnimation(this.eod);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void hv(boolean z) {
        if (!z) {
            this.enY.setRefreshing(false);
        }
    }

    public void a(InterfaceC0423a interfaceC0423a) {
        this.eob = interfaceC0423a;
    }

    public RelativeLayout bcT() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.BK.setData(list);
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.BK != null) {
            for (int count = this.BK.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.BK.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.BK.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.BK.removeOnScrollListener(this.mOnScrollListener);
        this.BK.setOnSrollToBottomListener(null);
        this.BK.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
