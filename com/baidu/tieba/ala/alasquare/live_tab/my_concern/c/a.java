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
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private BdSwipeRefreshLayout dyk;
    private View dyl;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a dym;
    private InterfaceC0335a dyn;
    private AlphaAnimation dyo;
    private AlphaAnimation dyp;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int dyr = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.dyr != i) {
                this.dyr = i;
                if (this.dyr != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.aJB();
                        return;
                    } else {
                        a.this.aJA();
                        return;
                    }
                }
                a.this.aJA();
            }
        }
    };
    private com.baidu.tbadk.core.view.i mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private BdTypeRecyclerView zj;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0335a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        aJx();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.dyl = this.mRootView.findViewById(R.id.divider_shadow);
        this.zj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.zj.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.zj.setFadingEdgeLength(0);
        this.zj.setOverScrollMode(2);
        this.zj.addOnScrollListener(this.mOnScrollListener);
        this.zj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.dyn != null) {
                    a.this.dyn.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (a.this.dyn != null) {
                    a.this.dyn.onListPullRefresh(z);
                }
            }
        });
        this.dyk = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.dyk.setProgressView(this.mPullView);
        this.dym = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.zj.addAdapters(this.dym.aJs());
    }

    private void aJx() {
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

    public View aJy() {
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
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.zj, R.color.cp_bg_line_d);
    }

    private boolean aJz() {
        return this.dyl.getVisibility() == 0;
    }

    public void aJA() {
        if (!aJz()) {
            this.dyl.setVisibility(0);
            if (this.dyo == null) {
                this.dyo = new AlphaAnimation(0.0f, 1.0f);
                this.dyo.setFillAfter(true);
                this.dyo.setDuration(300L);
            }
            this.dyl.startAnimation(this.dyo);
        }
    }

    public void aJB() {
        if (aJz()) {
            if (this.dyp == null) {
                this.dyp = new AlphaAnimation(1.0f, 0.0f);
                this.dyp.setFillAfter(true);
                this.dyp.setDuration(300L);
                this.dyp.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dyl.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dyl.startAnimation(this.dyp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dyk.setRefreshing(false);
        }
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.dyn = interfaceC0335a;
    }

    public RelativeLayout aJC() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.zj.setData(list);
    }

    public void p(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.zj != null) {
            for (int count = this.zj.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.zj.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.zj.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.zj.removeOnScrollListener(this.mOnScrollListener);
        this.zj.setOnSrollToBottomListener(null);
        this.zj.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
