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
    private BdTypeRecyclerView Bn;
    private AlphaAnimation eiA;
    private BdSwipeRefreshLayout eiv;
    private View eiw;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a eix;
    private InterfaceC0410a eiy;
    private AlphaAnimation eiz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int eiC = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.eiC != i) {
                this.eiC = i;
                if (this.eiC != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.aZX();
                        return;
                    } else {
                        a.this.aZW();
                        return;
                    }
                }
                a.this.aZW();
            }
        }
    };
    private com.baidu.tbadk.core.view.h mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0410a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        aZT();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.eiw = this.mRootView.findViewById(R.id.divider_shadow);
        this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Bn.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Bn.setFadingEdgeLength(0);
        this.Bn.setOverScrollMode(2);
        this.Bn.addOnScrollListener(this.mOnScrollListener);
        this.Bn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.eiy != null) {
                    a.this.eiy.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.h(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new g.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (a.this.eiy != null) {
                    a.this.eiy.onListPullRefresh(z);
                }
            }
        });
        this.eiv = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.eiv.setProgressView(this.mPullView);
        this.eix = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Bn.addAdapters(this.eix.aZO());
    }

    private void aZT() {
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

    public View aZU() {
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
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.Bn, R.color.cp_bg_line_d);
    }

    private boolean aZV() {
        return this.eiw.getVisibility() == 0;
    }

    public void aZW() {
        if (!aZV()) {
            this.eiw.setVisibility(0);
            if (this.eiz == null) {
                this.eiz = new AlphaAnimation(0.0f, 1.0f);
                this.eiz.setFillAfter(true);
                this.eiz.setDuration(300L);
            }
            this.eiw.startAnimation(this.eiz);
        }
    }

    public void aZX() {
        if (aZV()) {
            if (this.eiA == null) {
                this.eiA = new AlphaAnimation(1.0f, 0.0f);
                this.eiA.setFillAfter(true);
                this.eiA.setDuration(300L);
                this.eiA.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.eiw.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.eiw.startAnimation(this.eiA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void hi(boolean z) {
        if (!z) {
            this.eiv.setRefreshing(false);
        }
    }

    public void a(InterfaceC0410a interfaceC0410a) {
        this.eiy = interfaceC0410a;
    }

    public RelativeLayout aZY() {
        return this.mContainer;
    }

    public void setData(List<com.baidu.adp.widget.ListView.m> list) {
        this.Bn.setData(list);
    }

    public void w(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Bn != null) {
            for (int count = this.Bn.getCount() - 1; count >= 0; count--) {
                com.baidu.adp.widget.ListView.m item = this.Bn.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Bn.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Bn.removeOnScrollListener(this.mOnScrollListener);
        this.Bn.setOnSrollToBottomListener(null);
        this.Bn.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
