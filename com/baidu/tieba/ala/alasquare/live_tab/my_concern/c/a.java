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
/* loaded from: classes2.dex */
public class a {
    private BdTypeRecyclerView Bs;
    private BdSwipeRefreshLayout ejj;
    private View ejk;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a ejl;
    private InterfaceC0412a ejm;
    private AlphaAnimation ejn;
    private AlphaAnimation ejo;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int ejq = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.ejq != i) {
                this.ejq = i;
                if (this.ejq != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.baw();
                        return;
                    } else {
                        a.this.bav();
                        return;
                    }
                }
                a.this.bav();
            }
        }
    };
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0412a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        bas();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.ejk = this.mRootView.findViewById(R.id.divider_shadow);
        this.Bs = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Bs.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Bs.setFadingEdgeLength(0);
        this.Bs.setOverScrollMode(2);
        this.Bs.addOnScrollListener(this.mOnScrollListener);
        this.Bs.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.ejm != null) {
                    a.this.ejm.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (a.this.ejm != null) {
                    a.this.ejm.onListPullRefresh(z);
                }
            }
        });
        this.ejj = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.ejj.setProgressView(this.mPullView);
        this.ejl = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Bs.addAdapters(this.ejl.ban());
    }

    private void bas() {
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

    public View bat() {
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
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Bs, R.color.cp_bg_line_d);
    }

    private boolean bau() {
        return this.ejk.getVisibility() == 0;
    }

    public void bav() {
        if (!bau()) {
            this.ejk.setVisibility(0);
            if (this.ejn == null) {
                this.ejn = new AlphaAnimation(0.0f, 1.0f);
                this.ejn.setFillAfter(true);
                this.ejn.setDuration(300L);
            }
            this.ejk.startAnimation(this.ejn);
        }
    }

    public void baw() {
        if (bau()) {
            if (this.ejo == null) {
                this.ejo = new AlphaAnimation(1.0f, 0.0f);
                this.ejo.setFillAfter(true);
                this.ejo.setDuration(300L);
                this.ejo.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.ejk.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.ejk.startAnimation(this.ejo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void hn(boolean z) {
        if (!z) {
            this.ejj.setRefreshing(false);
        }
    }

    public void a(InterfaceC0412a interfaceC0412a) {
        this.ejm = interfaceC0412a;
    }

    public RelativeLayout bax() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.Bs.setData(list);
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Bs != null) {
            for (int count = this.Bs.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.Bs.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Bs.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Bs.removeOnScrollListener(this.mOnScrollListener);
        this.Bs.setOnSrollToBottomListener(null);
        this.Bs.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
