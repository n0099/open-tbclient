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
    private BdSwipeRefreshLayout dxt;
    private View dxu;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a dxv;
    private InterfaceC0335a dxw;
    private AlphaAnimation dxx;
    private AlphaAnimation dxy;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int dxA = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.dxA != i) {
                this.dxA = i;
                if (this.dxA != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.aJz();
                        return;
                    } else {
                        a.this.aJy();
                        return;
                    }
                }
                a.this.aJy();
            }
        }
    };
    private com.baidu.tbadk.core.view.i mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;
    private BdTypeRecyclerView yJ;

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
        aJv();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.dxu = this.mRootView.findViewById(R.id.divider_shadow);
        this.yJ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.yJ.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.yJ.setFadingEdgeLength(0);
        this.yJ.setOverScrollMode(2);
        this.yJ.addOnScrollListener(this.mOnScrollListener);
        this.yJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.dxw != null) {
                    a.this.dxw.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.i(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new h.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (a.this.dxw != null) {
                    a.this.dxw.onListPullRefresh(z);
                }
            }
        });
        this.dxt = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.dxt.setProgressView(this.mPullView);
        this.dxv = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.yJ.addAdapters(this.dxv.aJq());
    }

    private void aJv() {
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

    public View aJw() {
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
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.yJ, R.color.cp_bg_line_d);
    }

    private boolean aJx() {
        return this.dxu.getVisibility() == 0;
    }

    public void aJy() {
        if (!aJx()) {
            this.dxu.setVisibility(0);
            if (this.dxx == null) {
                this.dxx = new AlphaAnimation(0.0f, 1.0f);
                this.dxx.setFillAfter(true);
                this.dxx.setDuration(300L);
            }
            this.dxu.startAnimation(this.dxx);
        }
    }

    public void aJz() {
        if (aJx()) {
            if (this.dxy == null) {
                this.dxy = new AlphaAnimation(1.0f, 0.0f);
                this.dxy.setFillAfter(true);
                this.dxy.setDuration(300L);
                this.dxy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.dxu.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.dxu.startAnimation(this.dxy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void fU(boolean z) {
        if (!z) {
            this.dxt.setRefreshing(false);
        }
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.dxw = interfaceC0335a;
    }

    public RelativeLayout aJA() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.yJ.setData(list);
    }

    public void p(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.yJ != null) {
            for (int count = this.yJ.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.yJ.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.yJ.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.yJ.removeOnScrollListener(this.mOnScrollListener);
        this.yJ.setOnSrollToBottomListener(null);
        this.yJ.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
