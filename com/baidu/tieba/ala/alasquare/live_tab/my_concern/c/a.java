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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private BdTypeRecyclerView Wu;
    private BdSwipeRefreshLayout fGm;
    private View fGn;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a fGo;
    private InterfaceC0589a fGp;
    private AlphaAnimation fGq;
    private AlphaAnimation fGr;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.5
        private int fGt = -1;

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            if (this.fGt != i) {
                this.fGt = i;
                if (this.fGt != 1) {
                    if (a.this.a(recyclerView)) {
                        a.this.bGn();
                        return;
                    } else {
                        a.this.bGm();
                        return;
                    }
                }
                a.this.bGm();
            }
        }
    };
    private com.baidu.tbadk.core.view.g mPullView;
    private View mRootView;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0589a {
        void onListPullRefresh(boolean z);

        void onScrollToBottom();
    }

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_live_tab_my_concern_activity, (ViewGroup) null);
        initView();
    }

    private void initView() {
        buP();
        this.mContainer = (RelativeLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_container);
        this.fGn = this.mRootView.findViewById(R.id.divider_shadow);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_recyclerview);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity()));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.Wu.addOnScrollListener(this.mOnScrollListener);
        this.Wu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.1
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (a.this.fGp != null) {
                    a.this.fGp.onScrollToBottom();
                }
            }
        });
        this.mPullView = new com.baidu.tbadk.core.view.g(this.mTbPageContext);
        this.mPullView.setListPullRefreshListener(new f.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (a.this.fGp != null) {
                    a.this.fGp.onListPullRefresh(z);
                }
            }
        });
        this.fGm = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.ala_live_tab_my_concern_pull_refresh_layout);
        this.fGm.setProgressView(this.mPullView);
        this.fGo = new com.baidu.tieba.ala.alasquare.live_tab.my_concern.a.a(this.mTbPageContext);
        this.Wu.addAdapters(this.fGo.bGf());
    }

    private void buP() {
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

    public View bGk() {
        return this.mContainer;
    }

    public void onChangeSkinType(int i) {
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.mTbPageContext, i);
        }
        ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ap.setBackgroundColor(this.fGm, R.color.cp_bg_line_d);
        ap.setBackgroundColor(this.Wu, R.color.cp_bg_line_d);
    }

    private boolean bGl() {
        return this.fGn.getVisibility() == 0;
    }

    public void bGm() {
        if (!bGl()) {
            this.fGn.setVisibility(0);
            if (this.fGq == null) {
                this.fGq = new AlphaAnimation(0.0f, 1.0f);
                this.fGq.setFillAfter(true);
                this.fGq.setDuration(300L);
            }
            this.fGn.startAnimation(this.fGq);
        }
    }

    public void bGn() {
        if (bGl()) {
            if (this.fGr == null) {
                this.fGr = new AlphaAnimation(1.0f, 0.0f);
                this.fGr.setFillAfter(true);
                this.fGr.setDuration(300L);
                this.fGr.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.my_concern.c.a.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        a.this.fGn.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            this.fGn.startAnimation(this.fGr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RecyclerView recyclerView) {
        return recyclerView == null || !recyclerView.canScrollVertically(-1);
    }

    public void kh(boolean z) {
        if (!z) {
            this.fGm.setRefreshing(false);
        }
    }

    public void a(InterfaceC0589a interfaceC0589a) {
        this.fGp = interfaceC0589a;
    }

    public RelativeLayout bGo() {
        return this.mContainer;
    }

    public void setData(List<q> list) {
        this.Wu.setData(list);
    }

    public void x(Class<? extends com.baidu.tieba.card.data.b> cls) {
        if (this.Wu != null) {
            for (int count = this.Wu.getCount() - 1; count >= 0; count--) {
                q item = this.Wu.getItem(count);
                if (item != null && item.getClass().equals(cls)) {
                    this.Wu.removeItem(count);
                }
            }
        }
    }

    public void onDestroy() {
        this.Wu.removeOnScrollListener(this.mOnScrollListener);
        this.Wu.setOnSrollToBottomListener(null);
        this.Wu.setScrollable(null);
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
            this.mPullView.release();
        }
    }
}
